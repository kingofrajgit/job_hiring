package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Application;
import model.CompanyProfile;
import dataBaseConnection.Databasecon;
import logic.UsersInput;
import model.JobProfile;

public class ApplicationDAO {

	@SuppressWarnings("finally")
	public static int insert() throws Exception {

		String query1 = null;
		int t = 0;

		Application application = new Application();
		Connection con = Databasecon.getConnection();
		int rows = 0;

		try {
			PreparedStatement stmt = con
					.prepareStatement("insert into job_application (user_mailId,job_id) values(?,?)");
			stmt.setString(1, application.getMailId());
			stmt.setInt(2, application.getJobid());
			rows = stmt.executeUpdate();
			System.out.println("succesfull");
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			con.close();
			return rows;
		}
	}

	public static void findMyApplications(String emailId) throws Exception {
		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;

		try {
			// Prepare SQL.
			query = " SELECT  hiring_companys.job_id,hiring_companys.companyName,hiring_companys.branch,hiring_companys.roll,hiring_companys.skills,hiring_companys.salery FROM hiring_companys INNER JOIN job_application ON hiring_companys.job_id=job_application.job_id WHERE job_application.user_mailId = ?";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, emailId);

			// Execute SQL.
			ResultSet rs = stmt.executeQuery();

			// Get data from database.
			ArrayList<JobProfile> jobFiles = new ArrayList<JobProfile>();
			JobProfile jobFile1 = new JobProfile();
			while (rs.next()) {
				JobProfile jobFile = new JobProfile();
				jobFile.setJobId(rs.getInt("job_id"));
				jobFile.setBranch(rs.getString("branch"));
				jobFile.setCompany(rs.getString("companyName"));
				jobFile.setRoll(rs.getString("roll"));
//				jobFile.setPlace_Details(rs.getString("location_details"));
				jobFile.setSkills(rs.getString("skills"));
				jobFile.setSalery(rs.getInt("salery"));
				Application.print(jobFile);
			}
//			jobFile1.print(jobFiles);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
			UsersInput.jobsProfile(emailId);
		}
	}

	public static void viewApplications() throws Exception{
		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;

		try {
			// Prepare SQL.
			query =" SELECT  hiring_companys.job_id,hiring_companys.companyName,hiring_companys.branch,hiring_companys.roll,hiring_companys.skills,hiring_companys.salery FROM hiring_companys INNER JOIN job_application ON hiring_companys.job_id=job_application.job_id WHERE job_application.user_mailId =?";

			PreparedStatement stmt = con.prepareStatement(query);
//			stmt.setString(1,CompanyProfile.);

			// Execute SQL.
			ResultSet rs = stmt.executeQuery();
			 
			// Get data from database.
			ArrayList<JobProfile> jobFiles = new ArrayList<JobProfile>();
			JobProfile jobFile1  = new JobProfile();
			while (rs.next()) {
				JobProfile jobFile  = new JobProfile();
				jobFile.setJobId(rs.getInt("job_id"));
				jobFile.setBranch(rs.getString("branch"));
				jobFile.setCompany(rs.getString("companyName"));
				jobFile.setRoll(rs.getString("roll"));
//				jobFile.setPlace_Details(rs.getString("location_details"));
				jobFile.setSkills(rs.getString("skills"));
				jobFile.setSalery(rs.getInt("salery"));
				Application.print(jobFile);
			}
//			jobFile1.print(jobFiles);
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
//			UsersInput.jobsProfile(emailId);
		}
		
	}

	@SuppressWarnings("finally")
	public static ArrayList<Application> FindId(String mailId) throws Exception {
		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;
		ArrayList<Application> list = new ArrayList<Application>();

		try {
			// Prepare SQL.
			query = "SELECT job_id FROM hiring_companys WHERE mail_id = ?;";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, mailId);
			ResultSet rs = stmt.executeQuery();
			
			Application obj = new Application();
			while (rs.next()) {
				obj = new Application();
				int jobId=rs.getInt("job_id");
				obj.setJobid(jobId);
				list.add(obj);
			}
			

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			
			con.close();
			return list;
		}
	}
	
}
