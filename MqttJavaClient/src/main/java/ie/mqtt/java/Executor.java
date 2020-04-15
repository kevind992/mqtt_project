package ie.mqtt.java;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Kevin Delassus
 * @brief Class Executor contains all the implementation to execute the commands
 * Once a Command has been added to the command list, a worker thread then executes 
 * this command
 */
public class Executor implements Runnable {
	
	// List to store all commands
	private List<Command> commandList = new ArrayList<Command>();
	
	public Executor() {
		
	}
	
    public void addCommand(Command command){
		commandList.add(command); // Adding command to list
		this.notify(); // Notifying thread that there is a new command that needs to be executed
    }
    
    public void run() { // Code which will be run by the thread
    	while(true) {
    		synchronized (this) {
	    		if(!commandList.isEmpty()) {
    				for (Command command : commandList) 
    					command.execute(); // executing all commands
    				commandList.clear();
	    		}
	    		try {
					this.wait(); // once all commands are executed put thread into wait
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    	}
	}
}
