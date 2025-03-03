package e1;

import e1.API.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {

    public static final int EMPTY_BALANCE = 0;
    public static final int INITIAL_DEPOSIT = 1000;
    public static final int HIGHER_WITHDRAW = 1500;
    public static final int FIRST_WITHDRAW = 200;

    protected BankAccount account;

    protected void depositAndWithdraw(int deposit, int withdraw) {
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(EMPTY_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, this.account.getBalance());
    }
}
