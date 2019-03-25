import java.util.Random;

public class GarageManager {
	public static void main(String[] args) {
		
		//Initialize		
		Car maserati = new Car("Burgandy", "BITCOIN", "Maserati", "Levante");
		Car rangeSport = new Car("White w/ Black Roof", "RVRSPRT", "Land Rover", "Range Rover Sport");
		Car rangeVelar = new Car("Gray w/ Black Roof", "TXVELAR", "Land Rover", "Range Rover Velar");
		Car landDefender = new Car("Green", "97DFNDR", "Land Rover", "Defender");
		Car bmwM6 = new Car("Silver", "LAKE IT", "BMW", "M6 Convertible");
		Car mercedesG63 = new Car("Matte Gray", "KYLIE", "Mercedes-Benz", "G63 AMG");
		Car audiR8 = new Car("Red", "BEZOS", "Audi", "R8");
		Car teslaX = new Car("Blue", "BB BLUE", "Tesla", "Model X");
		Car cayenneGts = new Car("Brown", "GTS PRCH", "Porche", "Cayenne GTS");
		
		ParkingGarage skyHouseGarage = new ParkingGarage(7);
		ParkingGarage domainGarage = new ParkingGarage(10);
		ParkingGarage fourSeasonsGarage = new ParkingGarage(12);
				
		//Park
		System.out.println(skyHouseGarage.Park(maserati, new Random().nextInt(7)));
		System.out.println(skyHouseGarage.Park(rangeSport, new Random().nextInt(7)));
		System.out.println(skyHouseGarage.Park(rangeVelar, new Random().nextInt(7)));			
		System.out.println(skyHouseGarage.Park(landDefender, new Random().nextInt(7)));
		System.out.println(skyHouseGarage.Park(bmwM6, new Random().nextInt(7)));
		
		System.out.println(domainGarage.Park(mercedesG63, new Random().nextInt(10)));	
		System.out.println(domainGarage.Park(audiR8, new Random().nextInt(10)));
		System.out.println(domainGarage.Park(teslaX, new Random().nextInt(10)));
		System.out.println(domainGarage.Park(cayenneGts, new Random().nextInt(10)));

		System.out.println("Sky House Garage has the following cars parked in it:");			
		skyHouseGarage.printInventory();
		
		System.out.println("Domain Garage has the following cars parked in it:");			
		domainGarage.printInventory();
		
		//Vacate all spots from first 2 garages
		for(int i = 0; i < 7; i++) {
			if(skyHouseGarage.cars[i] != null) {
				System.out.println(skyHouseGarage.Vacate(i));
			}
		}
		for(int i = 0; i < 10; i++) {
			if(domainGarage.cars[i] != null) {
				System.out.println(domainGarage.Vacate(i));
			}
		}
		
		//Park Again
		System.out.println(fourSeasonsGarage.Park(maserati, new Random().nextInt(12)));
		System.out.println(fourSeasonsGarage.Park(rangeSport, new Random().nextInt(12)));
		System.out.println(fourSeasonsGarage.Park(rangeVelar, new Random().nextInt(12)));			
		System.out.println(fourSeasonsGarage.Park(landDefender, new Random().nextInt(12)));
		System.out.println(fourSeasonsGarage.Park(bmwM6, new Random().nextInt(12)));		
		System.out.println(fourSeasonsGarage.Park(mercedesG63, new Random().nextInt(12)));	
		System.out.println(fourSeasonsGarage.Park(audiR8, new Random().nextInt(12)));
		System.out.println(fourSeasonsGarage.Park(teslaX, new Random().nextInt(12)));
		System.out.println(fourSeasonsGarage.Park(cayenneGts, new Random().nextInt(12)));
		
		System.out.println("Four Seasons Garage has the following cars parked in it:");			
		fourSeasonsGarage.printInventory();		
	}
}
