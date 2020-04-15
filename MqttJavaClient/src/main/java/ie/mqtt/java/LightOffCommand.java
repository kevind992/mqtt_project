package ie.mqtt.java;
/**
 * @author Kevin Delassus
 */
public class LightOffCommand implements Command {
	
	private Client client;
	
	public LightOffCommand(Client client) {
		this.client = client;
	}
	
	public void execute() {
		System.out.println("Light Off Command");
		synchronized (client) {
			client.publish("Off Command");	
		}
		
	}
}
