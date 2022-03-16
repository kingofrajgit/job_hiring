package jobDetails;

public class JobDetails {
	
	public  String companyName	=	null;
	public static String branch	= 	null;
	public static String roll	 = 	null;
	public static int vacancy	 = 	0;
	public static String place_Details	=	null;
	public static String localDate	=	null;	
	
	public JobDetails(String companyName, String branch, String roll, int vacancy, String place, String date) {
		this.branch 	=	branch;
		this.companyName	=	companyName;
		this.roll	=	roll;
		this.vacancy	=	vacancy;
		this.place_Details	=	place;
		this.localDate	=	date;
	}


}
