DROP TABLE job_hiring;
CREATE TABLE job_hiring(
	user_mail_id VARCHAR (100) PRIMARY KEY NOT NULL,
	user_pass VARCHAR(100)  NOT NULL,
	user_name VARCHAR (100) NOT NULL,
	DOB DATE NOT NULL,
	college_Name VARCHAR(100) NOT NULL ,
	cource VARCHAR(100)  NOT NULL,
	branch VARCHAR(100) NOT  NULL
);
 
INSERT INTO job_hiring (userMailId,userPass ) VALUES 
	('kingofraj7092@gmail.com','pass1234');
	
	SELECT userMailId,userPass FROM job_hiring WHERE 
	userMailId = 'kingofraj7092@gmail.com' AND userPass = 'pass1234';
	
	SELECT * FROM job_hiring;
	create table table_name(
	foreign key (id) references another_table (id)
	);
---------------------------------company detailes-------------

	DROP TABLE companys_details;
	CREATE TABLE companys_details(
		company_id INT PRIMARY KEY,
		mail_id VARCHAR(40) NOT NULL,
		company_pass VARCHAR (40) NOT NULL,
		UNIQUE(mail_id,company_pass)
);
	
-----------------------------------------------------inner join --------------------------------------------

SELECT  hiring_companys.job_id,hiring_companys.company_name,hiring_companys.branch,hiring_companys.roll,hiring_companys.skills,hiring_companys.salary,job_application.user_mail_id 
FROM hiring_companys INNER JOIN job_application ON hiring_companys.job_id=job_application.job_id WHERE job_application.user_mail_id ='kingofraj.7092@gmail.com';
	
SELECT job_hiring.userMailId,job_hiring.userName,job_hiring.college_Name,job_hiring.cource,job_hiring.branch FROM job_hiring INNER JOIN job_application ON job_hiring.userMailId=job_application.user_mailId; 

-----------------------------------------------	jobs --------------------------------------------------

	CREATE TABLE hiring_companys(
branch	VARCHAR (20)NOT NULL,
companyName	VARCHAR (20)PRIMARY KEY NOT NULL,
roll	VARCHAR (20) NOT NULL,
vacancy	int NOT NULL,
location_details    VARCHAR (20)NOT NULL,
last_date  DATE
);
ALTER TABLE hiring_companys ADD mail_id VARCHAR (40) NOT NULL;

SELECT * FROM hiring_companys;
SELECT *FROM job_hiring;
DELETE  FROM hiring_companys WHERE companyName = 'zogo';
DELETE FROM hiring_companys WHERE vacancy;

INSERT INTO hiring_companys (branch,companyName,roll,vacancy,location_details,finish_date) VALUES 
	('IT','rev','Sd',6,'chennai','2022-03-04');
	
	
	
UPDATE hiring_companys SET mail_id = 'infosys@gmail.com' WHERE job_id = 12;

---------------------------------------------	application details -------------------------------------------------

	CREATE TABLE job_application(
application_id INT PRIMARY KEY AUTO_INCREMENT,
job_id INT NOT NULL,
user_mailId VARCHAR (40) NOT NULL

);
ALTER TABLE job_application ADD job_id INT NOT NULL;
-----------------------------------------------view course name------------------------------------------------------
CREATE TABLE specification(
id INT AUTO_INCREMENT PRIMARY KEY,
key_values VARCHAR(40) NOT NULL,
course VARCHAR(200)NOT NULL
);
INSERT INTO specification (key_values,course) VALUES ('ece','Electronics and communication engineerinig');
SELECT * FROM specification;

----------------------------------------------view college name -----------------------------------------------------

CREATE TABLE college_names(
id INT AUTO_INCREMENT PRIMARY KEY,
key_name VARCHAR(40) NOT NULL,
college VARCHAR(200)NOT NULL
);
INSERT INTO college_names (key_name,college) VALUES ('gce-tiruneveli','Government college of engineering, tirunelveli');
SELECT key_name,college FROM college_names;