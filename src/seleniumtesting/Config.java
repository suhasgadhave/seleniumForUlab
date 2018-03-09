package seleniumtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Config {
	public final static WebDriver driver =Config.configFirefox();

	public static WebDriver configFirefox() {
		System.setProperty("webdriver.gecko.driver", "lib/browsersDrivers/geckodriver");
		System.setProperty("webdriver.firefox.bin", "/usr/selinum_testing_browsers/firefox/firefox-bin");
		return (new FirefoxDriver());
	}
	public static WebDriver configChrome() {
		System.setProperty("webdriver.chrome.driver", "lib/browsersDrivers/chromedriver");
		System.setProperty("webdriver.chrome.bin", "/opt/google/chrome/google-chrome");
		return (new ChromeDriver());
	}
	public static void stop(boolean closeBrowser) {
		if (closeBrowser) {
			driver.close();
		}
		System.exit(0);
	}
	
}

