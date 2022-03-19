DROP TABLE job_hiring;
CREATE TABLE job_hiring(
	userMailId VARCHAR (100) PRIMARY KEY NOT NULL,
	userPass VARCHAR(100)  NOT NULL,
	userName VARCHAR (100) NOT NULL,
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
	
--	company table details

	CREATE TABLE hiring_companys(
branch	VARCHAR (20)NOT NULL,
companyName	VARCHAR (20)PRIMARY KEY NOT NULL,
roll	VARCHAR (20) NOT NULL,
vacancy	int NOT NULL,
location_details    VARCHAR (20)NOT NULL,
last_date  DATE

);
SELECT * FROM hiring_companys;
SELECT *FROM job_hiring;
DELETE  FROM hiring_companys WHERE companyName = 'zogo';
DELETE FROM hiring_companys WHERE vacancy;

INSERT INTO hiring_companys (branch,companyName,roll,vacancy,location_details,finish_date) VALUES 
	('IT','rev','Sd',6,'chennai','2022-03-04');
	
	
--	application details

	CREATE TABLE job_application(
application_id INT PRIMARY KEY AUTO_INCREMENT,
user_mailId VARCHAR (40) NOT NULL,
user_name VARCHAR (40) NOT NULL,
roll VARCHAR (40) NOT NULL,
brach VARCHAR (40) NOT NULL,
company VARCHAR (40) NOT NULL,
location VARCHAR (40) NOT NULL,
selery	VARCHAR (40) NOT NULL
);
ALTER TABLE job_application ADD job_id INT NOT NULL;