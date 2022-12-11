package jobHiring;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import dao.UserDAO;
import model.UserDetails;

public class ListAllUsersTest {

	public static void main(String[] args) throws Exception {
		ArrayList<UserDetails> userFile = UserDAO.getAllDetails();
			try {
				for (UserDetails file : userFile) {
					String JobsDetails = file.getUserName() + "," + file.getUserMailId() + "," + file.getDOB() + "," + file.getCollegeName() + ","
						+ file.getCource() ;
					byte[] content = JobsDetails.getBytes();
					Path path = Paths.get("UsersDetails.txt");
					FileWriter writer = new FileWriter("UsersDetails.txt"); 			//					Files.write(path, content);
					writer.write(JobsDetails + System.lineSeparator());
					System.out.println(JobsDetails );
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

