
public class Room implements Rentable {

	double dailyRate;
	String description;
	
	public Room(double rate, String desc) {
		dailyRate = rate;
		description = desc;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getDailyRate() {
		return dailyRate;
	}

	@Override
	public double getPrice(double days) {
		return days*dailyRate;
	}
	
}
