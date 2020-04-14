package ie.mqtt.java;

public class LightOnCommand implements Command{

	private Client client;
	
	public LightOnCommand(Client client) {
		this.client = client;
	}
	
	public void execute() {
		System.out.println("Light Off Command");
		client.publish("On Command");
	}
}
