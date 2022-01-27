package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Patient {

		private IntegerProperty regNo, stdNo, year, age, phoneNo, leaveDays;
		private StringProperty name, course, dept, sex, date, time, leaveOptions, complaint, remarks;
		
		//constructor
		public Patient() {
			
			this.regNo = new SimpleIntegerProperty();
			this.name = new SimpleStringProperty();
			this.stdNo = new SimpleIntegerProperty();
			this.year = new SimpleIntegerProperty();
			this.course = new SimpleStringProperty();
			this.dept = new SimpleStringProperty();
			this.sex = new SimpleStringProperty(); 
			this.age = new SimpleIntegerProperty(); 
			this.phoneNo = new SimpleIntegerProperty(); 
			this.date = new SimpleStringProperty();
			this.time = new SimpleStringProperty();
			this.leaveOptions = new SimpleStringProperty(); 
			this.leaveDays = new SimpleIntegerProperty(); 
			this.complaint = new SimpleStringProperty(); 
			this.remarks = new SimpleStringProperty();
			
		}
			
		//getters and setters
		public Integer getStdNo() {
			return stdNo.get();
		}
	
		public void setStdNo(Integer stdNo) {
			this.stdNo.set(stdNo);
		}
		
		public IntegerProperty get_StdNo() {
			return stdNo;
		}

		public Integer getYear() {
			return year.get();
		}
	
		public void setYear(Integer year) {
			this.year.set(year);
		}
		
		public IntegerProperty get_Year() {
			return year;
		}
	
		public Integer getAge() {
			return age.get();
		}
	
		public void setAge(Integer age) {
			this.age.set(age);
		}
		
		public IntegerProperty get_Age() {
			return age;
		}
	
		public Integer getPhoneNo() {
			return phoneNo.get();
		}
	
		public void setPhoneNo(Integer phoneNo) {
			this.phoneNo.set(phoneNo);
		}
		
		public IntegerProperty get_PhoneNo() {
			return phoneNo;
		}
	
		public Integer getLeaveDays() {
			return leaveDays.get();
		}
	
		public void setLeaveDays(Integer leaveDays) {
			this.leaveDays.set(leaveDays);
		}
		
		public IntegerProperty get_LeaveDays() {
			return leaveDays;
		}
	
		public Integer getRegNo() {
			return regNo.get();
		}
	
		public void setRegNo(Integer regNo) {
			this.regNo.set(regNo);
		}
		
		public IntegerProperty get_RegNo() {
			return regNo;
		}
	
		public String getName() {
			return name.get();
		}
	
		public void setName(String name) {
			this.name.set(name);
		}
		
		public StringProperty get_Name() {
			return name;
		}
	
		public String getCourse() {
			return course.get();
		}
	
		public void setCourse(String course) {
			this.course .set(course);
		}
		
		public StringProperty get_Course() {
			return course;
		}
	
		public String getDept() {
			return dept.get();
		}
	
		public void setDept(String dept) {
			this.dept.set(dept);
		}
		
		public StringProperty get_Dept() {
			return dept;
		}
	
		public String getSex() {
			return sex.get();
		}
	
		public void setSex(String sex) {
			this.sex.set(sex);
		}
		
		public StringProperty get_Sex() {
			return sex;
		}
	
		public String getDate() {
			return date.get();
		}
	
		public void setDate(String date) {
			this.date.set(date);
		}
	
		public StringProperty get_Date() {
			return date;
		}
		
		public String getTime() {
			return time.get();
		}
	
		public void setTime(String time) {
			this.time.set(time);
		}
		
		public StringProperty get_Time() {
			return time;
		}
	
		public String getLeaveOptions() {
			return leaveOptions.get();
		}
	
		public void setLeaveOptions(String leaveOptions) {
			this.leaveOptions.set(leaveOptions);
		}
		
		public StringProperty get_leaveOptions() {
			return leaveOptions;
		}
	
		public String getComplaint() {
			return complaint.get();
		}
	
		public void setComplaint(String complaint) {
			this.complaint.set(complaint);
		}
		
		public StringProperty get_Complaint() {
			return complaint;
		}
	
		public String getRemarks() {
			return remarks.get();
		}
	
		public void setRemarks(String remarks) {
			this.remarks.set(remarks);
		}
		
		public StringProperty get_Remarks() {
			return remarks;
		}

}


//private Integer regNo, stdNo, year, age, phoneNo, leaveDays;
//private String name, course, dept, sex, date, time, leaveOptions, complaint, remarks;
//
//
//public Patient(int regNo, String name, Integer stdNo, Integer year, String course, String dept, String sex, Integer age, Integer phoneNo, String date, String time, String leaveOptions, Integer leaveDays, String complaint, String remarks) {
//
//	this.regNo = regNo;
//	this.stdNo = stdNo;
//	this.year = year;
//	this.age = age;
//	this.phoneNo = phoneNo;
//	this.leaveDays = leaveDays;
//	this.name = name;
//	this.course = course;
//	this.dept = dept;
//	this.sex = sex;
//	this.date = date;
//	this.time = time;
//	this.leaveOptions = leaveOptions;
//	this.complaint = complaint;
//	this.remarks = remarks;
//}
//
//
//public Integer getRegNo() {
//	return regNo;
//}
//
//
//public void setRegNo(Integer regNo) {
//	this.regNo = regNo;
//}
//
//
//public Integer getStdNo() {
//	return stdNo;
//}
//
//
//public void setStdNo(Integer stdNo) {
//	this.stdNo = stdNo;
//}
//
//
//public Integer getYear() {
//	return year;
//}
//
//
//public void setYear(Integer year) {
//	this.year = year;
//}
//
//
//public Integer getAge() {
//	return age;
//}
//
//
//public void setAge(Integer age) {
//	this.age = age;
//}
//
//
//public Integer getPhoneNo() {
//	return phoneNo;
//}
//
//
//public void setPhoneNo(Integer phoneNo) {
//	this.phoneNo = phoneNo;
//}
//
//
//public Integer getLeaveDays() {
//	return leaveDays;
//}
//
//
//public void setLeaveDays(Integer leaveDays) {
//	this.leaveDays = leaveDays;
//}
//
//
//public String getName() {
//	return name;
//}
//
//
//public void setName(String name) {
//	this.name = name;
//}
//
//
//public String getCourse() {
//	return course;
//}
//
//
//public void setCourse(String course) {
//	this.course = course;
//}
//
//
//public String getDept() {
//	return dept;
//}
//
//
//public void setDept(String dept) {
//	this.dept = dept;
//}
//
//
//public String getSex() {
//	return sex;
//}
//
//
//public void setSex(String sex) {
//	this.sex = sex;
//}
//
//
//public String getDate() {
//	return date;
//}
//
//
//public void setDate(String date) {
//	this.date = date;
//}
//
//
//public String getTime() {
//	return time;
//}
//
//
//public void setTime(String time) {
//	this.time = time;
//}
//
//
//public String getLeaveOptions() {
//	return leaveOptions;
//}
//
//
//public void setLeaveOptions(String leaveOptions) {
//	this.leaveOptions = leaveOptions;
//}
//
//
//public String getComplaint() {
//	return complaint;
//}
//
//
//public void setComplaint(String complaint) {
//	this.complaint = complaint;
//}
//
//
//public String getRemarks() {
//	return remarks;
//}
//
//
//public void setRemarks(String remarks) {
//	this.remarks = remarks;
//}
