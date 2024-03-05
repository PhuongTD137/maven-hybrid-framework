package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestLiveGuru {
	private WebDriver driver;

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();

		} else if (browserName.equals("h_firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = WebDriverManager.firefoxdriver().capabilities(options).create();

		} else if (browserName.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();

		} else if (browserName.equals("h_chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = WebDriverManager.chromedriver().capabilities(options).create();

		} else if (browserName.equals("edge")) {
			driver = WebDriverManager.edgedriver().create();

		} else if (browserName.equals("opera")) {
			driver = WebDriverManager.operadriver().create();

		} else if (browserName.equals("coccoc")) {
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = WebDriverManager.chromedriver().driverVersion("115.0.5790.102").create();

		} else if (browserName.equals("ie")) {
			driver = WebDriverManager.iedriver().arch32().create();

		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/");

		return driver;
	}

}
