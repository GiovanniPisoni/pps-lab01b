package e1.decorator;

import e1.API.BankAccount;

public class CanWithdrawDecorator extends BankAccountDecorator{

    public CanWithdrawDecorator(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
