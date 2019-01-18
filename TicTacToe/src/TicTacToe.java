import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static Boolean humanTeam; //X = false O = true
	static Boolean gameStarted;
	static String scoreBoard[][] = new String[3][3] ;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i =0; i < 3; i++) {
			for(int j=0; j < 3; j++) {
				scoreBoard[i][j] = " ";
			}				
		}
		
		PrintBoard();		
		
		System.out.println("Let's play Tic-Tac-Toe!");
		
		PickTurns(scanner);
		
		while(gameStarted) {
			GetNextMove(scanner);
			CheckForWin();
			PlayNextMove();
			CheckForWin();
		}		
		
		scanner.close();
	}
	
	private static void CheckForWin() {
		if((scoreBoard[0][0].equals(scoreBoard[0][1]) && scoreBoard[0][1].equals(scoreBoard[0][2]) && !scoreBoard[0][2].equals(" ")) ||
				(scoreBoard[0][0].equals(scoreBoard[1][1]) && scoreBoard[1][1].equals(scoreBoard[2][2]) && !scoreBoard[2][2].equals(" ")) ||
				(scoreBoard[0][0].equals(scoreBoard[1][0]) && scoreBoard[1][0].equals(scoreBoard[2][0]) && !scoreBoard[2][0].equals(" ")) ||
				(scoreBoard[0][2].equals(scoreBoard[1][1]) && scoreBoard[1][1].equals(scoreBoard[0][2]) && !scoreBoard[0][2].equals(" ")) ||
				(scoreBoard[0][1].equals(scoreBoard[1][1]) && scoreBoard[1][1].equals(scoreBoard[2][1]) && !scoreBoard[2][1].equals(" ")) ||
				(scoreBoard[0][2].equals(scoreBoard[1][2]) && scoreBoard[1][2].equals(scoreBoard[2][2]) && !scoreBoard[2][2].equals(" ")) ||
				(scoreBoard[1][0].equals(scoreBoard[1][1]) && scoreBoard[1][1].equals(scoreBoard[1][2]) && !scoreBoard[1][2].equals(" ")) ||
				(scoreBoard[2][0].equals(scoreBoard[2][1]) && scoreBoard[2][1].equals(scoreBoard[2][2]) && !scoreBoard[2][2].equals(" "))) {
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
		
		System.out.println("Ok, now it's my turn");
		
		switch(computerMove) {
		case 1:
			scoreBoard[0][0] = humanTeam ? "X" : "O";
			break;
		case 2:
			scoreBoard[0][1] = humanTeam ? "X" : "O";
			break;
		case 3:
			scoreBoard[0][2] = humanTeam ? "X" : "O";       
			break;
		case 4:
			scoreBoard[1][0] = humanTeam ? "X" : "O";  
			break;
		case 5:
			scoreBoard[1][1] = humanTeam ? "X" : "O"; 
			break;
		case 6:
			scoreBoard[1][2] = humanTeam ? "X" : "O";  
			break;
		case 7:
			scoreBoard[2][0] = humanTeam ? "X" : "O";
			break;
		case 8:
			scoreBoard[2][1] = humanTeam ? "X" : "O";
			break;
		case 9:
			scoreBoard[2][2] = humanTeam ? "X" : "O";
			break;
		}	
		
		PrintBoard();
	}

	public static void GetNextMove(Scanner scanner) {
		int humanMove = -1;		
		
		Boolean validateMove = false;
		
		while(!validateMove) {			
			System.out.println("Pick a square!");		      
		        humanMove = scanner.nextInt();							
		  		validateMove = ValidateMove(humanMove);
		};
				
		switch(humanMove) {
		case 1:
			scoreBoard[0][0] = humanTeam ? "O" : "X";
			break;
		case 2:
			scoreBoard[0][1] = humanTeam ? "O" : "X";
			break;
		case 3:
			scoreBoard[0][2] = humanTeam ? "O" : "X";   
			break;
		case 4:
			scoreBoard[1][0] = humanTeam ? "O" : "X";    
			break;
		case 5:
			scoreBoard[1][1] = humanTeam ? "O" : "X";  
			break;
		case 6:
			scoreBoard[1][2] = humanTeam ? "O" : "X";
			break;
		case 7:
			scoreBoard[2][0] = humanTeam ? "O" : "X";   
			break;
		case 8:
			scoreBoard[2][1] = humanTeam ? "O" : "X"; 
			break;
		case 9:
			scoreBoard[2][2] = humanTeam ? "O" : "X";
			break;
		default:
			break;
		}			
		
		PrintBoard();
		
		
	}

	static void PrintBoard() {
		
		System.out.println("1    |2    |3    ");
		System.out.println("  "+scoreBoard[0][0]+"  |  "+scoreBoard[0][1]+"  |  "+scoreBoard[0][2]+"  ");
		System.out.println("_____|_____|_____");
		System.out.println("4    |5    |6    ");
		System.out.println("  "+scoreBoard[1][0]+"  |  "+scoreBoard[1][1]+"  |  "+scoreBoard[1][2]+"  ");
		System.out.println("_____|_____|_____");		
		System.out.println("7    |8    |9    ");
		System.out.println("  "+scoreBoard[2][0]+"  |  "+scoreBoard[2][1]+"  |  "+scoreBoard[2][2]+"  ");
		System.out.println("     |     |     ");
	}
	
	public static void PickTurns(Scanner scanner) {
	
		String humanMove = null;
		
		Boolean validInput = false;
		
		while(!validInput) {
			System.out.println("Do you want to be Xs or Os ??");	
			humanMove = scanner.next();		
			validInput = ValidateTurnInput(humanMove);
		};		
		
		if(humanMove.equals("X")) {
			humanTeam = false;
		}else {
			humanTeam = true;
		}			
		
		gameStarted = true;
		
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
				break;
			case 2:
				if(scoreBoard[0][1] != " ") {
					return false;
				}
				break;
			case 3:				  
				if(scoreBoard[0][2] != " ") {
					return false;
				}
				break;
			case 4:				        	
				if(scoreBoard[1][0] != " ") {
					return false;
				}
				break;
			case 5:
				if(scoreBoard[1][1] != " ") {
					return false;
				}
				break;
			case 6:				    
				if(scoreBoard[1][2] != " ") {
					return false;
				}
				break;
			case 7:				  
				if(scoreBoard[2][0] != " ") {
					return false;
				}
				break;
			case 8:
				if(scoreBoard[2][1] != " ") {
					return false;
				}
				break;
			case 9:
				if(scoreBoard[2][2] != " ") {
					return false;
				}
				break;
			}
			return true;
		}		
	}	
}
