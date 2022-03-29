package logic;

import java.sql.ResultSet;

import model.JobProfile;

public abstract class Jobs {

	public abstract int deleteJob(int jobId) throws Exception;

	public abstract int updateJob() throws Exception;

	public abstract void jobSerching(JobProfile jobProfile) throws Exception;

	public abstract int updateJobVacancy(int applicationId) throws Exception;

	public abstract int updateJobSkills(JobProfile details) throws Exception;

	protected abstract int updateJobSalary(JobProfile details) throws Exception;
	

}
