package questions;

// creating a new class of two objects which are going to be swapped
class ab {	
	int a;
	int b;
}

public class CallByValueAndReference {
	
	void value(int a, int b) {    // passing values from main method
		System.out.println("The values passed are:");
		System.out.println("a = " + a + " and b = " + b);
	}
	
	void reference(ab temp) { // creating new instance of the class as formal parameter
		temp.a = 10;  // assigning new values
		temp.b = 5;
	}

	public static void main(String[] args) {
		
		CallByValueAndReference inst1 = new CallByValueAndReference(); // declaring instance of the class
		System.out.println("Call by Value");
		inst1.value(4, 5); // calling the value method passing arguments
		
		ab inst2 = new ab(); // declaring instance of the class
		inst2.a = 5; // assigning values
		inst2.b = 10;
		
		System.out.println("\nCall by Reference");
		
		System.out.println("The values before swapping are:");
		System.out.println("a = " + inst2.a + " and b = " + inst2.b);
		
		inst1.reference(inst2); // calling reference method by passing the instance as the actual parameter 
		
		System.out.println("\nThe values after swapping are:");
		System.out.println("a = " + inst2.a + " and b = " + inst2.b);
	}

}