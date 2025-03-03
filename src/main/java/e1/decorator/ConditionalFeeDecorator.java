package e1.decorator;

import e1.API.BankAccount;

public class ConditionalFeeDecorator extends BankAccountDecorator {
    private final int fee;
    private final int withdrawalLimit;

    public ConditionalFeeDecorator(final int fee, final int withdrawalLimit, BankAccount base) {
        super(base);
        this.fee = fee;
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(int amount) {
        if (withdrawalLimit >= amount) {
            super.withdraw(amount + fee);
        } else {
            super.withdraw(amount);
        }
    }
}
