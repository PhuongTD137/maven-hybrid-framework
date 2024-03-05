package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, password);
	}

	public void clickLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
	}

	public AdminDashboardPageObject loginAsAdmin(String email, String password) {
		inputToEmailTextBox(email);
		inputToPasswordTextBox(password);
		clickLoginButton();
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
}