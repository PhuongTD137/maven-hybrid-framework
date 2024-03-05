package pageObjects.facebook.register;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.register.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);

	}

	public boolean isConfirmEmailTextboxDisplayed() {
		// waitForElementVisible(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.PHONE_OR_EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PHONE_OR_EMAIL_TEXTBOX, email);
	}

	public void clickCloseIcon() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
	}

	public boolean isConfirmEmailTextboxUndisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

}
