package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.dataTable.HomePageObject;
import pageObjects.jquery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private List<String> actualAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("2");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isActivePageNumberDisplayed("2"));

		homePage.openPagingByPageNumber("18");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isActivePageNumberDisplayed("18"));

		homePage.openPagingByPageNumber("24");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isActivePageNumberDisplayed("24"));
	}

	// @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToSearchTextBoxByHeader("Females", "643");
		homePage.enterToSearchTextBoxByHeader("Country", "US Virgin Islands");
		homePage.enterToSearchTextBoxByHeader("Males", "709");
		homePage.enterToSearchTextBoxByHeader("Total", "1350");
		sleepInSecond(1);

		homePage.enterToSearchTextBoxByHeader("Females", "338282");
		homePage.enterToSearchTextBoxByHeader("Country", "Argentina");
		homePage.enterToSearchTextBoxByHeader("Males", "349238");
		homePage.enterToSearchTextBoxByHeader("Total", "687522");

	}

	// @Test
	public void Table_03_Get_Data() {
		homePage.refreshCurrentPage(driver);
		sleepInSecond(3);

		homePage.getAllRowsFromAllPages();

		actualAllCountryValues = homePage.getAllValuesByColumn("country");

	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.enterToTextboxAtRowNumberByColumnName("Company", "1", "FPT");
		sleepInSecond(1);
		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person", "1", "Nguyen Thi An");
		sleepInSecond(1);
		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed", "1", "50");
		sleepInSecond(1);

		homePage.clickLoadButton();

		homePage.enterToTextboxAtRowNumberByColumnName("Company", "4", "Fsoft");
		sleepInSecond(1);
		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person", "3", "Linh Tran");
		sleepInSecond(1);
		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed", "5", "1000");
		sleepInSecond(1);

		homePage.selectItemAtRowIndexByColumnName("Country", "6", "Taiwan");
		sleepInSecond(3);
		homePage.selectItemAtRowIndexByColumnName("Country", "3", "Hong Kong");
		sleepInSecond(3);

		homePage.checkToItemAtRowIndexByColumnName("NPO?", "2");
		sleepInSecond(1);
		homePage.checkToItemAtRowIndexByColumnName("NPO?", "3");
		sleepInSecond(1);
		homePage.checkToItemAtRowIndexByColumnName("NPO?", "6");
		sleepInSecond(1);
		homePage.checkToItemAtRowIndexByColumnName("NPO?", "7");
		sleepInSecond(1);
		homePage.checkToItemAtRowIndexByColumnName("NPO?", "8");
		sleepInSecond(1);

		homePage.uncheckToItemAtRowIndexByColumnName("NPO?", "1");
		sleepInSecond(1);
		homePage.uncheckToItemAtRowIndexByColumnName("NPO?", "4");
		sleepInSecond(1);
		homePage.uncheckToItemAtRowIndexByColumnName("NPO?", "5");
		sleepInSecond(1);

		homePage.clickToIconByRowIndex("1", "Insert Row Above");
		sleepInSecond(3);
		homePage.clickToIconByRowIndex("3", "Insert Row Above");
		sleepInSecond(3);
		homePage.clickToIconByRowIndex("7", "Move Up");
		sleepInSecond(3);
		homePage.clickToIconByRowIndex("8", "Move Down");
		sleepInSecond(3);
		homePage.clickToIconByRowIndex("9", "Remove Current Row");
		sleepInSecond(3);
		homePage.clickToIconByRowIndex("7", "Remove Current Row");
		sleepInSecond(3);
		homePage.clickToIconByRowIndex("8", "Remove Current Row");
		sleepInSecond(3);

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
