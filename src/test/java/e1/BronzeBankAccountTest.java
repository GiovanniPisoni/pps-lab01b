package e1;

import e1.factory.BankAccountFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends AbstractBankAccountTest {

    private static final int NO_OVERLIMIT_WITHDRAW = 200;
    private static final int OVERLIMIT_WITHDRAW = 300;
    private static final short FIRST_EXPECTED_BALANCE = INITIAL_DEPOSIT - NO_OVERLIMIT_WITHDRAW;
    private static final short SECOND_EXPECTED_BALANCE = INITIAL_DEPOSIT - OVERLIMIT_WITHDRAW;

    @BeforeEach
    void init(){
        this.account = new BankAccountFactoryImpl().createBronzeBankAccount();
    }

    @Test
    void testConditionalFeeNoOverlimitWithdraw() {
        this.depositAndWithdraw(INITIAL_DEPOSIT, NO_OVERLIMIT_WITHDRAW);
        assertEquals(FIRST_EXPECTED_BALANCE, this.account.getBalance());
    }

    @Test
    void testConditionalFeeWithOverlimitWithdraw() {
        this.depositAndWithdraw(INITIAL_DEPOSIT, OVERLIMIT_WITHDRAW);
        assertEquals(SECOND_EXPECTED_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(HIGHER_WITHDRAW));
    }

}
