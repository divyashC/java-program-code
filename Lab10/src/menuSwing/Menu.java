package menuSwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu implements ActionListener {

	JLabel label;

	Menu() {

		JFrame frame = new JFrame("My Menu"); // Creating new Frame
		frame.setLayout(new GridBagLayout());  //choosing FlowLayout as the layout
		frame.setSize(400, 400);  //dimensions for the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //terminates the program when application is closed
		frame.setVisible(true); // making the frame visible

		label = new JLabel(); //creating a label to display selection of Menu 
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		frame.add(label); // adding label to the frame

		JMenuBar menubar = new JMenuBar(); //creating new menu bar
		frame.setJMenuBar(menubar); //add the menu bar to the frame

		//creating file and edit menu for menu bar
		JMenu filemenu = new JMenu("File");
		JMenu editmenu = new JMenu("Edit");

		//adding menu to the menu bar
		menubar.add(filemenu);
		menubar.add(editmenu);

		//creating menu items for file menu
		JMenuItem newitem = new JMenuItem("New");
		newitem.setIcon(new ImageIcon("img\\New2020.png")); //importing new icon

		JMenuItem openitem = new JMenuItem("Open");
		openitem.setIcon(new ImageIcon("img\\Open2020.png")); //importing new icon

		JMenuItem saveitem = new JMenuItem("Save");
		saveitem.setIcon(new ImageIcon("img\\Save2020.png")); //importing new icon

		JSeparator separator = new JSeparator();  // creating new separator 
		separator.setBackground(Color.BLACK);

		JMenuItem exititem = new JMenuItem("Exit");
		exititem.setIcon(new ImageIcon("img\\Exit2020.png")); //importing new icon
		// Ctrl+W shortcut key
		exititem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));

		// adding menu items to file menu
		filemenu.add(newitem);
		filemenu.add(openitem);
		filemenu.add(saveitem);
		filemenu.add(separator);
		filemenu.add(exititem);

		//creating menu items for edit menu
		JMenuItem cutitem = new JMenuItem("Cut");
		// Ctrl+X shortcut key 
		cutitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));

		JMenuItem copyitem = new JMenuItem("Copy");
		// Ctrl+C shortcut key
		copyitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

		JMenuItem pasteitem = new JMenuItem("Paste");
		// Ctrl+V shortcut key
		pasteitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));

		JMenuItem selectallitem = new JMenuItem("Select All");
		// Ctrl+A shortcut key
		selectallitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));

		// adding menu items to edit menu
		editmenu.add(cutitem);
		editmenu.add(copyitem);
		editmenu.add(pasteitem);
		editmenu.add(selectallitem);

		//adding action listeners for the menu items
		newitem.addActionListener(this);
		openitem.addActionListener(this);
		saveitem.addActionListener(this);
		exititem.addActionListener(this);
		cutitem.addActionListener(this);
		copyitem.addActionListener(this);
		pasteitem.addActionListener(this);
		selectallitem.addActionListener(this);

	}

	public void actionPerformed (ActionEvent aevent) {

		String str = aevent.getActionCommand();  // string to get action command

		if (str.equals("Exit")) {  // control statement to exit the program is exit is clicked
			System.exit(0);
		}

		label.setText("You selected '" + str + "'"); // to display JLabel in center of the frame

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run( ) { 
				new Menu();  // new object of menu class
			}
		});

	}

}