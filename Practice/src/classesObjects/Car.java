package classesObjects;

public class Car {
	
	String model;
	String company;
	double price;
	float mileage;
	int capacity;
	
	void buy() {
		System.out.println("Congratulations!!! You now have your own " + model);
	}
	
	void sell() {
		System.out.println("Congratulations!!! You earned Nu." + price);
	}

}