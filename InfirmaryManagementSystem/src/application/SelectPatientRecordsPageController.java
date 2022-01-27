package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class SelectPatientRecordsPageController {
	
	@FXML
	private Button StaffButton;
	
	@FXML 
	private Button StudentsButton;
	
	@FXML 
	private Button OthersButton;
	
	@FXML 
	private Button BackButton;
	
	
	public void userBack(ActionEvent event) throws IOException {
		
		Main m = new Main();
		m.changeScene("HomePage.fxml");
		
	}
	
	public void staffRecords(ActionEvent event) throws IOException {
		
		Main m = new Main();
		m.showPatientRecords("StaffPatientRecords.fxml");
		
	}
	
	public void studentRecords(ActionEvent event) throws IOException {
			
		Main m = new Main();
		m.showPatientRecords("PatientRecords.fxml");
		
	}

	public void OthersRecords(ActionEvent event) throws IOException {
	
		Main m = new Main();
		m.showPatientRecords("OtherPatientRecords.fxml");
	
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
