package jobHiring;

import model.Application;
import logic.JobValidation;
import logic.Jobs;

public class JobApplyTest {

	public static void main(String[] args) throws Exception {
		
		
		String UsermailId = "kingofraj.7092@gmail.com";
		int applicationId = 2;  
		
		Application application = new Application();
		application.setJobid(applicationId);
		application.setMailId(UsermailId);
		Jobs job = new JobValidation();
		job.updateJobVacancy(applicationId);
		
	}

}
