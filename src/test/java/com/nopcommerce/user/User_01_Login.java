package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class User_01_Login extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	String password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		emailAddress = "auto" + getRandomNumber() + "@gmail.com";
		password = "111111";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		openPageUrl(driver, "https://demo.nopcommerce.com");

	}

	@Test
	public void TC_01_Login_Empty_Data() {
		waitForElementClickable(driver, "//a[@class = 'ico-register']");
		clickToElement(driver, "//a[@class = 'ico-register']");

		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", password);
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		waitForElementClickable(driver, "//a[@class = 'ico-login']");
		clickToElement(driver, "//a[@class = 'ico-login']");

		waitForElementClickable(driver, "//button[text()='Log in']");
		clickToElement(driver, "//button[text()='Log in']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Please enter your email");

	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		waitForElementClickable(driver, "//a[@class = 'ico-login']");
		clickToElement(driver, "//a[@class = 'ico-login']");

		sendKeyToElement(driver, "//input[@id='Email']", "123@123");
		sendKeyToElement(driver, "//input[@id='Password']", password);

		clickToElement(driver, "//button[text()='Log in']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'message-error')]"), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_03_Login_Not_Registered_Email() {
		waitForElementClickable(driver, "//a[@class = 'ico-login']");
		clickToElement(driver, "//a[@class = 'ico-login']");

		sendKeyToElement(driver, "//input[@id='Email']", "auto.12@gmail.com");
		sendKeyToElement(driver, "//input[@id='Password']", password);

		clickToElement(driver, "//button[text()='Log in']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'message-error')]"), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Login_Not_Input_Password() {
		waitForElementClickable(driver, "//a[@class = 'ico-login']");
		clickToElement(driver, "//a[@class = 'ico-login']");

		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);

		clickToElement(driver, "//button[text()='Log in']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'message-error')]"), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_05_Login_Wrong_Password() {
		waitForElementClickable(driver, "//a[@class = 'ico-login']");
		clickToElement(driver, "//a[@class = 'ico-login']");

		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", "123123");

		clickToElement(driver, "//button[text()='Log in']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'message-error')]"), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Successful() {
		waitForElementClickable(driver, "//a[@class = 'ico-login']");
		clickToElement(driver, "//a[@class = 'ico-login']");

		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", password);

		clickToElement(driver, "//button[text()='Log in']");

		Assert.assertEquals(getPageUrl(driver), "https://demo.nopcommerce.com/");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
