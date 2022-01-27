package questions;

public class Simpleobject {
	
	Simpleobject(){
		System.out.println("No argument passed");
	}
	
	Simpleobject(String txt) { // creating new method of same name to implement constructor overloading
		System.out.println("The argument passed is " + txt);
	}
	

	public static void main(String[] args) {
		
		new Simpleobject();
		new Simpleobject("Hello"); //passing Hello as an argument to the constructor 

	}

}