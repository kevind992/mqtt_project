package ie.mqtt.java;

import org.eclipse.paho.client.mqttv3.MqttException;

public class Runner {
	public static void main(String[] args) {
		Client client = new Client("Hello Shane");
		
		try {
			client.Connect();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
