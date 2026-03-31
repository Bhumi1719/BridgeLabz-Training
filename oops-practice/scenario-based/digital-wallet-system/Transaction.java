public class Transaction {
    private static int COUNTER = 1;
    private int transactionId;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.transactionId = COUNTER ++;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ID: " + transactionId + " | " + type + " | Amount: " + amount;
    }
}
