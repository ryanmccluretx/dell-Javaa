
public class RentableProgram {
	
	public static void main(String[] args) {
		
		
		//Initialize
		Rentable[] rentables = new Rentable[9];
		rentables[0] = new Room(99.99, "This is the homeymoon room");
		rentables[1] = new Room(49.99, "This is the motel room");
		rentables[2] = new Room(149.99, "This is the executive room");
		rentables[3] = new Condo(980, "This is the Spring Break condo");
		rentables[4] = new Condo(490, "This is the entry level condo");
		rentables[5] = new Condo(700, "This is the mid-range condo");
		rentables[6] = new Tool(12, "This is a 12ft ladder");
		rentables[7] = new Tool(10, "This is a power drill");
		rentables[8] = new Tool(2, "This is a screw driver");
		
		//Run Program
		for(int i = 0; i < 9; i++) {
			System.out.println(rentables[i].getDescription() 
					+ " it is available for " + "$" 
					+ Double.toString(rentables[i].getDailyRate())
					+ ".");
		}


				
	}

}
