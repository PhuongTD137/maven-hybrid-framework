package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Level_17_Custom_Close_Driver extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "fc";
		emailAddress = "auto" + getRandomNumber() + "@gmail.com";
		password = "111111";

		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		userRegisterPage = userHomePage.clickRegisterLink();

		log.info("Pre-condition - Step 02: Enter to Firstname textbox with value is'" + firstName + "'");
		userRegisterPage.sendKeyToFirstNameTextbox(firstName);

		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is'" + lastName + "'");
		userRegisterPage.sendKeyToLastNameTextbox(lastName);

		log.info("Pre-condition - Step 04: Enter to Email textbox with value is'" + emailAddress + "'");
		userRegisterPage.sendKeyToEmailTextbox(emailAddress);

		log.info("Pre-condition - Step 06: Enter to Password textbox with value is'" + password + "'");
		userRegisterPage.sendKeyToPasswordTextbox(password);

		log.info("Pre-condition - Step 07: Enter to Confirm password textbox with value is'" + password + "'");
		userRegisterPage.sendKeyToConfirmPasswordTextbox(password);

		log.info("Pre-condition - Step 08: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		driver = null;

		log.info("Pre-condition - Step 09: Verify register success message is displayed");
		Assert.assertEquals(userRegisterPage.getSuccessMessage(), "Your registration completed");

		log.info("Pre-condition - Step 10: Click 'Continue' button");
		userHomePage = userRegisterPage.clickContinueButton();

		log.info("Pre-condition - Step 11: Navigate to 'Login' page");
		userLoginPage = userHomePage.clickLoginLink();

		log.info("Pre-condition - Step 12: Login with Email address and Password");
		userHomePage = userLoginPage.loginAsUser(emailAddress, password);

	}

	@Test
	public void Search_01_Name() {

	}

	@Test
	public void User_02_Address() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
