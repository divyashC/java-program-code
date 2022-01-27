package application;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PatientDetailsEntryController implements Initializable {

	// Buttons

	@FXML
	private Button backButton;

	@FXML
	private Button saveButton;

	// Patient Details Entry Components

	@FXML
	public TextField nameTextField;

	@FXML
	private TextField studentNoTextField;

	@FXML
	private TextField regNoTextField;

	@FXML
	private RadioButton maleRadioButton;

	@FXML
	private RadioButton femaleRadioButton;

	@FXML
	private ToggleGroup gender;

	@FXML
	private TextField ageTextField;

	@FXML
	private TextField phoneNoTextField;

	@FXML
	private DatePicker DateSelector;

	@FXML
	private TextField timeTextField;

	@FXML
	private RadioButton amRadioButton;

	@FXML
	private RadioButton pmRadioButton;

	@FXML
	private ToggleGroup timeSelect;

	@FXML
	private TextArea complaintTextArea;

	@FXML
	private TextArea remarksTextArea;

	@FXML
	private TextField leaveDaysTextField;

	// ComboBox

	@FXML
	public ComboBox<String> yearComboBox;

	@FXML
	public ComboBox<String> courseComboBox;

	@FXML
	public ComboBox<String> departmentComboBox;

	@FXML
	public ComboBox<String> leaveOptionsComboBox;

	//Medicine
	@FXML
	public CheckBox medicineChecBox;

	@FXML
	public ComboBox<String> medicineComboBox;

	@FXML
	public TextField medicineQuantityTextField;

	@FXML
	public CheckBox injectionChecBox;

	@FXML
	public ComboBox<String> injectionComboBox;

	@FXML
	public TextField injectionQuantityTextField;

	// Error Labels
	@FXML
	private Label nameErrorMessage;

	@FXML
	private Label stdNoErrorMessage;

	@FXML
	private Label ageErrorMessage;

	@FXML
	private Label genderErrorMessage;

	@FXML
	private Label deptErrorMessage;

	@FXML
	private Label yearErrorMessage;

	@FXML
	private Label courseErrorMessage;

	@FXML
	private Label phoneNoErrorMessage;

	@FXML
	private Label complaintErrorMessage;

	@FXML
	private Label remarksErrorMessage;

	@FXML
	private Label leaveDaysErrorMessage;

	@FXML
	private Label leaveOptionsErrorMessage;

	public String sex, time, year, course, department, leaveOptions, ampm;
	public LocalDate date;
	public Integer lastRegNo;

	//combo box items in a array list
	ObservableList<String>  yearList = FXCollections.observableArrayList("1", "2", "3", "4", "5");
	ObservableList<String>  departmentList = FXCollections.observableArrayList("Civil Department", "Architecture Department", "Electrical Department", "IT Department", "ECE Department");
	ObservableList<String>  leaveOptionList = FXCollections.observableArrayList("No Leave", "Bed Rest", "Full Day Leave", "Half Day Leave", "Referred to PGH");
	ObservableList<String>  medicineList = FXCollections.observableArrayList();
	ObservableList<String>  injectionList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		departmentComboBox.setItems(departmentList);
		leaveOptionsComboBox.setItems(leaveOptionList);
		yearComboBox.setItems(yearList);
		medicineComboBox.setItems(medicineList);
		injectionComboBox.setItems(injectionList);
		
		//sets current data in date selector
		DateSelector.setValue(LocalDate.now());
		date = DateSelector.getValue();

		//sets current time in text field
		String pattern = "hh:mm";
		timeTextField.setText((LocalTime.now()).format(DateTimeFormatter.ofPattern(pattern)));
		
		//selects radio button depending on the time
		String ampmPattern = "hh: mm a";
		ampm = (LocalTime.now()).format(DateTimeFormatter.ofPattern(ampmPattern));
		ampm = ampm.substring(6, 7);

		if (ampm.equals("AM")) {
			amRadioButton.setSelected(true);
		} else {
			pmRadioButton.setSelected(true);
		}
		
		time = timeTextField.getText() + ampm;
			
		//calls a method go get last RegNo stored in the database
		getLastRegNo();
		
		//gets medicine names from database and saves it in the combo box
		try {

			Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			Statement statement1 = connection1.createStatement();

			String sql = "SELECT * FROM medicine_list;";
			ResultSet resultset1 = statement1.executeQuery(sql);

			while (resultset1.next()) {
				String medicineName = resultset1.getString("medicine_name");
				medicineComboBox.getItems().addAll(medicineName);
			}

			statement1.close();
			connection1.close();
			resultset1.close();

		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR fetching Medicine Name from Database!!");
			alert.showAndWait();

		}

		//gets injection names from database and saves it in the combo box
		try {

			Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			Statement statement2 = connection2.createStatement();

			String sql = "SELECT * FROM injection_list;";
			ResultSet resultset2 = statement2.executeQuery(sql);

			while (resultset2.next()) {
				String injectionName = resultset2.getString("injection_name");
				injectionComboBox.getItems().addAll(injectionName);
			}

			statement2.close();
			connection2.close();
			resultset2.close();

		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR fetching Injection Name from Database!!");
			alert.showAndWait();

		}

	}
	
	//gets selected department and displays courses according to it
	public void deptComboBoxSelected (ActionEvent event) throws IOException {

		department = departmentComboBox.getValue();

		if (department == "Civil Department") {
			ObservableList<String>  courseList = FXCollections.observableArrayList("ME in CM", "BE CE", "BE EG");
			courseComboBox.setItems(courseList);
			//			courseComboBox.getItems().addAll("ME in CM", "BE CE", "BE EG");
		}

		else if (department == "Architecture Department") {
			ObservableList<String>  courseList = FXCollections.observableArrayList("B Arch.");
			courseComboBox.setItems(courseList);
			//			courseComboBox.getItems().addAll("B Arch.");
		}

		else if (department == "Electrical Department") {
			ObservableList<String>  courseList = FXCollections.observableArrayList("ME in RE", "BE EE");
			courseComboBox.setItems(courseList);
			//			courseComboBox.getItems().addAll("ME in RE", "BE EE");
		}

		else if (department == "IT Department") {
			ObservableList<String>  courseList = FXCollections.observableArrayList("BE IT");
			courseComboBox.setItems(courseList);
			//			courseComboBox.getItems().addAll("BE IT");
		}

		else if (department == "ECE Department") {
			ObservableList<String>  courseList = FXCollections.observableArrayList("BE ECE", "BE ICE");
			courseComboBox.setItems(courseList);
			//			courseComboBox.getItems().addAll("BE ECE", "BE ICE");
		}


	}
	
	//gets selected combo box item
	public void comboChanged (ActionEvent event) throws IOException{

		year = yearComboBox.getValue();
		course = courseComboBox.getValue();
		leaveOptions = leaveOptionsComboBox.getValue();

		if (leaveOptions == "No Leave") {
			leaveDaysTextField.setText("0");
		}


	}

	public void homePage(ActionEvent event) throws IOException {

		Main m = new Main();
		m.changeScene("SelectPatientEntryPage.fxml");

	}

	public void sexRadioSelect (ActionEvent event) throws IOException {

		if (maleRadioButton.isSelected()) {
			sex = "Male";
		}

		else if (femaleRadioButton.isSelected()) {
			sex = "Female";
		}

	}

	public void timeRadioSelect (ActionEvent event) throws IOException {

		if (amRadioButton.isSelected()) {
			time = timeTextField.getText() + " AM";
		}

		else if (pmRadioButton.isSelected()) {
			time = timeTextField.getText() + " PM";
		}

	}
	
	//updates medicine quantity in database after prescribing it 
	public void medicinePrescribed(ActionEvent event) {

		String medicineName = medicineComboBox.getValue();

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

			String sql = "UPDATE medicine_list SET medicine_quantity = (medicine_quantity-?) WHERE medicine_name = ?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, Double.parseDouble(medicineQuantityTextField.getText()));
			statement.setString(2, medicineName);

			statement.executeUpdate();

			statement.close();
			connection.close();

		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Prescribing Medicine!!");
			alert.showAndWait();

		}

	}
	
	//updates injection quantity in database after prescribing it
	public void prescribeInjection(ActionEvent event) {

		String injectionName = injectionComboBox.getValue();

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

			String sql = "UPDATE injection_list SET injection_quantity = (injection_quantity-?) WHERE injection_name = ?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, Double.parseDouble(injectionQuantityTextField.getText()));
			statement.setString(2, injectionName);

			statement.executeUpdate();

			statement.close();
			connection.close();

		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Prescribing Injection!!");
			alert.showAndWait();

		}

	}

	public void saveDetails(ActionEvent event) throws IOException {
		
		//checks if feilds are empty
		try {
			if (year.isEmpty()|| course.isEmpty() || leaveOptions.isEmpty() || sex.isEmpty() || course.isEmpty() || department.isEmpty()) {
				throw new NullPointerException();
			}

		}
		
		catch (NullPointerException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please Fill-up all fields!!");
			alert.showAndWait();

		}
		
		boolean  allCorrect = checkAllValues();
		
		//saves data in database if all fields are filled
		if (allCorrect) {

			try {

				date = DateSelector.getValue();

				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

				String sql = "INSERT INTO patient_records (reg_no, name, student_no, sex, age, year, course, department, phone_no, date, time, leave_options, no_of_days, complaint, remarks) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setInt(1, Integer.parseInt(regNoTextField.getText()));
				statement.setString(2, nameTextField.getText());
				statement.setInt(3, Integer.parseInt(studentNoTextField.getText()));
				statement.setString(4, sex);
				statement.setInt(5, Integer.parseInt(ageTextField.getText()));
				statement.setInt(6, Integer.parseInt(year));
				statement.setString(7, course);
				statement.setString(8, department);
				statement.setInt(9, Integer.parseInt(phoneNoTextField.getText()));
				statement.setString(10, date.toString());
				statement.setString(11, time);
				statement.setString(12, leaveOptions);
				statement.setInt(13, Integer.parseInt(leaveDaysTextField.getText()));
				statement.setString(14, complaintTextArea.getText());
				statement.setString(15, remarksTextArea.getText());

				int rowsInserted = statement.executeUpdate();

				if (rowsInserted > 0) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Message");
					alert.setHeaderText(null);
					alert.setContentText("Saved Successfully!");
					alert.showAndWait();
				}

				Main m = new Main();
				m.changeScene("PatientDetailsEntry.fxml");

				statement.close();
				connection.close();

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
		}
	}
	
	//checks if all fields are filled correctly
	public boolean checkAllValues() {

		boolean checked = false;

		int correct = 0;

		if (nameTextField.getText().isBlank()) {
			nameErrorMessage.setVisible(true);
		} else {
			nameErrorMessage.setVisible(false);
			correct += 1;
		}

		if (studentNoTextField.getText().length() == 8) {
			stdNoErrorMessage.setVisible(false);
			correct += 1;	
		} else {
			stdNoErrorMessage.setVisible(true);
		}

		if (maleRadioButton.isSelected() || femaleRadioButton.isSelected()) {
			genderErrorMessage.setVisible(false);
			correct += 1;
		} else {
			genderErrorMessage.setVisible(true);
		}

		if (ageTextField.getText().isBlank()) {
			ageErrorMessage.setVisible(true);
		} else {
			ageErrorMessage.setVisible(false);
			correct += 1;
		}

		if (phoneNoTextField.getText().length() == 8) {
			phoneNoErrorMessage.setVisible(false);
			correct += 1;
		} else {
			phoneNoErrorMessage.setVisible(true);
		}

		if (complaintTextArea.getText().isBlank()) {
			complaintErrorMessage.setVisible(true);
		} else {
			complaintErrorMessage.setVisible(false);
			correct += 1;
		}

		if (remarksTextArea.getText().isBlank()) {
			remarksErrorMessage.setVisible(true);
		} else {
			remarksErrorMessage.setVisible(false);
			correct += 1;
		}

		if (leaveDaysTextField.getText().isBlank()) {
			leaveDaysErrorMessage.setVisible(true);
		} else {
			leaveDaysErrorMessage.setVisible(false);
			correct += 1;
		}

		if (year.isEmpty()) {
			yearErrorMessage.setVisible(true);
		} else {
			yearErrorMessage.setVisible(false);
			correct += 1;
		}

		if (course.isEmpty()) {
			courseErrorMessage.setVisible(true);
		} else {
			courseErrorMessage.setVisible(false);
			correct += 1;
		}

		if (department.isEmpty()) {
			deptErrorMessage.setVisible(true);
		} else {
			deptErrorMessage.setVisible(false);
			correct += 1;
		}

		if (leaveOptions.isEmpty()) {
			leaveOptionsErrorMessage.setVisible(true);
		} else {
			leaveOptionsErrorMessage.setVisible(false);
			correct += 1;
		}

		if (correct >= 12) {
			checked = true;
		}

		return checked;
	}

	//gets last regNo from database and increments it 
	public void getLastRegNo() {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

			String sql = "SELECT max(reg_no) from patient_records;";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(sql);

			if (resultset.next()) {
				lastRegNo = resultset.getInt(1);
				lastRegNo++;
				regNoTextField.setText(lastRegNo.toString());
			}

			else {
				regNoTextField.setText("100");
			}

			resultset.close();
			statement.close();
			connection.close();

		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Generating Reg Nos!!");
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