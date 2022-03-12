package inputs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import dbcon.Databasecon;

public class God extends GetInput {

	static Scanner sc = new Scanner(System.in);

	public static String userMailId = null;
	public static String userPass = null;
	public static String userName = null;
	public static String DOB = null;
	public static String collegeName = null;
	public static String cource = null;
	public static String branch = null;

	public God(String userName2, String dOB2, String collegeName2, String cource2, String branch2, String userMailId2,
			String userPass2) {
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

	public static String getInput1(String str) {
		String result = null;
		System.out.println("==> Enter your" + " " + str);
		result = sc.next();
		return result;

	}

	public God[] getvalue(String userMailId2, String userPass) {
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
		God[] god = new God[1];
		God obj = new God(userName, DOB, collegeName, cource, branch, userMailId2, userPass);
		god[0] = obj;
		return god;
	}

	public void registerValitation() throws Exception {
		String userMailId = getInput1("mailId");
		String userPass = getInput1("password");
		try {
			int verify = Querys.cacheValidation(userMailId, userPass);
			if (verify == 0) {
				God[] god = getvalue(userMailId, userPass);
				int n = Querys.insert(god);
				System.out.println(userMailId + userPass);
			} else {
				throw new Exception("Invalide Email Or passward");
			}
		} catch (Exception ep) {

			System.out.println(ep.getMessage());
		}
	}
}
