package problemsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import problems.BankingTransactions;

public class BankingTransactionsTest {

    private BankingTransactions account;

    @BeforeEach
    void setUp() {
        account = new BankingTransactions(1000.0);
    }

    @Test
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void testWithdraw() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Exception exception = assertThrows(
                IllegalStateException.class,
                () -> account.withdraw(2000.0)
        );

        assertEquals("Insufficient balance", exception.getMessage());
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void testInvalidDeposit() { // For invalid deposit
        assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-100)
        );
    }

    @Test
    void testInvalidWithdraw() { // For invalid withdrawal
        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(0)
        );
    }
}

