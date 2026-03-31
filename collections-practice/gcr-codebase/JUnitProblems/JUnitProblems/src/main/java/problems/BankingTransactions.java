package problems;

public class BankingTransactions {

    private double balance;

    public BankingTransactions(double initialBalance) {
        this.balance = initialBalance;
    }

    // For Depositing money
    public void deposit(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    // For Withdrawing money
    public void withdraw(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }

    // For getting current balance
    public double getBalance() {
        return balance;
    }
}
