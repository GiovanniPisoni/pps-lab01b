package e1.decorator;

import e1.API.BankAccount;

public class MandatoryFeeDecorator extends BankAccountDecorator {
    private final int fee;

    public MandatoryFeeDecorator(final int fee, BankAccount base) {
        super(base);
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        super.withdraw(amount + fee);
    }
}
