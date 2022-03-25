package logic;

import DAO.CompanyDAO;
import DAO.UserDAO;
import model.CompanyProfile;

public class CompanyValidation {
	
	@SuppressWarnings("finally")
	public static int registerValitation(CompanyProfile obj) throws Exception {
		int verify = 0;
		String mailId = obj.getMailId();
		String password = obj.getPassword();
		try {
			if (!mailId.isBlank() && !mailId.isEmpty() && !password.isBlank() && !password.isEmpty()) {
				if (mailId.contains("@")) {
					verify = CompanyDAO.checkValidation(obj);
					System.out.println(" valid" + verify);
				} else {
					System.out.println("not valid");
				}
			} else {
				System.out.println("not valid");
			}
		} catch (Exception ep) {

			System.out.println(ep.getMessage());
		} finally {
			return verify;
		}
	}



}
