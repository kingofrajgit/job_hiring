package jobHiring;
import java.util.Scanner;
import job.Jobs;
import job.JobsDAO;
import jobDetails.JobDetails;

public class JobAddTest {
	
	
	public static void main(String[] args) throws Exception {
		
		
		@SuppressWarnings("resource")
		Scanner sc	=	new Scanner(System.in);
		System.out.println("1.Enter your  branch");
		String branch	=	sc.next();
		System.out.println("4.Enter your comapny name");
		String companyName	=	sc.next();
		System.out.println("2.Enter your roll");
		String roll	 =	sc.next();
		System.out.println("3.Enter your vacancy and place");
		int vacancy	=	sc.nextInt();
		String place	=	sc.next();
		System.out.println("5.Enter lost entry date");
		String date	=	sc.next();
		JobsDAO obj1	=	new JobsDAO();
		JobDetails obj	=	new JobDetails(companyName, branch, roll, vacancy, place,date);
		obj1.addJob(obj);
		sc.close();
	}

}
