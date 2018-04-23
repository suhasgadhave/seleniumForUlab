package issuesTestCode;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import seleniumtesting.Driver;
import seleniumtesting.User;

public class AccOwnerManagerTest {
	public static Map<String, Boolean> run() throws Exception{
		Map<String, Boolean> accOwnTestResult = new HashMap<String, Boolean>();
		try {
			Driver.restartBrowser();
			if (!LoginTest.isLoginSuccessful()) {
				accOwnTestResult.put(User.getType()+" login failed.",false);
				return accOwnTestResult;
			}
			Thread.sleep(2000);
			isProfileDDSuccessful(accOwnTestResult);
			Thread.sleep(2000);
			isCompanyDDSuccessful(accOwnTestResult);
			new ChangePasswordTest().testChangePass(accOwnTestResult, User.getType());
		} catch (Exception e) {
			accOwnTestResult.put(User.getType()+" testing failed due to "+e.getMessage(),false);
			System.out.println(User.getType()+" testing failed due to "+e.getMessage());
		}
		return accOwnTestResult;
	}
	private static Map<String, Boolean> isCompanyDDSuccessful(Map<String, Boolean> accOwnTestResult) throws Exception {
		try {
			WebElement companyMenu = Driver.getByLinkText(User.getComName());
			companyMenu.click();
			Thread.sleep(2000);

			WebElement userProfile = Driver.getByLinkText("Cases");
			WebElement companyProfile = Driver.getByLinkText("Collaboration");
			WebElement companyUserProfile = Driver.getByLinkText("Company Users");
			WebElement WSListProfile = Driver.getByLinkText("Workstation List");

			if (userProfile.isDisplayed() && companyProfile.isDisplayed() && companyUserProfile.isDisplayed() && WSListProfile.isDisplayed()) {
				accOwnTestResult.put(User.getType()+" is able to see company menu drop down.",true);
			} else {
				accOwnTestResult.put(User.getType()+" is able to see company menu drop down.",false);
			}
		} catch (Exception e) {
			accOwnTestResult.put(User.getType()+" is able to see company menu drop down.",false);
			System.out.println(User.getType()+" is able to see company menu drop down.");
		}
		return accOwnTestResult;
	}

	private static Map<String, Boolean> isProfileDDSuccessful(Map<String, Boolean> accOwnTestResult) throws Exception {
		try {
			WebElement profileMenu = Driver.getByLinkText(User.getName());
			profileMenu.click();
			Thread.sleep(2000);

			WebElement userProfile = Driver.getByLinkText("User Profile");
			WebElement companyProfile = Driver.getByLinkText("Company Profile");

			if (userProfile.isDisplayed() && companyProfile.isDisplayed()) {
				accOwnTestResult.put(User.getType()+" is able to see profile menu drop down.",true);
				userProfile.click();
				Thread.sleep(2000);
				String userProfileScreenTitle = Driver.getTitle();
				if (userProfileScreenTitle.equals("User Profile")) {
					accOwnTestResult.put(User.getType()+" is able to see user profile menu.",true);
				} else {
					accOwnTestResult.put(User.getType()+" is able to see user profile menu.",false);
				}
				profileMenu.click();
				Thread.sleep(2000);
				companyProfile.click();
				Thread.sleep(2000);
				String companyProfileScreenTitle = Driver.getDriver().getTitle();
				if (companyProfileScreenTitle.equals("Company Profile")) {
					accOwnTestResult.put(User.getType()+" is able to see company profile menu.",true);
				} else {
					accOwnTestResult.put(User.getType()+" is able to see company profile menu.",false);
				}
			} else {
				accOwnTestResult.put(User.getType()+" is able to see profile menu drop down.",false);
			}			

		} catch (Exception e) {
			accOwnTestResult.put(User.getType()+" is able to see profile menu drop down.",false);
			System.out.println(User.getType()+" is able to see profile menu drop down.");
		}
		return accOwnTestResult;
	}
}
