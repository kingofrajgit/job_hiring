package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Application {
	
	private  int jobid = 0;
	
	private  String mailId = null;
	
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	

	public  Application() {
	}
	
	
	@Override
	public String toString() {
		return "Application [mailId=" + mailId + ", getMailId()=" + getMailId() + ", getJobid()=" + getJobid() + "]";
	}



	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public   String getMailId() {
		return mailId;
	}
	public int getJobid() {
		
		return jobid;
	}



	public static void print(JobProfile jobFiles) {
		String JobsDetails1 =  jobFiles.getcompanyName() + "	" +  jobFiles.getBranch() + "	" +  jobFiles.getroll() + "	" +  jobFiles.getskills() + "	"
				+  "	" +  jobFiles.getSalary();

		String path = "jobsDetails.txt";
		System.out.println(JobsDetails1);
		
		appendUsingBufferedWriter(path, JobsDetails1);
	
	}


private static void appendUsingBufferedWriter(String path, String content) {
	File file = new File(path);
	FileWriter fr = null;
	BufferedWriter br = null;
	try {
		// to append to file, you need to initialize FileWriter using below constructor
		fr = new FileWriter(file, true);
		br = new BufferedWriter(fr);
		for (int i = 0; i <1; i++) {
			br.newLine();
			// you can use write or append method
			br.write(content);
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}

	
	

}
