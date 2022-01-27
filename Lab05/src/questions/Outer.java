package questions;

public class Outer {
	
	void display() {
		System.out.println("You called display() Function inside Outer class\n");
	}
	
	void sum(int a, int b) {
		System.out.println("You called sum() Function inside Outer class");
		System.out.println("The sum of " + a + " and " + b + " is " + (a+b));
	}
		
	static class Inner {
		
		static void display() {
			System.out.println("\nYou called display() Function inside Inner class");
		}
		
	}

	public static void main(String[] args) {

		Outer inst1 = new Outer();  // declaring instance of outer class
		inst1.display();  // calling display function of Outer class
		inst1.sum(4, 5);  // calling sum function of Outer class
		
		Inner.display();  // calling display function of Inner class

	}

}