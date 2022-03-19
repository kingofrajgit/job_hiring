package jobHiring;

import application.Application;
import job.JobValidation;
import job.Jobs;

public class JobApplyTest {

	public static void main(String[] args) throws Exception {
		
		String my_userName = "jeyaraj";
		String my_mailId = "kingofraj.7092@gmail.com";

		int applicationId = 2;  
		
		Application application = new Application(my_userName,my_mailId);
		System.out.println(application.getName());
		
		Jobs job = new JobValidation();
		job.updateJobVacancy(applicationId);
		
	}

}
