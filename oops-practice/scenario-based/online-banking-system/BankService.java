public interface BankService {
    void createAccount(Account acc);
    Account findAccount(int accNo) throws AccountNotFoundException;
    void transfer(int from, int to, double amount)
            throws InsufficientBalanceException, AccountNotFoundException;
}

