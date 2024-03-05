package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_14_Log_ReportNG extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;

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
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		userRegisterPage = userHomePage.clickRegisterLink();

		log.info("Register - Step 02: Enter to Firstname textbox with value is'" + firstName + "'");
		userRegisterPage.sendKeyToFirstNameTextbox(firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value is'" + lastName + "'");
		userRegisterPage.sendKeyToLastNameTextbox(lastName);

		log.info("Register - Step 04: Enter to Email textbox with value is'" + emailAddress + "'");
		userRegisterPage.sendKeyToEmailTextbox(emailAddress);

		log.info("Register - Step 06: Enter to Password textbox with value is'" + password + "'");
		userRegisterPage.sendKeyToPasswordTextbox(password);

		log.info("Register - Step 07: Enter to Confirm password textbox with value is'" + password + "'");
		userRegisterPage.sendKeyToConfirmPasswordTextbox(password);

		log.info("Register - Step 08: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		log.info("Register - Step 09: Verify register success message is displayed");
		verifyEquals(userRegisterPage.getSuccessMessage(), "Your registration completed...");

		log.info("Register - Step 10: Click 'Continue' button");
		userHomePage = userRegisterPage.clickContinueButton();
	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to 'Login' page");
		userLoginPage = userHomePage.clickLoginLink();

		log.info("Login - Step 02: Login with Email address and Password");
		userHomePage = userLoginPage.loginAsUser(emailAddress, password);

		log.info("Login - Step 03: Navigate to 'Customer Infor' page");
		userCustomerInforPage = userHomePage.clickMyAccountLink();

		log.info("Login - Step 04: Verify 'Customer Infor' page is displayed ");
		verifyTrue(userCustomerInforPage.isCustomerInforPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
