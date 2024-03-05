package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_ExtentV5_Screenshot extends BaseTest {
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
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
		userRegisterPage = userHomePage.clickRegisterLink();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is'" + firstName + "'");
		userRegisterPage.sendKeyToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is'" + lastName + "'");
		userRegisterPage.sendKeyToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is'" + emailAddress + "'");
		userRegisterPage.sendKeyToEmailTextbox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is'" + password + "'");
		userRegisterPage.sendKeyToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm password textbox with value is'" + password + "'");
		userRegisterPage.sendKeyToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click 'Register' button");
		userRegisterPage.clickRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(userRegisterPage.getSuccessMessage(), "Your registration completed");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 09: Click 'Continue' button");
		userHomePage = userRegisterPage.clickContinueButton();

	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to 'Login' page");
		userLoginPage = userHomePage.clickLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Login with Email address and Password");
		userHomePage = userLoginPage.loginAsUser(emailAddress, password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Verify 'My Account Link' is displayed");
		Assert.assertFalse(userHomePage.isMyAccountLinkDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Navigate to 'Customer Infor' page");
		userCustomerInforPage = userHomePage.clickMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'Customer Infor' page is displayed");
		Assert.assertFalse(userCustomerInforPage.isCustomerInforPageDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
