package room;

public class RoomInfo extends Display{
	
	String stdName, roomNo, hostelBlock, newRoom, newBlock, problem;
	int stdNo;
	
	public RoomInfo(String Name, int stdno){  // constructor 
		
		this.stdName = Name;
		this.stdNo = stdno;
		this.roomNo = "Not Allocated, please book a Room";
		
	}

	public void RoomDetails(String roomNumber) { //method overriding
		this.roomNo = roomNumber;
		this.hostelBlock = roomNumber.substring(0,2);
		System.out.println();
		System.out.println(" * * * * * * Room Details * * * * * * ");
		System.out.println("Name: " + this.stdName);
		System.out.println("Student No.: " + this.stdNo);
		System.out.println("Room No.: " + this.roomNo);
		System.out.println("Hostel Block: " + this.hostelBlock);
		System.out.println("Your Room Currently has: ");
		System.out.println("	1. Bed - 2 Nos");
		System.out.println("	2. Tubelight - 2 Nos");
		System.out.println("	3. Bulb - 1 Nos");
		System.out.println("	4. Chair - 2 Nos");
		System.out.println("	5. Table - 1 Nos");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
	}
	
	public void Maintenance(String prob) {
		this.problem = prob;
		System.out.println();
		System.out.println(" * * * * * * Maintenance * * * * * * ");
		System.out.println("Name: " + this.stdName);
		System.out.println("Student No.: " + this.stdNo);
		System.out.println("Room No.: " + this.roomNo);
		System.out.println("Hostel Block: " + this.hostelBlock);
		System.out.println("We have notified the Maintenance Councillors.");
		System.out.println("Your room will be serviced ASAP");
		System.out.println("Problem Statement: " + this.problem);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
		
	}
	
	public void BookRoom(String... room) { //method overloading 
		System.out.println("Number of Rooms Booked: " + room.length);
		System.out.println("You have book " + room.length + " rooms in. We will notify you shortly! ");  
	}
	
	public void BookRoom(String nRoom) { //method overloading 
		this.newRoom = nRoom;
		this.newBlock = nRoom.substring(0,2);
		System.out.println();
		System.out.println(" * * * * * * Room Booking * * * * * * ");
		System.out.println("Name: " + this.stdName);
		System.out.println("Student No.: " + this.stdNo);
		System.out.println("Room No.: " + this.newRoom);
		System.out.println("Hostel Block: " + this.newBlock);
		System.out.println("You have book room " + newRoom + "  in block " + newBlock);  
		System.out.println("We will notify you shortly after discussing with Block Councillors");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
		
		
	}
	
	public void ChangeRooms(String nRoom) {
		this.newRoom = nRoom;
		System.out.println(" * * * * * * Room Change* * * * * * ");
		System.out.println("Name: " + this.stdName);
		System.out.println("Student No.: " + this.stdNo);
		System.out.println("Room No.: " + this.newRoom);
		System.out.println("We will look upon your request");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
	}

}

class Display {
	
	String stdName, roomNo, hostelBlock;
	int stdNo;
	
	public void RoomDetails(String roomNumber) { //method overriding
		this.roomNo = roomNumber;
		this.hostelBlock = roomNumber.substring(0,2);
		System.out.println();
		System.out.println(" * * * * * * Room Details * * * * * * ");
		System.out.println("Name: " + this.stdName);
		System.out.println("Student No.: " + this.stdNo);
		System.out.println("Room No.: " + this.roomNo);
		System.out.println("Hostel Block: " + this.hostelBlock);
		System.out.println("Your Room Currently has: ");
		System.out.println("	1. Bed - 2 Nos");
		System.out.println("	2. Tubelight - 2 Nos");
		System.out.println("	3. Bulb - 1 Nos");
		System.out.println("	4. Chair - 2 Nos");
		System.out.println("	5. Table - 1 Nos");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
	}

	public void menu() {
		System.out.println();
		System.out.println(" * * * * * * Hostel Services * * * * * * ");
		System.out.println(">> Enter 1 to View Your Room Details");
		System.out.println(">> Enter 2 to Book New Room");
		System.out.println(">> Enter 3 to Avail Maintenance Services ");
		System.out.println(">> Enter 4 to Change Rooms ");
		System.out.println(">> Enter 5 to Exit");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
	}
	
}