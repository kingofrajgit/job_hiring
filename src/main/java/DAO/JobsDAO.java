package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataBaseConnection.Databasecon;
import model.JobProfile;

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
	public static int jobinsert(JobProfile obj) throws Exception {

		Connection con = Databasecon.getConnection();
		int rows = 0;
		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into hiring_companys (job_id,branch,companyName,roll ,vacancy,location_details,finish_date,skills,salery) values(?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, JobProfile.getjobId());
			stmt.setString(2, JobProfile.getBranch());
			stmt.setString(3, JobProfile.getcompanyName());
			stmt.setString(4, JobProfile.getroll());
			stmt.setInt(5, JobProfile.getvacancy());
			stmt.setString(6, JobProfile.getlocation_details());
			stmt.setString(7, JobProfile.getfinish_date());
			stmt.setString(8, JobProfile.getskills());
			stmt.setInt(9, JobProfile.getsalery());
			rows = stmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			con.close();
			return rows;
		}
	}

	public static int jobDelete(int jobId) throws Exception {
		
		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();
		
		try {
			query="delete  from hiring_companys where job_id	= ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1,JobProfile.getjobId());
			t = stmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return t;

	}

	@SuppressWarnings("finally")
	public static int jobUpdate() throws Exception {

		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;

		try {
			query = "update hiring_companys set vacancy = ? where job_id = ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, JobProfile.getvacancy());
			stmt.setInt(2, JobProfile.getjobId());
			t = stmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			return t;
		}

	}

	public static void jobSearchigSkills(String skills) throws Exception {

		Connection con = Databasecon.getConnection();
		String query = null;
		int t = 0;

		try {
			// Prepare SQL.
			query = "select * from hiring_companys where skills = ? and vacancy > 0 ";

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, JobProfile.getskills());

			// Execute SQL.
			ResultSet rs = stmt.executeQuery();

			// Get data from database.
			ArrayList<JobProfile> jobFiles = new ArrayList<JobProfile>();

			while (rs.next()) {

				JobProfile jobFile = new JobProfile();

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
				jobFile.print(jobFiles);
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

			JobProfile jobFile = new JobProfile();

			// Get data from database.
			List<JobProfile> jobFiles = new ArrayList<JobProfile>();
			while (rs.next()) {
				jobFile = new JobProfile();
				jobFile.setBranch(rs.getString("branch"));
				jobFile.setCompany(rs.getString("companyName"));
				jobFile.setRoll(rs.getString("roll"));
				jobFile.setVacancy(rs.getInt("vacancy"));
				jobFile.setPlace_Details(rs.getString("location_details"));
				jobFile.setLocalDate(rs.getString("finish_date"));
				jobFile.setSkills(rs.getString("skills"));
				jobFile.setSalery(rs.getInt("salery"));
				jobFiles.add(jobFile);
				System.out.println(jobFiles);
			}
			jobFile.print(jobFiles);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
		}
	}

	public static int jobUpdate1(int id) {

		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();

		try {
			querystr1.append("update hiring_companys set vacancy = (vacancy-1) where companyName = ('").append(id)
					.append("')");

			query1 = querystr1.toString();
			t = exceqution(query1);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return t;
	}

	public static void getDetails2(int id) throws Exception {

		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();
		Connection con = Databasecon.getConnection();

		try {
			// Prepare SQL.
			querystr1.append("select * from hiring_companys where job_id = '" + id + "'");

			query1 = querystr1.toString();
			Statement statement = con.createStatement();

			// Execute SQL.
			ResultSet rs = statement.executeQuery(query1);

			// Get data from database.
			ArrayList<JobProfile> jobFiles = new ArrayList<JobProfile>();
			JobProfile jobFile = null;
			while (rs.next()) {
				jobFile = new JobProfile();
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
