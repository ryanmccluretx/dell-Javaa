
public class Vehicle {
	int numWheels;
	int capacity;
	
	public Vehicle(int capacity, int numWheels) {
		this.capacity = capacity;
		this.numWheels = numWheels;
	}
	
	public String honk(){
		return "honk! honk!";
	}
}
