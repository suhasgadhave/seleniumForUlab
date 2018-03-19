package issuesTestCode;

import comman.Comman;
import seleniumtesting.Driver;

public class LearningCode {
	public static void run() throws InterruptedException {
        Driver.getDriver().get(Comman.Data.TEST_URL);
        
      Driver.getDriver().get(Comman.Data.TEST_URL);
      Driver.getDriver().get("javascript:%7B window.__gwt_bookmarklet_params %3D %7B'server_url'%3A'http%3A%2F%2F127.0.0.1%3A9876%2F'%7D%3B var s %3D document.createElement('script')%3B s.src %3D 'http%3A%2F%2F127.0.0.1%3A9876%2Fdev_mode_on.js'%3B void(document.getElementsByTagName('head')%5B0%5D.appendChild(s))%3B%7D");
      Thread.sleep(1000);
      Driver.getByLinkText("Compile").click();
      Thread.sleep(2000);

//      WebElement email = Driver.getElementByXpath("//*[@placeholder='email']");
//      email.sendKeys(Comman.Data.ADMIN_EMAIL_CURRECT);
//      WebElement pass = Driver.getElementByXpath("//*[@placeholder='password']");
//      pass.sendKeys(Comman.Data.ADMIN_PASS_CURRECT);
//      Driver.getByLinkText("Login").click();

//		Driver.getDriver().findElement(By.cssSelector(".form-control[placeholder='email']")).sendKeys("sg312");
//        WebElement pass = Driver.getElementByPlaceHolder("password");
//        pass.sendKeys("sg312");
//        WebElement loginBtn = Driver.getBtnElement("Login");
//        loginBtn.click();

        
	}
// TRY TO LOGIN FB
//	{
//        Driver.getDriver().get(Comman.Data.TEST_URL);
//        
//        WebElement email = Driver.getElementById("email");
//        email.sendKeys("sg312");
//        WebElement pass = Driver.getElementById("pass");
//        pass.sendKeys("sg312");
//        WebElement loginBtn = Driver.getElementById("loginbutton");
//        loginBtn.click();
//
//	}
//	{
//		String baseUrl = "http://google.in/";
//		String expectedTitle = "Welcome: Mercury Tours";
//		String actualTitle = "";
//
//		// launch Fire fox and direct it to the Base URL
//		driver.get(baseUrl);
//
//		// get the actual value of the title
//		actualTitle = driver.getTitle();
//
//		/*
//		 * compare the actual title of the page with the expected one and print
//		 * the result as "Passed" or "Failed"
//		 */
//		if (actualTitle.contentEquals(expectedTitle)){
//			System.out.println("Test Passed!");
//		} else {
//			System.out.println("Test Failed");
//		}
//	}
	
}
