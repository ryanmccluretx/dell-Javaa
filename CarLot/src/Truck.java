
public class Truck extends Vehicle {

	public String bedSize;
	
	public Truck(String license, String make, String model, String price, String bedSize) {
		this.license = license;
		this.make = make;
		this.model = model;
		this.price = price;
		this.bedSize = bedSize;
	}
	
	//Print Vehicle description
	public void printDescription() {
		System.out.println("This beautiful " + this.make + " " + this.model 
				+ ", with license plate " + this.license + " has a bed size of " 
				+ this.bedSize + " and costs " + this.price + ".");
	}
}
