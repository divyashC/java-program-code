package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class StaffPatient {

		private IntegerProperty regNo, age, phoneNo, leaveDays;
		private StringProperty name, dept, sex, date, time, leaveOptions, complaint, remarks;
		
		//default constuctor 
		public StaffPatient() {
			
			this.regNo = new SimpleIntegerProperty();
			this.name = new SimpleStringProperty();
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