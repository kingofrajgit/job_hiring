package application;

public class Application {
	
	private static String userName = null;
	
	private static String mailId = null;

	public  Application(String my_userName, String my_mailId) {
		setUserName( my_userName);
		setMailId(my_mailId);
	}
	
	public void setMailId(String mailId) {
	
		this.mailId = mailId;
	}
	
	public void setUserName(String username) {
		
		this.userName = username;
	}

	public static String getMailId() {
		// TODO Auto-generated method stub
		return mailId;
	}

	public static String getName() {
		
		return userName;
	}
	
	

}
