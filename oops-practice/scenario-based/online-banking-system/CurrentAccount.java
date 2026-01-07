public class CurrentAccount extends Account {
    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return balance * 0.02;
    }
}


