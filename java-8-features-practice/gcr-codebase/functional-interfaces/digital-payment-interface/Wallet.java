public class Wallet implements Payment {
    private String walletName;

    public Wallet(String walletName) {
        this.walletName = walletName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Wallet: " + walletName);
    }
}