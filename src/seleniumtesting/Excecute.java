package seleniumtesting;

import java.util.HashMap;
import java.util.Map;

import issuesTestCode.LoginTest;

public class Excecute {

	public static void main(String[] args) {
		Map<String, Boolean> testResult = new HashMap<String, Boolean>();
		try {
			testResult.putAll(LoginTest.run());
		} catch (Exception e) {
			System.out.println("*****************ERROR******************");
			System.out.println(e.getMessage());
		} finally {
			int i=0;
			System.out.println("*****************RESULT******************");

			for(Map.Entry<String, Boolean> entry : testResult.entrySet()) {
			    String key = entry.getKey();
			    Boolean value = entry.getValue();
				System.out.println(++i +") "+key+" : "+ value);
			}
			Config.stop(true,true);
		}
	}

}
