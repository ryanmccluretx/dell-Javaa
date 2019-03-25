
public class Fib {

	public int addNumbers(int numOne, int numTwo) {
		return numOne + numTwo;
	}
	
	public static void main(String[] args) {
		recursiveFib(5);
	}
	
	public static int recursiveFib(int index) {
		if(index == 0 || index == 1) {
			return 1;
		}		
		return(recursiveFib(index-1) + recursiveFib(index-2));		
	}
}
