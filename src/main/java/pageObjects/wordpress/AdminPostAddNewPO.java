package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTitleTextbox(String titleText) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendKeyToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, titleText);
	}

	public void inputToBodyTextbox(String bodyText) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_AREA);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_AREA);

		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendKeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, bodyText);
	}

	public void clickPrePublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_OR_UPDATE_BUTTON);
	}

	public void clickPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
	}

	public AdminPostSearchPO openPostSearchPage(String url) {
		openPageUrl(driver, url);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

	public String getPostPublishedMessage() {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_PUBLISHED_MESSAGE);
		return getElementText(driver, AdminPostAddNewPageUI.POST_PUBLISHED_MESSAGE);
	}

	public boolean isPostPublishedMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_PUBLISHED_MESSAGE, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.POST_PUBLISHED_MESSAGE, postPublishedMessage);
	}

}
