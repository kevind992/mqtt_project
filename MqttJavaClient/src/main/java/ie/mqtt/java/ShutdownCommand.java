package ie.mqtt.java;
/**
 * 
 * @author Kevin Delassus
 *  
 */
public class ShutdownCommand implements Command {

private Client client;
	
	public ShutdownCommand(Client client) {
		this.client = client;
	}
	
	public void execute() {
		client.disconnect();
	}
}
