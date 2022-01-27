package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo {

	public static void main(String[] args) {
		String url1 = "jdbc:mysql://localhost:3306/mtdb";
		String user = "root";
		String password = "root";

		try {
			Connection conn1 = DriverManager.getConnection(url1, user, password);
			String sql = "INSERT INTO std (id, firstname, lastname) VALUES (?, ?, ?)";
			PreparedStatement statement = conn1.prepareStatement(sql);
			statement.setString(1, "44");
			statement.setString(2, "Parshu");
			statement.setString(3, "Dhungyel");
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}
			statement.close();
			conn1.close();
		} catch (SQLException e) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			e.printStackTrace();
		}
	}

}
