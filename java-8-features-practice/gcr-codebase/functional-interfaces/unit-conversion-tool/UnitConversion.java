import java.util.Scanner;

public class UnitConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double value;

        do {
            System.out.println("\nUnit Conversion Menu");
            System.out.println("1. Kilometers to Miles");
            System.out.println("2. Miles to Kilometers");
            System.out.println("3. Kilograms to Pounds");
            System.out.println("4. Pounds to Kilograms");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            if(choice == 5) {
                System.out.println("Exited");
                break;
            }

            System.out.print("Enter value: ");
            value = sc.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println(value + " km = " + UnitConverter.kmToMiles(value) + " miles");
                    break;
                case 2:
                    System.out.println(value + " miles = " + UnitConverter.milesToKm(value) + " km");
                    break;
                case 3:
                    System.out.println(value + " kg = " + UnitConverter.kgToLbs(value) + " lbs");
                    break;
                case 4:
                    System.out.println(value + " lbs = " + UnitConverter.lbsToKg(value) + " kg");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}