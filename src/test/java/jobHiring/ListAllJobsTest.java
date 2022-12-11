package jobHiring;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.JobsDAO;
import model.JobProfile;
public class ListAllJobsTest {

	public static void main(String[] args) throws Exception {
		JobsDAO obj = new JobsDAO();
		List<JobProfile> jobFile = obj.getAllDetails();
			int count = 0;
			String JobsDetails =" job id " + "	"+ "company name"+"		" +"Branch"+ "		"+"roll"+"		"+"skills"+"		"+"place_Details"+"		"+"salary"+"		"+"vacancy" ;
			System.out.println(JobsDetails);
			for (JobProfile jobFiles : jobFile) {
				String JobsDetails1 = jobFiles.getjobId()+"	"+jobFiles.getCompanyName() + "		" + jobFiles.getBranch() + "		" + jobFiles.getRoll() + "		"
						+ jobFiles.getSkills() + "		" + jobFiles.getPlace_Details() + "		" + jobFiles.getSalary() + "		"
						+ jobFiles.getVacancy();
				count++;
				String path = "jobsDetails.txt";
				System.out.println(JobsDetails1);
			}	
	}

}
