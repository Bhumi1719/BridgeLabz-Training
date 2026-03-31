public class WalletPayment implements Payment {
    private double balance = 2000;

    public void pay(double amount) throws PaymentFailedException {
        if (amount > balance)
            throw new PaymentFailedException("Insufficient wallet balance!");
        balance -= amount;
        System.out.println("Paid INR " + amount + " using Wallet.");
    }
}

