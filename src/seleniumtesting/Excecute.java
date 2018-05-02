package seleniumtesting;

import java.util.HashMap;
import java.util.Map;

import comman.Comman;
import issuesTestCode.AccOwnerManagerTest;
import issuesTestCode.LoginTest;

public class Excecute {

	public static void main(String[] args) {
		Map<String, Boolean> testResult = new HashMap<String, Boolean>();
		try {
			int tryCount=0;
			boolean isTestFinished=false;
			while (!isTestFinished || tryCount>9) {
				try {
					tryCount++;
					testResult = new HashMap<String, Boolean>();
					testResult.putAll(LoginTest.run());
								
					User.setUser(Comman.Data.UserCredentail.CUST_OWNER_EMAIL_CURRECT, Comman.Data.UserCredentail.CUST_OWNER_PASS_CURRECT,
							Comman.Data.UserCredentail.CUST_OWNER_COMP_NAME,Comman.Data.UserCredentail.CUST_OWNER_NAME, "Account Owner");
					testResult.putAll(AccOwnerManagerTest.run());

					User.setUser(Comman.Data.UserCredentail.CUST_USER_EMAIL_CURRECT, Comman.Data.UserCredentail.CUST_MANAGER_PASS_CURRECT,
							Comman.Data.UserCredentail.CUST_MANAGER_COMP_NAME,Comman.Data.UserCredentail.CUST_MANAGER_NAME, "Account Manager");
					testResult.putAll(AccOwnerManagerTest.run());
					isTestFinished=true;
				} catch (Exception e) {
					if (testResult.size()>0) {
						isTestFinished=true;
						throw new Exception(e);
					} 
				} 
			}
		} catch (Exception e) {
			System.out.println("\n\n*****************ERROR******************");
			System.out.println(e.getMessage());
		} finally {
			new Report().sendReport(testResult);
			Config.stop(true,true);
		}
	}

}
