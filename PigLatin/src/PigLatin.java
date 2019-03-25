import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Please input an English word");
		String userInput = reader.next();
		
		String pigLatin = convertWord(userInput);
		System.out.println("Your word in Pig Latin is: " + pigLatin + ".");
				
		reader.close();
	}
	
	public static String convertWord(String userInput) {
		
		String lowerCase = userInput.toLowerCase();
		//check if vowel exists
		if((lowerCase.indexOf('a') == -1) &&
				(lowerCase.indexOf('e') == -1) &&
				(lowerCase.indexOf('i') == -1) &&
				(lowerCase.indexOf('o') == -1) &&
				(lowerCase.indexOf('u') == -1) &&
				(lowerCase.indexOf('y') == -1)) {
			return lowerCase+"ay";
		}else if(lowerCase.startsWith("a") ||
				lowerCase.startsWith("e") ||
				lowerCase.startsWith("i") ||
				lowerCase.startsWith("o") ||
				lowerCase.startsWith("u") ||
				lowerCase.startsWith("y")) {
			return lowerCase+"yay";			
		}else {
			int firstVowelIdx = -1;
			for(int i = 0; i < lowerCase.length(); i++) {
				if(lowerCase.charAt(i) == 'a' ||
						lowerCase.charAt(i) == 'e' ||
						lowerCase.charAt(i) == 'i' ||
						lowerCase.charAt(i) == 'o' ||
						lowerCase.charAt(i) == 'u' ||
						lowerCase.charAt(i) == 'y') {
					firstVowelIdx = i;
					i = lowerCase.length() -1; //so it breaks out of loop
				}
			}
			String moveToEnd = lowerCase.substring(0, firstVowelIdx);
			String newBeginning = lowerCase.replaceFirst(moveToEnd, "");
			return newBeginning+moveToEnd+"ay";
		}	
	}	
}
