package jobHiring;

import java.util.Scanner;
import job.JobsDAO;
import job.Jobs;
import jobDetails.JobDetails;

public class JobUpdateTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your companyName");
		String companyName = sc.nextLine();
		System.out.println("enter your perfered roll");
		String roll = sc.nextLine();
		System.out.println("enter your vacancy");
		String vacancy = sc.nextLine();
		Jobs job = new JobsDAO();
		int a = job.updateJob(companyName, roll,vacancy);
		if (a == 0) {
			System.out.println("Your job details is not deleted");
		} else {
			System.out.println("Your job detais is update successfull");
		}

	}

}
