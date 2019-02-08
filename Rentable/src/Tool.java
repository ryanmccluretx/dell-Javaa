
public class Tool implements Rentable {
	
	double hourlyRate;
	String description;
	
	public Tool(double rate, String desc) {
		hourlyRate = rate;
		description = desc;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getDailyRate() {
		return hourlyRate*24;
	}

	@Override
	public double getPrice(double days) {
		return getDailyRate()*days;
	}

}
