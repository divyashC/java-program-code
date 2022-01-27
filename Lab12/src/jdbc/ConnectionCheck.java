package jdbc;

import java.sql.*;

public class ConnectionCheck{

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/familydb";  // server url
		String user = "root";
		String password = "root";

		try {

			Connection connection1 = DriverManager.getConnection(url, user, password); //creating new connection
			
			if (connection1 != null) {
				System.out.println("Connected to FamilyDB"); //connection successful message
			}
			
			connection1.close();

		} 

		catch (SQLException e) {
			
			System.out.println("Error!!! Connection Failed");  // error message
			e.printStackTrace();
			
		}

	}

}
