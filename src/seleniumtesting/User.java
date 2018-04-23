package seleniumtesting;

public class User {

	public static String email="";
	public static String password="";
	public static String comName=""; 
	public static String name="";
	public static String type="";

	public static void setUser (String e,String p,String cn, String n, String t) {
		setEmail(e);
		setPassword(p);
		setComName(cn);
		setName(n);
		setType(t);
	}
	
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		User.email = email;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		User.password = password;
	}
	public static String getComName() {
		return comName;
	}
	public static void setComName(String comName) {
		User.comName = comName;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		User.name = name;
	}

	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		User.type = type;
	} 

}
