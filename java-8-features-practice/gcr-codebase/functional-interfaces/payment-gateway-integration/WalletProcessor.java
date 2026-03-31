public class WalletProcessor implements PaymentProcessor {
    private String walletName;

    public WalletProcessor(String walletName) {
        this.walletName = walletName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("\nPaid $" + amount + " using Wallet: " + walletName);
    }
}