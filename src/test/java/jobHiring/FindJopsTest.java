package jobHiring;

import java.util.Scanner;
import logic.Jobs;
import logic.JobValidation;
import model.JobProfile;

public class FindJopsTest {

	public static void main(String[] args) throws Exception {
		
		Jobs job = new JobValidation();
		JobProfile jobProfile = new JobProfile();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter your Skills");
		String skills = sc.next();
		
		jobProfile.setSkills(skills);
		job.jobSerching(skills);
		
	}

}
