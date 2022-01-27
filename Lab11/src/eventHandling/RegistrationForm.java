package eventHandling;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegistrationForm implements ActionListener {


	private JFrame frame;
	private JLabel regformLabel, nameLabel, stdIDLabel, dateLabel, programmeLabel, semesterLabel, 
	numberLabel, addressLabel, errorLabel;
	private JTextField  textFieldName, textFieldStdID, textFieldNumber;
	private JComboBox dateList, monthList, yearList, programmeList, semesterList;
	private JTextArea textArea;
	private JButton ResetButton, SubmitButton;


	RegistrationForm() {

		frame = new JFrame("Registration Form");
		frame.setBounds(100, 100, 700, 450);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		regformLabel = new JLabel("Registration Form");
		regformLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		regformLabel.setBounds(229, 24, 200, 45);

		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		nameLabel.setBounds(56, 95, 49, 21);

		textFieldName = new JTextField ();
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldName.setBounds(131, 93, 160, 25);

		stdIDLabel = new JLabel("Student ID");
		stdIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		stdIDLabel.setBounds(327, 95, 68, 21);

		textFieldStdID = new JTextField ();
		textFieldStdID.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldStdID.setBounds(423, 93, 182, 25);

		dateLabel = new JLabel("Date of Birth");
		dateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		dateLabel.setBounds(327, 140, 85, 20);

		String dates[] = { "", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30",
		"31" };
		dateList = new JComboBox(dates);
		dateList.setBounds(425, 139, 49, 25);	

		String months[] = { "", "Jan", "Feb", "Mar", "Apr",
				"May", "Jun", "July", "Aug",
				"Sep", "Oct", "Nov", "Dec" };
		monthList = new JComboBox(months);
		monthList.setBounds(484, 139, 49, 25);	

		String years[]  = { "", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", 
				"2005", "2006", "2007", "2008", "2009", 
				"2010", "2011", "2012", "2013", "2014",
				"2015", "2016", "2017", "2018", "2019",
				"2020", "2021"};
		yearList = new JComboBox(years);
		yearList.setBounds(543, 139, 62, 25);	

		programmeLabel = new JLabel("Programme");
		programmeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		programmeLabel.setBounds(327, 182, 68, 21);

		String programme[] = {"", "BE Civil", "BE Electrical", "BE IT", 
				"BE ECE", "BE ICE", "BE EG", "BE Arch", 
				"ME CM", "ME RE"};
		programmeList = new JComboBox(programme);
		programmeList.setBounds(423, 181, 182, 25);		

		semesterLabel = new JLabel("Semester");
		semesterLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		semesterLabel.setBounds(56, 185, 53, 21);

		String semester[] = {"", "Semester 1", "Semester 2", "Semester 3", 
				"Semester 4", "Semester 5", "Semester 6", 
				"Semester 7", "Semester 8", "Semester 9", 
		"Semester 10"};
		semesterList = new JComboBox(semester);
		semesterList.setBounds(131, 181, 95, 25);	

		numberLabel = new JLabel("Contact No.");
		numberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		numberLabel.setBounds(56, 140, 76, 21);

		textFieldNumber = new JTextField();
		textFieldNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldNumber.setColumns(8);
		textFieldNumber.setBounds(131, 138, 160, 25);	

		textArea = new JTextArea();
		textArea.setBounds(131, 232, 160, 105);

		addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		addressLabel.setBounds(56, 233, 62, 21);

		ResetButton = new JButton("Reset");
		ResetButton.setBounds(473, 254, 85, 21);
		ResetButton.addActionListener(this);

		SubmitButton = new JButton("Submit");
		SubmitButton.setBounds(473, 294, 85, 21);
		SubmitButton.addActionListener(this);

		frame.add(nameLabel);
		frame.add(textFieldName);
		frame.add(regformLabel);
		frame.add(stdIDLabel);
		frame.add(textFieldStdID);
		frame.add(dateLabel);
		frame.add(dateList);
		frame.add(monthList);
		frame.add(yearList);
		frame.add(programmeLabel);
		frame.add(programmeList);
		frame.add(semesterLabel);
		frame.add(semesterList);
		frame.add(numberLabel);
		frame.add(textFieldNumber);
		frame.add(textArea);
		frame.add(addressLabel);
		frame.add(ResetButton);
		frame.add(SubmitButton);	

		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(410, 326, 250, 21);
		frame.add(errorLabel);

	}

	public void actionPerformed(ActionEvent e) {

		try {

			long num = Long.parseLong(textFieldNumber.getText());

			if ((e.getSource() == SubmitButton)) {

				if ( num<99999999 && num>9999999 ) {
					errorLabel.setText("");
					SwingUtilities.invokeLater(new Runnable() {
						public void run() { 
							String name = textFieldName.getText();
							String stdid = textFieldStdID.getText();
							String date =  (String)dateList.getSelectedItem();
							String month =  (String)monthList.getSelectedItem();
							String year =  (String)yearList.getSelectedItem();
							String pl = (String)programmeList.getSelectedItem();
							String seml = (String)semesterList.getSelectedItem();
							String num = textFieldNumber.getText();
							String address = textArea.getText();
							new Display(name, stdid, date, month, year, pl, seml, num, address);					
						}
					});
				}

				else {
					errorLabel.setText("*Please Enter a Valid 8 digit number");
				}
			}
		}

		catch (Exception ae) {
			errorLabel.setText("*Please Enter a Valid 8 digit number");
		}

		if ((e.getSource() == ResetButton)) {

			String def = "";
			textFieldName.setText(def);
			textFieldStdID.setText(def);
			dateList.setSelectedIndex(0);
			monthList.setSelectedIndex(0);
			yearList.setSelectedIndex(0);
			programmeList.setSelectedIndex(0);
			semesterList.setSelectedIndex(0);
			textFieldNumber.setText(def);
			textArea.setText(def);

		}

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() { 
				new RegistrationForm(); 
			}
		});


	}
}
