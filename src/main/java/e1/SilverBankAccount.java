package e1;

import e1.API.BankAccount;

public class SilverBankAccount implements BankAccount {

   private final CoreBankAccount base;

    public SilverBankAccount(final CoreBankAccount base) {
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
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + 1);
    }
}
