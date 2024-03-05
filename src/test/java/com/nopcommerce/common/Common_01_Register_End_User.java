package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName;
	public static String emailAddress, password;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;

	@Parameters("browser")
	@BeforeTest(description = "Create new user for all Test Classes")
	public void Register(String browserName) {
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

		log.info("Pre-condition - Step 09: Verify register success message is displayed");
		verifyEquals(userRegisterPage.getSuccessMessage(), "Your registration completed");

		log.info("Pre-condition - Step 10: Click 'Continue' button");
		userHomePage = userRegisterPage.clickContinueButton();

		driver.quit();
	}

}
