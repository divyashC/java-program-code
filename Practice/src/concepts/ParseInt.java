package concepts;

import java.util.Scanner;

public class ParseInt {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int a, b;
		String input;
		input = sc.nextLine();
		
		char ch = input.charAt(1);
		
		if (ch=='+') {
			a = Integer.parseInt(input.split("\\+")[0]);
			b = Integer.parseInt(input.split("\\+")[1]);
			
			System.out.println("The sum of " + a + " and " + b + " is " + (a+b));
		}
		
		else {
			a = Integer.parseInt(input.split("\\-")[0]);
			b = Integer.parseInt(input.split("\\-")[1]);
			
			System.out.println("The difference of " + a + " and " + b + " is " + (a-b));
		}
		
		sc.close();


	}

}
