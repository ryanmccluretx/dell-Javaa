
public class Program {

	public static void main(String args[]) {
		
		Vehicle mazda = new Car(4,5,4);
		Vehicle moto1 = new Motorcycle(2, "cruiser");
		
	}
	
	public static void printClass(Vehicle v) {
		if(v instanceof Car) {
			System.out.println("it's a car");
		}
		
		if(v instanceof Motorcycle) {
			System.out.println("it's a motorcycle");
		}
		
		if(v instanceof Car) {
			System.out.println("it's a car");
		}
	}
}
