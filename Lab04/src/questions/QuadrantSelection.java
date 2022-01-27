package questions;

import java.util.Scanner;

public class QuadrantSelection {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x, y;
		System.out.println("Enter x Co-ordinate: ");
		x = sc.nextInt();
		System.out.println("Enter y Co-ordinate: ");
		y = sc.nextInt();

		if (x > 0 && y > 0) {
			System.out.println("x = " + x + " and y = " + y + " lies in 1st Quadrant");
		}

		else if (x < 0 && y > 0) {
			System.out.println("x = " + x + " and y = " + y + " lies in 2nd Quadrant");
		}

		else if (x < 0 && y < 0) {
			System.out.println("x = " + x + " and y = " + y + " lies in 3rd Quadrant");
		}

		else {
			System.out.println("x = " + x + " and y = " + y + " lies in 4th Quadrant");
		}
		
		sc.close();
		
	}

}
