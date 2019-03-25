import java.util.List;

public class Controller {

	/* Member variables */
	
    Timesheet timesheet;
    ConsoleUtils consoleUtils;
    
    /* Constructor */
    
    public Controller(){
        this.timesheet = new Timesheet();
        this.consoleUtils = new ConsoleUtils();
    }
    
    /* Methods */

	/*
	 * Runs the program
	 */
    public void start() {

        consoleUtils.printHelp(); // Print the action menu

        boolean quit = false;
        while(!quit) {

			// Prompt the user for input, collect input, parse into parts
            String input = consoleUtils.promptString("> ");
            String[] actionParts = input.split(" ");
            String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
            if (action.equals("add")) {

                processAddAction();

            } else if (action.equals("delete")) {

                processDeleteAction(actionParts);

            } else if (action.equals("stop")) {

                processStopAction(actionParts);

            } else if (action.equals("list")) {

                processListAction(actionParts);

            } else if (action.equals("quit")) {
            	
            	consoleUtils.info("Game Over :)");

                quit = true;

            } else if (action.equals("help")) {
            	
            	consoleUtils.info("Let me help you!");

            	consoleUtils.printHelp(); // Print the action menu
            	
            } else if(action.length() ==0 ){
            
                // do nothing.
                
            } else {
            
                consoleUtils.error("Invalid Action");
                
            }
        }

    }

	/*
	 * The user requested that a given TimesheetEntry be stopped (marked as complete)
	 * This method conveys that request to the Timesheet
	 */
    public void processStopAction(String[] actionParts){

        if(actionParts.length > 2){
            consoleUtils.error("Too many inputs to stop command");
            return;
        }else if(actionParts.length == 1) {
        	consoleUtils.error("Stop command requires a valid Integer ID");
            return;
        }

        int id = Integer.parseInt(actionParts[1]);
        
        try {        	
        	timesheet.stop(timesheet.get(id));
        	consoleUtils.info("Stopped ID:" + id);
        }catch(Exception e) {
        	consoleUtils.error("This task has already been stopped!");
		}		
    }

	/*
	 * The user requested that a given TimesheetEntry be deleted
	 * This method conveys that request to the Timesheet
	 */
    public void processDeleteAction(String[] actionParts){

        if(actionParts.length > 2){
            consoleUtils.error("Too many inputs to delete command");
            return;
        }

        int id = Integer.parseInt(actionParts[1]);
		
        timesheet.delete(timesheet.get(id));
        
        consoleUtils.info("Deleted ID:" + id);
    }

	/*
	 * The user wants to view a list of timesheet entries
	 * This method conveys that request to the Timesheet,
	 * along with any special options (active-only, filter by project name)
	 */
    public void processListAction(String[] actionParts){
    
        if(actionParts.length > 3){
            consoleUtils.error("Too many inputs to list command");
            return;
        }
        
        consoleUtils.info("Here's the list!");
		
        //print out the list of entries
        if(actionParts.length == 1) { 
        	consoleUtils.printList(timesheet.list(false, null));
        }else {
        	if(actionParts.length == 2) {
        		if(actionParts[1].equals("-a")) {
                	consoleUtils.printList(timesheet.list(true, null)); // list -a
            	}else{
            		consoleUtils.printList(timesheet.list(false, actionParts[1])); // list PROJECT
            	}
        	}
        	if(actionParts.length == 3){
        		if(actionParts[1].equals("-a")) {
        			consoleUtils.printList(timesheet.list(true, actionParts[2])); // list -a PROJECT
        		} else if(actionParts[2].equals("-a")) {
        			consoleUtils.printList(timesheet.list(true, actionParts[1])); // list PROJECT -a
        		}
        	}        
        	
        }	        
    }

	/*
	 * The user wants to add a new entry to the Timesheet
	 * This method conveys that request to the Timesheet, along with
	 * the specified project name and task description 
	 */
    public void processAddAction(){
    
        String project = consoleUtils.promptString("Project Name (one word only):");
        String description = consoleUtils.promptString("Task:");
        
        if(project.isEmpty()){
        	consoleUtils.error("A Project is required!");
        	return;
        }
        
        if(description.isEmpty()) {
        	consoleUtils.error("A Task is required!");
        	return;
        }

		timesheet.add(project, description);
		
		consoleUtils.info("Added " + description + " to Project " + project);
    }
}