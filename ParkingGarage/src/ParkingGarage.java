
public class ParkingGarage {
	Car[] cars;
	int capacity;
	
	public ParkingGarage(int capacity) {
		cars = new Car[capacity];
		this.capacity = capacity;
	}
	
	public String Park(Car car, int spot) {
		//reserve a spot for a car
		if(spot < 0 || spot >= capacity) {
			throw new IndexOutOfBoundsException("Parking spot " + spot + " is out of bounds!");
		}else if(cars[spot] != null) {
			//the assignment was unclear if this should be an exception.. it just said notify the user. hope this is fine
			return("Oops! there's already a car parked there");	
		}
		cars[spot] = car;
		return("You found a parking spot! Your " + car.getMakeAndModel() + " has been parked in spot " + spot);	
	}
	
	public String Vacate(int spot) {
		//Removes a car from a parking spot if it exists
		if(cars[spot] == null) {
			return "Silly user! There was no car parked at spot " + spot;	
		}
		Car carToRemove = cars[spot];
		cars[spot] = null;
		return "I've removed your " + carToRemove.getMakeAndModel() + " from spot " + spot;
	}
	
	public void printInventory() {
		//only prints if there are cars in the lot
		for(int i = 0; i < capacity; i++) {
			if(cars[i] != null) {
				System.out.println("Parking spot " + i + " currently has a beautifl " + cars[i].color 
						+ " " + cars[i].getMakeAndModel() + " with License Plate " + cars[i].license);
			}
		}
	}
	
}
