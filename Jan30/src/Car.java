
public class Car extends Vehicle{
	
	public int numDoors;
	
	public Car(int numWheels, int capacity, int numDoors) {
		super(numWheels, capacity);
		this.numDoors = numDoors;
	}
	
	@Override
	public String toString() {
		return "BUgatti";
	}
	
}
