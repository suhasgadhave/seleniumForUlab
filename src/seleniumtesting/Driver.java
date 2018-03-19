package seleniumtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Driver {
	static WebDriver driver=null;

	public static WebElement getElementById(String id) {
		return driver.findElement(By.id(id));
	}
	public static WebElement getElementByName(String name) {
		return driver.findElement(By.name(name));
	}
	public static WebElement getElementByClassName(String name) {
		return driver.findElement(By.className(name));
	}
	public static WebElement getElementByPlaceHolder(String name) {
		return driver.findElement(By.tagName(name));
	}
	public static WebElement getElementByXpath(String path) {
		return driver.findElement(By.xpath(path));
	}
	public static WebElement getByLinkText(String name) {
		return driver.findElement(By.linkText(name));
	}
	public static WebDriver getDriver() {
		if (driver==null) {
			driver=Config.configFirefox();
		}
		return driver;
	}
	public static void restartBrowser() {
		Config.stop(true, false);
		driver=Config.configFirefox();
	}
}
