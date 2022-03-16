package jobHiring;

import java.util.Scanner;
import job.JobsDAO;
import job.Jobs;
import jobDetails.JobDetails;

public class JobDeleteTest {

	public static void main(String[] args) {
		
		Scanner sc	=	new Scanner(System.in);
		System.out.println("enter your vacancy");
		String companyName	=	sc.nextLine();
		Jobs job	=	new JobsDAO();
	int a =	job.deleteJob(companyName);
	if(a	==	0) {
		System.out.println("Your job details is not deleted");
	}
	else {
		System.out.println("Your job detais is deleted successfull");
	}
		

	}

}
