package miniProject;

import javax.swing.*;
import java.awt.*;

public class Login {
	
	private static JTextField textField;
	private static JPasswordField passwordField;
	private static JMenuItem newitem;

	public static void main(String[] args) {

		JFrame frame = new JFrame();
        frame.setTitle("CST Infirmary Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(614, 637);
        frame.setVisible(true);


        frame.getContentPane().setBackground(new Color(26,129,232));
        frame.getContentPane().setLayout(null);
        
        JLabel lblUsername = new JLabel("Username\r\n:");
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblUsername.setBounds(153, 270, 108, 45);
        frame.getContentPane().add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblPassword.setBounds(153, 325, 108, 45);
        frame.getContentPane().add(lblPassword);
        
        textField = new JTextField();
        textField.setBounds(271, 283, 180, 25);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(271, 335, 180, 25);
        frame.getContentPane().add(passwordField);
        
        JButton btnLoginButton = new JButton("Login");
        btnLoginButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnLoginButton.setBounds(363, 417, 88, 33);
        frame.getContentPane().add(btnLoginButton);
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\Logo100.png"));
        lblLogo.setBounds(236, 58, 100, 100);
        frame.getContentPane().add(lblLogo);
        
        JLabel lblNewLabel = new JLabel("CST Health Infirmary");
        lblNewLabel.setFont(new Font("Roboto Medium", Font.BOLD, 28));
        lblNewLabel.setBounds(160, 174, 291, 45);
        frame.getContentPane().add(lblNewLabel);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 600, 33);
        frame.getContentPane().add(menuBar);
        
        JMenu filemenu = new JMenu("File");
        filemenu.setAlignmentX(1.0f);
        menuBar.add(filemenu);
        filemenu.setBackground(Color.LIGHT_GRAY);
        filemenu.setOpaque(true);
        
        newitem = new JMenuItem("New");
//        newitem.setOpaque(true);
//        newitem.setBackground(Color.LIGHT_GRAY);
        newitem.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Lab10\\img\\New2020.png"));
        newitem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        filemenu.add(newitem);
        
        JMenuItem openitem = new JMenuItem("Open");
        openitem.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Lab10\\img\\Open2020.png"));
//        openitem.setOpaque(true);
//        openitem.setBackground(Color.LIGHT_GRAY);
        filemenu.add(openitem);
        
        JMenuItem saveitem = new JMenuItem("Save");
        saveitem.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Lab10\\img\\Save2020.png"));
//        saveitem.setOpaque(true);
//        saveitem.setBackground(Color.LIGHT_GRAY);
        filemenu.add(saveitem);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(Color.BLACK);
        filemenu.add(separator);
        
        JMenuItem exititem = new JMenuItem("Exit    Ctrl+W");
        exititem.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Lab10\\img\\Exit2020.png"));
//        exititem.setOpaque(true);
//        exititem.setBackground(Color.LIGHT_GRAY);
        filemenu.add(exititem);
        
        JMenu editmenu = new JMenu("Edit");
        menuBar.add(editmenu);
        
        JMenuItem cutitem = new JMenuItem("Cut");
        editmenu.add(cutitem);
        
        JMenuItem copyitem = new JMenuItem("Copy");
        editmenu.add(copyitem);
        
        JMenuItem pasteitem = new JMenuItem("Paste");
        editmenu.add(pasteitem);
        
        JMenuItem selectallitem = new JMenuItem("Select All");
        editmenu.add(selectallitem);
		
	}
}
