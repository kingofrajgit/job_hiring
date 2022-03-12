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