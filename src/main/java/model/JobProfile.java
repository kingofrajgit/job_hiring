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

	private int jobId = 0;

	private String companyName = null;

	private String branch = null;

	private String roll = null;

	private int vacancy = 0;

	private String place_Details = null;

	private String localDate = null;

	private String skills = null;

	private int salary = 0;

	private String mailId = null;

	public JobProfile(int jobId, String companyName, String branch, String roll, int vacancy, String place, String date,
			String skills, int salery, String mailId) {

		this.jobId = jobId;
		this.branch = branch;
		this.companyName = companyName;
		this.roll = roll;
		this.vacancy = vacancy;
		this.place_Details = place;
		this.localDate = date;
		this.skills = skills;
		this.salary = salery;
		this.mailId = mailId;
	}

	public JobProfile() {
		// TODO Auto-generated constructor stub
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public int getjobId() {

		return jobId;
	}

	public String getBranch() {

		return branch;
	}

	public String getroll() {

		return roll;
	}

	public int getvacancy() {

		return vacancy;
	}

	public String getlocation_details() {

		return place_Details;
	}

	public String getfinish_date() {

		return localDate;
	}

	public String getskills() {

		return skills;
	}

	public int getsalery() {

		return salary;
	}

	public void setBranch(String branch) {
		this.branch = branch;

	}

	public void setCompany(String companyName) {
		this.companyName = companyName;

	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getRoll() {
		return roll;
	}

	public int getVacancy() {
		return vacancy;
	}

	public String getPlace_Details() {
		return place_Details;
	}

	public String getLocalDate() {
		return localDate;
	}

	public String getSkills() {
		return skills;
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

	public void setJobId(int jobid) {
		this.jobId = jobid;
	}

	@Override
	public String toString() {
		return "JobProfile [jobId=" + jobId + ", companyName=" + companyName + ", branch=" + branch + ", roll=" + roll
				+ ", vacancy=" + vacancy + ", place_Details=" + place_Details + ", localDate=" + localDate + ", skills="
				+ skills + ", salary=" + salary + "]";
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

	public void printAllDetails(JobProfile jobFile) {

	}
}
