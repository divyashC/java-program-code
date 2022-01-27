package questions;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double a, b, c;
		System.out.println("Enter Angle 1: ");
		a = sc.nextDouble();
		System.out.println("Enter Angle 2: ");
		b = sc.nextDouble();
		System.out.println("Enter Angle 3: ");
		c = sc.nextDouble();
		
		if (a+b+c == 180) {
			System.out.println("Yes, Triangle can be formed with " + a + ", "+ b + " and " + c + " angles");
		}
		else {
			System.out.println("No, Triange cannot be formed because total angle is not 180");
		}
		
		sc.close();
		

	}

}




