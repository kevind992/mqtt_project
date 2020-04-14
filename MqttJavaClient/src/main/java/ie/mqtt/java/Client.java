package ie.mqtt.java;

import javax.swing.text.StyleContext.SmallAttributeSet;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Client {
	
	private String msg;
	private MqttClient client;
	
	
	public Client(String msg) {
		this.msg = msg;
	}
	
	public void Connect() throws MqttException {
		client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
		client.setCallback(new CallBack());
		client.connect();
		MqttMessage message = new MqttMessage();
		message.setPayload(msg.getBytes());
		client.publish("iot_data", message);
		client.disconnect();
	}
	
}
