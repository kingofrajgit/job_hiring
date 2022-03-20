package jobHiring;
import java.util.Scanner;
import logic.Jobs;
import logic.JobValidation;
import model.JobProfile;

public class JobAddTest {
	
	
	public static void main(String[] args) throws Exception {
		
		JobValidation obj1	=	new JobValidation();
		Scanner sc	=	new Scanner(System.in);
		
		System.out.println("1).Enter the jobId");
		int  jobId	=	sc.nextInt();
		System.out.println("2).Enter your  branch");
		String branch	=	sc.next();
		System.out.println("3).Enter your comapny name");
		String companyName	=	sc.next();
		System.out.println("4).Enter your roll");
		String roll	 =	sc.next();
		System.out.println("5).Enter your vacancy and place");
		int vacancy	=	sc.nextInt();
		System.out.println("5).Enter your location");
		String place	=	sc.next();
		System.out.println("6).Enter lost entry date");
		String date	=	sc.next();
		System.out.println("7).Enter the skils details");
		String Skills	=	sc.next();
		System.out.println("8).Enter the salery");
		int salery	=	sc.nextInt();
		
		JobProfile obj	=	new JobProfile(jobId,companyName, branch, roll, vacancy, place,date,Skills,salery);
		obj1.addJob(obj);
		sc.close();
	}

}
