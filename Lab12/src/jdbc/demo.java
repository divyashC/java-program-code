package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo {

	public static void main (String[] args) {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/infirmary_management_system", "root", "root");
			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM patient_records;";
			ResultSet resultset = statement.executeQuery(sql);


			while (resultset.next()) {

				int a = resultset.getInt(1);
				String b = resultset.getString(2);
				int c = resultset.getInt(3);
				String d =  resultset.getString(4);
				int e = resultset.getInt(5);
				int f = resultset.getInt(6);
				String g = resultset.getString(7);
				String h = resultset.getString(8);
				int i = resultset.getInt(9);
				String j = resultset.getString(10);
				String k = resultset.getString(11);
				String l = resultset.getString(12);
				int m = resultset.getInt(13);
				String n = resultset.getString(14);
				String o = resultset.getString(15);
				
				String output = "%d, %s, %d, %s, %d, %d, %s, %s, %d, %s, %s, %s, %s, %s, %s";
				System.out.println(String.format(output, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o));

			}

		}
		
		catch (SQLException e) {
			System.out.println("Error!!! Connection Failed");
			e.printStackTrace();
		}
	
	}

}

