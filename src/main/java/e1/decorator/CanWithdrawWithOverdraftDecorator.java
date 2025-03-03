package e1.decorator;

import e1.API.BankAccount;

public class CanWithdrawWithOverdraftDecorator extends BankAccountDecorator{
    private final int overdraftLimit;

    public CanWithdrawWithOverdraftDecorator(final int overdraftLimit, BankAccount base) {
        super(base);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() + this.overdraftLimit < amount){
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
