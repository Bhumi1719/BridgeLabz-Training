import java.util.Scanner;

// Creating a class with attributes
class Device {
    String deviceId;
    String status;

    // Creating a constructor of the class
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Creating a method to display the status of the device
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Creating a subclass with attributes
class Thermostat extends Device {
    double temperatureSetting;

    // Creating a constructor using super keyword
    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    // Creating a method to display the status of the device
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + " °C");
    }
}

public class SmartHomeDevice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Device ID: ");
        String deviceId = sc.nextLine();

        System.out.print("Enter Device Status (ON/OFF): ");
        String status = sc.nextLine();

        System.out.print("Enter Temperature Setting: ");
        double temp = sc.nextDouble();

        Thermostat thermostat = new Thermostat(deviceId, status, temp);

        System.out.println("\nDevice Status is");
        thermostat.displayStatus();
	}

}
