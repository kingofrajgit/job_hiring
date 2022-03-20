package logic;

import java.sql.ResultSet;

public abstract class Jobs {

	public abstract int deleteJob(int jobId) throws Exception;

	public abstract int updateJob() throws Exception;

	public abstract void jobSerching(String skills) throws Exception;

	public abstract void updateJobVacancy(int applicationId) throws Exception;

}
