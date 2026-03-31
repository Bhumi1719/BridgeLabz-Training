// Creating a class named bankAccount with attributes
class BankAccountModifier {
    public int accountNumber; // Accessible from anywhere
    protected String accountHolder;  // Accessible within same package or subclass
    private double balance; // Accessible only inside this class

    // Creating a constructor of the class
    BankAccountModifier(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Creating a getter method to access private balance
    public double getBalance() {
        return balance;
    }

    // Creating a setter method to modify private balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// Creating a child class which extends the parent class
class SavingsAccount extends BankAccountModifier {

    // CReating a constructor of the subclass which call the parent class constructor using super keyword
    SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    // Creating method for displaying the account details
    void displayAccountDetails() {
        System.out.println("Account Number is: " + accountNumber);   // public access
        System.out.println("Account Holder is: " + accountHolder);   // protected access
        System.out.println("Balance is INR " + getBalance());          // private via getter method
    }
}
public class BankAccountManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating an object of the class
        SavingsAccount sa = new SavingsAccount(1256, "Bhumika", 60000.0);

        sa.displayAccountDetails(); // Calling method to display the account details

        sa.setBalance(70000.0); // Calling the setter method to modify balance 

        System.out.println(); // For extra line
        sa.displayAccountDetails(); // Again calling the method for displaying updated details
	}

}
