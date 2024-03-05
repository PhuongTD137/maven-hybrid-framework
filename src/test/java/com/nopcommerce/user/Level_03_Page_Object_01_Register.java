package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_03_Page_Object_01_Register {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	private String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		emailAddress = "automation" + getRandomNumber() + "@gmail.com";
		firstName = "An";
		lastName = "Nguyen";
		password = "123456";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		// Khi mở Url thì nó qua trang HomePage -> khởi tạo HomePage
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Step 01: Click Register link");
		homePage.clickRegisterLink();

		// Sau khi click Register Link -> nhảy qua trang Register -> khởi tạo RegisterPage
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_01 - Step 02: Click Register button");
		registerPage.clickRegisterButton();

		System.out.println("Register_01 - Step 03: Verify error messages displayed");
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getRequiredEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void Register_02_Register_Invalid_Email() {
		System.out.println("Register_02 - Step 01: Click Register link");
		homePage.clickRegisterLink();

		// Sau khi click Register Link -> nhảy qua trang Register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_02 - Step 02: Input to required fields");
		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.sendKeyToEmailTextbox("123@123");
		registerPage.sendKeyToPasswordTextbox(password);
		registerPage.sendKeyToConfirmPasswordTextbox(password);

		System.out.println("Register_02 - Step 03: Click Register button");
		registerPage.clickRegisterButton();

		System.out.println("Register_02 - Step 04: Verify error messages displayed");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void Register_03_Success() {
		System.out.println("Register_03 - Step 01: Click Register link");
		homePage.clickRegisterLink();

		// Sau khi click Register Link -> nhảy qua trang Register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_03 - Step 02: Input to required fields");
		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox(password);
		registerPage.sendKeyToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - Step 03: Click Register button");
		registerPage.clickRegisterButton();

		System.out.println("Register_02 - Step 04: Verify success messages displayed");
		Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		registerPage.clickContinueButton();

		homePage = new UserHomePageObject(driver);
		Assert.assertEquals(homePage.getHomePageUrl(), "https://demo.nopcommerce.com/");
	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Register_04 - Step 01: Click Register link");
		homePage.clickRegisterLink();

		// Sau khi click Register Link -> nhảy qua trang Register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_04 - Step 02: Input to required fields");
		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox(password);
		registerPage.sendKeyToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - Step 03: Click Register button");
		registerPage.clickRegisterButton();

		System.out.println("Register_04 - Step 04: Verify error messages displayed");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		System.out.println("Register_05 - Step 01: Click Register link");
		homePage.clickRegisterLink();

		// Sau khi click Register Link -> nhảy qua trang Register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_05 - Step 02: Input to required fields");
		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox("12345");
		registerPage.sendKeyToConfirmPasswordTextbox("12345");

		System.out.println("Register_05 - Step 03: Click Register button");
		registerPage.clickRegisterButton();

		System.out.println("Register_05 - Step 04: Verify error messages displayed");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_ConfirmPassword_NotMatch_Password() {
		System.out.println("Register_06 - Step 01: Click Register link");
		homePage.clickRegisterLink();

		// Sau khi click Register Link -> nhảy qua trang Register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_06 - Step 02: Input to required fields");
		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox(password);
		registerPage.sendKeyToConfirmPasswordTextbox("123457");

		System.out.println("Register_06 - Step 03: Click Register button");
		registerPage.clickRegisterButton();

		System.out.println("Register_06 - Step 04: Verify error messages displayed");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
