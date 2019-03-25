
public class LicenseProgram {

	public static void main(String args[]) {
		DriversLicense ricky = new DriversLicense();
		ricky.FirstName = "Ricky";
		ricky.LastName = "Martin";
		ricky.BirthDate = "1971,12,24";
		ricky.Gender = "Male";
		
		DriversLicense miley = new DriversLicense();
		miley.FirstName = "Miley";
		miley.LastName = "Cyrus";
		miley.BirthDate = "1992,11,23";
		miley.Gender = "Female";
		
		DriversLicense cardi = new DriversLicense();
		cardi.FirstName = "Cardi";
		cardi.LastName = "B";
		cardi.BirthDate = "1992,10,11";
		cardi.Gender = "Female";
		
		System.out.println(ricky.FirstName + " has a Driver's License!");
		System.out.println("Name: " + ricky.getFullName());
		System.out.println("Age: " + ricky.getAge());
		System.out.println();
		
		System.out.println(cardi.FirstName + " has a Driver's License!");
		System.out.println("Name: " + cardi.getFullName());
		System.out.println("Age: " + cardi.getAge());
		System.out.println();
		
		System.out.println(miley.FirstName + " has a Driver's License!");
		System.out.println("Name: " + miley.getFullName());
		System.out.println("Age: " + miley.getAge());
		System.out.println();

		
	}
}
