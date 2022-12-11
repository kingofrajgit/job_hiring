package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

import dataBaseConnection.Databasecon;
import model.JobProfile;
import logic.InputValidation;
import model.UserDetails;

public class UserDAO {

	public static int exceqution(String query) throws Exception {
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		int rows = (int) statement.executeLargeUpdate(query);
		System.out.println("number of rows=" + rows);
		connection.close();
		return rows;

	}

	public static ResultSet excequtionSelect(String query) throws Exception {
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		connection.close();
		return rs;

	}

	public static int insert(UserDetails god2) throws Exception {
		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();
		try {

			querystr1.append(
					"insert into job_hiring (userMailId,userPass,userName,DOB,college_Name,cource,branch ) values   ('")
					.append(god2.getUserMailId()).append("','").append(god2.getUserPass()).append("','")
					.append(god2.getUserName()).append("','").append(god2.getDOB()).append("','")
					.append(god2.getCollegeName()).append("','").append(god2.getCource()).append("','")
					.append(god2.getBranch()).append("')");
//			}
			query1 = querystr1.toString();
			t = exceqution(query1);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return t;
	}

	@SuppressWarnings("finally")
	public static int checkValidation(String mailId, String password) throws Exception {
		String query = null;
		int result = 0;
		StringBuilder querystr = new StringBuilder();
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		try {

			querystr.append("select  userMailId,userPass from job_hiring where userMailId = ('").append(mailId)
					.append("') or userPass = ('").append(password).append("')");
			query = querystr.toString();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				result++;
			}
		} catch (Exception e) {
			connection.close();
			e.printStackTrace();
		} finally {

			return result;
		}

	}

	@SuppressWarnings("finally")
	public static int cacheValidation2(String mailId, String password) throws Exception {
		String query = null;
		int result = 0;
		StringBuilder querystr = new StringBuilder();
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		try {

			querystr.append("select  userMailId,userPass from job_hiring where userMailId = ('").append(mailId)
					.append("') and userPass = ('").append(password).append("')");
			query = querystr.toString();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				result++;
			}
		} catch (Exception e) {
			connection.close();
			e.printStackTrace();
		} finally {

			return result;
		}
	}

	@SuppressWarnings("finally")
	public static ArrayList<UserDetails> getAllDetails() throws Exception {
		Connection con = Databasecon.getConnection();
		String query = null;
		ArrayList<UserDetails> jobFiles = new ArrayList<UserDetails>();
		try {
			// Prepare SQL.
			query = ("SELECT userMailId,userName,DOB,college_Name,cource,branch FROM job_hiring");
			PreparedStatement statement = con.prepareStatement(query);

			ResultSet rs = statement.executeQuery();
			UserDetails userDetails = null;

			while (rs.next()) {

				// object greation for userDetails class
				userDetails = new UserDetails();

				userDetails.setMailId(rs.getString("userMailId"));
				userDetails.setName(rs.getString("userName"));
				userDetails.setDob(rs.getString("DOB"));
				userDetails.setCollege_name(rs.getString("College_name"));
				userDetails.setcource(rs.getString("cource"));
				userDetails.setbranch(rs.getString("branch"));

				jobFiles.add(userDetails);

			}
//			userDetails.print(jobFiles);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
			return jobFiles;
		}

	}

	@SuppressWarnings("finally")
	public static String getSkills(String userMailId) throws Exception {

		UserDetails obj = new UserDetails();
		Connection con = Databasecon.getConnection();
		String skills = null;
		String query = null;

		try {
			// Prepare SQL.
			query = "select branch from job_hiring where userMailId = ? ";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, userMailId);
			// Execute SQL.
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				skills = rs.getString("branch");

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			con.close();
			return skills;
		}
	}

}
