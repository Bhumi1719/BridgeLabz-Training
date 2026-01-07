import java.util.*;

public class BankServiceImplementation implements BankService {
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> history = new ArrayList<>();

    public void createAccount(Account acc) {
        accounts.add(acc);
    }

    public Account findAccount(int accNo) throws AccountNotFoundException {
        for (Account a : accounts)
            if (a.getAccNo() == accNo)
                return a;

        throw new AccountNotFoundException("Account not found");
    }

    public synchronized void transfer(int from, int to, double amount)
            throws InsufficientBalanceException, AccountNotFoundException {

        Account sender = findAccount(from);
        Account receiver = findAccount(to);

        sender.withdraw(amount);
        receiver.deposit(amount);

        history.add(new Transaction(from, to, amount));
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions");
            return;
        }
        for (Transaction t : history)
            System.out.println(t);
    }
}
