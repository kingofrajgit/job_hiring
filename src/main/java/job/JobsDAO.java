package job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import application.ApplictionDAO;

import dbcon.Databasecon;
import jobDetails.JobDetails;

public class JobsDAO {
	public static int exceqution(String query) throws Exception {
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		System.out.println("number of rows=" + query);
		int rows = statement.executeUpdate(query);
		connection.close();
		return rows;

	}

	

	public static ResultSet excequtionSelect(String query) throws Exception {
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		System.out.println("number of rows=" + rs);
		return rs;

	}

	@SuppressWarnings("finally")
	public static int jobinsert(JobDetails obj) throws Exception {

		String query1 = null;
		int t = 0;
		Connection con = Databasecon.getConnection();

		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into hiring_companys (job_id,branch,companyName,roll ,vacancy,location_details,finish_date,skills,salery) values(?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, JobDetails. getjobId());
			stmt.setString(2, JobDetails.getBranch());
			stmt.setString(3, JobDetails.getcompanyName());
			stmt.setString(4, JobDetails.getroll());
			stmt.setInt(5, JobDetails.getvacancy());
			stmt.setString(6, JobDetails.getlocation_details());
			stmt.setString(7, JobDetails.getfinish_date());
			stmt.setString(8, JobDetails.getskills());
			stmt.setInt(9, JobDetails.getsalery());
			int rows = stmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			con.close();
			return t;
		}
	}

	public static int jobDelete(String companyName) {

		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();

		try {
			querystr1.append("delete from hiring_companys where companyName	=	('").append(companyName).append("')");
			query1 = querystr1.toString();
			t = exceqution(query1);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return t;

	}

	@SuppressWarnings("finally")
	public static int jobUpdate(String companyName, String roll, String vacancy) {
		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();

		try {
			querystr1.append("update hiring_companys set vacancy = ('").append(vacancy)
					.append("') where companyName = ('").append(companyName).append("') and roll = ('").append(roll)
					.append("') ");

			query1 = querystr1.toString();
			t = exceqution(query1);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			return t;
		}

	}

	@SuppressWarnings("finally")
	public static void jobSearchig(String skills) throws Exception {

		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();
		Connection con = Databasecon.getConnection();

		try {
			// Prepare SQL.
			querystr1.append("select * from hiring_companys where skills = ('").append(skills).append("') and vacancy > 0 ");

			query1 = querystr1.toString();
			Statement statement = con.createStatement();

			// Execute SQL.
			ResultSet rs = statement.executeQuery(query1);

			// Get data from database.
			ArrayList<JobDetails> jobFiles = new ArrayList<JobDetails>();
			while (rs.next()) {
				JobDetails jobFile = new JobDetails();
				jobFile.setJobId(rs.getString("job_ib"));
				jobFile.setBranch(rs.getString("branch"));
				jobFile.setCompany(rs.getString("companyName"));
				jobFile.setRoll(rs.getString("roll"));
				jobFile.setVacancy(rs.getInt("vacancy"));
				jobFile.setPlace_Details(rs.getString("location_details"));
				jobFile.setLocalDate(rs.getString("finish_date"));
				jobFile.setSkills(rs.getString("skills"));
				jobFile.setSalery(rs.getInt("salery"));
				jobFiles.add(jobFile);
				jobFile.print(jobFile);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
		}
	}

	public static void getAllDetails() throws Exception {

		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();
		Connection con = Databasecon.getConnection();

		try {
			// Prepare SQL.
			querystr1.append("select * from hiring_companys");

			query1 = querystr1.toString();
			Statement statement = con.createStatement();

			// Execute SQL.
			ResultSet rs = statement.executeQuery(query1);
			
			JobDetails jobFile1 = new JobDetails();
					
			// Get data from database.
			ArrayList<JobDetails> jobFiles = new ArrayList<JobDetails>();
			while (rs.next()) {
				JobDetails jobFile = new JobDetails();
				jobFile.setBranch(rs.getString("branch"));
				jobFile.setCompany(rs.getString("companyName"));
				jobFile.setRoll(rs.getString("roll"));
				jobFile.setVacancy(rs.getInt("vacancy"));
				jobFile.setPlace_Details(rs.getString("location_details"));
				jobFile.setLocalDate(rs.getString("finish_date"));
				jobFile.setSkills(rs.getString("skills"));
				jobFile.setSalery(rs.getInt("salery"));
				jobFiles.add(jobFile);
				jobFile1.print(jobFile);
			}
			

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
		}
	}

	public static void jobUpdate(int id) {
		
		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();

		try {
			querystr1.append("update hiring_companys set vacancy = (vacancy-1) where companyName = ('").append(id).append("')");

			query1 = querystr1.toString();
			t = exceqution(query1);
		} catch (Exception e) {

			e.printStackTrace();
		} 
	}



	public static void getDetails2(int id) throws Exception {
		
		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();
		Connection con = Databasecon.getConnection();

		try {
			// Prepare SQL.
			querystr1.append("select * from hiring_companys where job_id = '"+id+"'");

			query1 = querystr1.toString();
			Statement statement = con.createStatement();

			// Execute SQL.
			ResultSet rs = statement.executeQuery(query1);

			// Get data from database.
			ArrayList<JobDetails> jobFiles = new ArrayList<JobDetails>();
			JobDetails jobFile = null;
			while (rs.next()) {
				 jobFile = new JobDetails();
				jobFile.setJobId(rs.getInt("job_id"));
				jobFile.setBranch(rs.getString("branch"));
				jobFile.setCompany(rs.getString("companyName"));
				jobFile.setRoll(rs.getString("roll"));
				jobFile.setVacancy(rs.getInt("vacancy"));
				jobFile.setPlace_Details(rs.getString("location_details"));
				jobFile.setLocalDate(rs.getString("finish_date"));
				jobFile.setSkills(rs.getString("skills"));
				jobFile.setSalery(rs.getInt("salery"));
				jobFiles.add(jobFile);
				jobFile.setValues(jobFile);
				ApplictionDAO.insert(jobFile);
				
			}
		

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
		}
		
	}

}
