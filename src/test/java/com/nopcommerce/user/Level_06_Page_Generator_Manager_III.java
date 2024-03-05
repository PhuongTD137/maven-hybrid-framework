package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserLoginPageObject loginPage;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "fc";
		emailAddress = "auto" + getRandomNumber() + "@gmail.com";
		password = "111111";

		System.out.println("Pre-condition - Step 01: Click Register link");
		registerPage = homePage.clickRegisterLink();

		System.out.println("Pre-condition - Step 02: Input to required fields");
		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox(password);
		registerPage.sendKeyToConfirmPasswordTextbox(password);

		System.out.println("Pre-condition - Step 03: Click Register button");
		registerPage.clickRegisterButton();

		System.out.println("Pre-condition - Step 04: Verify success messages displayed");
		Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - Step 05: Click Continue button");
		registerPage.clickContinueButton();

		homePage = PageGeneratorManager.getUserHomePage(driver);

		System.out.println("Pre-condition - Step 06: Verify return to Homepage");
		Assert.assertEquals(homePage.getHomePageUrl(), "https://demo.nopcommerce.com/");

	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01 - Step 1: Click Login link");
		loginPage = homePage.clickLoginLink();

		System.out.println("Login_01 - Step 2: Click Login button");
		loginPage.clickLoginButton();

		System.out.println("Login_01 - Step 3: Verify error message displayed");
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02 - Step 1: Click Login link");
		loginPage = homePage.clickLoginLink();

		System.out.println("Login_02 - Step 2: Input invalid email");
		loginPage.inputToEmailTextbox("123@#$");
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_02 - Step 3: Click Login button");
		loginPage.clickLoginButton();

		System.out.println("Login_02 - Step 4: Verify error message displayed");
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void Login_03_Not_Registered_Email() {
		System.out.println("Login_03 - Step 1: Click Login link");
		loginPage = homePage.clickLoginLink();

		System.out.println("Login_03 - Step 2: Input not-existing email");
		loginPage.inputToEmailTextbox("aaa@gmail.com");
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_03 - Step 3: Click Login button");
		loginPage.clickLoginButton();

		System.out.println("Login_03 - Step 4: Verify error message displayed");
		Assert.assertEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Not_Input_Password() {
		System.out.println("Login_04 - Step 1: Click Login link");
		loginPage = homePage.clickLoginLink();

		System.out.println("Login_04 - Step 2: Not input password");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("");

		System.out.println("Login_04 - Step 3: Click Login button");
		loginPage.clickLoginButton();

		System.out.println("Login_04 - Step 4: Verify error message displayed");
		Assert.assertEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Wrong_Password() {
		System.out.println("Login_05 - Step 1: Click Login link");
		loginPage = homePage.clickLoginLink();

		System.out.println("Login_05 - Step 2: Input wrong password");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123456");

		System.out.println("Login_05 - Step 3: Click Login button");
		loginPage.clickLoginButton();

		System.out.println("Login_05 - Step 4: Verify error message displayed");
		Assert.assertEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Success() {
		System.out.println("Login_06 - Step 1: Click Login link");
		loginPage = homePage.clickLoginLink();

		System.out.println("Login_06 - Step 2: Input right email and password");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_06 - Step 3: Click Login button");
		loginPage.clickLoginButton();

		homePage = PageGeneratorManager.getUserHomePage(driver);

		System.out.println("Login_06 - Step 4: Verify successful login - Log out link displayed");
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());

		System.out.println("Login_06 - Step 5: Click Log out link");
		homePage.clickLogoutLink();

		System.out.println("Login_06 - Step 6: Verify successful logout - Log in link displayed");
		Assert.assertTrue(homePage.isLoginLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
