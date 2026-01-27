import java.util.Scanner;

public class BankTransactionSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        BankAccount account = new BankAccount(balance);

        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
