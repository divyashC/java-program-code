package gui;

import java.awt.*;

@SuppressWarnings("serial")
public class SmileyFace extends Frame {

	public void paint(Graphics g) {

		// yellow oval
		g.setColor(new Color(207, 207, 207));
		g.fillOval(50, 80, 225, 240);

		// blue eyes
		g.setColor(new Color(68, 114, 196));
		g.fillOval(95, 150, 45, 45);
		g.fillOval(185, 150, 45, 45);

		// blue nose
		g.setColor(new Color(68, 114, 196));
		int [] x = {148,163,178};
        int [] y = {210,175,210};
		g.fillPolygon(x, y, 3);

		// blue mouth
		g.fillArc(133, 225, 60, 45, 0, 180);
		g.setColor(new Color(207, 207, 207));
		g.fillArc(145, 235, 35, 35, 0, 180);

	}

	public static void main(String[] args) {

		SmileyFace obj = new SmileyFace();
		obj.setSize(new Dimension(350, 400));
		obj.setTitle("Smiley Face");
		obj.setVisible(true);
	}

}


