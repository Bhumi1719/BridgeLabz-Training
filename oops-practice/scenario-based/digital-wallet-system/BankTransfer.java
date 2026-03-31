public class BankTransfer implements TransferService {
    @Override
    public void transfer(User from, User to, double amount) throws InsufficientBalanceException {
        from.getWallet().withdraw(amount);
        to.getWallet().addMoney(amount);
        from.getWallet().recordTransfer("BANK_TRANSFER_SENT", amount);
        to.getWallet().recordTransfer("BANK_TRANSFER_RECEIVED", amount);
    }
}
