
public class Motorcycle extends Vehicle {

	private String type;
	
	public Motorcycle(int capacity, String type) {
		super(2, capacity);
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Motorcycle [type=" + type + ", getNumWheels()=" + this.numWheels;
	}
	
	public String honk() {
		return "toot! toot!";
	}
}
