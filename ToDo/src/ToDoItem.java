
public class ToDoItem {
	public static int nextId = 1;
	private int id;
	private String description;
	private boolean completed;
	
	public ToDoItem(String description) {
		this.description = description;
		this.id = nextId;
		nextId++;		
	}
	
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	

}
