package jobHiring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import job.Jobs;
import job.JobValidation;

public class JopSerchingTest {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your Skillss");
		String skills = sc.nextLine();
		Jobs job = new JobValidation();
		job.jobSerchin(skills);
		
//		while (rs.next()) {
//			a++;
//			int i = 0;
//			System.out.print(rs.getString(++i) + "   " + rs.getString(++i) + "    " + rs.getString(++i) + "  "
//					+ rs.getString(++i));
//
//		}
//		if (a == 0) {
//			System.out.println("The job is not exist");
//		} else {
//			System.out.println("The job is  exist");
//		}
		

	}

}
