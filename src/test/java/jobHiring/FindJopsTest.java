package jobHiring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import logic.JobValidation;
import logic.Jobs;
import model.JobProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class FindJopsTest {

	private static org.apache.logging.log4j.Logger log = LogManager.getLogger();

	public static void main(String[] args) throws Exception {

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Skills");
		log.info("Enter your Skills");
		String skills = sc.next();
		
		Jobs job = new JobValidation();
		JobProfile jobProfile = new JobProfile();
		jobProfile.setSkills(skills);
		ArrayList<JobProfile> jobFiles = job.jobSerching(jobProfile);
//		System.out.println(jobFiles);
		print(jobFiles);
	}
	public static void print(ArrayList<JobProfile> jobFile) throws IOException {
		for (JobProfile jobFiles : jobFile) {
			String JobsDetails1 = jobFiles.getCompanyName() + "	" + jobFiles.getBranch() + "	" + jobFiles.getRoll() + "	"
					+ jobFiles.getSkills() + "	" + jobFiles.getPlace_Details() + "	" + jobFiles.getSalary() + "	"
					+ jobFiles.getVacancy();

			String path = "jobsDetails.txt";
			System.out.println(JobsDetails1);

//			appendUsingBufferedWriter(path, JobsDetails1);
		}
	}

	private static void appendUsingBufferedWriter(String path, String content) {
		File file = new File(path);
		FileWriter fr = null;
		BufferedWriter br = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			for (int i = 0; i < 1; i++) {
				br.newLine();
				// you can use write or append method
				br.write(content);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
