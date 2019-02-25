import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGuessGame {
	
	public static ArrayList<String> words;
	public static String word;
	public static String correctLetters = "";
	public static String lettersGuessed = "";
	public static boolean gameStarted;

	public static void main(String[] args) {
		
		getWords();
		
		setRandomWord();
		
		gameStarted = true; 		
		
		System.out.println("Guess the below word! You may use upper or lowercase letters, one at a time.");
		
		Scanner s = new Scanner(System.in);		
		
		int correctLettersNow = 0; //keep track for displaying when complete
		while(gameStarted) {			
			displayWord(word);
			getUserInput(s);
			if(correctLetters.length() > correctLettersNow) {
				correctLettersNow++;
				System.out.println("You guessed a correct letter!");
				displayWord(word);				
			}
			if(gameStarted) {
				System.out.println("So far you've guessed " + lettersGuessed);
				System.out.println("Guess another letter!");
			}
		}		
		
		System.out.println("Congratulatoins, you completed the word!");
		
		s.close();
						
	}
	
	//Get and process each letter from the user
	private static void getUserInput(Scanner s) {	
		
		String userGuess = s.next();	
		
		while(!validateUserInput(userGuess)) {
			System.out.println("Please enter a single letter.");
			userGuess = s.next();
		}
		
		userGuess = userGuess.toLowerCase();
		
		lettersGuessed += userGuess;
		if(word.contains(userGuess)) {
			correctLetters += userGuess;			
		}		
	}
	
	public static boolean validateUserInput(String userGuess) {
		//make sure it is a character    WARNING - SOME words in this dictionary contain hyphens. those instances results in an endless game
		if(userGuess.matches("[a-zA-Z]") && userGuess.length() == 1) {
			return true;
		}		
		return false;
	}

	private static void displayWord(String word) {
		//display current state of word guesses and check for win
		String printWord = "";
		for(int i = 0; i < word.length(); i++) {			
			if(correctLetters.contains(Character.toString(word.charAt(i)))) {
				printWord += Character.toString(word.charAt(i));
			}else {
				printWord += "-";
			}						
		}	
		System.out.println(printWord);
		if(!printWord.contains("-")) {
			gameStarted = false;
		}
	}

	//pick the word for the user to guess
	private static void setRandomWord() {		
		Random randNumGenerator = new Random();
	    int randNum = randNumGenerator.nextInt(words.size());
		word = words.get(randNum).toLowerCase();
	}

	//read in the dictionary
	public static void getWords() {
		Scanner s;
		try {
			s = new Scanner(new File("words.txt"));
			words = new ArrayList<String>();
			while (s.hasNext()){
				words.add(s.next());
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
