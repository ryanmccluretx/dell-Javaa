import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Please input 'Rock', 'Paper', or 'Scissors'");
		boolean correctInput = false;
		String userMove = "";
		while(!correctInput) {
			try {
				userMove = getUserMove(reader.next());
				correctInput = true;
			}
			catch(Exception e) {
				System.out.println("Oops, you need to input 'Rock', 'Paper', or 'Scissors'");
			}
		}		 
		
		String computerMove = getComputerMove();
		System.out.println("You played: " + userMove + ". And I played " + computerMove + ".");
		
		if(userMove == computerMove) {
			System.out.println("Oh no! We have a tie.");
		}
		else {	
			String winner = compute(userMove.toUpperCase(), computerMove.toUpperCase());
			System.out.println(winner + " WINS!");
		}
				
		reader.close();
	}
		
	private static String getUserMove(String userMove) {
		if(!(userMove.equals("Rock") || userMove.equals("Paper") || userMove.equals("Scissors"))) {
			throw new IllegalArgumentException();
		}
		return userMove;
	}

	private static String getComputerMove() {
		Random generator = new Random(); 
		int play = generator.nextInt(3);
		
		switch(play) {
		case 0:
			return "Rock";
		case 1:
			return "Paper";
		case 2:
			return "Scissors";
        default: 
        	return "Ha, Whoops!";		
		}
	}

	public static String compute(String userMove, String computerMove) {
		if(userMove.equals("ROCK") || computerMove.equals("ROCK")) {
			if(userMove.equals("PAPER") || computerMove.equals("PAPER")) {
				return "PAPER";
			}else if(userMove.equals("SCISSORS") || computerMove.equals("SCISSORS")) {
				return "ROCK";
			} 
		}
		if(userMove.equals("PAPER") || computerMove.equals("PAPER")) {
			if(userMove.equals("ROCK") || computerMove.equals("ROCK")) {
				return "PAPER";
			}else if(userMove.equals("SCISSORS") || computerMove.equals("SCISSORS")) {
				return "SCISSORS";
			} 
		}
		if(userMove.equals("SCISSORS") || computerMove.equals("SCISSORS")) {
			if(userMove.equals("ROCK") || computerMove.equals("ROCK")) {
				return "ROCK";
			}else if(userMove.equals("PAPER") || computerMove.equals("PAPER")) {
				return "SCISSORS";
			} 
		}
		return "oops";
	}
}
