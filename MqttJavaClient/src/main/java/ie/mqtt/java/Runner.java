package ie.mqtt.java;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		
		
		// HEADER
		System.out.println("===========================================");
		System.out.println("MQTT CLIENT");
		System.out.println("===========================================");
		System.out.println("Select from the following options");
		System.out.println("- 1 : Turn light ON \n- 2 : Turn Light OFF \n- 0 : QUIT");
		System.out.println("===========================================");
		
		Scanner scan = new Scanner(System.in);
		int i_Option = scan.nextInt();
		
		Client client = Client.getInstance();
		Controller controller = new Controller(new LightOnCommand(client), 
				new LightOffCommand(client), 
				new ShutdownCommand(client));
		
		do {
			
			switch (i_Option) {
			case 1: // Light on
				System.out.println("Turning Light On!");
				controller.turnOn();
				break;
			case 2: // Light off
				System.out.println("Turning Light Off!");
				controller.turnOff();
				break;
			case 0: // Shutdown
				System.out.println("Shutting Down!");
				controller.shutdown();
				break;
			default:
				System.out.println("Invalid Option!");
				break;
			}
			
			// HEADER
			System.out.println("===========================================");
			System.out.println("Select from the following options");
			System.out.println("- 1 : Turn light ON \n- 2 : Turn Light OFF \n- 0 : QUIT");
			System.out.println("===========================================");
			i_Option = scan.nextInt();
			
		} while (i_Option != 0);
		
		System.out.println("Good-bye!");
		
		scan.close();
	}
}

