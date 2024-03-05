package com.nopcommerce.user;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_C extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 01: Navigate to 'Login' page");
		userLoginPage = userHomePage.clickLoginLink();

		log.info("Pre-condition - Step 02: Set Cookies and reload page");
		userLoginPage.setCookies(driver, Common_01_Register_Cookie.allCookies);
		for (Cookie cookie : Common_01_Register_Cookie.allCookies) {
			System.out.println("cookie tai class c" + cookie);
		}
		userLoginPage.refreshCurrentPage(driver);
		sleepInSecond(3);

		log.info("Pre-condition - Step 03: Verify 'My Account' link is displayed ");
		verifyTrue(userHomePage.isMyAccountLinkDisplayed());

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
		// driver.quit();
	}

}
