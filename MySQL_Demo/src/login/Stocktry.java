package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Stocktry {

	public static void main(String[] args) {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");

			String sql = "UPDATE injection_list SET injection_quantity = (injection_quantity - ?) WHERE injection_name = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, 1);
			statement.setString(2,"DXM");

			statement.executeUpdate();
			
			System.out.println("Done");
			
			statement.close();
			connection.close();

		}

		catch (SQLException ae) {

			System.out.println("Error!!! Connection Failed");
			ae.printStackTrace();
			

		}

	}

}
