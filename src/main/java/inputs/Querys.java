package inputs;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Statement;
import inputs.God;

import dbcon.Databasecon;

public class Querys {

	public static int exceqution(String query) throws Exception {
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		int rows = (int) statement.executeLargeUpdate(query);
		System.out.println("number of rows=" + rows);
		connection.close();;
		return rows;

	}

	public static ResultSet excequtionSelect(String query) throws Exception {
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		System.out.println("number of rows=" + rs);
		
		return rs;

	}

	public static int insert(God[] god) throws Exception {
		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();
		try {
			for (God god2 : god) {
				querystr1.append(
						"insert into job_hiring (userMailId,userPass,userName,DOB,college_Name,cource,branch ) values   ('")
						.append(god2.userMailId).append("','").append(god2.userPass).append("','").append(god2.userName)
						.append("','").append(god2.DOB).append("','").append(god2.collegeName).append("','")
						.append(god2.cource).append("','").append(god2.branch).append("')");
			}
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
		try {

			querystr.append("select userMailId,userPass from job_hiring where userMailId = ('").append(mailId)
					.append("') and userPass = ('").append(password).append("')");
			query = querystr.toString();
			System.out.println(query);
			ResultSet rs = excequtionSelect(query);
			while (rs.next()) {
				result++;
			}
			System.out.println(result);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			return result;
		}

	}

}
