package ie.mqtt.java;

import java.util.Scanner;
/**
 * 
 * @author Kevin Delassus
 *
 */
public class Runner {
	public static void main(String[] args) {
		
		
		// HEADER
		System.out.println("===========================================");
		System.out.println("MQTT CLIENT");
		System.out.println("===========================================");
		System.out.println("Select from the following options");
		System.out.println("- 1 : Turn light ON \n- 2 : Turn Light OFF \n- 0 : QUIT");
		System.out.println("===========================================");
		
		// User input
		Scanner scan = new Scanner(System.in);
		int i_Option = scan.nextInt();
		
		Client client = Client.getInstance();
		Executor executor = new Executor();
		Thread thread = new Thread(executor);
		thread.start();
		
		do {
			synchronized (executor) {
				switch (i_Option) {
				case 1: // Light on
					System.out.println("Turning Light On!");
					executor.addCommand(new LightOnCommand(client)); // Added light on command
					break;
				case 2: // Light off
					System.out.println("Turning Light Off!");
					executor.addCommand(new LightOffCommand(client)); // Adding Light off command
					break;
				case 0: // Shutdown
					System.out.println("Shutting Down!");
					executor.addCommand(new ShutdownCommand(client)); // Adding shutdown command
					break;
				default:
					System.out.println("Invalid Option!");
					break;
				}
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

