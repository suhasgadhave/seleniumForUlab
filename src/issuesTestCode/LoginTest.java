package issuesTestCode;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import comman.Comman;
import seleniumtesting.Config;
import seleniumtesting.Driver;

public class LoginTest {
	public static Map<String, Boolean> run(){
		Map<String, Boolean> loginTestResult = new HashMap<String, Boolean>();
		try {

			loginTestResult.put("Admin able to login with currect credentials", 
					isAdminLoginSuccessful(Comman.Data.ADMIN_EMAIL_CURRECT,Comman.Data.ADMIN_PASS_CURRECT));
			loginTestResult.put("Admin able to login with Wrong eamil credentials", 
					!isAdminLoginSuccessful(Comman.Data.ADMIN_EMAIL_WRONG,Comman.Data.ADMIN_PASS_CURRECT));
			loginTestResult.put("Admin able to login with Wrong password credentials", 
					!isAdminLoginSuccessful(Comman.Data.ADMIN_EMAIL_CURRECT,Comman.Data.ADMIN_PASS_WRONG));
			loginTestResult.put("Admin able to login with wrong credentials", 
					!isAdminLoginSuccessful(Comman.Data.ADMIN_EMAIL_WRONG,Comman.Data.ADMIN_PASS_WRONG));

		} catch (InterruptedException e) {
		}
		return loginTestResult;
	}

	private static boolean isAdminLoginSuccessful(String emailVal,String passVal) throws InterruptedException {
		Config.goToLoginPage();
		String loginScreenTitle = Driver.getDriver().getTitle();
		WebElement email = Driver.getElementByXpath("//*[@placeholder='email']");
		email.sendKeys(emailVal);
		WebElement pass = Driver.getElementByXpath("//*[@placeholder='password']");
		pass.sendKeys(passVal);
		Driver.getByLinkText("Login").click();
		Thread.sleep(2000);
		String afterLoginScreenTitle = Driver.getDriver().getTitle();
		if (!loginScreenTitle.equals(afterLoginScreenTitle)){
			return true;
		}
		return false;
	}

}
