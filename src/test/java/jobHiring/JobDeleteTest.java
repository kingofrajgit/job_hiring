package jobHiring;

import java.util.Scanner;
import logic.JobValidation;
import logic.Jobs;
import model.JobProfile;

public class JobDeleteTest {

	public static void main(String[] args) throws Exception {

		Jobs job = new JobValidation();
		Scanner sc = new Scanner(System.in);
		JobProfile jobProfile = new JobProfile();

		System.out.println("enter your vacancy");
		int jobId = sc.nextInt();
		jobProfile.setJobId(jobId);
		int a = job.deleteJob(jobId);
		if (a == 0) {
			System.out.println("Your job details is not deleted");
		} else {
			System.out.println("Your job detais is deleted successfull");
		}

	}

}
