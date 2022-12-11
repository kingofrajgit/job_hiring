package jobHiring;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import logic.JobValidation;
import logic.Jobs;
import model.JobProfile;

public class FindJopsTestTest {
	
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger();
	@Test
	public void test() throws Exception {
		Jobs job = new JobValidation();
		JobProfile jobProfile = new JobProfile();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Skills");
		log.info("Enter your Skills");
		String skills = sc.next();

		jobProfile.setSkills(skills);
		job.jobSerching(jobProfile);
		assertEquals(skills,jobProfile.getSkills());

	}

}
