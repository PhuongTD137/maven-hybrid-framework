package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.sauceDemo.LoginPageObject;
import pageObjects.sauceDemo.PageGeneratorManager;
import pageObjects.sauceDemo.ProductPageObject;

public class Level_19_Sort_Data extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;
	private String userName = "standard_user";
	private String password = "secret_sauce";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String sauceUrl) {
		driver = getBrowserDriver(browserName, sauceUrl);
		loginPage = PageGeneratorManager.openLoginPage(driver);

		loginPage.inputToUsernameTextbox(userName);
		loginPage.inputToPasswordTextbox(password);
		productPage = loginPage.clickLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		log.info("Sort by Name - Step 01: Click to 'Name (A to Z)' filter");
		productPage.clickToSortFilter("Name (A to Z)");

		log.info("Sort by Name - Step 02: Verify products are sorted by name in ascending");
		verifyTrue(productPage.isProductSortedByNameInAscending());

		log.info("Sort by Name - Step 03: Click to 'Name (Z to A)' filter");
		productPage.clickToSortFilter("Name (Z to A)");

		log.info("Sort by Name - Step 04: Verify products are sorted by name in descending");
		verifyTrue(productPage.isProductSortedByNameInDescending());
	}

	@Test
	public void Sort_02_Price() {
		log.info("Sort by Name - Step 01: Click to 'Price (low to high)' filter");
		productPage.clickToSortFilter("Price (low to high)");

		log.info("Sort by Name - Step 02: Verify products are sorted by price in ascending");
		verifyTrue(productPage.isProductSortedByPriceInAscending());

		log.info("Sort by Name - Step 03: Click to 'Price (high to low)' filter");
		productPage.clickToSortFilter("Price (high to low)");

		log.info("Sort by Name - Step 04: Verify products are sorted by price in descending");
		verifyTrue(productPage.isProductSortedByPriceInDescending());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
