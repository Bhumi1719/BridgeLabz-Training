import java.util.*;

public class BankManager {

    private Map<Integer, Double> accountMap = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Method to add new account
    public void addAccount(int accNo, double balance) {
        accountMap.put(accNo, balance);
        System.out.println("Account added successfully!");
    }

    // Method to request a withdrawal
    public void requestWithdrawal(int accNo, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accNo, amount));
        System.out.println("Withdrawal request added to queue");
    }

    // Method to process all withdrawal requests
    public void processWithdrawals() {
        while(!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();

            int accNo = req.getAccountNumber();
            double amount = req.getAmount();

            if(!accountMap.containsKey(accNo)) {
                System.out.println("Account not found: " + accNo);
                continue;
            }

            double balance = accountMap.get(accNo);
            if(balance >= amount) {
                accountMap.put(accNo, balance - amount);
                System.out.println("Withdrawal successful from Account " + accNo);
            } else {
                System.out.println("Insufficient balance in Account " + accNo);
            }
        }
    }

    // Method to display accounts sorted by balance
    public void displaySortedByBalance() {
        TreeMap<Double, List<Integer>> sortedMap = new TreeMap<>();

        for(Map.Entry<Integer, Double> entry : accountMap.entrySet()) {
            sortedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println("\nAccounts Sorted by Balance:");
        for(Map.Entry<Double, List<Integer>> entry : sortedMap.entrySet()) {
            for(int accNo : entry.getValue()) {
                System.out.println("Account: " + accNo + " | Balance: " + entry.getKey());
            }
        }
    }

    // Method to display all accounts
    public void displayAllAccounts() {
        System.out.println("\nAll Accounts:");
        for(Map.Entry<Integer, Double> entry : accountMap.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " | Balance: " + entry.getValue());
        }
    }
}
