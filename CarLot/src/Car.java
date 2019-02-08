
public class Car extends Vehicle {

	public String type;
	public int numDoors;
	
	public Car(String license, String make, String model, String price, String type, int numDoors) {
		this.license = license;
		this.make = make;
		this.model = model;
		this.price = price;
		this.type = type;
		this.numDoors = numDoors;		
	}
	
	//Print Car Description
	public void printDescription() {
		System.out.println("This beautiful " + this.type + ", the " + this.make + " " 
				+ this.model + ", with license plate " 
				+ this.license + " costs " + this.price + ".");
	}
	
}
