package ie.mqtt.java;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class CallBack implements MqttCallback{

	public void connectionLost(Throwable cause) {
		System.out.println("Connection to Mqtt broker lost");
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("Message recieved:\n\t" + new String(message.getPayload()));
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
	

}
