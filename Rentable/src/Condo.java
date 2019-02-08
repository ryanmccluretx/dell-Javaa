
public class Condo implements Rentable {
	
	double weeklyRate;
	String description;
	
	public Condo(double rate, String desc) {
		weeklyRate = rate;
		description = desc;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public double getDailyRate() {
		return weeklyRate/7;
	}

	@Override
	public double getPrice(double days) {
		return weeklyRate*days;
	}

}
