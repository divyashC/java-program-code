package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MedicineRecordsController {

	
	@FXML
	private TextField medicineNameTextField;

	@FXML
	private DatePicker medicineExpiryDateSelector;

	@FXML
	private TextField medicineQuantityTextField;

	@FXML
	private Button medicineSaveButton;

	@FXML
	private TextField injectionNameTextField;

	@FXML
	private DatePicker injectionExpiryDateSelector;

	@FXML
	private TextField injectionQuantityTextField;

	@FXML
	private Button injectionSaveButton;

	//Importing table and columns
	@FXML
	private TableView<Medicine> medicineTable;

	@FXML
	private TableColumn<Medicine, String> col_medicineName;

	@FXML
	private TableColumn<Medicine, Double> col_medicineQuantity;

	@FXML
	private TableColumn<Medicine, String> col_medicineExpiryDate;

	@FXML
	private TableView<Injection> injectionTable;

	@FXML
	private TableColumn<Injection, String> col_injectionName;

	@FXML
	private TableColumn<Injection, Double> col_injectionQuantity;

	@FXML
	private TableColumn<Injection, String> col_injectionExpiryDate;

	@FXML
	private Button backButton;

	@FXML
	private Button medicineUpdateStockButton;
	
	@FXML
	private Button deleteMedicine;

	@FXML
	private Button injectionUpdateStockButton;
	
	@FXML
	private Button deleteInjection;

	LocalDate medicine_expiryDate, injection_expiryDate;

	public void backToHomePage(ActionEvent event) throws IOException{

		Main m = new Main();
		m.changeScene("HomePage.fxml");

	}

	public void showMedicineDate(ActionEvent event) throws IOException {

		medicine_expiryDate = medicineExpiryDateSelector.getValue();

	}

	public void showInjectionDate(ActionEvent event) throws IOException {

		injection_expiryDate = injectionExpiryDateSelector.getValue();

	}

	//save new medicine to the database 
	public void saveMedicine(ActionEvent event) throws IOException{

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

			String sql = "INSERT INTO medicine_list (medicine_name, medicine_quantity, medicine_expiry_date) VALUES (?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, medicineNameTextField.getText());
			statement.setDouble(2, Double.parseDouble(medicineQuantityTextField.getText()));
			statement.setString(3, medicine_expiryDate.toString());

			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Message");
				alert.setHeaderText(null);
				alert.setContentText("Saved Successfully!");
				alert.showAndWait();
			}

			Main m = new Main();
			m.changeScene("MedicineRecords.fxml");

			statement.close();
			connection.close();

		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Saving Medicine!!");
			alert.showAndWait();

		}

	}
		
	//update medicine stock 
	public void updateMedicine(ActionEvent event) throws IOException {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

			String sql = "UPDATE medicine_list SET medicine_quantity=medicine_quantity+?, medicine_expiry_date=? WHERE medicine_name=?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, Double.parseDouble(medicineQuantityTextField.getText()));
			statement.setString(2, medicine_expiryDate.toString());
			statement.setString(3, medicineNameTextField.getText());


			int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Message");
				alert.setHeaderText(null);
				alert.setContentText("Saved Successfully!");
				alert.showAndWait();
			}

			Main m = new Main();
			m.changeScene("MedicineRecords.fxml");

			statement.close();
			connection.close();

		}
		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Updating Stock!!");
			alert.showAndWait();

		}

	}
		
	//delete medicine records
	public void deleteMedicine(ActionEvent event) throws IOException{
		
		try {
			
			Medicine selectedRow = medicineTable.getSelectionModel().getSelectedItem();	
			String medicineName = selectedRow.getMedicineName();
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			
			String sql = "DELETE FROM medicine_list WHERE medicine_name = ?;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, medicineName);
			statement.execute();
			
			new Main().changeScene("MedicineRecords.fxml");
			
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
	}

	//save new injection
	public void saveInjection(ActionEvent event) throws IOException{

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

			String sql = "INSERT INTO injection_list (injection_name, injection_quantity, injection_expiry_date) VALUES (?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, injectionNameTextField.getText());
			statement.setDouble(2, Double.parseDouble(injectionQuantityTextField.getText()));
			statement.setString(3, injection_expiryDate.toString());

			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Message");
				alert.setHeaderText(null);
				alert.setContentText("Saved Successfully!");
				alert.showAndWait();
			}

			Main m = new Main();
			m.changeScene("MedicineRecords.fxml");

			statement.close();
			connection.close();

		}
		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Saving Injection!!");
			alert.showAndWait();

		}

	}

	//update injection info
	public void updateInjection(ActionEvent event) throws IOException {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

			String sql = "UPDATE injection_list SET injection_quantity=injection_quantity+?, injection_expiry_date=? WHERE injection_name=?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, Double.parseDouble(injectionQuantityTextField.getText()));
			statement.setString(2, injection_expiryDate.toString());
			statement.setString(3, injectionNameTextField.getText());

			int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Message");
				alert.setHeaderText(null);
				alert.setContentText("Saved Successfully!");
				alert.showAndWait();
			}

			Main m = new Main();
			m.changeScene("MedicineRecords.fxml");

			statement.close();
			connection.close();

		}
		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Updating Stock!!");
			alert.showAndWait();

		}
	}
	
	//delete Injection reocrds in database
	public void deleteInjection(ActionEvent event) throws IOException{
		
		try {
			
			Injection selectedRow = injectionTable.getSelectionModel().getSelectedItem();	
			String injectionName = selectedRow.getInjectionName();
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			
			String sql = "DELETE FROM injection_list WHERE injection_name = ?;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, injectionName);
			statement.execute();
			
			new Main().changeScene("MedicineRecords.fxml");
			
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
	}
	
	
	@FXML
	public void initialize() throws Exception {
		
		//get column info
		
		col_medicineName.setCellValueFactory(cellData -> cellData.getValue().get_MedicineName());
		col_medicineQuantity.setCellValueFactory(cellData -> cellData.getValue().get_MedicineQuantity().asObject());
		col_medicineExpiryDate.setCellValueFactory(cellData -> cellData.getValue().get_MedicineExpiryDate());

		col_injectionName.setCellValueFactory(cellData -> cellData.getValue().get_InjectionName());
		col_injectionQuantity.setCellValueFactory(cellData -> cellData.getValue().get_InjectionQuantity().asObject());
		col_injectionExpiryDate.setCellValueFactory(cellData -> cellData.getValue().get_InjectionExpiryDate());

		ObservableList<Medicine> medicineList = getMedicineRecords();
		populateMedicineTable(medicineList);

		ObservableList<Injection> injectionList = getInjectionRecords();
		populateInjectionTable(injectionList);

	}
	
	//set items in medicine table
	public void populateMedicineTable (ObservableList<Medicine> medicineList) {
		medicineTable.setItems(medicineList);
	}
	
	//get medicine records from database
	public static ObservableList<Medicine> getMedicineRecords() {

		ObservableList<Medicine> medicineList = FXCollections.observableArrayList();

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM medicine_list;";
			ResultSet resultset1 = statement.executeQuery(sql);

			medicineList = getMedicineObject(resultset1);

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

		return medicineList;

	}

	public static ObservableList<Medicine> getMedicineObject(ResultSet resultset1) {

		ObservableList<Medicine> medicineRecordList = FXCollections.observableArrayList();

		try {

			while (resultset1.next()) {

				Medicine obj = new Medicine();
				obj.setMedicineName(resultset1.getString("medicine_name"));
				obj.setMedicineQuantity(resultset1.getDouble("medicine_quantity"));
				obj.setMedicineExpiryDate(resultset1.getString("medicine_expiry_date"));

				medicineRecordList.add(obj);

			}

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
		return medicineRecordList;

	}
	
	//add items to injection table
	public void populateInjectionTable (ObservableList<Injection> injectionList) {
		injectionTable.setItems(injectionList);
	}
	
	//get injection records from database
	public static ObservableList<Injection> getInjectionRecords() {

		ObservableList<Injection> injectionList = FXCollections.observableArrayList();

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM injection_list;";
			ResultSet resultset2 = statement.executeQuery(sql);

			injectionList = getInjectionObject(resultset2);

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

		return injectionList;

	}

	public static ObservableList<Injection> getInjectionObject(ResultSet resultset2) {

		ObservableList<Injection> injectionRecordList = FXCollections.observableArrayList();

		try {

			while (resultset2.next()) {

				Injection obj = new Injection();
				obj.setInjectionName(resultset2.getString("injection_name"));
				obj.setInjectionQuantity(resultset2.getDouble("injection_quantity"));
				obj.setInjectionExpiryDate(resultset2.getString("injection_expiry_date"));

				injectionRecordList.add(obj);

			}

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
		return injectionRecordList;

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