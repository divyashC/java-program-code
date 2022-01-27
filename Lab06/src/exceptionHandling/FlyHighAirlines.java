package exceptionHandling;

import java.util.Scanner;

public class FlyHighAirlines {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Candidate's Age: ");
		int age = sc.nextInt(); // scanning for user input

		sc.close();

		try {
			if (age < 18 || age > 22) { // entering required conditions in the if block
				throw new AgeDoesNotMatchException("Age is not in between 18 and 22"); // throwing exception if the given age input is not in range
			}
			else {
				System.out.println("You are eligible to be a crew member");
			}
		}

		catch (AgeDoesNotMatchException ex) {
			System.out.println("Illegal Argument Exception => " + ex); // printing the exception in the console
		}
	}
}

@SuppressWarnings("serial")
class AgeDoesNotMatchException extends Exception {
	String a;
	AgeDoesNotMatchException(String b) { // A constructor to receive the String message
		a = b;
	}

	public String toString() {
		return (a);  // returning the message "a" which was received by the constructor 
	}
}


