package eventHandlingClassActivity;

import java.awt.event.*;
import javax.swing.*;

public class Button {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Button");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setLayout(null);
		
		JButton button = new JButton("Click Here");
		button.setBounds(180, 200, 120, 35);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				button.setText("Button Clicked");
			}
		});
		
		frame.add(button);

	}

}
