public abstract class Account {
    protected int accNo;
    protected String name;
    protected double balance;

    public Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public abstract double calculateInterest();

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount)
            throw new InsufficientBalanceException("Insufficient balance");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccNo() {
        return accNo;
    }
}
