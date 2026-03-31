import java.util.Scanner;

public class DigitalPaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double amount = 0.0;

        do {
            System.out.println("\nSelect Payment Method");
            System.out.println("1. UPI");
            System.out.println("2. Credit Card");
            System.out.println("3. Wallet");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            Payment payment = null;

            switch (choice) {
                case 1 :
                    sc.nextLine(); // consume newline
                    System.out.print("Enter UPI ID: ");
                    String upiId = sc.nextLine();

                    System.out.print("Enter amount to pay: $");
                    amount = sc.nextDouble();

                    payment = new UPI(upiId);
                    break;
                case 2 :
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Credit Card Number: ");
                    String cardNumber = sc.nextLine();

                    System.out.print("Enter amount to pay: $");
                    amount = sc.nextDouble();

                    payment = new CreditCard(cardNumber);
                    break;
                case 3 :
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Wallet Name: ");
                    String walletName = sc.nextLine();

                    System.out.print("Enter amount to pay: $");
                    amount = sc.nextDouble();

                    payment = new Wallet(walletName);
                    break;
                case 4 :
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            if(payment != null) {
                payment.pay(amount);
            }

        } while (choice != 4);

    }
}