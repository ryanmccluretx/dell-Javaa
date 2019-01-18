import java.util.Scanner;

public class Statistics {
	
	private static int min;
	private static int max;
	private static int avg;
	private static int sum;
	private static int numElem;
	
	private static int[] numbers;

	public static void main(String args[]) {
		
		Scanner reader = new Scanner(System.in);
		
		Boolean validInput = false;
		System.out.println("Please input a list of numbers from -2,147,483,648 to 2,147,483,647, separated by commas (,)");
		String userNumbers = reader.nextLine();
		createArray(userNumbers);
		
		getMin();
		getMax();
		getNumElem();
		getAvg();
		getSum();
		
		System.out.println("I got your numbers. The minimum is " + min + ".");
		System.out.println("The maximum is " + max + ".");
		System.out.println("The number of elements you sent is" + numElem + ".");
		System.out.println("The average is " + avg + ".");
		System.out.println("The sum of all these numbers is " + sum + ".");
				
		reader.close();		
	}


	private static void createArray(String userNumbers) {
		String[] strNumbers = userNumbers.split(",");
		numbers = new int[strNumbers.length];
		for(int i=0; i<strNumbers.length; i++) {
			numbers[i] = Integer.parseInt(strNumbers[i]);
		}		
		
		numElem = numbers.length;
	}

	public static int getMin() {
		int currentMin = numbers[0];
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] < currentMin) {
				currentMin = numbers[i];
			}
		}
		min = currentMin;
		return min;
	}

	public static int getMax() {
		int currentMax = numbers[0];
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] > currentMax) {
				currentMax = numbers[i];
			}
		}
		max = currentMax;
		return max;
	}

	public static int getAvg() {
		int sum = getSum();
		avg = sum/numbers.length;
		return avg;
	}

	public static int getSum() {
		int currentSum = 0;
		for(int i=0; i<numbers.length; i++) {
			currentSum += numbers[i];
		}
		sum = currentSum;
		return sum;
	}

	public static int getNumElem() {
		numElem = numbers.length;
		return numElem;
	}
}
