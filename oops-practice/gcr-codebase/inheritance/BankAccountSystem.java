import java.util.Scanner;

// Creating a super class named bankaccount with attributes
class BankAccount {
    String accountNumber;
    double balance;

    // Creating a constructor of the class
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Creating a method to display the type of account
    void displayAccountType() {
        System.out.println("Account Type: Bank Account");
    }

    // Creating a method to display the details
    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Creating a subclass savingsaccount with attributes
class SavingsAccount extends BankAccount {
    double interestRate;

    // Creating a constructor using super keyword
    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Creating a method to display the account type
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }

    // Creating a method to display the details
    void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Creating a subclass named checkingaccount with attributes
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    // Creating a constructor using super keyword 
    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    // Creating a method to display the account type
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }

    // Creating a method to display the details
    void displayDetails() {
        super.displayDetails();
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}

// Creating a subclass named fixeddepositaccount with attributes
class FixedDepositAccount extends BankAccount {
    int tenure;

    // Creating a constructor using super keyword
    FixedDepositAccount(String accountNumber, double balance, int tenure) {
        super(accountNumber, balance);
        this.tenure = tenure;
    }

    // Creating a method to display the account type
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }

    // Creating a method to display the details
    void displayDetails() {
        super.displayDetails();
        System.out.println("Tenure: " + tenure + " months");
    }
}

public class BankAccountSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        System.out.println("3. Fixed Deposit Account");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

        BankAccount account;

        if (choice == 1) {
            System.out.print("Enter Interest Rate (%): ");
            double rate = sc.nextDouble();
            account = new SavingsAccount(accNo, balance, rate);

        } else if (choice == 2) {
            System.out.print("Enter Withdrawal Limit: ");
            double limit = sc.nextDouble();
            account = new CheckingAccount(accNo, balance, limit);

        } else if (choice == 3) {
            System.out.print("Enter Tenure (months): ");
            int tenure = sc.nextInt();
            account = new FixedDepositAccount(accNo, balance, tenure);

        } else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        System.out.println("\nAccount Details");
        account.displayAccountType();
        account.displayDetails();
	}

}
