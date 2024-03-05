package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.EndUserSearchPostPageUI;

public class EndUserSearchPostPO extends BasePage {
	WebDriver driver;

	public EndUserSearchPostPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNothingFoundTitleMessageDisplayed(String messageTitle) {
		waitForElementVisible(driver, EndUserSearchPostPageUI.NOTHING_FOUND_TITLE_MESSAGE, messageTitle);
		return isElementDisplayed(driver, EndUserSearchPostPageUI.NOTHING_FOUND_TITLE_MESSAGE, messageTitle);
	}

	public boolean isNothingFoundDetailMessageDisplayed(String messageDetail) {
		waitForElementVisible(driver, EndUserSearchPostPageUI.NOTHING_FOUND_DETAIL_MESSAGE, messageDetail);
		return isElementDisplayed(driver, EndUserSearchPostPageUI.NOTHING_FOUND_DETAIL_MESSAGE, messageDetail);
	}
}
