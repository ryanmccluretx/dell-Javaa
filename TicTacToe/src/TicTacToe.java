import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static Boolean humanTeam; //X = false O = true
	static Boolean gameStarted;
	static String scoreBoard[][] = new String[3][3] ;

	public static void main(String[] args) {

		Boolean humanTurn;
		
		for(int i =0; i < 3; i++) {
			for(int j=0; j < 3; j++) {
				scoreBoard[i][j] = " ";
			}				
		}
		
		PrintBoard();		
		
		System.out.println("Let's play Tic-Tac-Toe!");
		
		PickTurns();
		
		while(gameStarted) {
			GetNextMove();
			PlayNextMove();
			CheckForWin();
		}		
		
	}
	
	private static void CheckForWin() {
		if((scoreBoard[0][0].equals(scoreBoard[0][1]) && scoreBoard[0][1].equals(scoreBoard[0][2])) ||
				(scoreBoard[0][0].equals(scoreBoard[1][1]) && scoreBoard[1][1].equals(scoreBoard[2][2])) ||
				(scoreBoard[0][0].equals(scoreBoard[1][0]) && scoreBoard[1][0].equals(scoreBoard[2][0])) ||
				(scoreBoard[0][2].equals(scoreBoard[1][1]) && scoreBoard[1][1].equals(scoreBoard[0][2])) ||
				(scoreBoard[0][1].equals(scoreBoard[1][1]) && scoreBoard[1][1].equals(scoreBoard[2][1])) ||
				(scoreBoard[0][2].equals(scoreBoard[1][2]) && scoreBoard[1][2].equals(scoreBoard[2][2])) ||
				(scoreBoard[1][0].equals(scoreBoard[1][1]) && scoreBoard[1][1].equals(scoreBoard[1][2])) ||
				(scoreBoard[2][0].equals(scoreBoard[2][1]) && scoreBoard[2][1].equals(scoreBoard[2][2]))) {
			System.out.println("We have a Winner!");
			gameStarted = false;
		}		
		
		Boolean catsGame = true;
		for(int i =0; i < 3; i++) {
			for(int j=0; j < 3; j++) {
				if(scoreBoard[i][j] == " ") {
					catsGame = false;
				}				
			}				
		}
		
		if(catsGame) {
			System.out.println("Nobody Wins! :-(");
			gameStarted = false;
		}
	}

	private static void PlayNextMove() {

		int computerMove = new Random().nextInt(10);
		while(!ValidateMove(computerMove)) {
			computerMove = new Random().nextInt(10);
		};	
		
		switch(computerMove) {
		case 1:
			scoreBoard[0][0] = humanTeam ? "X" : "O";
		case 2:
			scoreBoard[0][1] = humanTeam ? "X" : "O";
		case 3:
			scoreBoard[0][2] = humanTeam ? "X" : "O";        	
		case 4:
			scoreBoard[1][0] = humanTeam ? "X" : "O";        	
		case 5:
			scoreBoard[1][1] = humanTeam ? "X" : "O";        	
		case 6:
			scoreBoard[1][2] = humanTeam ? "X" : "O";        	
		case 7:
			scoreBoard[2][0] = humanTeam ? "X" : "O";        	
		case 8:
			scoreBoard[2][1] = humanTeam ? "X" : "O";        	
		case 9:
			scoreBoard[2][2] = humanTeam ? "X" : "O";        	
		}	
		
		PrintBoard();
	}

	public static void GetNextMove() {
		
		Scanner reader = new Scanner(System.in);
		
		int humanMove = -1;		
		
		Boolean validateMove = false;
		
		while(!validateMove) {
			System.out.println("Pick a square!");	
			humanMove = reader.nextInt();		
			validateMove = ValidateMove(humanMove);
		};
				
		switch(humanMove) {
		case 1:
			scoreBoard[0][0] = humanTeam ? "O" : "X";
		case 2:
			scoreBoard[0][1] = humanTeam ? "O" : "X";
		case 3:
			scoreBoard[0][2] = humanTeam ? "O" : "X";        	
		case 4:
			scoreBoard[1][0] = humanTeam ? "O" : "X";        	
		case 5:
			scoreBoard[1][1] = humanTeam ? "O" : "X";        	
		case 6:
			scoreBoard[1][2] = humanTeam ? "O" : "X";        	
		case 7:
			scoreBoard[2][0] = humanTeam ? "O" : "X";        	
		case 8:
			scoreBoard[2][1] = humanTeam ? "O" : "X";        	
		case 9:
			scoreBoard[2][2] = humanTeam ? "O" : "X";        	
		}			
		
		PrintBoard();
		
		reader.close();	
		
	}

	static void PrintBoard() {
		
		System.out.println("1    |2    |3    ");
		System.out.println("  "+"scoreBoard[0][0]"+"  |  "+"scoreBoard[0][1]"+"  |  "+"scoreBoard[0][2]"+"  ");
		System.out.println("_____|_____|_____");
		System.out.println("4    |5    |6    ");
		System.out.println("  "+"scoreBoard[1][0]"+"  |  "+"scoreBoard[1][1]"+"  |  "+"scoreBoard[1][2]"+"  ");
		System.out.println("_____|_____|_____");		
		System.out.println("7    |8    |9    ");
		System.out.println("  "+"scoreBoard[2][0]"+"  |  "+"scoreBoard[2][1]"+"  |  "+"scoreBoard[2][2]"+"  ");
		System.out.println("     |     |     ");
	}
	
	public static void PickTurns() {
	
		Scanner reader = new Scanner(System.in);

		String humanMove = null;
		
		Boolean validInput = false;
		
		while(!validInput) {
			System.out.println("Do you want to be Xs or Os ??");	
			humanMove = reader.next();		
			validInput = ValidateTurnInput(humanMove);
		};		
		
		if(humanMove.equals("X")) {
			humanTeam = false;
		}else {
			humanTeam = true;
		}			
		
		gameStarted = true;
		
		reader.close();	
	}

	public static Boolean ValidateTurnInput(String humanMove) {
		
		if(humanMove.toUpperCase().equals("X") || humanMove.toUpperCase().equals("O")) {
			return true;
		}else {
			return false;
		}		
	}
	
	public static Boolean ValidateMove(int humanMove) {
	
		if(humanMove < 1 || humanMove > 9) {
			return false;
		}else {
			switch(humanMove) {
			case 1:
				if(scoreBoard[0][0] != " ") {
					return false;
				}
			case 2:
				if(scoreBoard[0][1] != " ") {
					return false;
				}
			case 3:				  
				if(scoreBoard[0][2] != " ") {
					return false;
				}
			case 4:				        	
				if(scoreBoard[1][0] != " ") {
					return false;
				}
			case 5:
				if(scoreBoard[1][1] != " ") {
					return false;
				}
			case 6:				    
				if(scoreBoard[1][2] != " ") {
					return false;
				}
			case 7:				  
				if(scoreBoard[2][0] != " ") {
					return false;
				}
			case 8:
				if(scoreBoard[2][1] != " ") {
					return false;
				}
			case 9:
				if(scoreBoard[2][2] != " ") {
					return false;
				}
			}
			return true;
		}		
	}	
}
