package job;

import java.sql.ResultSet;

public abstract class Jobs {

	public abstract int deleteJob(String companyName);

	public abstract int updateJob(String companyName, String roll, String vacancy);

	public abstract void jobSerchin(String skills) throws Exception;

	public abstract void updateJobVacancy(int applicationId) throws Exception;

}
