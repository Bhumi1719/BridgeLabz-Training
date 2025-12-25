import java.util.*;

public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the balance of your card: ");
        double balance = sc.nextDouble();

        while(balance > 0) {
            System.out.print("\nEnter distance in km (or -1 to quit): ");
            int distance = sc.nextInt(); // User input for distance inside the loop until loop terminates

            if(distance == -1) { // Condition for loop to terminate
                break;
            }

            // Using ternary operator to calculate the fare
            double fare = (distance <= 5) ? 10 : (distance <= 10) ? 20 : (distance <= 20) ? 30 : 40;

            // Conditionals for calculating the fare
            if(balance >= fare) {
                balance -= fare;
                System.out.println("Fare deducted from card balance is INR " + fare);
                System.out.println("Remaining balance in the card is INR " + balance);
            } else {
                System.out.println("Insufficient balancein your card. Please recharge it");
                break;
            }
        }
    }
}
