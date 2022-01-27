///* Lab 03 Question - Write a java program calculate the grade of a student based on the marks of class 12
// * by each subject. Print the grade based on this logic.
// * If the average marks is >= 80 then print Grade 'A'
// * If the average marks is <80 and >= 60 then print Grade 'B'
// * If the average marks is <60 and >=40 then print Grade 'C'
// * else print Grade 'D'
// * *assume that the student has 6 subjects. Create an array to store student marks*/
//
//package selectionStatement;
//
//import java.util.Scanner;
//
//public class Grade {
//
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int i;
//		float total=0, avg, marks[] = new float[6];
//		
//		for (i=0; i<6; i++) {
//			System.out.println("Enter marks for subject " + (i+1) + ": ");
//			marks[i] = sc.nextFloat();
//			total += marks[i];
//		}
//		
//		sc.close();
//		
//		avg = total/6;
//		
//		System.out.println("Your average is " + avg);
//		
//		if (avg >= 80) {
//			System.out.println("Grade - 'A'");
//		}
//		
//		else if (avg<80 && avg>=60) {
//			System.out.println("Grade - 'B'");
//		}
//		
//		else if (avg<60 && avg>=40) {
//			System.out.println("Grade - 'C'");
//		}
//		
//		else {
//			System.out.println("Grade - 'D'");
//		}
//		
//
//	}
//
//}
