//package questions;
//
//import java.util.Scanner;
//
//public class Grade {
//
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//
//		int marks[] = new int[5];
//		int avg, total = 0, i;
//
//		for (i = 0; i < 5; i++) {
//
//			System.out.println("Enter Marks for subject " + (i + 1) + ": ");
//			marks[i] = sc.nextInt();
//			total += marks[i];
//
//		}
//
//		avg = total / 5;
//
//		System.out.println("Your average is " + avg);
//
//		switch (avg / 10) {
//
//		case 10:
//			System.out.println("Your Grade is 'A'");
//			break;
//
//		case 9:
//			System.out.println("Your Grade is 'A'");
//			break;
//
//		case 8:
//			System.out.println("Your Grade is 'A'");
//			break;
//
//		case 7:
//			System.out.println("Your Grade is 'B'");
//			break;
//
//		case 6:
//			System.out.println("Your Grade is 'C'");
//			break;
//
//		case 5:
//			System.out.println("Your Grade is 'D'");
//			break;
//
//		default:
//			System.out.println("Your Grade is 'E'");
//
//		}
//
//		sc.close();
//
//	}
//
//}
