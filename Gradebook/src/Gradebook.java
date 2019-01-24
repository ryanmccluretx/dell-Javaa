import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gradebook {
	

	static Integer numStudents; 
	static Map<String,String> gradeBook = new HashMap<String,String>();
	static Map<String,Double> gradeBookAvg = new HashMap<String,Double>();

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Let's make a studeng Gradebook :-)");
		System.out.println("First, tell me how many students are in your class");
		numStudents = scanner.nextInt();
		scanner.nextLine(); //need to do this to clear the Int input
		
		System.out.println("Great, now, one line at a time, tell me the full name,");
		System.out.println("and list of grades, of each student, separated by a comma, like this:");
		System.out.println("John Doe,98,87,89.5,99,100");
		System.out.println("Jane Doe,100,88,94,100,90");
		
		for(int i=0; i<numStudents; i++) {
			String userInput;
			while(!scanner.hasNext()) {} // wait for each student to be inputed 
			userInput = scanner.nextLine();
			addStudent(userInput);
		}
		
		printStudentsAndAverage();
				
		scanner.close();
	}


	private static void printStudentsAndAverage() {
		System.out.println("Here is the list of students and their current average grades:");
		
		for(Map.Entry<String,Double> entry: gradeBookAvg.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}		
	}


	private static void addStudent(String studentInfo) {		
		String[] studentInfoArray = studentInfo.split(",");
		Double[] studentGrades = new Double[studentInfoArray.length -1]; //this array is one less than the StudentInfoArray because it is the grades minus the student name
		String studentName = studentInfoArray[0];		
		
		String grades = studentInfo.replaceFirst(studentName + ",", ""); //remove the student name from the user inputed comma separated value

		gradeBook.put(studentName, grades);	
		
		//starting for loop at 1 because studentInfoArray[0] is the name, and the rest are the grades
		for(int i=1; i<studentInfoArray.length; i++) {
			studentGrades[i-1] = Double.parseDouble(studentInfoArray[i]);
		}		
				
		gradeBookAvg.put(studentName, getAvg(studentGrades));
	}
	
	public static double getAvg(Double[] grades) {
		double sum = getSum(grades);
		return sum/grades.length;
	}

	public static double getSum(Double[] grades) {
		double currentSum = 0;
		for(int i=0; i<grades.length; i++) {
			currentSum += grades[i];
		}
		return currentSum;
	}
}
