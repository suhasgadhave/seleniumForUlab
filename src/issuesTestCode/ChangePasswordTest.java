package issuesTestCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebElement;

import comman.Comman;
import seleniumtesting.Driver;
import seleniumtesting.User;

public class ChangePasswordTest {
	public static Map<String, Boolean> run() throws Exception{
		Map<String, Boolean> accOwnTestResult = new HashMap<String, Boolean>();
		try {
			Driver.restartBrowser();
//			if (!LoginTest.isLoginSuccessful(Comman.Data.UserCredentail.CUST_OWNER_EMAIL_CURRECT, Comman.Data.UserCredentail.CUST_OWNER_PASS_CURRECT)) {
//				accOwnTestResult.put("Account Owner login failed.",false);
//				return accOwnTestResult;
//			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return accOwnTestResult;
	}

	public void testChangePass(Map<String, Boolean> passChangeResult,String user) {
		String  oldPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT+new Random().nextInt();
		String  newPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT;
		String  confirmPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT;
		passChangeResult.put(user+"'s password change with wrong old Password",!changePassword(oldPass, newPass, confirmPass));

		oldPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT;
		newPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT;
		confirmPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT;
		passChangeResult.put(user+"'s password change with same old and new password",!changePassword(oldPass, newPass, confirmPass));

		oldPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT;
		newPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT+new Random().nextInt();
		confirmPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT;
		passChangeResult.put(user+"'s password change with different new and confirm password",!changePassword(oldPass, newPass, confirmPass));

		oldPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT;
		newPass=Comman.Data.UserCredentail.ADMIN_PASS_CURRECT+new Random().nextInt(3);
		passChangeResult.put(user+"'s password change appropriate data",changePassword(oldPass, newPass, newPass));

		passChangeResult.put(user+"'s password Reseted for DB consistancy",changePassword(newPass,oldPass,oldPass));
	}
	private static boolean changePassword(String  oldPass, String  newPass, String  confirmPass) {
		try {
			WebElement profileMenu = Driver.getByLinkText(User.getName());
			profileMenu.click();
			WebElement userProfile = Driver.getByLinkText("Change Password");
			userProfile.click();
			Thread.sleep(2000);
			WebElement oldPassField = Driver.getElementByXpath("//*[@placeholder='Old password']");
			WebElement newPassField = Driver.getElementByXpath("//*[@placeholder='New password']");
			WebElement confirmPassField = Driver.getElementByXpath("//*[@placeholder='Verify new password']");

			if (oldPassField.isDisplayed() && newPassField.isDisplayed() && confirmPassField.isDisplayed()) {
				return applyChange(oldPassField, newPassField, confirmPassField, oldPass, newPass, confirmPass);
			} 
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	private static boolean applyChange(WebElement oldPassField,WebElement newPassField,WebElement confirmPassField,String  oldPass, String  newPass, String  confirmPass) throws InterruptedException {
		oldPassField.sendKeys(oldPass);
		newPassField.sendKeys(newPass);
		confirmPassField.sendKeys(confirmPass);
		Driver.getByLinkText("Submit").click();
		Thread.sleep(2000);
		try {
			WebElement successfulMsg=Driver.getByLinkText("Click here to go to homepage...");
			if (successfulMsg!=null) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}
}
