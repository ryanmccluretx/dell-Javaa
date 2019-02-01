
public class Car {
	String color;
	String license;
	String make;
	String model;
	
	public Car(String color, String license, String make, String model) {
		this.color = color;
		this.license = license;
		this.make = make;
		this.model = model;
	}
	public String getMakeAndModel() {		
		return make + " " + model;
	}	
}
