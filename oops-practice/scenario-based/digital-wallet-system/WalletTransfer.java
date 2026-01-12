public class WalletTransfer implements TransferService {
    @Override
    public void transfer(User from, User to, double amount) throws InsufficientBalanceException {
        from.getWallet().withdraw(amount);
        to.getWallet().addMoney(amount);
        from.getWallet().recordTransfer("WALLET_TO_WALLET_SENT", amount);
        to.getWallet().recordTransfer("WALLET_TO_WALLET_RECEIVED", amount);
    }
}
