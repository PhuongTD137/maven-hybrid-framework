package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;

	@FindBy(id = "Email")
	private WebElement emailTextbox;

	@FindBy(id = "Password")
	private WebElement passwordTextbox;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;

	@FindBy(id = "register-button")
	private WebElement registerButton;

	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMessage;

	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMessage;

	@FindBy(id = "Email-error")
	private WebElement requiredEmailErrorMessage;

	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(css = "div.result")
	private WebElement successMessage;

	@FindBy(xpath = "//div/a[contains(@class, 'register-continue-button')]")
	private WebElement continueButton;

	public void clickRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public String getFirstNameErrorMessage() {
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getLastNameErrorMessage() {
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getRequiredEmailErrorMessage() {
		waitForElementVisible(driver, requiredEmailErrorMessage);
		return getElementText(driver, requiredEmailErrorMessage);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void sendKeyToFirstNameTextbox(String firstName) {
		sendKeyToElement(driver, firstNameTextbox, firstName);
	}

	public void sendKeyToLastNameTextbox(String lastName) {
		sendKeyToElement(driver, lastNameTextbox, lastName);

	}

	public void sendKeyToEmailTextbox(String emailAddress) {
		sendKeyToElement(driver, emailTextbox, emailAddress);

	}

	public void sendKeyToPasswordTextbox(String password) {
		sendKeyToElement(driver, passwordTextbox, password);

	}

	public void sendKeyToConfirmPasswordTextbox(String password) {
		sendKeyToElement(driver, confirmPasswordTextbox, password);

	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getSuccessMessage() {
		waitForElementVisible(driver, successMessage);
		return getElementText(driver, successMessage);
	}

	public void clickContinueButton() {
		waitForElementClickable(driver, continueButton);
		clickToElement(driver, continueButton);
	}

}
