package jobHiring;

import java.util.Scanner;
import logic.JobValidation;
import logic.Jobs;
import model.JobProfile;

public class JobUpdateTest {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Jobs job = new JobValidation();
		JobProfile details = new JobProfile();

		int jobId = 0;
		int answer = 0;

		System.out.println("enter your jobId");
		jobId = sc.nextInt();
		System.out.println("enter your vacancy");
		int vacancy = sc.nextInt();

		details.setJobId(jobId);
		details.setVacancy(vacancy);
		answer = job.updateJob();
		if (answer == 0) {
			System.out.println("Your job details not update");
		} else {
			System.out.println("Your job details update successfull");
		}

	}

}
