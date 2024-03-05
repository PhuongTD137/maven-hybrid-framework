package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}

	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}

	public static AdminPostSearchPO getAdminPostSearchPage(WebDriver driver) {
		return new AdminPostSearchPO(driver);
	}

	public static AdminPostAddNewPO getAdminPostAddNewPage(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}

	public static EndUserHomePO getUserHomePage(WebDriver driver) {
		return new EndUserHomePO(driver);
	}

	public static EndUserPostDetailPO getUserPostDetailPage(WebDriver driver) {
		return new EndUserPostDetailPO(driver);
	}

	public static EndUserSearchPostPO getUserSearchPostPage(WebDriver driver) {
		return new EndUserSearchPostPO(driver);
	}
}
