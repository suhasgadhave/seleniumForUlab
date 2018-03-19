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
			System.out.println("\n\n*****************ERROR******************");
			System.out.println(e.getMessage());
		} finally {
			int i=0;
			Map<String, Boolean> failedTest = new HashMap<String, Boolean>();
			System.out.println("\n\n*****************ALL RESULT******************");
			for(Map.Entry<String, Boolean> entry : testResult.entrySet()) {
				String key = entry.getKey();
				Boolean value = entry.getValue();
				System.out.println(++i +") "+key+" : "+ value);
				if (!value) {
					failedTest.put(key, value);
				}
			}
			
			if (failedTest.size()>0) {
				i=0;
				System.out.println("\n\n*****************FAILED RESULT******************");
				for(Map.Entry<String, Boolean> entry : failedTest.entrySet()) {
					String key = entry.getKey();
					Boolean value = entry.getValue();
					System.out.println(++i +") "+key+" : "+ value);
				}
			}
			Config.stop(true,true);
		}
	}

}
