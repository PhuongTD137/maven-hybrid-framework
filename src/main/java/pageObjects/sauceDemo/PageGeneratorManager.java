package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static ProductPageObject openProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
}
