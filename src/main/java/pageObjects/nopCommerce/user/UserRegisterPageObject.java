package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {

	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click Register button")
	public void clickRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);

	}

	public String getFirstNameErrorMessage() {
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getLastNameErrorMessage() {
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getRequiredEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REQUIRED_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REQUIRED_EMAIL_ERROR_MESSAGE);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Enter to FirstName textbox with value is {0}")
	public void sendKeyToFirstNameTextbox(String firstName) {
		sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	@Step("Enter to LastName textbox with value is {0}")
	public void sendKeyToLastNameTextbox(String lastName) {
		sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	@Step("Enter to Email textbox with value is {0}")
	public void sendKeyToEmailTextbox(String emailAddress) {
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	@Step("Enter to Password textbox with value is {0}")
	public void sendKeyToPasswordTextbox(String password) {
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	@Step("Enter to ConfirmPassword textbox with value is {0}")
	public void sendKeyToConfirmPasswordTextbox(String password) {
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);

	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	@Step("Verify success message is displayed")
	public String getSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.SUCCESS_MESSAGE);
	}

	@Step("Navigate to Home page")
	public UserHomePageObject clickContinueButton() {
		waitForElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
