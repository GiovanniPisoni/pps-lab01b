package e1.decorator;

import e1.API.BankAccount;

public class FeeDecorator extends BankAccountDecorator {
    private final int fee;

    public FeeDecorator(BankAccount base, final int fee) {
        super(base);
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        super.withdraw(amount + fee);
    }
}
