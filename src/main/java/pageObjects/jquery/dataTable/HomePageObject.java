package pageObjects.jquery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String number) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGINATION_NUMBER, number);
		clickToElement(driver, HomePageUI.DYNAMIC_PAGINATION_NUMBER, number);
	}

	public boolean isActivePageNumberDisplayed(String number) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_ACTIVE_PAGINATION_NUMBER, number);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_ACTIVE_PAGINATION_NUMBER, number);
	}

	public void enterToSearchTextBoxByHeader(String searchBy, String textValue) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_SEARCH_TEXTBOX, searchBy);
		sendKeyToElement(driver, HomePageUI.DYNAMIC_SEARCH_TEXTBOX, textValue, searchBy);
		pressKeyToElement(driver, HomePageUI.DYNAMIC_SEARCH_TEXTBOX, Keys.ENTER, searchBy);
	}

	public List<String> getAllRowsFromAllPages() {
		List<WebElement> totalPage = getListWebElement(driver, HomePageUI.PAGE_NUMBER);

		List<String> allRowValues = new ArrayList<String>();

		for (int i = 1; i <= totalPage.size(); i++) {
			clickToElement(driver, HomePageUI.DYNAMIC_PAGINATION_NUMBER, String.valueOf(i));

			List<WebElement> allRows = getListWebElement(driver, HomePageUI.ROW_EACH_PAGE);
			for (WebElement row : allRows) {
				System.out.println(row.getText());
				allRowValues.add(row.getText());
			}
		}
		return allRowValues;
	}

	public List<String> getAllValuesByColumn(String columnName) {
		List<WebElement> totalPage = getListWebElement(driver, HomePageUI.PAGE_NUMBER);

		List<String> allRowValues = new ArrayList<String>();

		for (int i = 1; i <= totalPage.size(); i++) {
			clickToElement(driver, HomePageUI.DYNAMIC_PAGINATION_NUMBER, String.valueOf(i));

			List<WebElement> allRows = getListWebElement(driver, HomePageUI.DYNAMIC_COLUMN, columnName);
			for (WebElement row : allRows) {
				System.out.println(row.getText());
				allRowValues.add(row.getText());
			}
		}
		return allRowValues;
	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowIndex, String textValue) {
		int columnIndex = getListWebElement(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName).size() + 1;
		waitForElementClickable(driver, HomePageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		sendKeyToElement(driver, HomePageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, textValue, rowIndex, String.valueOf(columnIndex));
	}

	public void clickLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
	}

	public void selectItemAtRowIndexByColumnName(String columnName, String rowIndex, String textValue) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		System.out.println(columnIndex);
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, textValue, rowIndex, String.valueOf(columnIndex));
	}

	public void checkToItemAtRowIndexByColumnName(String columnName, String rowIndex) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	}

	public void uncheckToItemAtRowIndexByColumnName(String columnName, String rowIndex) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToIconByRowIndex(String rowIndex, String actionName) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, actionName);
		clickToElement(driver, HomePageUI.ICON_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, actionName);
	}

}
