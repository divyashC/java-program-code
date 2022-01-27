package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDemo {

	public static void main(String[] args) {
		String url1 = "jdbc:mysql://localhost:3306/mtdb";
		String user = "root";
		String password = "root";
		try {
			Connection conn1 = DriverManager.getConnection(url1, user, password);
			String sql = "DELETE FROM std WHERE firstname=?";
			PreparedStatement statement = conn1.prepareStatement(sql);
			statement.setString(1, "Parshu");

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}
			statement.close();
			conn1.close();
		} catch (SQLException e) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			e.printStackTrace();
		}
	}

}
