package login;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener{
	
	private JFrame frame;
	private JTextField UsernameTextField;
	private JPasswordField passwordField;
	private JButton LoginButton;
	private JLabel Messagelbl;
	
	public LoginPage(){
		
		frame = new JFrame();
		frame.setSize(new Dimension(250,300)); 
		frame.setTitle("Login"); 
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(24, 82, 72, 28);
		frame.getContentPane().add(lblUsername);
		
		UsernameTextField = new JTextField();
		UsernameTextField.setBounds(106, 89, 96, 19);
		frame.getContentPane().add(UsernameTextField);
		UsernameTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(24, 112, 72, 28);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(106, 118, 96, 21);
		frame.getContentPane().add(passwordField);
		
		LoginButton = new JButton("Login");
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LoginButton.setBounds(65, 164, 86, 28);
		LoginButton.addActionListener(this);
		frame.getContentPane().add(LoginButton);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLoginPage.setBounds(58, 25, 109, 38);
		frame.getContentPane().add(lblLoginPage);
		
		Messagelbl = new JLabel("");
		Messagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		Messagelbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Messagelbl.setBounds(24, 211, 202, 28);
		frame.getContentPane().add(Messagelbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 236, 263);
		frame.getContentPane().add(scrollPane);
		
		
    }
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
			
		if ((e.getSource() == LoginButton)) {
			
			try {

				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
				Statement statement = connection.createStatement();
				
				String sql = "SELECT * from login_details_demo where username='"+UsernameTextField.getText()+"' and password='"+passwordField.getText().toString()+"'";
				ResultSet resultset = statement.executeQuery(sql);
				
				if (resultset.next()) {
					Messagelbl.setText("Login Successful!");
				}
				
				else {
					Messagelbl.setText("Incorrect Credentials!!!");
				}
				
				resultset.close();
				connection.close();

			} 

			catch (SQLException ae) {
				
				System.out.println("Error!!! Connection Failed");  
				ae.printStackTrace();
				
			}
			
		}
	
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() { 
				new LoginPage(); 
			}
		});
	}
}