import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {

		System.out.println("Hello world!");
		System.out.println("Hola, me llamo Ryan, y tu?");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		System.out.println("¡Mucho Gusto! ¿Que Paso " + input + "?");
		reader.close();
	}

}
