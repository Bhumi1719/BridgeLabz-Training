// Making a class named bank account with attributes in it
class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    // Making a constructor of the class
    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method for displaying the current balance of the account
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    // Method for depositing the money in the account
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        displayBalance(); // Calling the method to display the balance after depositing money
    }

    // Method for withdrawing the money from the account
    void withdraw(double amount) {
        if (amount <= balance) { // Only if sufficient balance exists
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
            displayBalance(); // Calling the method to display the balance after the withdrawal
        } else { // If not sufficient balance
            System.out.println("Insufficient balance");
        }
    }
}

public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Making an object of the class to call it by name
		 BankAccount account = new BankAccount("State of Chennai", "ACC001", 700.0);

	     System.out.println(account.accountHolder); // displaying the name of the accountHolder
	     System.out.println(); // For an extra line

	     account.displayBalance(); // Calling the method to display the current balance
	     account.deposit(200.0); // Calling the method to deposit money
	     account.withdraw(100.0); // Calling method to withdraw the money
	     account.withdraw(1000.0); // Calling the method to again withdraw money
	     
	}

}
