package eventHandling;

import java.awt.*;
import javax.swing.*;

public class Display {

	private JFrame newframe;
	private JLabel showDetailsLabel,  NameDisplayLabel, NameDisplay,  StudentIdDisplayLabel, 
				   StudentIdDisplay, DobDisplayLabel, DateDisplay, MonthDisplay, YearDisplay, ProgrammeDisplayLabel, 
				   ProgrammeDisplay, SemesterDisplayLabel, SemesterDisplay, ContactDisplayLabel, ContactNoDisplay,
				   AddressDisplayLabel, AddressDisplay;

	public Display(String name, String stdid, String date, String month, String year, String pl, String seml, String num, String address) {

		newframe = new JFrame();
		newframe.setBounds(100, 100, 500, 450);
		newframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newframe.setVisible(true);
		newframe.setLayout(null);

		showDetailsLabel = new JLabel("Details");
		showDetailsLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		showDetailsLabel.setBounds(200, 30, 80, 35);

		NameDisplayLabel = new JLabel("Name");
		NameDisplayLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		NameDisplayLabel.setBounds(52, 88, 110, 20);

		NameDisplay = new JLabel(name);
		NameDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		NameDisplay.setBounds(160, 88, 250, 20);

		StudentIdDisplayLabel = new JLabel("Student ID");
		StudentIdDisplayLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		StudentIdDisplayLabel.setBounds(52, 118, 110, 20);

		StudentIdDisplay = new JLabel(stdid);
		StudentIdDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		StudentIdDisplay.setBounds(160, 118, 250, 20);

		DobDisplayLabel= new JLabel("Date of Birth");
		DobDisplayLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		DobDisplayLabel.setBounds(52, 148, 110, 20);

		DateDisplay = new JLabel(date);
		DateDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		DateDisplay.setBounds(160, 148, 30, 20);

		MonthDisplay = new JLabel(month);
		MonthDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		MonthDisplay.setBounds(187, 148, 40, 20);

		YearDisplay = new JLabel(year);
		YearDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		YearDisplay.setBounds(226, 148, 40, 20);

		ProgrammeDisplayLabel = new JLabel("Programme");
		ProgrammeDisplayLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ProgrammeDisplayLabel.setBounds(52, 178, 110, 20);

		ProgrammeDisplay = new JLabel(pl);
		ProgrammeDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ProgrammeDisplay.setBounds(160, 178, 250, 20);

		SemesterDisplayLabel = new JLabel("Semester");
		SemesterDisplayLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		SemesterDisplayLabel.setBounds(52, 208, 110, 20);

		SemesterDisplay = new JLabel(seml);
		SemesterDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		SemesterDisplay.setBounds(160, 208, 250, 20);

		ContactDisplayLabel = new JLabel("Contact Number");
		ContactDisplayLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ContactDisplayLabel.setBounds(52, 238, 110, 20);

		ContactNoDisplay = new JLabel(num);
		ContactNoDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ContactNoDisplay.setBounds(160, 238, 250, 20);

		AddressDisplayLabel = new JLabel("Address");
		AddressDisplayLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		AddressDisplayLabel.setBounds(52, 268, 110, 20);
//		AddressDisplay.setHorizontalAlignment(SwingConstants.LEFT);
//		AddressDisplay.setVerticalAlignment(SwingConstants.TOP);

		AddressDisplay = new JLabel(address);
		AddressDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		AddressDisplay.setBounds(160, 268, 250, 80);
		
		newframe.add(showDetailsLabel);	
		newframe.add(NameDisplayLabel);
		newframe.add(NameDisplay);
		newframe.add(StudentIdDisplayLabel);
		newframe.add(StudentIdDisplay);
		newframe.add(DobDisplayLabel);
		newframe.add(DateDisplay);
		newframe.add(MonthDisplay);
		newframe.add(YearDisplay);
		newframe.add(ProgrammeDisplayLabel);
		newframe.add(ProgrammeDisplay);
		newframe.add(SemesterDisplayLabel);
		newframe.add(SemesterDisplay);
		newframe.add(ContactDisplayLabel);
		newframe.add(ContactNoDisplay);
		newframe.add(AddressDisplayLabel);
		newframe.add(AddressDisplay);

	}

}
