package org.live.guru;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTestLiveGuru;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyAccountPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTestLiveGuru {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;

	String firstName, lastName, emailAddress, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		firstName = "Automation";
		lastName = "fc";
		emailAddress = "auto" + getRandomNumber() + "@gmail.com";
		password = "auto@1234";

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Register_To_System() {
		homePage.clickMyAccountLink();
		registerPage = homePage.clickRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);

		myAccountPage = registerPage.clickRegisterButton();

		Assert.assertTrue(myAccountPage.getContactInformationText().contains(firstName + " " + lastName + "\n" + emailAddress));

		myAccountPage.clickMyAccountLink();
		homePage = myAccountPage.clickLogoutLink();
	}

	@Test
	public void TC_02_Login_To_System() {
		homePage.clickMyAccountLink();
		loginPage = homePage.clickLoginLink();

		loginPage.inputToEmailAddressTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		myAccountPage = loginPage.clickLoginButton();

		Assert.assertTrue(myAccountPage.getContactInformationText().contains(firstName + " " + lastName + "\n" + emailAddress));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
