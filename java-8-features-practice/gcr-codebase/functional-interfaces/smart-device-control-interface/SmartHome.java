import java.util.*;

public class SmartHome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int deviceChoice; 
        int actionChoice;

        do {
            System.out.println("\nSmart Device Available: ");
            System.out.println("1. AC");
            System.out.println("2. TV");
            System.out.println("3. Light");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            deviceChoice = sc.nextInt();

            SmartDevice device = null; 

            switch (deviceChoice) {
                case 1 :
                    device = new AC();
                    break;
                case 2 :
                    device = new TV();
                    break;
                case 3 :
                    device = new Light();
                    break;
                case 4 :
                    System.out.println("Exited");
                    continue;
                default :
                    System.out.println("Invalid choice");
                    continue;
            }

            System.out.println("\nAction to perform: ");
            System.out.println("1. TURN ON");
            System.out.println("2. TURN OFF");

            System.out.print("\nEnter action to perform: ");
            actionChoice = sc.nextInt();

            switch (actionChoice) {
                case 1 :
                    device.turnOn();
                    break;
                case 2 :
                    device.turnOff();
                    break;
                default :
                    System.out.println("Invalid choice");
                    return;
            }
        } while(deviceChoice != 4);
    }
}