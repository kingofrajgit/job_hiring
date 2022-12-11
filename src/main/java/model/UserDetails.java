package model;
import java.io.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class UserDetails {

	private String userMailId = null;
	
	private String userPass = null;
	
	private String userName = null;
	
	private String DOB = null;
	
	private String collegeName = null;
	
	private String cource = null;
	
	private String branch = null;
	
	private int count = 0;
	
	private String skills = null;
	
	
	public UserDetails(String userName2, String dOB2, String collegeName2, String cource2, String branch2, String userMailId2, String userpass2) {
		
		setUserName(userName2);
		setDOB(dOB2);
		setCollegeName(collegeName2);
		setCource(cource2);
		setBranch(branch2);
		setUserMailId(userMailId2);
		setUserPass(userpass2);
	}
	public UserDetails() {
	
	}
	
	public void setMailId(String userMailId2) {
		setUserMailId(userMailId2);
		
	}
	public void setPass(String userpass2) {
		
		setUserPass(userpass2);
	}
	public void setName(String userName2) {
		setUserName(userName2);
		
	}
	public void setDob(String dOB2) {
		setDOB(dOB2);
	
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setCollege_name(String collegeName2) {
		setCollegeName(collegeName2);
		
		
	}
	public void setcource(String cource2) {
		setCource(cource2);
		
		
	}
	public void setbranch(String branch2) {
		
		setBranch(branch2);
	}
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCource() {
		return cource;
	}
	public void setCource(String cource) {
		this.cource = cource;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	


}
