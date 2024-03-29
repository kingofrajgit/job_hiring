package logic;

import java.util.Scanner;
import dao.UserDAO;

public class InputValidation extends GetInput {

	public InputValidation() {

	}

	@SuppressWarnings("finally")
	public int registerValitation(String userMailId, String userPass) throws Exception {
		UsersInput obj = new UsersInput();
		int verify = 1;
		try {
			if (!userMailId.isBlank() && !userMailId.isEmpty() && !userPass.isBlank() && !userPass.isEmpty()) {
				if (userMailId.contains("@gmail.com") && userPass.length() >= 8 && userPass.length() <= 16) {
					verify = UserDAO.checkValidation(userMailId, userPass);

				} else {
					System.out.println("Email id is not valid");
					obj.validationCheckInput();
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
