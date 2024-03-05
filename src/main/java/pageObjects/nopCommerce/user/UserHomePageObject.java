package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {

	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Navigate to Register page")
	public UserRegisterPageObject clickRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	@Step("Navigate to Login page")
	public UserLoginPageObject clickLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Verify 'Log out' link is displayed")
	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_LINK);
	}

	@Step("Verify 'Log in' link is displayed")
	public boolean isLoginLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}

	@Step("Navigate to 'Customer Info' page")
	public UserCustomerInforPageObject clickMyAccountLink() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	@Step("Verify 'My account' link is displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public void clickLogoutLink() {
		waitForElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);

	}

	public String getHomePageUrl() {
		return getPageUrl(driver);
	}

}
