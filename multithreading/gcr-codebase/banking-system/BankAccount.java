import java.time.LocalDateTime;

public class BankAccount {
    private int balance = 10000;

    // NOT synchronized intentionally to show race condition
    public void withdraw(String customerName, int amount) {

        System.out.println("[" + customerName + "] Attempting to withdraw " + amount);

        if(balance >= amount) {

            // Artificial delay to increase race condition chances
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;

            System.out.println("Transaction successful: " + customerName + ", Amount: " + amount + ", Balance: " + balance + ", Time: " + LocalDateTime.now());
        } else {
            System.out.println("Transaction FAILED: " + customerName + ", Amount: " + amount + ", Balance: " + balance + ", Time: " + LocalDateTime.now());
        }
    }
}