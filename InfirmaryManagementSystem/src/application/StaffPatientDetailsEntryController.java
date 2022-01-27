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

public class StaffPatientDetailsEntryController implements Initializable {

	// Buttons

	@FXML
	private Button backButton;

	@FXML
	private Button saveButton;

	// Patient Details Entry Components

	@FXML
	public TextField nameTextField;

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
	private Label ageErrorMessage;

	@FXML
	private Label genderErrorMessage;

	@FXML
	private Label deptErrorMessage;

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

	public String sex, time, department, leaveOptions, ampm;
	public LocalDate date;
	public Integer lastRegNo;
	
	//creating array list for ComboBox
	ObservableList<String>  departmentList = FXCollections.observableArrayList("Management", "Administration", "Civil Department", "Architecture Department", "Electrical Department", "IT Department", "ECE Department", "S&H Department", "ICT", "Others");
	ObservableList<String>  leaveOptionList = FXCollections.observableArrayList("No Leave", "Bed Rest", "Full Day Leave", "Half Day Leave", "Referred to PGH");
	ObservableList<String>  medicineList = FXCollections.observableArrayList();
	ObservableList<String>  injectionList = FXCollections.observableArrayList();
	
	//method called while class is loaded
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		departmentComboBox.setItems(departmentList);
		leaveOptionsComboBox.setItems(leaveOptionList);
		medicineComboBox.setItems(medicineList);
		injectionComboBox.setItems(injectionList);
	
		//gets current date and fills up the text field
		DateSelector.setValue(LocalDate.now());
		date = DateSelector.getValue();
		
		//gets current time and fills up the text field
		String pattern = "hh:mm";
		timeTextField.setText((LocalTime.now()).format(DateTimeFormatter.ofPattern(pattern)));

		//gets am and pm and selects the radio button
		String ampmPattern = "hh: mm a";
		ampm = (LocalTime.now()).format(DateTimeFormatter.ofPattern(ampmPattern));
		ampm = ampm.substring(6, 7);

		if (ampm.equals("AM")) {
			amRadioButton.setSelected(true);
		} else {
			pmRadioButton.setSelected(true);
		}
		
		time = timeTextField.getText() + ampm;
		
		//calls method to automatically fill up regNo Text field by incrementing the last regNo in the database
		getLastRegNo();
		
		//fills up medicine Combo Box by selecting available medicines in the database
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
		
		//fills up injection Combo Box by selecting available injections in the database
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

	// stores the item selected in the combo box in a string  
	public void comboChanged (ActionEvent event) throws IOException{
		
		department = departmentComboBox.getValue();
		leaveOptions = leaveOptionsComboBox.getValue();

		if (leaveOptions == "No Leave") {
			leaveDaysTextField.setText("0");
		}

	}

	public void homePage(ActionEvent event) throws IOException {

		Main m = new Main();
		m.changeScene("SelectPatientEntryPage.fxml");

	}
	
	//gets selected radio button
	public void sexRadioSelect (ActionEvent event) throws IOException {

		if (maleRadioButton.isSelected()) {
			sex = "Male";
		}

		else if (femaleRadioButton.isSelected()) {
			sex = "Female";
		}

	}
	
	//gets selected radio button
	public void timeRadioSelect (ActionEvent event) throws IOException {

		if (amRadioButton.isSelected()) {
			time = timeTextField.getText() + " AM";
		}

		else if (pmRadioButton.isSelected()) {
			time = timeTextField.getText() + " PM";
		}

	}
	
	//updates medicine quantity column in database by subtracting the quantity prescribed
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

	//updates injection quantity column in database by subtracting the quantity prescribed
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
	
	//saves details entered in the database
	public void saveDetails(ActionEvent event) throws IOException {

		boolean  allCorrect = checkAllStaffValues();

		if (allCorrect) {

			try {

				date = DateSelector.getValue();

				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

				String sql = "INSERT INTO patient_records_staffs (reg_no, name, sex, age, department, phone_no, date, time, leave_options, no_of_days, complaint, remarks) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setInt(1, Integer.parseInt(regNoTextField.getText()));
				statement.setString(2, nameTextField.getText());
				statement.setString(3, sex);
				statement.setInt(4, Integer.parseInt(ageTextField.getText()));
				statement.setString(5, department);
				statement.setInt(6, Integer.parseInt(phoneNoTextField.getText()));
				statement.setString(7, date.toString());
				statement.setString(8, time);
				statement.setString(9, leaveOptions);
				statement.setInt(10, Integer.parseInt(leaveDaysTextField.getText()));
				statement.setString(11, complaintTextArea.getText());
				statement.setString(12, remarksTextArea.getText());

				int rowsInserted = statement.executeUpdate();

				if (rowsInserted > 0) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Message");
					alert.setHeaderText(null);
					alert.setContentText("Saved Successfully!");
					alert.showAndWait();
				}

				Main m = new Main();
				m.changeScene("StaffPatientDetailsEntry.fxml");

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
	
	// checks if all feilds are filled up
	public boolean checkAllStaffValues() {

		boolean checked = false;

		int correct = 0;

		if (nameTextField.getText().isBlank()) {
			nameErrorMessage.setVisible(true);
		} else {
			nameErrorMessage.setVisible(false);
			correct += 1;
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

		if (correct >= 9) {
			checked = true;
		}

		return checked;
	}

	//gets last regNo from database and increments it to be filled up in the text field
	public void getLastRegNo() {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

			String sql = "SELECT max(reg_no) from patient_records_staffs;";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(sql);

			if (resultset.next()) {
				lastRegNo = resultset.getInt(1);
				lastRegNo++;
				regNoTextField.setText(lastRegNo.toString());
			}

			else {
				regNoTextField.setText("200");
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