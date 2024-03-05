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

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserLoginPageObject loginPage;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressesPageObject addressesPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointsPageObject rewardPointsPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "fc";
		emailAddress = "auto" + getRandomNumber() + "@gmail.com";
		password = "111111";

	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.clickRegisterLink();

		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox(password);
		registerPage.sendKeyToConfirmPasswordTextbox(password);

		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		registerPage.clickContinueButton();

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void User_03_MyAccount() {
		customerInforPage = homePage.clickMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		// Customer Infor -> Address
		addressesPage = customerInforPage.openAddressesPage(driver);

		// Address -> My Product Review
		myProductReviewPage = addressesPage.openToMyProductReviewPage(driver);

		// My Product Review -> Reward Point
		rewardPointsPage = myProductReviewPage.openRewardPointsPage(driver);

		// Reward Point -> Address
		addressesPage = rewardPointsPage.openAddressesPage(driver);

		// Address -> Reward Point
		rewardPointsPage = addressesPage.openRewardPointsPage(driver);

		// Reward Point -> My Product Review
		myProductReviewPage = rewardPointsPage.openToMyProductReviewPage(driver);
	}

	@Test
	public void User_05_Switch_User() {
		// user -> admin

		// admin -> user
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
