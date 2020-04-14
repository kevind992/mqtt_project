package ie.mqtt.java;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class Client {
	
	private static Client instance = null;
	private MqttClient client;
	
	private Client() {
		System.out.println("[INFO  ] Setting Mqtt Client..");
		connect();
	}
	
	private void connect() {
		// Attempting to connect with Mqtt broker
		try {
			client = new MqttClient("tcp://192.168.0.100:1883", MqttClient.generateClientId());
			client.setCallback(new CallBack()); // setting callback
			client.connect();
		} catch (MqttException e) {
			System.out.println("[ERROR  ]: " + e);
		}
	}
	
	public void publish(String strCmd) {
		try {
			MqttMessage message = new MqttMessage();
			message.setPayload(strCmd.getBytes());
			client.publish("light_command", message);
			message.clearPayload();
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			client.disconnect();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Client getInstance() {
		if (instance == null)
			instance = new Client();
		return instance;
	}
}
