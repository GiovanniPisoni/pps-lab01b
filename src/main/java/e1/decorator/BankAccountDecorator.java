package e1.decorator;

import e1.API.BankAccount;

public class BankAccountDecorator implements BankAccount {

    private final BankAccount base;

    public BankAccountDecorator(final BankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        base.withdraw(amount);
    }
}
