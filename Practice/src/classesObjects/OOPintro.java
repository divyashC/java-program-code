package classesObjects;

public class OOPintro {
	
	public static void main(String[] args) {
		
		Car car1 = new Car();
		Car car2 = new Car();
		
		car1.model = "Grand vitara";
		car1.company = "Suzuki";
		car1.price = 4000000;
		car1.mileage = 10.2f;
		car1.capacity = 5;
		
		car2.model = "Celerio";
		car2.company = "Maruti Suzuki";
		car2.price = 550000;
		car2.mileage = 22.5f;
		car2.capacity = 5;
		
		System.out.println("Model = " + car1.model);
		System.out.println("Company = " + car1.company);
		System.out.println("Price = Nu." + car1.price);
		System.out.println("Mileage(km) = " + car1.mileage);
		System.out.println("Capacity = " + car1.capacity);
		
		System.out.println("\nModel = " + car2.model);
		System.out.println("Company = " + car2.company);
		System.out.println("Price = Nu." + car2.price);
		System.out.println("Mileage(km) = " + car2.mileage);
		System.out.println("Capacity = " + car2.capacity);
		
		System.out.println();
		car1.buy();
		car2.sell();
		
	}

}