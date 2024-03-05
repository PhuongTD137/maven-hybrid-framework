package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.EndUserPostDetailPageUI;

public class EndUserPostDetailPO extends BasePage {
	WebDriver driver;

	public EndUserPostDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostTitleDisplayed(String postTitle) {
		waitForElementVisible(driver, EndUserPostDetailPageUI.POST_TITLE, postTitle);
		return isElementDisplayed(driver, EndUserPostDetailPageUI.POST_TITLE, postTitle);
	}

	public boolean isPostAuthorDisplayed(String postTitle, String authorName) {
		waitForElementVisible(driver, EndUserPostDetailPageUI.POST_AUTHOR_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, EndUserPostDetailPageUI.POST_AUTHOR_BY_POST_TITLE, postTitle, authorName);
	}

	public boolean isPostBodyDisplayed(String postTitle, String postBody) {
		waitForElementVisible(driver, EndUserPostDetailPageUI.POST_BODY_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, EndUserPostDetailPageUI.POST_BODY_BY_POST_TITLE, postTitle, postBody);
	}

	public boolean isPostedDayDisplayed(String postTitle, String currentDay) {
		waitForElementVisible(driver, EndUserPostDetailPageUI.POSTED_DATE_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, EndUserPostDetailPageUI.POSTED_DATE_BY_POST_TITLE, postTitle, currentDay);
	}

}
