package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_08_Switch_Role_II extends BaseTest {
	private WebDriver driver;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	private UserLoginPageObject userLoginPage;
	private UserHomePageObject userHomePage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private UserCustomerInforPageObject userCustomerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userEmailAddress = "auto12@gmail.com";
		userPassword = "111111";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.clickLoginLink();

		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isLogoutLinkDisplayed());

		userCustomerInforPage = userHomePage.clickMyAccountLink();

		userHomePage = userCustomerInforPage.clickUserLogoutLink(driver);

		adminLoginPage = userHomePage.openAdminPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);

		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

		adminLoginPage = adminDashboardPage.clickAdminLogoutLink(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		userHomePage = adminLoginPage.openUserPageUrl(driver, GlobalConstants.PORTAL_DEV_URL);

		userLoginPage = userHomePage.clickLoginLink();

		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isLogoutLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
