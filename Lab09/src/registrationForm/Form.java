package registrationForm;

import java.awt.*; 

@SuppressWarnings("serial")
public class Form extends Frame{
	
	Label lform, lname, lstudent_id, ldob, lprogramme, lsemester, lnumber, laddress, lblank;
	TextField tfname, tfstudent_id, tfdob, tfnumber;
	TextArea taAddress;
	List liprogramme, lisemester;
	Button bsubmit;
	
	public Form(){
		
		// Creating Instance of the Label class
		lform = new Label("Registration Form");
		lblank = new Label(" ");
		lname = new Label("Name: ");
		lstudent_id = new Label("Student ID: ");
		ldob = new Label("Date of Birth: ");
		lprogramme = new Label("Programme: ");
		lsemester = new Label("Semester: ");
		lnumber = new Label("Phone Number: ");
		laddress = new Label("Address: ");
		
		//Creating Instance of the TextField class
		tfname = new TextField(10);
		tfstudent_id = new TextField(10);
		tfdob = new TextField("dd/mm/yyyy",10);
		tfnumber = new TextField("+975-XXXXXXXX", 10);
		
		//Creating Instance of the List class
		liprogramme = new List(9);
		liprogramme.setBounds(100,100,75,75);
		liprogramme.add("ME Construction Management");
		liprogramme.add("ME Renewable Energy");
		liprogramme.add("BE IT");
		liprogramme.add("BE Civil");
		liprogramme.add("BE Electrical");
		liprogramme.add("BE ECE");
		liprogramme.add("BE ICE");
		liprogramme.add("BE EG");
		liprogramme.add("BE Arch");
		
		//Creating Instance of the List class
		lisemester = new List(10);
		liprogramme.setBounds(100,100,75,75);
		lisemester.add("1");
		lisemester.add("2");
		lisemester.add("3");
		lisemester.add("4");
		lisemester.add("5");
		lisemester.add("6");
		lisemester.add("7");
		lisemester.add("8");
		lisemester.add("9");
		lisemester.add("10");
		
		//Creating instances of the TextArea class
		taAddress = new TextArea("Please enter your correct address.....");
		
		//Creating instances of the Button class
		bsubmit = new Button("Submit");
		
		//Creating instances of the Font class
		Font Header = new Font("Times New Roman", Font.BOLD, 25);
		Font Normal = new Font("Times New Roman", Font.PLAIN, 14);
		
		//Applying Font
		lform.setFont(Header);
		lname.setFont(Normal);
		lstudent_id.setFont(Normal);
		ldob.setFont(Normal);
		lprogramme.setFont(Normal);
		lsemester.setFont(Normal);
		lnumber.setFont(Normal);
		laddress.setFont(Normal);
		
		//Setting the GridLayout
		setLayout(new GridLayout(9,2,8,2));
		
		//Adding AWT components to the GridLayout
		add(lform);
		add(lblank);
		add(lname);
		add(tfname);
		add(lstudent_id);
		add(tfstudent_id);
		add(ldob);
		add(tfdob);
		add(lprogramme);
		add(liprogramme);
		add(lsemester);
		add(lisemester);
		add(lnumber);
		add(tfnumber);
		add(laddress);
		add(taAddress);
		add(bsubmit);

    }

	public static void main(String[] args) {
		
		//Creating Instance of the Form class which is extended to Frame Class
		Form frame = new Form();
		frame.setSize(new Dimension(800,600)); //Giving Dimensions to the frame
		frame.setTitle("AWT Control Components");  //Giving Title to the frame
		frame.setVisible(true); //Making the frame visible

	}
}