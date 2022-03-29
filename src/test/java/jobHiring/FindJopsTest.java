package jobHiring;

import java.util.Scanner;
import logic.JobValidation;
import logic.Jobs;
import model.JobProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class FindJopsTest {

	private static org.apache.logging.log4j.Logger log = LogManager.getLogger();

	public static void main(String[] args) throws Exception {

		Jobs job = new JobValidation();
		JobProfile jobProfile = new JobProfile();
		Scanner sc = new Scanner(System.in);
		log.info("enter your Skills");
		String skills = sc.next();

		jobProfile.setSkills(skills);
		job.jobSerching(jobProfile);

	}

}
