package jobHiring;

import java.util.Scanner;

import userVerification.GetInput;
import userVerification.InputValidation;
import userVerification.Querys;

public class InputValidationCheckTest {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		GetInput get = new InputValidation(null, null, null, null, null, null, null);
		int option = 0;
		String userMailId = null;
		String userpass = null;
		System.out.println("==> Enter your mailid");
		userMailId = sc.next();
		System.out.println("==> Enter your password");
		userpass = sc.next();
		option = get.registerValitation(userMailId, userpass);
		if (option == 1) {
			System.out.println("This mailid or password is already prasent");
		} else {
			DeatilsRequired(userMailId, userpass);
		}

	} 

	static void DeatilsRequired(String userMailId, String userpass) throws Exception {

		System.out.println("1.Enter your Name");
		String userName = sc.next();
		System.out.println("2.Enter your DOB");
		System.out.println("Enter this format ==> 2001-03-20");
		String DOB = sc.next();
		System.out.println("3.Enter your coolegeName");
		String collegeName = sc.next();
		System.out.println("4.Enter your  cource");
		String cource = sc.next();
		System.out.println("5.Enter your branch");
		String branch = sc.next();
		InputValidation god = new InputValidation(userName, DOB, collegeName, cource, branch, userMailId, userpass);
		int n = Querys.insert(god);
	}

}
