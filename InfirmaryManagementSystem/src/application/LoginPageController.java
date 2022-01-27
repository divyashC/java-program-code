package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.*;

public class LoginPageController {
	
	@FXML
	private Button loginButton;
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField passwordField;
	
	public void userLogin (ActionEvent event) throws IOException {
		checkLogin();
	}
	
	//gets Username and Password from database and matches with the credentials entered
	private void checkLogin() throws IOException {
		
		Main m = new Main();

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			Statement statement = connection.createStatement();

			String sql = "SELECT * from login_details where username='"+usernameTextField.getText().toString()+"' and password='"+passwordField.getText().toString()+"'";
			ResultSet resultset = statement.executeQuery(sql);

			if (resultset.next()) {
				
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Login Message");
				alert.setHeaderText(null);
				alert.setContentText("Welcome, You have successfully logged in!");
				alert.showAndWait();
				
				m.changeScene("HomePage.fxml");
			}

			else if (usernameTextField.getText().isEmpty() && passwordField.getText().isEmpty()) {
				
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Login Message");
				alert.setHeaderText(null);
				alert.setContentText("Please Enter Credentials!!");
				alert.showAndWait();

			}

			else {
				
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Login Message");
				alert.setHeaderText(null);
				alert.setContentText("Incorrect Credentials!!");
				alert.showAndWait();

			}

			resultset.close();
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
		
		
		
		//login without using database
		/* if (usernameTextField.getText().toString().equals("admin") && passwordField.getText().toString().equals("admin")) {
			messageLabel.setText("Login Successful!!");
			m.changeScene("HomePage.fxml");
		}

		else if (usernameTextField.getText().isEmpty() && passwordField.getText().isEmpty()) {
			messageLabel.setText("Please Enter Credentials!!");
		}

		else {
			messageLabel.setText("Incorrect Credentials!!");
		} */
		
	}
	
}
