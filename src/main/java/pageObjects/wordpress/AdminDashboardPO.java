package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickPostIcon() {
		waitForElementClickable(driver, AdminDashboardPageUI.POST_ICON);
		clickToElement(driver, AdminDashboardPageUI.POST_ICON);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}
}
