package gui;

import java.awt.*;

@SuppressWarnings("serial")
public class House extends Frame {

	public void paint(Graphics g) {

		// wall1
		g.setColor(new Color(0, 153, 51)); // green
		g.fillRect(400, 200, 300, 400);

		int x1[] = { 350, 550, 750 };
		int y1[] = { 200, 53, 200 };

		// roof1
		g.setColor(new Color(153, 153, 102)); // silver
		g.fillPolygon(x1, y1, 3);

		// window
		g.setColor(new Color(192, 192, 192)); // gray
		g.fillRect(425, 290, 80, 130);
		g.fillRect(585, 290, 80, 130);
		
		//window top
		g.setColor(Color.black);
		g.fillRect(410, 255, 110, 20);
		g.fillRect(570, 255, 110, 20);

		// door
		g.setColor(new Color(139, 69, 19)); // brown
		g.fillRect(510, 470, 80, 130);
		
		int x2[] = { 700, 700, 800, 950 };
		int y2[] = { 435, 375, 375, 435};
		// roof2
		g.setColor(new Color(153, 153, 102)); // silver
		g.fillPolygon(x2, y2, 4);
		
		// wall2
		g.setColor(new Color(0, 204, 102)); // green
		g.fillRect(700, 435, 200, 165);

		// window
		g.setColor(new Color(192, 192, 192)); // gray
		g.fillRect(750, 470, 40, 60);
		g.fillRect(810, 470, 40, 60);

	}

	public static void main(String[] args) {

		House obj = new House();
		obj.setSize(new Dimension(1200, 700));
		obj.setTitle("House");
		obj.setVisible(true);
	}

}


