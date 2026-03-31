import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        while(true) {
            System.out.print("\nEnter account type (Savings/Checking) or 'exit' to finish: ");
            String type = sc.next();

            if(type.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter the account number: ");
            String accNumber = sc.next();

            System.out.print("Enter the balance: ");
            double balance = sc.nextDouble();

            BankAccount account;
            if(type.equalsIgnoreCase("Savings")) {
                account = new SavingsAccount(accNumber, balance);
            } else if(type.equalsIgnoreCase("Checking")) {
                account = new CheckingAccount(accNumber, balance);
            } else {
                System.out.println("Invalid account type. Try again.\n");
                continue;
            }

            accounts.add(account);
           
            for (BankAccount acc : accounts) {
            System.out.printf("\n%s (%s) - Fee: %.2f%n",
                    acc.getAccountNumber(),
                    acc instanceof SavingsAccount ? "Savings" : "Checking",
                    acc.calculateFee());
        }
        }
    }
}
