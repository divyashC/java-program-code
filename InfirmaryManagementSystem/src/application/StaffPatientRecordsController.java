package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StaffPatientRecordsController {
	
	//Importing Table and Table Columns
	
	@FXML 
	public TableView<StaffPatient> recordsTable;
	@FXML
	public TableColumn<StaffPatient, Integer> col_regNo;
	@FXML
	public TableColumn<StaffPatient, String> col_name;
	@FXML
	public TableColumn<StaffPatient, String> col_dept;
	@FXML
	public TableColumn<StaffPatient, String> col_sex; 
	@FXML
	public TableColumn<StaffPatient, Integer> col_age; 
	@FXML
	public TableColumn<StaffPatient, Integer> col_phoneNo; 
	@FXML
	public TableColumn<StaffPatient, String> col_date;
	@FXML
	public TableColumn<StaffPatient, String> col_time;
	@FXML
	public TableColumn<StaffPatient, String> col_leaveOptions; 
	@FXML
	public TableColumn<StaffPatient, Integer> col_leaveDays; 
	@FXML
	public TableColumn<StaffPatient, String> col_complaint;
	@FXML
	public TableColumn<StaffPatient, String> col_remarks;

	@FXML
	private Button backButton;

	@FXML 
	private Button logoutButton;
	
	@FXML
	private TextField filterByTextField;
	
	@FXML 
	private Button searchButton;
	
	@FXML 
	private Button refreshButton;
	
	@FXML 
	private Button deleteButton;
	
	public void backToHomePage(ActionEvent event) throws IOException {

		Main m = new Main();
		m.changeScene("SelectPatientRecordsPage.fxml");

	}

	public void logout(ActionEvent event) throws IOException {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to Logout?");
		if (alert.showAndWait().get() == ButtonType.OK){
			Main m = new Main();
			m.changeScene("LoginPage.fxml");
		}
	}
	
	//method to display filtered data
	public void filterTable(ActionEvent event) throws IOException {
		
		col_regNo.setCellValueFactory(cellData -> cellData.getValue().get_RegNo().asObject());
		col_name.setCellValueFactory(cellData -> cellData.getValue().get_Name());
		col_sex.setCellValueFactory(cellData -> cellData.getValue().get_Sex());
		col_age.setCellValueFactory(cellData -> cellData.getValue().get_Age().asObject());
		col_dept.setCellValueFactory(cellData -> cellData.getValue().get_Dept());
		col_phoneNo.setCellValueFactory(cellData -> cellData.getValue().get_PhoneNo().asObject());
		col_date.setCellValueFactory(cellData -> cellData.getValue().get_Date());
		col_time.setCellValueFactory(cellData -> cellData.getValue().get_Time());
		col_leaveOptions.setCellValueFactory(cellData -> cellData.getValue().get_leaveOptions());
		col_leaveDays.setCellValueFactory(cellData -> cellData.getValue().get_LeaveDays().asObject());
		col_complaint.setCellValueFactory(cellData -> cellData.getValue().get_Complaint());
		col_remarks.setCellValueFactory(cellData -> cellData.getValue().get_Remarks());
		
		//calling search method by passing the string entered in the text field
		ObservableList<StaffPatient> patientList = searchPatient(filterByTextField.getText());
		populateTable(patientList);	

	}
	
	//search passed string in any column of database
	public static ObservableList<StaffPatient> searchPatient(String str) {
		
		ObservableList<StaffPatient> patientList = FXCollections.observableArrayList();

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM patient_records_staffs WHERE '" + str + "' IN (reg_no, name, sex, age, department, phone_no, date, time, leave_options, no_of_days, complaint, remarks);";
			ResultSet resultset = statement.executeQuery(sql);

			patientList = getPatientObject(resultset);
			
		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Searching for '" + str + "' in the Database!!!");
			alert.showAndWait();

		}

		return patientList;
		
	}

	//method called to add data in columns while class is loaded
	@FXML
	public void initialize() throws Exception {
		
		filterByTextField.setText(null);
		
		col_regNo.setCellValueFactory(cellData -> cellData.getValue().get_RegNo().asObject());
		col_name.setCellValueFactory(cellData -> cellData.getValue().get_Name());
		col_sex.setCellValueFactory(cellData -> cellData.getValue().get_Sex());
		col_age.setCellValueFactory(cellData -> cellData.getValue().get_Age().asObject());
		col_dept.setCellValueFactory(cellData -> cellData.getValue().get_Dept());
		col_phoneNo.setCellValueFactory(cellData -> cellData.getValue().get_PhoneNo().asObject());
		col_date.setCellValueFactory(cellData -> cellData.getValue().get_Date());
		col_time.setCellValueFactory(cellData -> cellData.getValue().get_Time());
		col_leaveOptions.setCellValueFactory(cellData -> cellData.getValue().get_leaveOptions());
		col_leaveDays.setCellValueFactory(cellData -> cellData.getValue().get_LeaveDays().asObject());
		col_complaint.setCellValueFactory(cellData -> cellData.getValue().get_Complaint());
		col_remarks.setCellValueFactory(cellData -> cellData.getValue().get_Remarks());
		
		ObservableList<StaffPatient> patientList = getPatientRecords();
		populateTable(patientList);

	}
	
	//method to add all items to table
	public void populateTable (ObservableList<StaffPatient> patientList) {
		recordsTable.setItems(patientList);
	}

	//get table data from database
	public static ObservableList<StaffPatient> getPatientRecords() {

		ObservableList<StaffPatient> patientList = FXCollections.observableArrayList();

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM patient_records_staffs;";
			ResultSet resultset = statement.executeQuery(sql);

			patientList = getPatientObject(resultset);

		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Connecting to MySQL Database!!");
			alert.showAndWait();

		}

		return patientList;

	}

	//assign data to columns
	public static ObservableList<StaffPatient> getPatientObject(ResultSet resultset) {

		ObservableList<StaffPatient> patientRecordList = FXCollections.observableArrayList();

		try {
			
			int count = 0;
			
			while (resultset.next()) {
				
				count++;
				
				StaffPatient obj = new StaffPatient();

				obj.setRegNo(resultset.getInt("reg_no"));
				obj.setName(resultset.getString("name"));
				obj.setSex(resultset.getString("sex"));
				obj.setAge(resultset.getInt("age"));
				obj.setDept(resultset.getString("department"));
				obj.setPhoneNo(resultset.getInt("phone_no"));
				obj.setDate(resultset.getString("date"));
				obj.setTime(resultset.getString("time"));
				obj.setLeaveOptions(resultset.getString("leave_options"));
				obj.setLeaveDays(resultset.getInt("no_of_days"));
				obj.setComplaint(resultset.getString("complaint"));
				obj.setRemarks(resultset.getString("remarks"));

				patientRecordList.add(obj);

			}
			
			if (count==0) {
				
				new Main().changeScene("StaffPatientRecords.fxml");
				
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("No Data in MySQL Database!!");
				alert.showAndWait();
			}

		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Retriving Data from MySQL Database!!");
			alert.showAndWait();

		}
		return patientRecordList;

	}
	
	//method to delete selected row from database and table view
	public void deleteRow(ActionEvent event) throws IOException, NullPointerException{
		
		StaffPatient selectedRow = null;
		int regNoValue;
		
		try {
			
			selectedRow = recordsTable.getSelectionModel().getSelectedItem();	
			regNoValue = selectedRow.getRegNo();
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			
			String sql = "DELETE FROM patient_records_staffs WHERE reg_no = ?;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, regNoValue);
			statement.execute();
			
			new Main().changeScene("StaffPatientRecords.fxml");
			
		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Deleting Selected Row!!");
			alert.showAndWait();

		}
		
		catch (NullPointerException ae) {

			System.out.println("Error!!! Retriving Reg_No");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR!!! Please Select a  Row!!");
			alert.showAndWait();

		}

	}

	//MenuBar

	//Menu 1 - File

	//Menu Item 1.1
	public void HomePageMenuItem(ActionEvent event) {
		MenuBar obj = new MenuBar();
		obj.HomePage();
	}

	//Menu Item 1.2
	public void LogOutMenuItem(ActionEvent event) {
		MenuBar obj = new MenuBar();
		obj.LogOut();
	}

	//Menu Item 1.3
	public void ExitMenuItem(ActionEvent event) {
		MenuBar obj = new MenuBar();
		obj.Exit();
	}

	//Menu 2 - View

	//Menu Item 2.1
	public void NewPatientEntryMenuItem(ActionEvent event) {
		MenuBar obj = new MenuBar();
		obj.NewPatientEntry();
	}

	//Menu Item 2.2
	public void ShowPatientRecordMenuItem(ActionEvent event) {
		MenuBar obj = new MenuBar();
		obj.ShowPatientRecord();
	}

	//Menu Item 2.3
	public void MedicineRecordsMenuItem(ActionEvent event) {
		MenuBar obj = new MenuBar();
		obj.MedicineRecords();
	}

	//Menu 3  - Help

	//Menu Item 3.1
	public void CollegeWebsiteLinksMenuItem(ActionEvent event) {
		MenuBar obj = new MenuBar();
		obj.CollegeWebsiteLinks();
	}

	//Menu Item 3.2
	public void AboutMenuItem(ActionEvent event) {
		MenuBar obj = new MenuBar();
		obj.About();
	}

}