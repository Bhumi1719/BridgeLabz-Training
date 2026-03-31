import java.util.Scanner;

public class PaymentGatewayIntegration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPayment Options");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Wallet");

        System.out.print("\nChoose payment method: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter amount: $");
        double amount = sc.nextDouble();
        sc.nextLine();

        PaymentProcessor processor = null;

        switch (choice) {
            case 1:
                System.out.print("Enter UPI ID: ");
                String upiId = sc.next();
                processor = new UPIProcessor(upiId);
                break;
            case 2:
                System.out.print("Enter Credit Card Number: ");
                String cardNumber = sc.next();
                processor = new CreditCardProcessor(cardNumber);
                break;
            case 3:
                System.out.print("Enter Wallet Name: ");
                String walletName = sc.next();
                processor = new WalletProcessor(walletName);
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        processor.pay(amount);

        System.out.print("Do you want to refund this amount? (yes/no): ");
        String refundChoice = sc.next();

        if(refundChoice.equalsIgnoreCase("yes")) {
            processor.refund(amount);
        }
    }
}