CREATE DATABASE infirmary_management_system;

CREATE TABLE `login_details` (
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL
);

CREATE TABLE `medicine_list` (
  `medicine_name` varchar(30) NOT NULL,
  `medicine_quantity` double NOT NULL DEFAULT '0',
  `medicine_expiry_date` varchar(15) NOT NULL,
  PRIMARY KEY (`medicine_name`)
);

CREATE TABLE `injection_list` (
  `injection_name` varchar(30) NOT NULL,
  `injection_quantity` double NOT NULL DEFAULT '0',
  `injection_expiry_date` varchar(15) NOT NULL,
  PRIMARY KEY (`injection_name`)
) ;

CREATE TABLE `patient_records` (
  `reg_no` int NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL,
  `student_no` int NOT NULL,
  `sex` varchar(10) NOT NULL,
  `age` int NOT NULL,
  `year` int NOT NULL,
  `course` varchar(20) NOT NULL,
  `department` varchar(25) NOT NULL,
  `phone_no` int NOT NULL,
  `date` varchar(12) NOT NULL,
  `time` varchar(10) NOT NULL,
  `leave_options` varchar(25) NOT NULL,
  `no_of_days` int NOT NULL,
  `complaint` mediumtext NOT NULL,
  `remarks` tinytext NOT NULL,
  UNIQUE KEY `reg_no_UNIQUE` (`reg_no`)
) ;

CREATE TABLE `patient_records_staffs` (
  `reg_no` int NOT NULL DEFAULT '200',
  `name` varchar(45) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `age` int NOT NULL,
  `department` varchar(25) NOT NULL,
  `phone_no` int NOT NULL,
  `date` varchar(12) NOT NULL,
  `time` varchar(10) NOT NULL,
  `leave_options` varchar(25) NOT NULL,
  `no_of_days` int NOT NULL,
  `complaint` mediumtext NOT NULL,
  `remarks` tinytext NOT NULL,
  UNIQUE KEY `reg_no_UNIQUE` (`reg_no`)
) ;

CREATE TABLE `patient_records_others` (
  `reg_no` int NOT NULL DEFAULT '300',
  `name` varchar(45) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `age` int NOT NULL,
  `phone_no` int NOT NULL,
  `date` varchar(12) NOT NULL,
  `time` varchar(10) NOT NULL,
  `complaint` mediumtext NOT NULL,
  `remarks` tinytext NOT NULL,
  UNIQUE KEY `reg_no_UNIQUE` (`reg_no`)
);


