package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {
	WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickAddNewPostButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void enterToSearchTextbox(String searchValue) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, searchValue);
	}

	public void clickSearchPostButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
	}

	public boolean isPostSearchTableDisplayed(String headerIDName, String cellValue) {
		int columnIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerIDName) + 1;
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(columnIndex), cellValue);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(columnIndex), cellValue);
	}

	public AdminPostAddNewPO clickPostTitleLink(String headerIDName, String cellValue) {
		int columnIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerIDName) + 1;
		waitForElementClickable(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(columnIndex), cellValue);
		clickToElement(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(columnIndex), cellValue);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void selectPostCheckboxByTitle(String postTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.CHECKBOX_BY_POST_TITLE, postTitle);
		checkToDefaultCheckboxRadio(driver, AdminPostSearchPageUI.CHECKBOX_BY_POST_TITLE, postTitle);
	}

	public void selectTextItemInActionDropdown(String actionName) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ACTION_DROP_DOWN);
		clickToElement(driver, AdminPostSearchPageUI.ACTION_DROP_DOWN);
		selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.ACTION_DROP_DOWN, actionName);
	}

	public void clickApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
	}

	public boolean IsActionMessageDisplayed(String actionMessage) {
		waitForElementVisible(driver, AdminPostSearchPageUI.ACTION_MESSAGE, actionMessage);
		return isElementDisplayed(driver, AdminPostSearchPageUI.ACTION_MESSAGE, actionMessage);
	}

	public boolean IsNoPostFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
	}

}
