import java.util.Scanner;

public class Controller {
	public static Dao dataAccess;
	public static boolean appActive = true;
	
	public static void main(String[] args) {
		
		dataAccess = new Dao();
		
		System.out.println("Welcome to the ToDo App!");
		System.out.println("You can create ToDoItems, delete them, mark them complete, and view completed, inprogess, or all items");
		System.out.println("Let's start by adding your first to do item. It's ID will be 1. As you add more items, their IDs will increase");
		System.out.println("Enter a description for your first ToDo Item:");
		
		Scanner s = new Scanner(System.in);
		String description = s.nextLine();
		
		ToDoItem firstItem = new ToDoItem(description);
		dataAccess.Add(firstItem);
		System.out.println();
		printDirections();
		
		//MAIN LOOP
		while(appActive) {
			while(!s.hasNextLine()) {}
			processInput(s.nextLine(), s);
			if(appActive) {
				printDirections();
			}
		}
		
		s.close();		
	}
	
	private static void processInput(String userCommand, Scanner s) {
		userCommand = userCommand.toLowerCase();
		if(userCommand.equals("add")){
			System.out.println("Enter a description for your new ToDo Item:");
			while(!s.hasNextLine()) {}
			
			dataAccess.Add(new ToDoItem(s.nextLine()));
		}
		else if(userCommand.equals("delete")) {
			System.out.println("Enter the ID of the ToDo Item you want to delete:");
			while(!s.hasNextLine()) {}
			
			dataAccess.Delete(s.nextInt());
		}
		else if(userCommand.contains("complete")) {
			String[] commandArr = userCommand.split("complete ");
			dataAccess.Update(Integer.parseInt(commandArr[1]));
		}
		else if(userCommand.contains("list all")) {
			dataAccess.List();
		}
		else if(userCommand.contains("list done")) {
			dataAccess.ListState(true);
		}
		else if(userCommand.contains("list pending")) {
			dataAccess.ListState(false);
		}
		else if(userCommand.contains("stop")) {
			appActive = false;
		}		
	}

	public static void printDirections() {
		System.out.println();

		System.out.println("To add more ToDo Items, type 'Add'");
		System.out.println("To mark items complete, type 'Complete X', where X is the ID of the completed item");
		System.out.println("To view a list of your items type 'List All' or 'List Pending' or 'List Done'");
		System.out.println("To delete ToDo Items, type 'Delete X', where X is the ID of the item to delete");
		System.out.println("If you're done #DoingThings, type 'STOP'");
		System.out.println();

		System.out.println("What would you like to do?");
		
		System.out.println();

	}
}
