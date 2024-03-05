package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getContactInformationText() {
		waitForElementVisible(driver, MyAccountPageUI.CONTACT_INFORMATION_TEXT);
		return getElementText(driver, MyAccountPageUI.CONTACT_INFORMATION_TEXT);
	}

	public void clickMyAccountLink() {
		waitForElementClickable(driver, MyAccountPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, MyAccountPageUI.MY_ACCOUNT_LINK);

	}

	public HomePageObject clickLogoutLink() {
		waitForElementClickable(driver, MyAccountPageUI.LOGOUT_LINK);
		clickToElement(driver, MyAccountPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
}
