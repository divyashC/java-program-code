package questions;

import java.util.Scanner;

public class Eligibility {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String name;
		double height;
		int age, gender, bodyf;

		System.out.println("Enter Your Name: ");
		name = sc.nextLine();
		
		System.out.println("Enter 1 for Male and 2 for Female: ");
		gender = sc.nextInt();
		
		System.out.println("Enter Your Height in meter: ");
		height = sc.nextDouble();
		
		System.out.println("Enter Your Age: ");
		age = sc.nextInt();
		
		System.out.println("Enter Your Body Figure (1 for Normal - 2 for Thin - 3 for Fat): ");
		bodyf = sc.nextInt();

		if (height > 1.5 && age >= 18 && age <= 27 && bodyf == 1) {

			if (gender == 1) {
				System.out.println("Congratulation Mr." + name + " you are eligible to apply.");
			}

			else {
				System.out.println("Congratulation Ms." + name + " you are eligible to apply.");
			}

		}

		else {

			if (gender == 1) {
				System.out.println("Sorry Mr." + name + ", you can try next time.");
			}

			else {
				System.out.println("Sorry Ms." + name + ", you can try next time.");
			}
		}

		sc.close();

	}

}






