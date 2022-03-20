package logic;

import java.sql.ResultSet;

import model.JobProfile;
import DAO.JobsDAO;

public class JobValidation extends Jobs {

	public void addJob(JobProfile obj) throws Exception {

		int result = JobsDAO.jobinsert(obj);
		System.out.println(result);
	}

	@Override
	public int deleteJob(int JobId) throws Exception {
		int result = 0;
		result	=	JobsDAO.jobDelete(JobId);
		return result;

	}

	@Override
	public int updateJob() throws Exception {
		int result = 0;
		result	=	JobsDAO.jobUpdate();
		return result;
	}

	@Override
	public void jobSerching(String skills) throws Exception {
		
			JobsDAO.jobSearchigSkills(skills);
		
	}

	@Override
	public void updateJobVacancy(int id) throws Exception {
		
			JobsDAO.jobUpdate1(id);
			JobsDAO.getDetails2(id);
	}

}
