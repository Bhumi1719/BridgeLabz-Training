public class Transaction {
    int from, to;
    double amount;

    public Transaction(int from, int to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String toString() {
        return "From " + from + " To " + to + " Amount: " + amount;
    }
}


