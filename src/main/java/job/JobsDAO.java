package job;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import dbcon.Databasecon;
import jobDetails.JobDetails;

public class JobQuerys {
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
		System.out.println("number of rows=" + rs);

		return rs;

	}
	public static  int jobinsert(JobDetails obj) throws Exception {
		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();
		
		try {
//			for (InputValidation god2 : god ) {
				querystr1.append(
						"insert into  hiring_companys(branch,companyName,roll ,vacancy,location_details,finish_date) values   ('")
						.append(obj.branch).append("','").append(obj.companyName).append("','").append(obj.roll)
						.append("','").append(obj.vacancy).append("','").append(obj.place_Details).append("','")
						.append(obj.localDate).append("')");
			
			query1 = querystr1.toString();
			t = exceqution(query1);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return t;
	}

	public static int jobDelete(String companyName) {
		String query1 = null;
		int t = 0;
		StringBuilder querystr1 = new StringBuilder();
		
		try {
//			for (InputValidation god2 : god ) {
				querystr1.append(
						"delete from hiring_companys where companyName	=	('").append(companyName).append("')");
			
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
				querystr1.append(
						"update hiring_companys set vacancy = ('").append(vacancy).append("') where companyName = ('")
							.append(companyName).append("') and roll = ('").append(roll).append("') ");
			
			query1 = querystr1.toString();
			t = exceqution(query1);
		} catch (Exception e) {

			e.printStackTrace();
		}
		finally {
			
			return t;
		}
		
		
	}
	

}
