package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.ico-register")
	private WebElement registerLink;

	@FindBy(css = "a.ico-login")
	private WebElement loginLink;

	@FindBy(css = "a.ico-logout")
	private WebElement logoutLink;

	public void clickRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public String getHomePageUrl() {
		return getPageUrl(driver);
	}

	public void clickLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, logoutLink);
		return isElementDisplayed(driver, logoutLink);
	}

	public void clickLogoutLink() {
		waitForElementVisible(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

	public boolean isLoginLinkDisplayed() {
		waitForElementVisible(driver, loginLink);
		return isElementDisplayed(driver, loginLink);
	}
}
