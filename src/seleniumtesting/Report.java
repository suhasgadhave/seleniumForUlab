package seleniumtesting;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Report {

	final String username = "suhas.gadhave@wonderbiz.in"; // enter your mail id
	final String password = "SuhasG!123";// enter ur password
	private Map<String, Boolean> failedTest = new HashMap<String, Boolean>();
	private long totalCases=0;
	private long successfulCases=0;
	private long failedCases=0;
	private String passedCasesIntblFormat="";
	private String failedCasesIntblFormat="";

	private Map<String, String> getRecivers() {
		Map<String, String> reciversList=new HashMap<String, String>();
		reciversList.put("suhas.gadhave@wonderbiz.in", "Suhas Gadhave");
		//		reciversList.put("amarjeet.prajapati@wonderbiz.in", "Amarjeet Prajapati");
		return reciversList;
	}

	private void getResult(Map<String, Boolean> testResult) {
		totalCases=testResult.size();
		int i=0;
		System.out.println("\n\n*****************ALL RESULT******************");
		passedCasesIntblFormat+="<br><table>";
		passedCasesIntblFormat+="<tr><th>SUCESSFUL TEST CASES</th></tr>";
		for(Map.Entry<String, Boolean> entry : testResult.entrySet()) {
			String key = entry.getKey();
			Boolean value = entry.getValue();
			System.out.println(++i +") "+key+" : "+ value);
			if (!value) {
				failedTest.put(key, value);
			} else {
				passedCasesIntblFormat+="<tr><td>"+key+"</td></tr>";
				successfulCases++;
			}
		}

		passedCasesIntblFormat+="</table>";
		failedCases=failedTest.size();
		if (failedCases>0 && totalCases>0) {
			i=0;

			System.out.println("\n\n*****************FAILED RESULT******************");
			failedCasesIntblFormat+="<br><table>";
			failedCasesIntblFormat+="<tr><th>FAILED TEST CASES</th></tr>";
			for(Map.Entry<String, Boolean> entry : failedTest.entrySet()) {
				String key = entry.getKey();
				Boolean value = entry.getValue();
				System.out.println(++i +") "+key+" : "+ value);
				failedCasesIntblFormat+="<tr><td>"+key+"</td></tr>";
			}
			failedCasesIntblFormat+="</table>";

		} else if (totalCases>0) {
			System.out.println("\n\n All cases successful.");
		} else {
			System.out.println("\n\n Something went wrong.");
		}	
	}

	public void sendReport(Map<String, Boolean> testResult) {

		try {
			if (testResult==null || testResult.size()==0) {
				throw new Exception("No test cases found");
			}

			Session session = getSession(username, password);
			getResult(testResult);
			Map<String, String> reciversList=getRecivers();
			if (reciversList!=null && reciversList.size()>0)
			{
				for(Map.Entry<String, String> reciver : reciversList.entrySet()) {
					String recivermail = reciver.getKey();
					String reciverName = reciver.getValue();

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(username)); 
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(recivermail));

					message.setSubject("Report of Automation Testing");

					String mailbody="";
					if (reciverName!=null) {
						mailbody="<b>Hi "+reciverName+",</b>";
					} else {
						mailbody="<b>Hi,</b>";
					}
					mailbody+="<br><br><i>Please find the the report of testing as follow -</i>";

					mailbody+="<br><br>Total Cases - <b>"+totalCases+"</b>";

					if (totalCases==successfulCases) {
						mailbody+="<br>All cases successful.";
						mailbody+=passedCasesIntblFormat;
					} else if (totalCases==failedCases) {
						mailbody+="<br>All cases failed.";
						mailbody+=failedCasesIntblFormat;
					} else {						
						mailbody+="<br>Successful Cases - <b>"+successfulCases+"</b>";
						mailbody+="<br>Failed Cases - <b>"+failedCases+"</b>";
						mailbody+=passedCasesIntblFormat;
						mailbody+=failedCasesIntblFormat;
					}		

					message.setContent(mailbody,"text/html");
					Transport.send(message);
				}
			}

			System.out.println("Done");

		} catch (Exception e) {
			System.out.println("Error while sending report is :"+e.getMessage());
		}
	}

	private Session getSession(final String username, final String password) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465"); 
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		return session;
	}

}
