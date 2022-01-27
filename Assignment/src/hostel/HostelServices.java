package hostel;

import java.util.InputMismatchException;  // importing in-built package
import java.util.Scanner;  // importing in-built package
import room.RoomInfo;  // importing user-defined package

public class HostelServices {

	public static void main(String[] args) {

		String name, roomNo;
		int option, stdNo;
		String newRoom;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);  //creating object of scanner class

		System.out.println("Enter your Name: ");
		name = sc.nextLine();
		System.out.println("Enter your Student No.: ");
		stdNo = sc.nextInt();
		System.out.println("Enter your Room No: ");
		roomNo = sc.next();
		
		//user-defined package
		RoomInfo obj1 = new RoomInfo(name, stdNo); //creating object of RoomInfo class 
		
     	// using do-while block to let users access the menu several times before exiting 
		do {      

			obj1.menu();    //displaying menu to the users
			System.out.println("Enter Option: ");
			option = sc.nextInt();
			
			try {       // implementing try catch method of exception handling
				
				if (option>5) {   //control statements
					throw new InputMismatchException();   //throwing exception
				}
				
			}

			catch (InputMismatchException ex) {
				System.out.println("Input Mismatch Exception => " + ex);//exception message
				System.out.println("You did not choose an Option between 1 and 5 ");
				System.out.println("Try again!!");
			}

			switch (option) {

			case 1: 
				System.out.println();
				System.out.println("You chose Option 1 to View Your Room Details");
				obj1.RoomDetails(roomNo);
				break;

			case 2:
				System.out.println();
				System.out.println("You chose Option 2 to Book New Room ");
				System.out.println();
				System.out.println("Enter Room No. of the Room to be Booked: ");
				newRoom = sc.next();
				obj1.BookRoom(newRoom);
				break;
                
			case 3: 
				System.out.println();
				System.out.println("You chose Option 3 to Avail Maintenance Services");
				System.out.println();
				System.out.println("Specify your Problem: ");
				String prob = sc.next();
				obj1.Maintenance(prob);
				break;

			case 4:
				System.out.println();
				System.out.println("You chose Option 4 to Change Rooms ");
				System.out.println("Enter Room No. of New Room: ");
				newRoom = sc.next();
				obj1.ChangeRooms(newRoom);
				break;

			}

		}
		
		while (option!=5);

		if (option == 5) {
			System.out.println();
			System.out.println("Thank You For Availing Hostel Services!!");
			System.exit(5);  //program exits itself after 5 seconds on printing the above message
		}

	}

}