package e1.factory;

import e1.API.BankAccount;
import e1.API.BankAccountFactory;
import e1.CoreBankAccount;
import e1.decorator.CanWithdrawWithOverdraftDecorator;
import e1.decorator.FeeDecorator;

public class BankAccountFactoryImpl implements BankAccountFactory {

    private static final int SILVER_FEE = 1;
    private static final int SILVER_OVERDRAFT = 0;
    private static final int GOLD_FEE = 0;
    private static final int GOLD_OVERDRAFT = 500;


    @Override
    public BankAccount createSilverBankAccount() {
        return new CanWithdrawWithOverdraftDecorator(SILVER_OVERDRAFT, new FeeDecorator(SILVER_FEE, new CoreBankAccount()));
    }

    public BankAccount createGoldBankAccount() {
        return new CanWithdrawWithOverdraftDecorator(GOLD_OVERDRAFT, new FeeDecorator(GOLD_FEE, new CoreBankAccount()));
    }
}
