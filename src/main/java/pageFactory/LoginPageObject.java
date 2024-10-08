package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement emailTextbox;

	@FindBy(id = "Password")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement summaryErrorMessage;

	public void clickLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);
	}

	public String getSummaryErrorMessage() {
		waitForElementVisible(driver, summaryErrorMessage);
		return getElementText(driver, summaryErrorMessage);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}
}
