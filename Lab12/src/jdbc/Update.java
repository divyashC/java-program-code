package jdbc;

import java.sql.*;

public class Update {

	public static void main(String[] args) {
		
		String url1 = "jdbc:mysql://localhost:3306/familydb";
		String user = "root";
		String password = "root";

		try {

			Connection connection1 = DriverManager.getConnection(url1, user, password);
			
			//sql command to update table fields 
			String sql = "UPDATE relatives SET sl_no=?, first_name=?, last_name=?, relation=?";

			PreparedStatement statement = connection1.prepareStatement(sql);
			
			//passing new values to table fields
			statement.setInt(1, 01);
			statement.setString(2, "Divyash");
			statement.setString(3, "Chhetri");
			statement.setString(4, "Uncle");

			int rowsUpdated = statement.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("An existing relative was updated successfully!");
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
