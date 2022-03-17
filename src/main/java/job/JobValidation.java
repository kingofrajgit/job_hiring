package job;

import jobDetails.JobDetails;

public class JobsDAO extends Jobs {

	public void addJob(JobDetails obj) throws Exception {

		int result = JobQuerys.jobinsert(obj);
		System.out.println(result);
	}

	@Override
	public int deleteJob(String companyName) {
		int result = 0;
		result	=	JobQuerys.jobDelete(companyName);
		return result;

	}

	@Override
	public int updateJob(String companyName, String roll, String vacancy) {
		int result = 0;
		result	=	JobQuerys.jobUpdate(companyName,roll,vacancy);
		return result;
	}

}
