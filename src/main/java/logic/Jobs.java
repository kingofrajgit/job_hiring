package logic;

import java.util.ArrayList;

import model.JobProfile;

public abstract class Jobs {

	public abstract int deleteJob(int jobId) throws Exception;

	public abstract int updateJob() throws Exception;

	public abstract ArrayList<JobProfile> jobSerching(JobProfile jobProfile) throws Exception;

	public abstract int updateJobVacancy(int applicationId) throws Exception;

	public abstract int updateJobSkills(JobProfile details) throws Exception;

	public abstract int updateJobSalary(JobProfile details) throws Exception;
	

}
