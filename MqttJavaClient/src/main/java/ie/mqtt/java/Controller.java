package ie.mqtt.java;

public class Controller {
	
	private Command on;
	private Command off;
	private Command shutdown;
	
	public Controller(Command on, Command off, Command shutdown) {
		this.on = on;
		this.off = off;
		this.shutdown = shutdown;
	}
	
	public void turnOn() {
		on.execute();
	}
	
	public void turnOff() {
		off.execute();
	}
	
	public void shutdown() {
		shutdown.execute();
	}
}
