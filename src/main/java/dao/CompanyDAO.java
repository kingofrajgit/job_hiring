package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dataBaseConnection.Databasecon;
import model.CompanyProfile;

public class CompanyDAO {

	@SuppressWarnings("finally")
	public static int checkValidation(CompanyProfile obj) throws Exception {
		String query = null;
		int result = 0;
		 String mailId = obj.getMailId();
		 String password = obj.getPassword() ;
		StringBuilder querystr = new StringBuilder();
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		try {

			querystr.append("select  mail_id,company_pass from companys_details where mail_id = ('").append(mailId)
					.append("') or company_pass = ('").append(password).append("')");
			query = querystr.toString();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				result++;
			}
		} catch (Exception e) {
			connection.close();
			e.printStackTrace();
		} finally {
			System.out.println(result);
			return result;
		}
	}
	@SuppressWarnings("finally")
	public static int  companyDeatilsInsert(CompanyProfile obj) throws Exception {
		
		Connection con = Databasecon.getConnection();
		
		int rows = 0;
		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into companys_details (company_id,mail_id,company_pass) values(?,?,?)");
			stmt.setInt(1, obj.getId());
			stmt.setString(2, obj.getMailId());
			stmt.setString(3, obj.getPassword());
			
			rows = stmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			con.close();
			return rows;
		}
		
	}
	@SuppressWarnings("finally")
	public static int loginValidation(CompanyProfile obj) throws Exception {
		String query = null;
		int result = 0;
		 String mailId = obj.getMailId();
		 String password = obj.getPassword() ;
		StringBuilder querystr = new StringBuilder();
		Connection connection = Databasecon.getConnection();
		Statement statement = connection.createStatement();
		try {

			querystr.append("select  mail_id,company_pass from companys_details where mail_id = ('").append(mailId)
					.append("') and company_pass = ('").append(password).append("')");
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

}
