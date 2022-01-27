package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDemo {
	public static void main(String[] args) {
		String url1 = "jdbc:mysql://localhost:3306/sampledb";
		String user = "root";
		String password = "root";

		try {
			Connection conn1 = DriverManager.getConnection(url1, user, password);
			if (conn1 != null) {
				System.out.println("Connected to the database mtdb");
			}
			conn1.close();
		} catch (SQLException e) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			e.printStackTrace();
		}
	}

}
