package logic;

import java.sql.ResultSet;

import model.JobProfile;
import DAO.ApplicationDAO;
import DAO.JobsDAO;

public class JobValidation extends Jobs {

	public int addJob(JobProfile obj) throws Exception {

		int result = JobsDAO.jobinsert(obj);
		return result;
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
	public void jobSerching(JobProfile jobProfile) throws Exception {
		
			JobsDAO.jobSearchigSkills(jobProfile);
		
	}

	@Override
	public int updateJobVacancy(int id) throws Exception {
		int option	= 0;
		option	=	JobsDAO.jobUpdate1(id);
		if(option == 1)
		option = ApplicationDAO.insert();
	return option;
	}

}
