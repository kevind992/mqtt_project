package ie.mqtt.java;

public class LightOffCommand implements Command {
	
	private Client client;
	
	public LightOffCommand(Client client) {
		this.client = client;
	}
	
	public void execute() {
		System.out.println("Light Off Command");
		client.publish("Off command");	
	}
}
