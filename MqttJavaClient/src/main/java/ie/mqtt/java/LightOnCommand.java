package ie.mqtt.java;
/**
 * 
 * @author Kevin Delassus
 *
 */
public class LightOnCommand implements Command{

	private Client client;
	
	public LightOnCommand(Client client) {
		this.client = client;
	}
	
	public void execute() {
		System.out.println("Light Off Command");
		synchronized (client) {
			client.publish("On Command");
		}
		
	}
}
