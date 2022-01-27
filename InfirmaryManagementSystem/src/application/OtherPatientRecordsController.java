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

public class OtherPatientRecordsController {
	
	//table columns and table 
	@FXML 
	public TableView<OtherPatient> recordsTable;
	@FXML
	public TableColumn<OtherPatient, Integer> col_regNo;
	@FXML
	public TableColumn<OtherPatient, String> col_name;
	@FXML
	public TableColumn<OtherPatient, String> col_sex; 
	@FXML
	public TableColumn<OtherPatient, Integer> col_age; 
	@FXML
	public TableColumn<OtherPatient, Integer> col_phoneNo; 
	@FXML
	public TableColumn<OtherPatient, String> col_date;
	@FXML
	public TableColumn<OtherPatient, String> col_time;
	@FXML
	public TableColumn<OtherPatient, String> col_complaint;
	@FXML
	public TableColumn<OtherPatient, String> col_remarks;

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
		
	//show filtered data
	public void filterTable(ActionEvent event) throws IOException {
		
		col_regNo.setCellValueFactory(cellData -> cellData.getValue().get_RegNo().asObject());
		col_name.setCellValueFactory(cellData -> cellData.getValue().get_Name());
		col_sex.setCellValueFactory(cellData -> cellData.getValue().get_Sex());
		col_age.setCellValueFactory(cellData -> cellData.getValue().get_Age().asObject());
		col_phoneNo.setCellValueFactory(cellData -> cellData.getValue().get_PhoneNo().asObject());
		col_date.setCellValueFactory(cellData -> cellData.getValue().get_Date());
		col_time.setCellValueFactory(cellData -> cellData.getValue().get_Time());
		col_complaint.setCellValueFactory(cellData -> cellData.getValue().get_Complaint());
		col_remarks.setCellValueFactory(cellData -> cellData.getValue().get_Remarks());
		
		ObservableList<OtherPatient> patientList = searchPatient(filterByTextField.getText());
		populateTable(patientList);	

	}
	
	//search patient form database
	public static ObservableList<OtherPatient> searchPatient(String str) {
		
		ObservableList<OtherPatient> patientList = FXCollections.observableArrayList();

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM patient_records_others WHERE '" + str + "' IN (reg_no, name, sex, age, phone_no, date, time, complaint, remarks);";
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

	@FXML
	public void initialize() throws Exception {
		
		filterByTextField.setText(null);
		
		//get column data 
		col_regNo.setCellValueFactory(cellData -> cellData.getValue().get_RegNo().asObject());
		col_name.setCellValueFactory(cellData -> cellData.getValue().get_Name());
		col_sex.setCellValueFactory(cellData -> cellData.getValue().get_Sex());
		col_age.setCellValueFactory(cellData -> cellData.getValue().get_Age().asObject());
		col_phoneNo.setCellValueFactory(cellData -> cellData.getValue().get_PhoneNo().asObject());
		col_date.setCellValueFactory(cellData -> cellData.getValue().get_Date());
		col_time.setCellValueFactory(cellData -> cellData.getValue().get_Time());
		col_complaint.setCellValueFactory(cellData -> cellData.getValue().get_Complaint());
		col_remarks.setCellValueFactory(cellData -> cellData.getValue().get_Remarks());
		
		ObservableList<OtherPatient> patientList = getPatientRecords();
		populateTable(patientList);

	}
	
	//add items to table
	public void populateTable (ObservableList<OtherPatient> patientList) {
		recordsTable.setItems(patientList);
	}
	
	//get patient records from database
	public static ObservableList<OtherPatient> getPatientRecords() {

		ObservableList<OtherPatient> patientList = FXCollections.observableArrayList();

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM patient_records_others;";
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

	public static ObservableList<OtherPatient> getPatientObject(ResultSet resultset) {

		ObservableList<OtherPatient> patientRecordList = FXCollections.observableArrayList();

		try {
			
			int count = 0;
			
			while (resultset.next()) {
				
				count++;
				
				OtherPatient obj = new OtherPatient();

				obj.setRegNo(resultset.getInt("reg_no"));
				obj.setName(resultset.getString("name"));
				obj.setSex(resultset.getString("sex"));
				obj.setAge(resultset.getInt("age"));
				obj.setPhoneNo(resultset.getInt("phone_no"));
				obj.setDate(resultset.getString("date"));
				obj.setTime(resultset.getString("time"));
				obj.setComplaint(resultset.getString("complaint"));
				obj.setRemarks(resultset.getString("remarks"));

				patientRecordList.add(obj);

			}
			
			if (count==0) {
				
				new Main().changeScene("OtherPatientRecords.fxml");
				
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
		
	//delete selected row from database 
	public void deleteRow(ActionEvent event) throws IOException, NullPointerException{
		
		OtherPatient selectedRow = null;
		int regNoValue;
		
		try {
			
			selectedRow = recordsTable.getSelectionModel().getSelectedItem();	
			regNoValue = selectedRow.getRegNo();
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			
			String sql = "DELETE FROM patient_records_others WHERE reg_no = ?;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, regNoValue);
			statement.execute();
			
			new Main().changeScene("OtherPatientRecords.fxml");
			
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