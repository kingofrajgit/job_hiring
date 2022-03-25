package model;

public class CompanyProfile {
	
	private String MailId = null;
	
	private String Password = null;
	
	private int  Id = 0;

	public String getMailId() {
		return MailId;
	}

	public void setMailId(String mailId) {
		MailId = mailId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public CompanyProfile() {
	}

}
