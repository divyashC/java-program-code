//Write a program to create a room class, the attributes of this class are roomno, roomtype, roomarea and ACmachine. 
//Make roomno and roomtype private. Create the following methods, setdata() and displaydata().

package labQuestion;

import java.util.Scanner;

public class Room {
	
	private int roomNo;
	private String roomType;
	double roomArea;
	boolean ACmachine;
	
	public void setdata(int rNo, String rType, double rArea, boolean AC) {
		roomNo = rNo;
		roomType = rType;
		roomArea = rArea;
		ACmachine = AC;
	}
	
	public void displaydata() {
		System.out.println("Room Number: " + roomNo);
		System.out.println("Room Type: " + roomType);
		System.out.println("Room Area: " + roomArea + " m sq.");

		if (ACmachine) {
			System.out.println("The Room has AC");
		}
		
		else {
			System.out.println("The Room does not have AC");
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int rNo;
		String rType;
		double rArea;
		boolean AC;
		
		Room one = new Room();
		
		System.out.println("Enter Room No: ");
		rNo = sc.nextInt();
		System.out.println("Enter Room Type (Single/Double/Queen/King/Deluxe/Super Deluxe): ");
		rType = sc.next();
		System.out.println("Enter Room Area: ");
		rArea = sc.nextDouble();
		System.out.println("Is AC Required (true/false): ");
		AC = sc.nextBoolean();
		
		sc.close();
		
		one.setdata(rNo, rType, rArea, AC);
		one.displaydata();
		
	}

}
