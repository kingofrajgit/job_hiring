package job;

import java.sql.ResultSet;

import jobDetails.JobDetails;

public class JobValidation extends Jobs {

	public void addJob(JobDetails obj) throws Exception {

		int result = JobsDAO.jobinsert(obj);
		System.out.println(result);
	}

	@Override
	public int deleteJob(String companyName) {
		int result = 0;
		result	=	JobsDAO.jobDelete(companyName);
		return result;

	}

	@Override
	public int updateJob(String companyName, String roll, String vacancy) {
		int result = 0;
		result	=	JobsDAO.jobUpdate(companyName,roll,vacancy);
		return result;
	}

	@Override
	public void jobSerchin(String skills) throws Exception {
		
			JobsDAO.jobSearchig(skills);
		
	}

	@Override
	public void updateJobVacancy(int id) throws Exception {
		
			JobsDAO.jobUpdate(id);
			JobsDAO.getDetails2(id);
	}

}
