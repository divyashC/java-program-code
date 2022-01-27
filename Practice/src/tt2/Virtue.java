package tt2;

import java.util.Scanner;

public class Virtue {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name: ");
		String input = sc.next();
		sc.close();
		
		int i, score=0;
		
		for (i=0; i<=input.length(); i++) {
			
			char ch1 = input.charAt(i);
			
			if (ch1 == 'C' || ch1 == 'S' || ch1 == 'T' || ch1 == 'R' || ch1 == 'O' || ch1 == 'Y' || ch1 == 'A' || ch1 == 'L' || ch1 == 'U' || ch1 == 'N' || ch1 == 'I' || ch1 == 'V' || ch1 == 'E' || ch1 == 'Y' || ch1 == 'F' || ch1 == 'B' || ch1 == 'H' || ch1 == 'N') {
				score+=5;
			}
			
		}
		
		if (score>=40) {
			System.out.println("You have a good virtue in CST");
		}
		
		else {
			System.out.println("You need to work hard");
		}
		
	}

}
