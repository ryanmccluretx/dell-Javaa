import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Please input a number");
		int firstNum = reader.nextInt();
		
		System.out.println("Please input another number");
		int secondNum = reader.nextInt();
		
		System.out.println("Now type an operand (+, -, *, /, %)");
		char operand = reader.next().charAt(0);
		
		reader.close();
		
		int result = compute(firstNum, secondNum, operand);
		
		if(result == -1) {
			System.out.println("Oh No! something went wrong");
		}else {
			System.out.println("The answer of " + firstNum + operand + secondNum + " is: " + result);
		}		
	}
		
	public static int compute(int firstNum, int secondNum, char operand) {
		switch (operand) {
		case '+':
			return firstNum + secondNum;
		case '-':
			return firstNum - secondNum;
		case '*':
			return firstNum * secondNum;
		case '/':
			return firstNum / secondNum;
		case '%':
			return firstNum % secondNum;
		default:
			break;
		} 
		return -1;
	}
}
