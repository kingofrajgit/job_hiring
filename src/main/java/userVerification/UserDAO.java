package userVerification;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

import dbcon.Databasecon;
import jobDetails.JobDetails;
import userVerification.InputValidation;

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
					.append(god2.userMailId).append("','").append(god2.userPass).append("','").append(god2.userName)
					.append("','").append(god2.DOB).append("','").append(god2.collegeName).append("','")
					.append(god2.cource).append("','").append(god2.branch).append("')");
//			}
			query1 = querystr1.toString();
			t = exceqution(query1);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return t;
	}

	@SuppressWarnings("finally")
	public static int cacheValidation(String mailId, String password) throws Exception {
		String query = null;
		int result = 0;
		StringBuilder querystr = new StringBuilder();
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		try {

			querystr.append("select  userMailId,userPass from job_hiring where userMailId = ('").append(mailId).append("') or userPass = ('").append(password).append("')");
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

			querystr.append("select  userMailId,userPass from job_hiring where userMailId = ('").append(mailId).append("') and userPass = ('").append(password).append("')");
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
		public static void getalldetails() throws Exception {

			String query1 = null;
			int t = 0;
			StringBuilder querystr1 = new StringBuilder();
			Connection con = Databasecon.getConnection();

			try {
				// Prepare SQL.
				querystr1.append("select * from job_hiring");

				query1 = querystr1.toString();
				Statement statement = con.createStatement();

				// Execute SQL.
				ResultSet rs = statement.executeQuery(query1);

				// Get data from database.
				ArrayList<UserDetails> jobFiles = new ArrayList<UserDetails>();
				while (rs.next()) {
					UserDetails userDetails = new UserDetails();
					userDetails.setMailId(rs.getString("userMailId"));
					userDetails.setPass(rs.getString("userPass"));
					userDetails.setName(rs.getString("userName"));
					userDetails.setDob(rs.getString("DOB"));
					userDetails.setCollege_name(rs.getString("College_name"));
					userDetails.setcource(rs.getString("cource"));
					userDetails.setbranch(rs.getString("branch"));
			
					jobFiles.add(userDetails);
					userDetails.print(jobFiles);
				}

			} catch (Exception e) {

				e.printStackTrace();
			} finally {

				con.close();
			}

	}

}
