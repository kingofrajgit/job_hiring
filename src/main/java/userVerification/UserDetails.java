package userVerification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class UserDetails {

	public static String userMailId = null;
	
	public static String userPass = null;
	
	public static String userName = null;
	
	public static String DOB = null;
	
	public static String collegeName = null;
	
	public static String cource = null;
	
	public static String branch = null;
	
	public UserDetails(String userName2, String dOB2, String collegeName2, String cource2, String branch2, String userMailId2, String userpass2) {
		userName = userName2;
		DOB = dOB2;
		collegeName = collegeName2;
		cource = cource2;
		branch = branch2;
		userMailId = userMailId2;
		userPass = userpass2;
	}
	public UserDetails() {
	
	}
	public void print(ArrayList<UserDetails> userFile) throws IOException {
		try {
			for (UserDetails file : userFile) {
				String JobsDetails = file.userName + "," + file.userMailId + "," + file.DOB + "," + file.collegeName + ","
					+ file.cource ;
				byte[] content = JobsDetails.getBytes();

				Path path = Paths.get("UsersDetails.txt");

				Files.write(path, content);
			
			}
			System.out.println("All Details are inserted in this file" +" "+ "UsersDetails.txt");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setMailId(String userMailId2) {
		userMailId = userMailId2;
		
	}
	public void setPass(String userpass2) {
		
		userPass = userpass2;
	}
	public void setName(String userName2) {
		userName = userName2;
		
	}
	public void setDob(String dOB2) {
		DOB = dOB2;
		
		
		
	}
	public void setCollege_name(String collegeName2) {
		collegeName = collegeName2;
		
		
	}
	public void setcource(String cource2) {
		cource = cource2;
		
		
	}
	public void setbranch(String branch2) {
		
		branch = branch2;
	}
	

}
