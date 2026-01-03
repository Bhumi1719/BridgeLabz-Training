import java.util.Scanner;

// Creating a class named BankAccount with attributes
class BankAccount {
    String accountNumber;
    double balance;

    // Creating a constructor of the class
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Creating a method to deposit the amount
    void deposit(double amount) {
        if (amount > 0) { // Condition to check if amount is greater than 0
            balance += amount;
            System.out.println("Deposit Successful. \nAmount Deposited: " + amount);
        } else { // If amount is not greater than 0
            System.out.println("Invalid deposit amount.");
        }
    }

    // Creating a method to withdraw the amount from the bank
    void withdraw(double amount) {
        if (amount <= 0) { // Checking if amount is less than 1
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) { // Checking if withdrawing amount is greater than the amount present in bank
            System.out.println("Withdrawal Failed: \nInsufficient balance.");
        } else { // If none of the above conditions execute
            balance -= amount;
            System.out.println("Withdrawal Successful. \nAmount Withdrawn: " + amount);
        }
    }
 
    // Creating a method to check the current amount present in the bank
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class BankManager {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNo = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(accountNo, initialBalance);

        System.out.println();

        System.out.print("Enter deposit amount: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        System.out.println();
        
        System.out.print("Enter withdrawal amount: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);

        System.out.println();
        account.checkBalance();
	}

}
