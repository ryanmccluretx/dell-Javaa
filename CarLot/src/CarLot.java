import java.util.ArrayList;
import java.util.List;

public class CarLot {
	public String name;
	public List<Vehicle> vehicles;
	
	public CarLot(String name, List<Vehicle> vehicles) {
		this.name = name;
		this.vehicles = vehicles;
	}
	
	public CarLot(String name) {
		this.name = name;
		vehicles = new ArrayList<Vehicle>();
	}
	
	//Add a Vehicle to the lot
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	//Print the CarLot inventory
	public void printInventory() {
		System.out.println("The " + this.name + " has the following vehicles parked in it:");
		for(int i = 0; i < vehicles.size(); i++) {
			vehicles.get(i).printDescription();
		}
	}
}
 