import java.util.*;

public class CoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking number of customers using variable customer
        System.out.print("Enter the number of customers: ");
        int customer = sc.nextInt();

        final double GST = 0.15;

        // Taking counter variable and initializing it 1 to keep track of number of customers
        int counter = 1;

        // Using while loop to keep track of the customers and taking the order for each customer. As soon as the counter becomes greater than the customer count the loop terminates
        while(counter <= customer) {
            System.out.println("Take the order for customer " + counter);

            // Taking coffee type order from the customer
            System.out.print("Enter the type of coffee (Espresso/Latte/Cappuccino or exit to stop):");
            String typeCoffee = sc.next();

            // To check for exit statement. If exit is entered by the user then loop breaks
            if(typeCoffee.equalsIgnoreCase("exit")){
                System.out.println("Cafe is closed!");
                break;
            }

            // Taking the quantity of coffee orderd by the customer
            System.out.print("Enter the quantity of coffee: ");
            int quantity = sc.nextInt();

            // Making the switch case to display the price of different coffee types ordered by the customer
            double price = 0.0;
            switch(typeCoffee.toUpperCase()) {
                case "ESPRESSO":
                    price = 120;
                    System.out.println("The price for Espresso is INR " + price);
                    break;
                case "LATTE":
                    price = 150;
                    System.out.println("The price for Latte is INR " + price);
                    break;
                case "CAPPUCCINO":
                    price = 180;
                    System.out.println("The price for Cappuccino is INR " + price);
                    break;
                default:
                    System.out.println("Please enter the coffee type again");
                    continue; // Skip incrementing counter to retry for the same customer
            }

            // Finding the original price of the order
            double total = price * quantity;

            // Finding the gst applied to the particular order
            double gst = total * GST;

            // Finding the total bill to be paid
            double totalBill = total + gst;

            System.out.println("Your order amount is INR " + total);
            System.out.println("GST included is INR " + gst);
            System.out.println("The total bill to be paid is INR " + totalBill);
            counter++;
        }
    }
}