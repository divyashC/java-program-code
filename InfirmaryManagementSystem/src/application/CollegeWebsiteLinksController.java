package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class CollegeWebsiteLinksController {
	
	@FXML
	private Button HomePage;
	
	@FXML
	private Button Logout;
	
    @FXML
    private Hyperlink cstWebsite;

    @FXML
    private Hyperlink rubIMS;

    @FXML
    private Hyperlink mail;

    @FXML
    private Hyperlink vle;

    @FXML
    private Hyperlink library;

    @FXML
    private Hyperlink mrbs;

	//back to login page
	public void userLogout(ActionEvent event) throws IOException {
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to Logout?");
		if (alert.showAndWait().get() == ButtonType.OK){
			Main m = new Main();
			m.changeScene("LoginPage.fxml");
		}
		
	}
	
	public void HomePage(ActionEvent event) throws IOException { 
		
		Main m = new Main();
		m.changeScene("HomePage.fxml");
		
	}
	
	//calling openLinkInBrowser method and passing links as String
	public void cstWebsite(ActionEvent event) throws IOException { 	
		openLinkInBrowser("https://cst.edu.bt/index.php/en/");
	}
	
	public void rubIMS(ActionEvent event) throws IOException { 	
		openLinkInBrowser("https://ims.rub.edu.bt/");
	}
	
	public void mail(ActionEvent event) throws IOException { 	
		openLinkInBrowser("http://mail.rub.edu.bt/");
	}
	
	public void vle(ActionEvent event) throws IOException { 	
		openLinkInBrowser("https://vle.cst.edu.bt/");
	}
	
	public void library(ActionEvent event) throws IOException { 	
		openLinkInBrowser("https://lib.cst.edu.bt/");
	}
	
	public void mrbs(ActionEvent event) throws IOException { 	
		openLinkInBrowser("https://vle.cst.edu.bt/mrbs/web/day.php");
	}
	
	//mthod to open link in browser
	public void openLinkInBrowser(String str) throws IOException{
		try {
			Desktop.getDesktop().browse(new URL(str).toURI());
		}
		catch (URISyntaxException ae) {
			
			ae.printStackTrace();
			
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("ERROR Opening URL");
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
