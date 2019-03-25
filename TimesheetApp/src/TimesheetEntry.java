import java.time.LocalDateTime;

public class TimesheetEntry {
	//Member variables
	private String projectName;
	private String task;
	private int id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	//Static variables
	private static int NEXTID = 1;
	
	public TimesheetEntry(String myProject, String myTask) {
		projectName = myProject;
		task = myTask;
		startTime = LocalDateTime.now();
		id = NEXTID;
		NEXTID++;
	}
	
	public void updateEndTime(){
		if (endTime == null){
			endTime = LocalDateTime.now();
		}else {
			throw new IllegalArgumentException();
		}
	}

	public String getProjectName() {
		return projectName;
	}

	public String getTask() {
		return task;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

}
