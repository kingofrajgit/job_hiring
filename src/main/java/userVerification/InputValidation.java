package userVerification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import dbcon.Databasecon;

public class InputValidation extends GetInput {

	static Scanner sc = new Scanner(System.in);

	public static String userMailId = null;
	public static String userPass = null;
	public static String userName = null;
	public static String DOB = null;
	public static String collegeName = null;
	public static String cource = null;
	public static String branch = null;

	public InputValidation(String userName2, String dOB2, String collegeName2, String cource2, String branch2,
			String userMailId2, String userPass2) {
		userName = userName2;
		DOB = dOB2;
		collegeName = collegeName2;
		cource = cource2;
		branch = branch2;
		userMailId = userMailId2;
		userPass = userPass2;
	}

	public int getInput() {

		int option = 0;
		try {
			// I am getting option
			System.out.println("====================================================");
			System.out.println(" Enter your option");
			System.out.println();
			System.out.println(" regiser  ===>  2");
			System.out.println(" login	  ===>  3");
			option = sc.nextInt();

			if (option == 0 || option > 3) {
				throw new Exception("choose your correct option");
			}
		} catch (Exception ep) {
			// ep.printStackTrace();
			// System.out.println("Exception:" + ep.getMessage());

			System.out.println(ep.getMessage());
		}
		return option;

	}

	@SuppressWarnings("finally")
	public int registerValitation(String userMailId, String userPass) throws Exception {

		int verify = 1;
		try {
			verify = Querys.cacheValidation(userMailId, userPass);

//			if (verify == 0) {
//				InputValidation[] god = getvalue(userMailId, userPass);
//				int n = Querys.insert(god);
//				System.out.println(userMailId + userPass);
//			} else {
//				throw new Exception("Invalide Email Or passward");
//			}
		} catch (Exception ep) {

			System.out.println(ep.getMessage());
		} finally {
			return verify;
		}
	}

}
