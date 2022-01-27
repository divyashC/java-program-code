package jdbc;

import java.sql.*;

public class Display {

	public static void main(String[] args) {
		
		String url1 = "jdbc:mysql://localhost:3306/familydb";
		String user = "root";
		String password = "root";

		try {
			
			Connection connection1 = DriverManager.getConnection(url1, user, password);
			
			String sql = "SELECT * FROM relatives";

			Statement statement = connection1.createStatement();
			
			ResultSet check = statement.executeQuery(sql);
			
			//checking whether the table is empty or not
			boolean empty = true;
			while (check.next()) {
				empty = false;
			}
			
			//executes this block of code to print header if table is not empty
			if (!empty) {
				System.out.println(" | Database - familydb | Table - relation |");
				System.out.println("+-------+------------+-----------+----------+");
				System.out.println("| sl_no | first_name | last_name | relation |");
				System.out.println("+-------+------------+-----------+----------+");
			}
			
			else {
				System.out.println("familydb.realtion is EMPTY");
			}
			
			//code block to read each line of data from the table
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				
				int sl_no = result.getInt("sl_no");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				String relation = result.getString("relation");
				String output = "|  #%d   | %s    | %s   | %s    |";
				System.out.println(String.format(output, sl_no, first_name, last_name, relation));
				System.out.println("+-------+------------+-----------+----------+");
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
