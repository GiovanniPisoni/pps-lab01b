package e1;

import e1.factory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends AbstractBankAccountTest {

    private static final int FIRST_WITHDRAW = 200;
    private static final int HIGHER_WITHDRAW = 1200;
    private static final short EXPECTED_BALANCE = INITIAL_DEPOSIT - FIRST_WITHDRAW -1;

    @BeforeEach
    void init(){
        this.account = new BankAccountFactoryImpl().createSilverBankAccount();
    }

    @Test
    public void testCanWithdraw() {
        this.depositAndWithdraw(INITIAL_DEPOSIT, FIRST_WITHDRAW);
        assertEquals(EXPECTED_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(HIGHER_WITHDRAW));
    }

}
