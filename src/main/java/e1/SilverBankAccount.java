package e1;

import e1.API.BankAccount;

public class SilverBankAccount implements BankAccount {

   private final BankAccount base;

    public SilverBankAccount(final BankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        this.base.withdraw(amount);
    }
}
