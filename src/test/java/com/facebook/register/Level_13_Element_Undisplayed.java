package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.register.LoginPageObject;
import pageObjects.facebook.register.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	String email;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		email = "auto" + getRandomNumber() + "@gmail.com";
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {

		loginPage.clickCreateNewAccountButton();

		loginPage.inputToEmailTextbox(email);
		sleepInSecond(2);

		verifyTrue(loginPage.isConfirmEmailTextboxDisplayed());
	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		loginPage.inputToEmailTextbox("");
		sleepInSecond(2);

		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());
	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIcon();
		sleepInSecond(2);

		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
