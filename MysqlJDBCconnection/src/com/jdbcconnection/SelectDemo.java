package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String url1 = "jdbc:mysql://localhost:3306/mtdb";
		// String url1 = "jdbc:mysql://localhost:3306/sampledb";
		String user = "root";
		String password = "root";

		try {
			Connection conn1 = DriverManager.getConnection(url1, user, password);
			String sql = "SELECT * FROM std";

			Statement statement = conn1.createStatement();
			ResultSet result = statement.executeQuery(sql);

			int count = 0;

			while (result.next()) {
				String name = result.getString(2);
				String pass = result.getString(3);
				String ID = result.getString("id");
				String FirstName = result.getString("firstname");
				String lastName = result.getString("lastname");
				String output = "Students: #%d: %s - %s ";
				System.out.println(String.format(output, ++count, ID, FirstName, lastName));
			}
			statement.close();
			conn1.close();
		} catch (SQLException e) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			e.printStackTrace();
		}
	}

}
