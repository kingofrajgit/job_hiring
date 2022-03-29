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

	public int chosePrefernce() {
		System.out.println("===============================================");
		System.out.println("!....chose your option");
		System.out.println(":=) users    ==> 1");
		System.out.println(":=) companys ==> 2");
		int optioin = sc.nextInt();
		return optioin;

	}

	public int choseCompanys() {
		System.out.println("===============================================");
		System.out.println("!....chose your option");
		System.out.println(":=) Registration ==> 1");
		System.out.println(":=) login        ==> 2");
		int optioin = sc.nextInt();
		return optioin;
	}

	public int choseUser() {
		System.out.println("===============================================");
		System.out.println("....chose your option......");
		System.out.println("---------------------------");
		System.out.println(":=) Registration  ==> 1");
		System.out.println(":=) Login         ==> 2");
		int optioin = sc.nextInt();
		return optioin;
	}

	public void companyInputValidationCheck() throws Exception {
		System.out.println("===============================================");
		System.out.println("---Registration---");
		CompanyProfile obj = new CompanyProfile();
		log.info("Enter your id");
		int id = sc.nextInt();
		log.info("Enter your id");
		log.info("Enter your company mail id");
		String MailId = sc.next();
		log.info("Enter your company mail id");
		log.info("Enter your password");
		String password = sc.next();
		log.info("Enter your password");
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
		System.out.println("===============================================");
		System.out.println("---Wellcome Sir---");
		System.out.println("choose your option..");
		System.out.println("1. Job insert  ==> 1");
		System.out.println("2. Job update  ==> 2");
		System.out.println("3. Job delete  ==> 3");
///		System.out.println("4. applications ==> 4");
		System.out.println("5. Logout    	==> 4");
		System.out.println();
		int option = sc.nextInt();
		switch (option) {
		case 1:
			// Job insert dao
			option = getJobDetails(mailId);
			validation(option, mailId);
			break;
		case 2:
			option = updateJobs1(mailId);
			break;
		case 3:
			jobDelete(mailId);
			break;
//		case 4:
//			ArrayList<Application> list = ApplicationDAO.FindId(mailId);
//			for(Application rs : list) {
//			System.out.println(rs.getJobid());
//			}
//			break;
		case 4:
			logout();
			break;
		}
	}

	private void choice(String mailId) throws Exception {
		System.out.println("1. back            ==>4");
		System.out.println("2. logged out      ==>5");
		int option = sc.nextInt();
		if( option == 1) {
			companyVeaw(mailId);
		}else {
			logout();
		}
	}

	static void DeatilsRequired(String userMailId, String userPass) throws Exception {
		System.out.println("===============================================");
		UsersInput obj = new UsersInput();
		System.out.println("1.Enter your Name");
		String userName = sc.next();
		log.info("user name :"+userName);
		System.out.println("2.Enter your DOB");
		System.out.println("Enter this format ==> 2001-03-20");
		String DOB = sc.next();
		log.info("User date of birth :"+DOB);
		System.out.println("3.Enter your college name");
		String collegeName = sc.next();
		log.info("User college :ame :"+DOB);
		System.out.println("4.Enter your  cource");
		String cource = sc.next();
		log.info("User cource details :"+DOB);
		System.out.println("5.Enter your branch");
		String branch = sc.next();
		log.info("User branch details :"+DOB);
		UserDetails details = new UserDetails(userName, DOB, collegeName, cource, branch, userMailId, userPass);
		System.out.println("!.....In progress");
		int n = UserDAO.insert(details);
	
		if (n == 1) {
			log.info("registertion successfull");
			usersDisplay(userMailId, userPass);
		} else {
			log.error("registertion unsuccessfull");
			obj.validationCheckInput();
		}
	}

	public static void findJobs(String emailId) throws Exception {
	
		System.out.println("===============================================");
		log.info("Searching Page");
		System.out.println("Searching Page");
		Jobs job = new JobValidation();
		JobProfile jobProfile = new JobProfile();
		Scanner sc = new Scanner(System.in);
		log.info("Enter your Skills");
		String skills = sc.next();
	
		jobProfile.setSkills(skills);
		job.jobSerching(jobProfile);
		int option = 0;
		option = logoutBack();
		if (option == 1) {
			log.info("job profile bage");
			jobsProfile(emailId);
		} else {
			log.info("logout");
			logout();
		}
	
	}

	private int getJobDetails(String mailId) throws Exception {
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

	private void jobDelete(String mailId) throws Exception {
	
		System.out.println("===============================================");
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
		choice(mailId);
	}

	public static void jobsProfile(String emailId) throws Exception {
	
		System.out.println("===============================================");
		System.out.println("1.search jobs    ==> 1");
		System.out.println("2.My applications==> 2");
		System.out.println("3.apply jobs jobs==> 3");
		int option = sc.nextInt();
		if (option == 1) {
			findJobs(emailId);
		} else if (option == 2) {
			ApplicationDAO.findMyApplications(emailId);
		} else {
			applyJobs(emailId);
		}
	
	}

	public static void logout() {
	
	}

	public void loginCheck() throws Exception {
	
		UserDetails details = new UserDetails();
		System.out.println("===============================================");
		log.info("..welcome to Login page..");
		System.out.println("---------------------------");
		log.info("=> Enter your email");
		String emailId = sc.next();
		log.info(emailId);
		details.setMailId(emailId);
		log.info("=> Enter your password ");
		String password = sc.next();
		int a = 0;
		System.out.println("===============================================");
		System.out.println("..........Loading.........!");
		a = UserDAO.cacheValidation2(emailId, password);
		if (a == 0) {
			System.out.println("Invalid email or password");
			log.error("Invalid email or password");
			loginCheck();
		} else {
			usersDisplay(emailId, password);
		}
	}

	private static int logoutBack() {
		System.out.println("===============================================");
		System.out.println("  choose your option :");
		System.out.println(" --------------------");
		System.out.println("1.back  ==> 1");
		System.out.println("2.logout => 2");
		int n = sc.nextInt();
		return n;
	}

	public void loginCheckCompany() throws Exception {
		System.out.println("===============================================");
		System.out.println("---Login page---");
		CompanyProfile obj = new CompanyProfile();
		System.out.println("Enter your company mail id");
		String mailId = sc.next();
		System.out.println("Enter your password");
		String password = sc.next();
		System.out.println("!............loading.............");
		obj.setMailId(mailId);
		obj.setPassword(password);
		int a = CompanyDAO.loginValidation(obj);
		if (a == 1) {
			log.info("Login successfull");
			System.out.println("Login successfull");
			companyVeaw(mailId);
		} else {
			log.info("Login unsuccessfull");
			System.out.println("Login unsuccessfull");
			loginCheckCompany();
		}

	}

	public int terminateOrContinue() {
		System.out.println("===============================================");
		System.out.println(" choose the option");
		System.out.println("-------------------");
		System.out.println("1. terminate  => 1");
		System.out.println("2. continue   => 2");
		int optioin = sc.nextInt();
		return optioin ;
	}
	private int updateJobs1(String mailId) throws Exception {
		log.info("job update profile");
		System.out.println("===============================================");
		System.out.println("job update profile");
		System.out.println("1. skills update   ==>1");
		System.out.println("2. vacancy update  ==>2");
		System.out.println("3. salary update   ==>3");
		System.out.println("4. back            ==>4");
		System.out.println("5. logged out      ==>5");
		int option =sc.nextInt();
		switch(option){
			case 1:
				updateJobs2(mailId);
				break;
			case 2:
				updateJobs(mailId);
				break;
			case 3:
				updateJobs3(mailId);
				break;
			case 4:
				companyVeaw(mailId);
				break;
			case 5:
				logout();
				break;
		}
		return 0;
		
	}

	private void updateJobs2(String mailId) throws Exception {
		System.out.println("===============================================");
		Jobs job = new JobValidation();
		JobProfile details = new JobProfile();
	
		int jobId = 0;
		int answer = 0;
	
		System.out.println("Enter your jobId");
		jobId = sc.nextInt();
		System.out.println("Enter your skills");
		String skills = sc.next();
	
		details.setJobId(jobId);
		details.setSkills(skills);
		answer = job.updateJobSkills(details);
		if (answer == 0) {
			System.out.println("Your job details not update");
		} else {
			System.out.println("Your job details update successfull");
		}
		choice(mailId);
		
	}

	private void updateJobs3(String mailId) throws Exception {
		System.out.println("===============================================");
		Jobs job = new JobValidation();
		JobProfile details = new JobProfile();
	
		int jobId = 0;
		int answer = 0;
	
		System.out.println("enter your jobId");
		jobId = sc.nextInt();
		System.out.println("enter your vacancy");
		int salary = sc.nextInt();
	
		details.setJobId(jobId);
		details.setSalary(salary);
		answer = job.updateJobSalary(details);
		if (answer == 0) {
			System.out.println("Your job details not update");
		} else {
			System.out.println("Your job details update successfull");
		}
		choice(mailId);
	
		
	}

	private int updateJobs(String mailId) throws Exception {
	
		System.out.println("===============================================");
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
		choice(mailId);
	
		return 0;
	}

	public static void usersDisplay(String emailId, String password) throws Exception {
	
		UserDetails details = new UserDetails();
	
		log.info("successfull login.....!");
		System.out.println("===============================================");
		int option = 0;
		System.out.println("----Dasboard----");
		System.out.println("Job details	     ==> 1");
		System.out.print("");
		option = sc.nextInt();
		jobsProfile(emailId);
	
	}

	private void validation(int op, String mailId) throws Exception {
		System.out.println("===============================================");
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

	public void validationCheckInput() throws Exception {
	
		System.out.println("===============================================");
		log.info(" Registration page");
		System.out.println("welcome to Registration page");
		GetInput get = new InputValidation();
		int option = 0;
		String userMailId = null;
		String userPass = null;
	
		// getting input using Scanner class
		System.out.println("=> Enter your mail Id :");
		userMailId = sc.next();
		log.info("user MailId :"+userMailId);
		System.out.println("=> Enter your password :");
		userPass = sc.next();
		log.info("user Password :"+userPass);
	
		// calling check function
		option = get.registerValitation(userMailId, userPass);
		if (option >= 1) {
			System.out.println("Email id is already exist");
			System.out.println("Re-enter your valid email");
			log.info("Re-enter your valid email");
			validationCheckInput();
		} else {
			DeatilsRequired(userMailId, userPass);
		}
	}

}
