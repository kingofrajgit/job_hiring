package jobHiring;
import java.util.Scanner;

import dao.UserDAO;
public class LoginCheckTest {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("===> Enter your email <===");
		String emailId = sc.next();
		System.out.println("===> Enter your password <===");
		String password = sc.next();
		int a = 0 ;
		a = UserDAO.cacheValidation2(emailId,password);
		if(a == 0) {
			System.out.println(" Invalide email or password");
		}
		else {
			System.out.println("successfull login");
		}

	}

}
