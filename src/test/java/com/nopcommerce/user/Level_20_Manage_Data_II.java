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

public class Level_20_Manage_Data_II extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password, company, date, month, year, gender;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;

	@Parameters({ "browser", "firstName", "lastName", "emailAddress", "password", "company", "date", "month", "year" })
	@BeforeClass
	public void beforeClass(String browserName, String firstName, String lastName, String emailAddress, String password, String company, String date, String month, String year) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress + getRandomNumber() + "@gmail.com";
		this.password = password;
		this.company = company;
		this.date = date;
		this.month = month;
		this.year = year;
		gender = "Female";
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		userRegisterPage = userHomePage.clickRegisterLink();

		log.info("Register - Step 02: Select to Radio button");
		userRegisterPage.selectRadioButtonByLabel(driver, gender);

		log.info("Register - Step 03: Enter to Firstname textbox with value is'" + firstName + "'");
		userRegisterPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - Step 04: Enter to Lastname textbox with value is'" + lastName + "'");
		userRegisterPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register - Step 05: Enter to Email textbox with value is'" + emailAddress + "'");
		userRegisterPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register - Step 06: Enter to Password textbox with value is'" + password + "'");
		userRegisterPage.inputToTextboxByID(driver, "Password", password);

		log.info("Register - Step 07: Enter to Confirm password textbox with value is'" + password + "'");
		userRegisterPage.inputToTextboxByID(driver, "ConfirmPassword", password);

		log.info("Register - Step 08: Enter to Company textbox with value is'" + company + "'");
		userRegisterPage.inputToTextboxByID(driver, "Company", company);

		log.info("Register - Step 09: Select Birth day dropdown with value is'" + date + "'");
		userRegisterPage.selectDropdownByName(driver, "DateOfBirthDay", date);

		log.info("Register - Step 10: Select Birth month dropdown with value is'" + month + "'");
		userRegisterPage.selectDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register - Step 11: Select Birth year dropdown with value is'" + year + "'");
		userRegisterPage.selectDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register - Step 12: Select checkbox by ID");
		userRegisterPage.selectCheckboxByID(driver, "Newsletter");

		log.info("Register - Step 13: Click 'Register' button");
		userRegisterPage.clickButtonByTextValue(driver, "Register");

		log.info("Register - Step 14: Verify register success message is displayed");
		Assert.assertEquals(userRegisterPage.getSuccessMessage(), "Your registration completed");

		log.info("Register - Step 15: Click 'Continue' button");
		userHomePage = userRegisterPage.clickContinueButton();
	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to 'Login' page");
		userLoginPage = userHomePage.clickLoginLink();

		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		userLoginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + password + "'");
		userLoginPage.inputToTextboxByID(driver, "Password", password);

		log.info("Login - Step 04: Click 'Log in' button");
		userLoginPage.clickButtonByTextValue(driver, "Log in");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		// verify myAccountLink is displayed
		log.info("Login - Step 03: Verify 'My Account Link' is displayed");
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_My_Account() {
		log.info("My Account - Step 01: Navigate to 'Customer Infor' page");
		userCustomerInforPage = userHomePage.clickMyAccountLink();

		log.info("My Account - Step 02: Verify 'Customer Info' page is displayed");
		Assert.assertTrue(userCustomerInforPage.isCustomerInforPageDisplayed());

		log.info("My Account - Step 03: Verify 'First name' textbox is correct");
		Assert.assertEquals(userCustomerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("My Account - Step 04: Verify 'Last name' textbox is correct");
		Assert.assertEquals(userCustomerInforPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("My Account - Step 05: Verify 'Email' textbox is correct");
		Assert.assertEquals(userCustomerInforPage.getTextboxValueByID(driver, "Email"), emailAddress);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
