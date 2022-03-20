package model;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JobProfile {
	
	private static int jobId = 0;

	private static String companyName = null;

	private static String branch = null;

	private static String roll = null;

	private static int vacancy = 0;

	private static String place_Details = null;

	private static String localDate = null;

	private static String skills = null;

	private static int salary = 0;

	public JobProfile(int jobId,String companyName, String branch, String roll, int vacancy, String place, String date,
			String skills, int salery) {
		
		this.jobId = jobId;
		this.branch = branch;
		this.companyName = companyName;
		this.roll = roll;
		this.vacancy = vacancy;
		this.place_Details = place;
		this.localDate = date;
		this.skills = skills;
		this.salary = salery;
	}
	
	public JobProfile() {
		
	}

	public static int getjobId() {

		return jobId;
	}

	public static String getBranch() {

		return branch;
	}

	public static String getcompanyName() {

		return companyName;
	}

	public static String getroll() {

		return roll;
	}

	public static int getvacancy() {

		return vacancy;
	}

	public static String getlocation_details() {

		return place_Details;
	}

	public static String getfinish_date() {

		return localDate;
	}

	public static String getskills() {

		return skills;
	}

	public static int getsalery() {

		return salary;
	}

	public void setBranch(String branch) {
		this.branch = branch;

	}

	public void setCompany(String companyName) {
		this.companyName = companyName;

	}

	public void setRoll(String roll) {

		this.roll = roll;

	}

	public void setVacancy(int vacancy) {

		this.vacancy = vacancy;

	}

	public void setPlace_Details(String place) {

		this.place_Details = place;

	}

	public void setLocalDate(String date) {

		this.localDate = date;

	}

	public void setSkills(String skills) {

		this.skills = skills;

	}

	public void setSalery(int salery) {

		this.salary = salery;
	}
	
	public  void setJobId(int jobid) {
		this.jobId = jobid ;
	}

	public void print(List<JobProfile> jobFiles2) throws IOException {
		int  count = 0;
		for(JobProfile jobFiles : jobFiles2) {
			count++;
			String JobsDetails1 =  jobFiles.companyName + "," +  jobFiles.branch + "," +  jobFiles.roll + "," +  jobFiles.skills + ","
					+  jobFiles.place_Details + "," +  jobFiles.salary + "," +  jobFiles.vacancy;

			String path = "jobsDetails.txt";
			System.out.println(jobFiles+JobsDetails1);
			
			appendUsingBufferedWriter(path, JobsDetails1,count);
			
	}
		if(count !=0) {
		System.out.println("All Details are inserted in this file" + "jobsDetails.txt");
		}
		else {
			System.out.println("All Details are inserted in this file" + "jobsDetails.txt");
		}
		}
	

	private static void appendUsingBufferedWriter(String path, String content, int noOfLines) {
		File file = new File(path);
		FileWriter fr = null;
		BufferedWriter br = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			for (int i = 0; i < noOfLines; i++) {
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

	public void setJobId(String string) {
		
		
	}

	public int getJobId() {
		
		return jobId;
	}

	public void setValues(JobProfile jobFile) {
		this.jobId = jobFile.jobId;
		this.branch = jobFile.branch;
		this.companyName = jobFile.companyName;
		this.roll = jobFile.roll;
		this.vacancy = jobFile.vacancy;
		this.place_Details = jobFile.place_Details;
		this.salary = jobFile.salary;
		
	}
}
