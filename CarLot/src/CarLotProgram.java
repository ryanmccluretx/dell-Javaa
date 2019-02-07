
public class CarLotProgram {

	public static void main(String[] args) {
		//Initialize		
		Vehicle bmwM6 = new Car("LAKE IT", "BMW", "M6 Convertible", "$145,000", "Coupe", 2);
		Vehicle mercedesG63 = new Truck("MICHAEL", "Mercedes-Benz", "G63 AMG", "$200,000", "0ft");
		Vehicle audiA8 = new Car("SCOTT", "Audi", "R8", "$88,500", "Sedan", 4);
		Vehicle audiA3 = new Car("NEWHIRE", "Audi", "A3", "$32,000", "Hatchback", 3);
		Vehicle sierraDenali = new Truck("TXDNALI", "GMC", "Sierra Denali", "$69,000", "8ft");
		
		CarLot dellLot = new CarLot("Dell Employee Parking Lot");
		CarLot campusLot = new CarLot("University of Texas at Austin student lot");
		
		//Add Vehicles to Lot
		dellLot.addVehicle(bmwM6);
		dellLot.addVehicle(mercedesG63);
		dellLot.addVehicle(audiA8);
		dellLot.addVehicle(audiA3);
		campusLot.addVehicle(sierraDenali);
		
		//PrintLotInfo
		dellLot.printInventory();
		campusLot.printInventory();
	}
}
