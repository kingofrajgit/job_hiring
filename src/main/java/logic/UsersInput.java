package logic;

import java.util.ArrayList;
import java.util.Scanner;
import logic.GetInput;
import logic.InputValidation;
import DAO.ApplicationDAO;
import DAO.CompanyDAO;
import DAO.JobsDAO;
import DAO.UserDAO;
import model.Application;
import model.CompanyProfile;
import model.JobProfile;
import model.UserDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.gen5.api.Test;

import model.UserDisplay;

public class UsersInput {

	private static org.apache.logging.log4j.Logger log = LogManager.getLogger();

	static Scanner sc = new Scanner(System.in);

	public int choseUser() {
		System.out.println("===============================================");
		log.info("!....chose your option");
		log.info(":=) Registration  ==> 1");
		log.info(":=) Login         ==> 2");
		int optioin = sc.nextInt();
		log.debug("Enter login page");
		return optioin;
	}

	public void validationCheckInput() throws Exception {
		System.out.println("===============================================");
		log.info("");
		GetInput get = new InputValidation();

		int option = 0;
		String userMailId = null;
		String userpass = null;

		// getting input using Scanner
		log.info("=> Enter your mail id :");
		userMailId = sc.next();
		log.info("=> Enter your password");
		userpass = sc.next();

		// calling check function
		option = get.registerValitation(userMailId, userpass);
		if (option >= 1) {
			System.out.println("Email id is already exist");
			System.out.println("Re-enter your valid email");
			validationCheckInput();
		} else {
			DeatilsRequired(userMailId, userpass);
		}
	}

	static void DeatilsRequired(String userMailId, String userPass) throws Exception {
		System.out.println("===============================================");
		UsersInput obj = new UsersInput();
		log.info("1.Enter your Name");
		String userName = sc.next();
		log.info("2.Enter your DOB");
		log.info("Enter this format ==> 2001-03-20");
		String DOB = sc.next();
		log.info("3.Enter your college name");
		String collegeName = sc.next();
		log.info("4.Enter your  cource");
		String cource = sc.next();
		log.info("5.Enter your branch");
		String branch = sc.next();
		UserDetails details = new UserDetails(userName, DOB, collegeName, cource, branch, userMailId, userPass);
		log.info("!.....In progress");
		int n = UserDAO.insert(details);

		if (n == 1) {
			log.info("registertion successfull");
			usersDisplay(userMailId, userPass);
		} else {
			log.info("registertion unsuccessfull");
			obj.validationCheckInput();
		}
	}

	public static void usersDisplay(String emailId, String password) throws Exception {

		UserDetails details = new UserDetails();

		log.info("successfull login.....!");
		System.out.println("==========================================================");
		int option = 0;
		System.out.println("----Dasboard----");
		log.info("Job details	     ==> 1");
		option = sc.nextInt();
		jobsProfile(emailId);

	}

	public static void jobsProfile(String emailId) throws Exception {

		System.out.println("==========================================================");
		log.info("1.search jobs    ==> 1");
		log.info("2.My applications==> 2");
		log.info("3.apply jobs jobs==> 3");
		int option = sc.nextInt();
		if (option == 1) {
			findJobs();
		} else if (option == 2) {
			ApplicationDAO.findMyApplications(emailId);
		} else {
			applyJobs(emailId);
		}

	}

	private static void applyJobs(String emailId) throws Exception {

		System.out.println("1. continue to apply ==>1");
		System.out.println("1. go back           ==>2");
		int op = sc.nextInt();
		if (op == 2) {
			jobsProfile(emailId);
		} else {
			System.out.println("==========================================================");
			System.out.println("----apply jobs----");
			System.out.println("Enter application id");
			int applicationId = sc.nextInt();
			
			Application application = new Application();
			
			application.setJobid(applicationId);
			application.setMailId(emailId);
			Jobs job = new JobValidation();
			int option = job.updateJobVacancy(applicationId);
			if (option == 1) {
				System.out.println("applied");
				jobsProfile(emailId);
			} else {
				System.out.println("Not applied");

			}
		}

	}

	public static void findJobs() throws Exception {

		System.out.println("==========================================================");
		Jobs job = new JobValidation();
		JobProfile jobProfile = new JobProfile();
		Scanner sc = new Scanner(System.in);
		log.info("Enter your Skills");
		String skills = sc.next();

		jobProfile.setSkills(skills);
		job.jobSerching(jobProfile);

	}

	public void loginCheck() throws Exception {

		UserDetails details = new UserDetails();
		System.out.println("===================================================");
		log.info("..welcome to Login page..");
		System.out.println("---------------------------");
		log.info("=> Enter your email");
		String emailId = sc.next();
		details.setMailId(emailId);
		log.info("=> Enter your password ");
		String password = sc.next();
		int a = 0;
		System.out.println("===================================================");
		System.out.println("!..........Loading.......");
		a = UserDAO.cacheValidation2(emailId, password);
		if (a == 0) {
			log.error("Invalid email or password");
			loginCheck();
		} else {
			usersDisplay(emailId, password);
		}
	}

	public int chosePrefernce() {
		System.out.println("===================================================");
		log.info("!....chose your option");
		log.info(":=) users    ==> 1");
		log.info(":=) companys ==> 2");
		int optioin = sc.nextInt();
		return optioin;

	}

	public int choseCompanys() {
		System.out.println("===================================================");
		log.info("!....chose your option");
		log.info(":=) Registration ==> 1");
		log.info(":=) login        ==> 2");
		int optioin = sc.nextInt();
		return optioin;
	}

	public void companyInputValidationCheck() throws Exception {
		System.out.println("==========================================================");
		System.out.println("---Registration---");
		CompanyProfile obj = new CompanyProfile();
		log.info("Enter your id");
		int id = sc.nextInt();
		log.info("Enter your company mail id");
		String MailId = sc.next();
		log.info("Enter your password");
		String password = sc.next();
		obj.setId(id);
		obj.setMailId(MailId);
		obj.setPassword(password);
		int a = CompanyValidation.registerValitation(obj);
		if (a >= 1) {
			System.out.println("Email id is already exist");
			System.out.println("Re-enter your valid email");
			companyInputValidationCheck();
		} else {
			a = CompanyDAO.companyDeatilsInsert(obj);
		}
		if (a == 1) {
			log.info("registertion successfull");
			companyVeaw(MailId);
		} else {
			log.info("registertion unsuccessfull");
			companyInputValidationCheck();
		}

	}
	private void companyVeaw(String mailId) throws Exception {
		System.out.println("=========================================================");
		System.out.println("---Wellcome Sir---");
		System.out.println("choose your option..");
		System.out.println("1. Job insert  ==> 1");
		System.out.println("2. Job update  ==> 2");
		System.out.println("3. Job delete  ==> 3");
		System.out.println("4. applications ==> 4");
		System.out.println("5. Logout    	==> 5");
		System.out.println();
		int option = sc.nextInt();
		switch (option) {
		case 1:
			// Job insert dao
			option = getJobDetails();
			validation(option,mailId);
			break;
		case 2:
			option = updateJobs();
			break;
		case 3:
			jobDelete();
			break;
		case 4:
			ArrayList<Application> list = ApplicationDAO.FindId(mailId);
			for(Application rs : list) {
			System.out.println(rs.getJobid());
			}
			break;
		case 5:
			
			break;
		}
	}

	private void jobDelete() throws Exception {

		System.out.println("==========================================================");
		Jobs job = new JobValidation();
		Scanner sc = new Scanner(System.in);
		JobProfile jobProfile = new JobProfile();

		System.out.println("enter your vacancy");
		int jobId = sc.nextInt();
		jobProfile.setJobId(jobId);
		int a = job.deleteJob(jobId);
		if (a == 0) {
			System.out.println("Your job details is not deleted");
		} else {
			System.out.println("Your job detais is deleted successfull");
		}

	}

	private int updateJobs() throws Exception {

		System.out.println("==========================================================");
		Jobs job = new JobValidation();
		JobProfile details = new JobProfile();

		int jobId = 0;
		int answer = 0;

		System.out.println("enter your jobId");
		jobId = sc.nextInt();
		System.out.println("enter your vacancy");
		int vacancy = sc.nextInt();

		details.setJobId(jobId);
		details.setVacancy(vacancy);
		answer = job.updateJob();
		if (answer == 0) {
			System.out.println("Your job details not update");
		} else {
			System.out.println("Your job details update successfull");
		}

		return 0;
	}

	private void validation(int op,String mailId) throws Exception {
		System.out.println("==========================================================");
		if (op >= 1) {
			log.info("Your job is successfully added");
			System.out.println("Choose your option");
			System.out.println("1. Go back");
			System.out.println("2. logout");
			op = sc.nextInt();
			if (op == 1) {
				companyVeaw(mailId);
			} else {
				chosePrefernce();
			}
		} else {
			log.info("Your job is insert unsuccessfully ");
		}
	}

	private int getJobDetails() throws Exception {
		JobValidation obj1 = new JobValidation();
		Scanner sc = new Scanner(System.in);

		System.out.println("1).Enter the jobId");
		int jobId = sc.nextInt();
		System.out.println("2).Enter your  branch");
		String branch = sc.next();
		System.out.println("3).Enter your comapny name");
		String companyName = sc.next();
		System.out.println("4).Enter your roll");
		String roll = sc.next();
		System.out.println("5).Enter your vacancy ");
		int vacancy = sc.nextInt();
		System.out.println("5).Enter your location");
		String place = sc.next();
		System.out.println("6).Enter lost entry date");
		String date = sc.next();
		System.out.println("7).Enter the skils details");
		String Skills = sc.next();
		System.out.println("8).Enter the salery");
		int salery = sc.nextInt();

		JobProfile obj = new JobProfile(jobId, companyName, branch, roll, vacancy, place, date, Skills, salery);
		int t = obj1.addJob(obj);
		return t;
	}

	public void loginCheckCompany() throws Exception {
		System.out.println("==========================================================");
		System.out.println("---Login page---");
		CompanyProfile obj = new CompanyProfile();
		log.info("Enter your company mail id");
		String mailId = sc.next();
		log.info("Enter your password");
		String password = sc.next();
		System.out.println("!............loading.............");
		obj.setMailId(mailId);
		obj.setPassword(password);
		int a = CompanyDAO.loginValidation(obj);
		if (a == 1) {
			log.info("Login successfull");
			companyVeaw(mailId);
		} else {
			log.info("Login unsuccessfull");
			loginCheckCompany();
		}

	}

}
