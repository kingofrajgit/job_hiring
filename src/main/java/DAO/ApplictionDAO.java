package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import logic.Application;
import dataBaseConnection.Databasecon;
import model.JobProfile;

public class ApplictionDAO {

	public static void insert(JobProfile jobFile) throws Exception {
		
		String query1 = null;
		int t = 0;
		Connection con = Databasecon.getConnection();

		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into job_application (user_mailId,user_name,roll,branch,company,location,salery,job_id) values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, Application. getMailId());
			stmt.setString(2, Application.getName());
			stmt.setString(3, JobProfile.getroll());
			stmt.setString(4,  JobProfile.getBranch());
			stmt.setString(5,  jobFile.getcompanyName());
			stmt.setString(6,  jobFile.getlocation_details() );
			stmt.setInt(7,  jobFile.getsalery());
			stmt.setInt(8,  jobFile.getJobId());
			int rows = stmt.executeUpdate();
			System.out.println("succesfull");
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			con.close();
			
		}
	}
	
	

}