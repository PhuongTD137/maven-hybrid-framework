package com.nopcommerce.user;

import java.lang.reflect.Method;

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

public class Level_15_ExtentV2_Screenshot extends BaseTest {
	WebDriver driver;
	String firstName, lastName, emailAddress, password;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	UserCustomerInforPageObject userCustomerInforPage;

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
	public void User_01_Register(Method method) {
		// ExtentManager.startTest(method.getName(), "User_01_NewCustomer");
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
		// userRegisterPage = userHomePage.clickRegisterLink();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is'" + firstName + "'");
		// userRegisterPage.sendKeyToFirstNameTextbox(firstName);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname textbox with value is'" + lastName + "'");
		// userRegisterPage.sendKeyToLastNameTextbox(lastName);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is'" + emailAddress + "'");
		// userRegisterPage.sendKeyToEmailTextbox(emailAddress);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is'" + password + "'");
		// userRegisterPage.sendKeyToPasswordTextbox(password);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm password textbox with value is'" + password + "'");
		// userRegisterPage.sendKeyToConfirmPasswordTextbox(password);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click 'Register' button");
		// userRegisterPage.clickRegisterButton();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success message is displayed");
		// Assert.assertEquals(userRegisterPage.getSuccessMessage(), "Your registration completed...");
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 09: Click 'Continue' button");
		// userHomePage = userRegisterPage.clickContinueButton();
		//
		// ExtentManager.endTest();
	}

	@Test
	public void User_02_Login(Method method) {
		// ExtentManager.startTest(method.getName(), "User_02_Login");
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to 'Login' page");
		// userLoginPage = userHomePage.clickLoginLink();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Login with Email address and Password");
		// userHomePage = userLoginPage.loginAsUser(emailAddress, password);
		//
		// // verify myAccountLink is displayed
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Verify 'My Account Link' is displayed");
		// Assert.assertFalse(userHomePage.isMyAccountLinkDisplayed());
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Navigate to 'Customer Infor' page");
		// userCustomerInforPage = userHomePage.clickMyAccountLink();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'Customer Infor' page is displayed ");
		// Assert.assertFalse(userCustomerInforPage.isCustomerInforPageDisplayed());
		//
		// ExtentManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
