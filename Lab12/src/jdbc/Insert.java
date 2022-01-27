package jdbc;

import java.sql.*;

public class Insert {

	public static void main(String[] args) {
		
		String url1 = "jdbc:mysql://localhost:3306/familydb";
		String user = "root";
		String password = "root";

		try {

			Connection connection1 = DriverManager.getConnection(url1, user, password);

			String sql = "INSERT INTO relatives (sl_no, first_name, last_name, relation) VALUES (?, ?, ?, ?)";

			PreparedStatement statement = connection1.prepareStatement(sql);

			statement.setInt(1, 01);
			statement.setString(2, "Sangay");
			statement.setString(3, "Dorji");
			statement.setString(4, "Father");

			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) {
				System.out.println("A new relative was inserted successfully!");
			}

			statement.close();
			connection1.close();

		} 

		catch (SQLException e) {
			System.out.println("Error!!! Connection Failed");
			e.printStackTrace();
		}
	}

}
