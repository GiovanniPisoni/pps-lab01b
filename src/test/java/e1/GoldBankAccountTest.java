package e1;

import e1.factory.BankAccountFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends AbstractBankAccountTest{

    private static final short EXPECTED_BALANCE = INITIAL_DEPOSIT - FIRST_WITHDRAW;

    @BeforeEach
    void init(){
        this.account = new BankAccountFactoryImpl().createGoldBankAccount();;
    }

    @Test
    public void testCanWithdraw() {
        this.depositAndWithdraw(INITIAL_DEPOSIT, FIRST_WITHDRAW);
        assertEquals(EXPECTED_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithOverdraft(){
        this.depositAndWithdraw(INITIAL_DEPOSIT, HIGHER_WITHDRAW);
        assertEquals(INITIAL_DEPOSIT-HIGHER_WITHDRAW, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanOverdraft(){
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(HIGHER_WITHDRAW+1));
    }

}
