package seleniumtesting;

import issuesTestCode.LearningCode;

public class Excecute {

	public static void main(String[] args) {
		//		driver.get(comman.Comman.Data.TEST_URL);
		//		driver.findElement(By.id("")).sendKeys("Suhas");;
		try {
		LearningCode.run();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
//			Config.stop(true);
		}
	}

}
