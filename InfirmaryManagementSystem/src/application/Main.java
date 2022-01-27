package application;
	
import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;


public class Main extends Application {
	
	private static Stage stage;
	
	//method to open Stage
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			stage = primaryStage;
			primaryStage.setResizable(false);
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
			primaryStage.setTitle("Infirmary Management System");
			Scene scene = new Scene(root,800,600);
			primaryStage.getIcons().add( new Image("LogoIcon.png"));
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to change between different fxm files
	public void changeScene(String fxml) {
		
		try {
			//making other fmxl files non resizable and displaying it in the centre of the screen
			stage.setResizable(false);
			stage.setHeight(637.5999755859375);
			stage.setWidth(814.4000244140625);
			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
			stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
		    stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
			Parent pane = FXMLLoader.load(getClass().getResource(fxml));
			stage.getScene().setRoot(pane);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//method to open fxml files that contains tables to show records
	public void showPatientRecords(String fxml) {
		
		try {
			Parent pane = FXMLLoader.load(getClass().getResource(fxml));
			stage.getScene().setRoot(pane);
			stage.setResizable(true);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//main method
	public static void main(String[] args) {
		launch(args);
	}
}
