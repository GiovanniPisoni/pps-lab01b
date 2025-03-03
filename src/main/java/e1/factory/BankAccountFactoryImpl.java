package e1.factory;

import e1.API.BankAccount;
import e1.API.BankAccountFactory;
import e1.CoreBankAccount;
import e1.decorator.BankAccountDecorator;
import e1.decorator.CanWithdrawDecorator;
import e1.decorator.FeeDecorator;

public class BankAccountFactoryImpl implements BankAccountFactory {

    private static final int SILVER_FEE = 1;

    @Override
    public BankAccount createSilverBankAccount() {
        return new CanWithdrawDecorator(new FeeDecorator(SILVER_FEE, new CoreBankAccount()));
    }

}
