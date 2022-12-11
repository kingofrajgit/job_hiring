package logic;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.JobProfile;
import dao.ApplicationDAO;
import dao.JobsDAO;

public class JobValidation extends Jobs {

	public int addJob(JobProfile obj) throws Exception {

		int result = JobsDAO.jobinsert(obj);
		return result;
	}

	@Override
	public int deleteJob(int JobId) throws Exception {
		int result = 0;
		result = JobsDAO.jobDelete(JobId);
		return result;

	}

	@Override
	public int updateJob() throws Exception {
		int result = 0;
		result = JobsDAO.jobUpdate();
		return result;
	}

	@Override
	public ArrayList<JobProfile> jobSerching(JobProfile jobProfile) throws Exception {

		ArrayList<JobProfile> jobFiles = JobsDAO.jobSearchigSkills(jobProfile);
		return jobFiles;
	}

	@Override
	public int updateJobVacancy(int id) throws Exception {
		int option = 0;
		option = JobsDAO.jobUpdate1(id);
		if (option == 1)
			option = ApplicationDAO.insert();
		return option;
	}

	@Override
	public int updateJobSkills(JobProfile details) throws Exception {
		int result = 0;
		result = JobsDAO.jobUpdateSkills(details);
		return result;
	}

	@Override
	public int updateJobSalary(JobProfile details) throws Exception {
		int result = 0;
		result = JobsDAO.jobUpdateSalery(details);
		return result;
	}

}
