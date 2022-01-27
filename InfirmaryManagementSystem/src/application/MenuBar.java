package application;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class MenuBar {

	Main m = new Main();

	//Menu 1 - File

	//Menu Item 1.1
	public void HomePage() {

		m.changeScene("HomePage.fxml");

	}

	//Menu Item 1.2
	public void LogOut() {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to Logout?");
		if (alert.showAndWait().get() == ButtonType.OK){
			m.changeScene("LoginPage.fxml");
		}

	}

	//Menu Item 1.3
	public void Exit() {

        System.exit(0);

	}

	//Menu 2 - View

	//Menu Item 2.1
	public void NewPatientEntry() {

		m.changeScene("SelectPatientEntryPage.fxml");

	}

	//Menu Item 2.2
	public void ShowPatientRecord() {

		m.showPatientRecords("SelectPatientRecordsPage.fxml");

	}

	//Menu Item 2.3
	public void MedicineRecords() {

		m.changeScene("MedicineRecords.fxml");

	}

	//Menu 3  - Help

	//Menu Item 3.1
	public void CollegeWebsiteLinks() {

		m.changeScene("CollegeWebsiteLinks.fxml");
		
	}

	//Menu Item 3.2
	public void About() {
		
		m.changeScene("About.fxml");
	}
	


}
