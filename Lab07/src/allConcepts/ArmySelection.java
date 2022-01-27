package allConcepts;

import java.util.Scanner;
import java.util.InputMismatchException;  //importing exception class

public class ArmySelection extends Details {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);

		Info obj1 = new Info(); //creating object of Info class

		System.out.println("Enter Candidate's Name: ");
		String name = sc.nextLine();
		obj1.setName(name);

		System.out.println("Enter Candidate's Age (19-25): ");
		int age = sc.nextInt();

		try {       //implementing try catch method of exception handling

			if (age < 19 || age > 25) {  //control statements
				throw new InputMismatchException();
			}

			else {
				System.out.println("Your age is between 19-25! You are eligible");
			}
		}

		catch (InputMismatchException ex) {
			System.out.println("Input Mismatch Exception => " + ex); //throwing exception message
		}
		obj1.setAge(age);

		System.out.println("Enter Candidate's Height: ");
		float height = sc.nextFloat();
		obj1.setHeight(height);

		System.out.println("Enter Candidate's Mother Tongue: ");
		String mt = sc.nextLine();
		obj1.setMT(mt);

		sc.close();
		
		obj1.obj2.displayDetails();

	}
}

class Details {  //superclass

	String name;  //creating variables in superclass
	int age;
	float height;
	String mothertongue;

	public void setMT(String mt) { // method overriding
		this.mothertongue = mt;
	}
}

class Info extends Details {  //inheritance
	
	public void setMT(String mt) {  // method overriding
		this.mothertongue = mt;
	}

	public void setName(String n) { //method overloading
		this.name = n;
	}

	public void setName(String firstname, String lastname) {  //method overloading
		this.name = firstname + " " + lastname;
	}

	public void setAge(int a) {
		this.age = a;
	}

	public void setHeight(float h) {
		this.height = h;
	}
	
	DisplayDetails obj2 = new DisplayDetails();
	
	class DisplayDetails extends Details implements display{ //nested class + implementing interface
		
		DisplayDetails() { //constructors
			this.mothertongue = "Dzongkha";
		}

		public void displayDetails() {
			System.out.println("Name: " + this.name);
			System.out.println("Age: " + this.age);
			System.out.println("Height: " + this.height);
			System.out.println("Mother Tongue: " + this.mothertongue);
		}

	}

}

interface display {  //interface
	abstract void displayDetails();
}





