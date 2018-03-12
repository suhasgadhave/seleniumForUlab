package seleniumtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import comman.Comman;

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
	public static void goToLoginPage() throws InterruptedException {
		Driver.getDriver().get(Comman.Data.TEST_URL);
		Thread.sleep(2000);
		Driver.getDriver().get("javascript:%7B window.__gwt_bookmarklet_params %3D %7B'server_url'%3A'http%3A%2F%2F127.0.0.1%3A9876%2F'%7D%3B var s %3D document.createElement('script')%3B s.src %3D 'http%3A%2F%2F127.0.0.1%3A9876%2Fdev_mode_on.js'%3B void(document.getElementsByTagName('head')%5B0%5D.appendChild(s))%3B%7D");
		Thread.sleep(2000);
		Driver.getByLinkText("Compile").click();
		Thread.sleep(2000);
	}
	public static void stop(boolean closeBrowser,boolean stopSystem) {
		if (closeBrowser) {
			driver.close();
		} 
		if (stopSystem) {
			System.exit(0);
		}
	}

}

