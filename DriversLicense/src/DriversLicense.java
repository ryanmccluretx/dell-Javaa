import java.time.LocalDate;
import java.time.Period;

public class DriversLicense {
	String FirstName;
	String LastName;
	String BirthDate;
	String Height;
	String Gender;
	
	public int getAge() {
		LocalDate today = LocalDate.now(); // today's date
		String[] birthdayArray = BirthDate.split(","); //assuming BirthDate is csv string
		
		LocalDate birthday = LocalDate.of(Integer.parseInt(birthdayArray[0]), Integer.parseInt(birthdayArray[1]), Integer.parseInt(birthdayArray[2])); 

		Period period = Period.between(birthday, today);

		return period.getYears();
	}
	
	public String getFullName() {
		//Concat first + last
		return FirstName + " " + LastName;
	}
}
