package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.uploadFiles.HomePageObject;
import pageObjects.jquery.uploadFiles.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	String beachImg = "beach.jpg";
	String computerImg = "computer.jpg";
	String parkImg = "park.jpg";
	String[] multipleFiles = { beachImg, computerImg, parkImg };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadFiles(driver, beachImg);
		homePage.uploadFiles(driver, computerImg);
		homePage.uploadFiles(driver, parkImg);
		sleepInSecond(2);
		Assert.assertTrue(homePage.isFileLoadedByName(beachImg));
		Assert.assertTrue(homePage.isFileLoadedByName(computerImg));
		Assert.assertTrue(homePage.isFileLoadedByName(parkImg));
		sleepInSecond(2);
		homePage.clickStartButton();
		Assert.assertTrue(homePage.isFileUploadedByName(beachImg));
		Assert.assertTrue(homePage.isFileUploadedByName(computerImg));
		Assert.assertTrue(homePage.isFileUploadedByName(parkImg));
		sleepInSecond(2);
		Assert.assertTrue(homePage.IsImageLoaded(beachImg));
		Assert.assertTrue(homePage.IsImageLoaded(computerImg));
		Assert.assertTrue(homePage.IsImageLoaded(parkImg));
	}

	@Test
	public void Upload_02_Multiple_Files_Per_Time() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadFiles(driver, multipleFiles);
		sleepInSecond(2);
		Assert.assertTrue(homePage.isFileLoadedByName(beachImg));
		Assert.assertTrue(homePage.isFileLoadedByName(computerImg));
		Assert.assertTrue(homePage.isFileLoadedByName(parkImg));
		sleepInSecond(2);
		homePage.clickStartButton();
		sleepInSecond(2);
		Assert.assertTrue(homePage.isFileUploadedByName(beachImg));
		Assert.assertTrue(homePage.isFileUploadedByName(computerImg));
		Assert.assertTrue(homePage.isFileUploadedByName(parkImg));
		sleepInSecond(2);
		Assert.assertTrue(homePage.IsImageLoaded(beachImg));
		Assert.assertTrue(homePage.IsImageLoaded(computerImg));
		Assert.assertTrue(homePage.IsImageLoaded(parkImg));
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
