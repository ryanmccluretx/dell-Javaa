import java.util.ArrayList;

public class Dao {
	public ArrayList<ToDoItem> toDoItems = new ArrayList<ToDoItem>();
	
	
	public void Update(int id) {		
		ToDoItem updateItem = toDoItems.get(id);
		updateItem.setCompleted(true);
		toDoItems.set(id,  updateItem);
	}
	
	public void Add(ToDoItem item) {
		toDoItems.add(item);
		System.out.println("Congratulations! you added ToDo Item with ID " + item.getId() + " and description " + item.getDescription() + ".");
	}
	
	public void Delete(int id) {
		toDoItems.remove(id);
		System.out.println("You have deleted added ToDo Item with ID " + id + ".");
	}
	
	public void List() {
		for(ToDoItem itm : toDoItems){
			printItemStatus(itm);			
		}		
	}
	
	public void ListState(boolean completed) {
		for(ToDoItem itm : toDoItems){
			if(completed && itm.isCompleted()) {
				printItemStatus(itm);			
			}else if(!completed && !itm.isCompleted()){
				printItemStatus(itm);			
			}
		}		
	}
	
	private void printItemStatus(ToDoItem itm) {
		System.out.println("ToDo Item " + itm.getId() + ": " + itm.getDescription() + " " + (itm.isCompleted() ? "COMPLETED." : "IN-PROGRESS."));
	}
}
