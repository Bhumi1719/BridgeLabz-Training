import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private double balance = 0;
    private List<Transaction> transactions = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("ADD", amount));
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount));
    }

    public void recordTransfer(String type, double amount) {
        transactions.add(new Transaction(type, amount));
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
