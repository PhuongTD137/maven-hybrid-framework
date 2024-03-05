package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_15_Allure extends BaseTest {
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

	@Description("Register to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register() {

		userRegisterPage = userHomePage.clickRegisterLink();

		userRegisterPage.sendKeyToFirstNameTextbox(firstName);

		userRegisterPage.sendKeyToLastNameTextbox(lastName);

		userRegisterPage.sendKeyToEmailTextbox(emailAddress);

		userRegisterPage.sendKeyToPasswordTextbox(password);

		userRegisterPage.sendKeyToConfirmPasswordTextbox(password);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getSuccessMessage(), "Your registration completed");

		userHomePage = userRegisterPage.clickContinueButton();

	}

	@Description("Login to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_02_Login() {

		userLoginPage = userHomePage.clickLoginLink();

		userHomePage = userLoginPage.loginAsUser(emailAddress, password);

		Assert.assertFalse(userHomePage.isMyAccountLinkDisplayed());

		userCustomerInforPage = userHomePage.clickMyAccountLink();

		Assert.assertFalse(userCustomerInforPage.isCustomerInforPageDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
