package jdbc;

import java.sql.*;

public class Create {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/family_db"; //server url
		String user = "root";
		String password = "root";

		try {

			Connection connection = DriverManager.getConnection(url, user, password);

			//sql command to create new table
			String sql = "CREATE TABLE relatives (sl_no int(2) NOT NULL, first_name VARCHAR(15) NOT NULL, last_name VARCHAR(15) NOT NULL, relation VARCHAR(20) NOT NULL, PRIMARY KEY (sl_no));";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//receives update
			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) {
				System.out.println("A new 'relatives' table has been created");
			}

			statement.close();
			connection.close();

		} 

		catch (SQLException e) {
			
			System.out.println("Error!!! Could not create table"); //error message
			e.printStackTrace();
			
		}

	}

}
