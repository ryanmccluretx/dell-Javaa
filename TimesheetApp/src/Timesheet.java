import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Timesheet {
	private List<TimesheetEntry> database;
	
	public Timesheet() {
		database = new ArrayList<>();
	}
	
	public void add(String project, String task) {
		database.add(new TimesheetEntry(project, task));
	}
	
	public List<TimesheetEntry> list(boolean activeOnly, String name){
		if(name == null) {
			if(activeOnly) {	
				List<TimesheetEntry> activeEntries = new ArrayList<TimesheetEntry>();			
					for(int i = 0; i < database.size(); i++) {
						TimesheetEntry currentEntry = database.get(i);
						if(currentEntry.getEndTime() == null) {
							activeEntries.add(currentEntry); //If activeOnly is set to true, return a list of all the active (incomplete) TimesheetEntries in the Timesheet
						}
					}			
					return activeEntries;
			}else {
				return database;
			}
		}else {
			List<TimesheetEntry> projectEntries = new ArrayList<TimesheetEntry>();
			for(int i = 0; i < database.size(); i++){
				TimesheetEntry currentEntry = database.get(i);
				if(currentEntry.getProjectName().equals(name)) {
					if(activeOnly) {										
						if(currentEntry.getEndTime() == null) {
							projectEntries.add(currentEntry); //If activeOnly is set to true, return a list of all the active (incomplete) TimesheetEntries in the Timesheet
						}
					} else {
						projectEntries.add(currentEntry);
					}						
				}
			}
			return projectEntries;
		}		
	}
	
	public TimesheetEntry get(int id) {
		
		Iterator<TimesheetEntry> dbIt = database.iterator();		
		for(int i = 0; i < database.size(); i++) {
			TimesheetEntry entry = dbIt.next();
			if(entry.getId() == id) {
				return entry;
			}
		}
		
		//Not Found
		return null;		
	}

	public void delete(TimesheetEntry entry) {		
		database.remove(entry);
	}
	
	public void stop(TimesheetEntry entry) {
		TimesheetEntry entryToStop = get(entry.getId());
		entryToStop.updateEndTime();	
	}
}
