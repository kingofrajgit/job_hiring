package jobHiring;

import java.util.Scanner;
import logic.Jobs;
import logic.JobValidation;
import model.JobProfile;

public class JobAddTest {

	public static void main(String[] args) throws Exception {

		JobValidation obj1 = new JobValidation();
		Scanner sc = new Scanner(System.in);

		System.out.println("1).Enter the jobId");
		// int jobId = sc.nextInt();
		int jobId = 25;
		System.out.println("2).Enter your  branch");
//		String branch = sc.next();
		String branch ="IT";
		System.out.println("3).Enter your comapny name");
//		String companyName = sc.next();
		String companyName = "finsurge";
		System.out.println("4).Enter your roll");
//		String roll = sc.next();
		String roll = "SD";
		System.out.println("5).Enter your vacancy ");
//		int vacancy = sc.nextInt();
		int vacancy = 9;
		System.out.println("5).Enter your location");
//		String place = sc.next();
		String place ="nagercoil";
		System.out.println("6).Enter lost entry date");
//		String date = sc.next();
		String date = "2022-04-21";
		System.out.println("7).Enter the skils details");
//		String Skills = sc.next();
		String Skills = "python";
		System.out.println("8).Enter the salery");
//		int salery = sc.nextInt();
		int salery = 500000;
		String mailId = "rev@revature.com";

		JobProfile obj = new JobProfile(jobId, companyName, branch, roll, vacancy, place, date, Skills, salery,mailId);
		obj1.addJob(obj);
		sc.close();
	}

}
