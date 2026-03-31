import java.util.*;

// Creating an interface named Loanable for loan-related operations
interface Loanable {

	// Creating a method to apply for loan
	void applyForLoan();

	// Creating a method to calculate the loan eligibility
	double calculateLoanEligibility();
}

// Creating an abstract class named BankAccount with attributes
abstract class BankAccount {

	// Creating private attributes(Encapsulated)
	private String accountNumber;
	private String holderName;
 
	// Creating a protected attribute(accessible to subclasses)
	protected double balance; 

	// Creating a constructor of the class
	public BankAccount(String accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	// Creating a getter method for account number
	public String getAccountNumber() {
		return accountNumber;
	}

	// Creating a getter method for account holder name
	public String getHolderName() {
		return holderName;
	}

	// Creating a concrete method to deposit money in the account
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Amount deposited: " + amount);
		}
	}

	// Creating a concrete method to withdraw money from the account
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Amount withdrawn: " + amount);
		} else {
			System.out.println("Insufficient balance");
		}
	}

	// Creating an abstract method for interest calculation
	public abstract double calculateInterest();

	// Creating a method to display the details of the account
	public void displayDetails() {
		System.out.println("Account Number is: " + accountNumber);
		System.out.println("Holder Name is: " + holderName);
		System.out.println("Balance is: " + balance);
	}
}

// Creating a subclass named SavingsAccount which is Loanable
class SavingsAccount extends BankAccount implements Loanable {

	// Creating a constructor using super keyword
	public SavingsAccount(String accNo, String name, double balance) {
		super(accNo, name, balance);
	}

	// Creating a method to calculate interest for savings account
	@Override
	public double calculateInterest() {
		return balance * 0.04;
	}

	// Creating a method to apply for loan
	@Override
	public void applyForLoan() {
		System.out.println("Loan applied for Savings Account");
	}

	// Creating a method to calculate loan eligibility
	@Override
	public double calculateLoanEligibility() {
		return balance * 5;
	}
}

// Creating a subclass named CurrentAccount which is Loanable
class CurrentAccount extends BankAccount implements Loanable {
	
	// Creating a constructor using super keyword
	public CurrentAccount(String accNo, String name, double balance) {
		super(accNo, name, balance);
	}

	//Creating a method to calculate interest for savings account
	@Override
	public double calculateInterest() {
		return balance * 0.02;
	}

 	//Creating a method to apply for loan
 	@Override
 	public void applyForLoan() {
 		System.out.println("\nLoan applied for Current Account");
 	}

 	// Creating a method to calculate loan eligibility
 	@Override
 	public double calculateLoanEligibility() {
 		return balance * 3;
 	}
}

public class BankingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner sc = new Scanner(System.in);
        
        // Creating a list of accounts
        List<BankAccount> accounts = new ArrayList<>();

        // Asking the user to enter thenumber of accounts
        System.out.print("Enter number of accounts: ");
        int number = sc.nextInt();
        
        sc.nextLine();

        // Loop for taking account details
        for(int i=0; i<number; i++) {

            System.out.print("\nEnter account type (Savings/Current): ");
            String type = sc.nextLine();
            
            // Condition to check if anything else is entered by user in type field except alphabets
	        if(!type.matches("[a-zA-Z ]+")) {
	        	   System.out.println("Invalid name! Only alphabets are allowed.");
	        	   i--; // For repeating the iteration
	        	   continue;
	        }

            System.out.print("Enter account number: ");
            String accNo = sc.nextLine();

            System.out.print("Enter holder name: ");
            String name = sc.nextLine();
            
            // Condition to check if anything else is entered by user in name field except alphabets
	        if(!name.matches("[a-zA-Z ]+")) {
	        	   System.out.println("Invalid name! Only alphabets are allowed.");
	        	   i--; // For repeating the iteration
	        	   continue;
	        }

            System.out.print("Enter initial balance: ");
            double balance = sc.nextDouble();
            
            sc.nextLine();

            if(type.equalsIgnoreCase("Savings")) {
                accounts.add(new SavingsAccount(accNo, name, balance));
            } else if (type.equalsIgnoreCase("Current")) {
                accounts.add(new CurrentAccount(accNo, name, balance));
            } else {
                System.out.println("Invalid account type");
            }
        }

        // Polymorphism demonstration
        for(BankAccount account : accounts) {

            System.out.println("\nAccount Details");
            System.out.println("________________");
            
            account.displayDetails(); // Calling the method to display the details of account

            System.out.println("Interest: " + account.calculateInterest()); // Calling the method to calculate the interest

            Loanable loan = (Loanable) account;
            loan.applyForLoan();
            System.out.println("Loan Eligibility: " + loan.calculateLoanEligibility());
            System.out.println("----------------------------------");
        }
	}

}
