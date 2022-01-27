package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo {

	public static void main(String[] args) {
		String url1 = "jdbc:mysql://localhost:3306/mtdb";
		String user = "root";
		String password = "root";
		try {
			Connection conn1 = DriverManager.getConnection(url1, user, password);
			String sql = "UPDATE std SET id=?, firstname=?, lastname=? WHERE id=?";

			PreparedStatement statement = conn1.prepareStatement(sql);
			statement.setString(1, "1");
			statement.setString(2, "Dorji");
			statement.setString(3, "Wangchuk");
			statement.setString(4, "1");
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}
			statement.close();
			conn1.close();
		} catch (SQLException e) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			e.printStackTrace();
		}

	}

}
