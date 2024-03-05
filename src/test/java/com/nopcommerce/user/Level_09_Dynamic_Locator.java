package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointsPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private UserAddressesPageObject userAddressesPage;
	private UserMyProductReviewPageObject userMyProductReviewPage;
	private UserRewardPointsPageObject userRewardPointsPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "fc";
		emailAddress = "auto" + getRandomNumber() + "@gmail.com";
		password = "111111";

	}

	@Test
	public void User_01_Register_Login() {
		userRegisterPage = userHomePage.clickRegisterLink();

		userRegisterPage.sendKeyToFirstNameTextbox(firstName);
		userRegisterPage.sendKeyToLastNameTextbox(lastName);
		userRegisterPage.sendKeyToEmailTextbox(emailAddress);
		userRegisterPage.sendKeyToPasswordTextbox(password);
		userRegisterPage.sendKeyToConfirmPasswordTextbox(password);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getSuccessMessage(), "Your registration completed");

		userHomePage = userRegisterPage.clickContinueButton();

		userLoginPage = userHomePage.clickLoginLink();
		userHomePage = userLoginPage.loginAsUser(emailAddress, password);

		userCustomerInforPage = userHomePage.clickMyAccountLink();
		Assert.assertTrue(userCustomerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_02_Dynamic_Page_1() {
		// Customer Infor -> Address
		userAddressesPage = (UserAddressesPageObject) userCustomerInforPage.openDynamicPagesAtMyAccountPage(driver, "Addresses");

		// Address -> My Product Review
		userMyProductReviewPage = (UserMyProductReviewPageObject) userAddressesPage.openDynamicPagesAtMyAccountPage(driver, "My product reviews");

		// My Product Review -> Reward Point
		userRewardPointsPage = (UserRewardPointsPageObject) userMyProductReviewPage.openDynamicPagesAtMyAccountPage(driver, "Reward points");

		// Reward Point -> Address
		userAddressesPage = (UserAddressesPageObject) userRewardPointsPage.openDynamicPagesAtMyAccountPage(driver, "Addresses");

		// Address -> Reward Point
		userRewardPointsPage = (UserRewardPointsPageObject) userAddressesPage.openDynamicPagesAtMyAccountPage(driver, "Reward points");

		// Reward Point -> My Product Review
		userMyProductReviewPage = (UserMyProductReviewPageObject) userRewardPointsPage.openDynamicPagesAtMyAccountPage(driver, "My product reviews");

	}

	@Test
	public void User_03_Dynamic_Page_2() {
		// Customer Infor -> Address
		userCustomerInforPage.openDynamicPagesAtMyAccountSideBar(driver, "Addresses");
		userAddressesPage = PageGeneratorManager.getUserAddressesPage(driver);

		// Address -> My Product Review
		userAddressesPage.openDynamicPagesAtMyAccountSideBar(driver, "My product reviews");
		userMyProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		// My Product Review -> Reward Point
		userMyProductReviewPage.openDynamicPagesAtMyAccountSideBar(driver, "Reward points");
		userRewardPointsPage = PageGeneratorManager.getUserRewardPointsPage(driver);

		// Reward Point -> Address
		userAddressesPage.openDynamicPagesAtMyAccountSideBar(driver, "Addresses");
		userAddressesPage = PageGeneratorManager.getUserAddressesPage(driver);

		// Address -> Reward Point
		userAddressesPage.openDynamicPagesAtMyAccountSideBar(driver, "Reward points");
		userRewardPointsPage = PageGeneratorManager.getUserRewardPointsPage(driver);

		// Reward Point -> My Product Review
		userRewardPointsPage.openDynamicPagesAtMyAccountSideBar(driver, "My product reviews");
		userMyProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
