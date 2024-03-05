package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_A extends BaseTest {
	private WebDriver driver;
	private String emailAddress, password;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = Common_01_Register_End_User.emailAddress;
		password = Common_01_Register_End_User.password;

		log.info("Login - Step 01: Navigate to 'Login' page");
		userLoginPage = userHomePage.clickLoginLink();

		log.info("Login - Step 02: Login with Email address and Password");
		userHomePage = userLoginPage.loginAsUser(emailAddress, password);

		log.info("Login - Step 03: Navigate to 'Customer Infor' page");
		userCustomerInforPage = userHomePage.clickMyAccountLink();

		log.info("Login - Step 04: Verify 'Customer Infor' page is displayed ");
		verifyTrue(userCustomerInforPage.isCustomerInforPageDisplayed());

	}

	@Test
	public void Search_01() {

	}

	@Test
	public void Search_02() {

	}

	@Test
	public void Search_03() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
