package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.EndUserHomePageUI;

public class EndUserHomePO extends BasePage {
	WebDriver driver;

	public EndUserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostTitleDisplayed(String postTitle) {
		waitForElementVisible(driver, EndUserHomePageUI.POST_TITLE, postTitle);
		return isElementDisplayed(driver, EndUserHomePageUI.POST_TITLE, postTitle);
	}

	public boolean isPostAuthorDisplayed(String postTitle, String authorName) {
		waitForElementVisible(driver, EndUserHomePageUI.POST_AUTHOR_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, EndUserHomePageUI.POST_AUTHOR_BY_POST_TITLE, postTitle, authorName);
	}

	public boolean isPostBodyDisplayed(String postTitle, String postBody) {
		waitForElementVisible(driver, EndUserHomePageUI.POST_BODY_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, EndUserHomePageUI.POST_BODY_BY_POST_TITLE, postTitle, postBody);
	}

	public EndUserPostDetailPO clickToPostTitleLink(String postTitle) {
		waitForElementClickable(driver, EndUserHomePageUI.POST_TITLE, postTitle);
		clickToElement(driver, EndUserHomePageUI.POST_TITLE, postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}

	public boolean isPostedDayDisplayed(String postTitle, String currentDay) {
		waitForElementVisible(driver, EndUserHomePageUI.POSTED_DATE_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, EndUserHomePageUI.POSTED_DATE_BY_POST_TITLE, postTitle, currentDay);
	}

	public void enterToSearchTextbox(String searchValue) {
		waitForElementVisible(driver, EndUserHomePageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, EndUserHomePageUI.SEARCH_TEXTBOX, searchValue);
	}

	public EndUserSearchPostPO clickSearchbutton() {
		waitForElementClickable(driver, EndUserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, EndUserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchPostPage(driver);
	}

	public boolean isPostTitleUndisplayed(String postTitle) {
		return isElementUndisplayed(driver, EndUserHomePageUI.POST_TITLE, postTitle);
	}

}
