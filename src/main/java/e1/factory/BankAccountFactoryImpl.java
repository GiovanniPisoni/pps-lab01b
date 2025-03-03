package e1.factory;

import e1.API.BankAccount;
import e1.API.BankAccountFactory;
import e1.CoreBankAccount;
import e1.decorator.CanWithdrawWithOverdraftDecorator;
import e1.decorator.ConditionalFeeDecorator;
import e1.decorator.MandatoryFeeDecorator;

public class BankAccountFactoryImpl implements BankAccountFactory {


    private static final int BRONZE_OVERDRAFT = 0;
    private static final int BRONZE_FEE = 1;
    private static final int BRONZE_LIMIT = 100;
    private static final int SILVER_FEE = 1;
    private static final int SILVER_OVERDRAFT = 0;
    private static final int GOLD_FEE = 0;
    private static final int GOLD_OVERDRAFT = 500;


    @Override
    public BankAccount createBronzeBankAccount() {
        return new CanWithdrawWithOverdraftDecorator(BRONZE_OVERDRAFT,
                 new ConditionalFeeDecorator(BRONZE_FEE,
                         BRONZE_LIMIT,
                         new CoreBankAccount()));
    }

    @Override
    public BankAccount createSilverBankAccount() {
        return new CanWithdrawWithOverdraftDecorator(SILVER_OVERDRAFT,
                 new MandatoryFeeDecorator(SILVER_FEE,
                         new CoreBankAccount()));
    }

    @Override
    public BankAccount createGoldBankAccount() {
        return new CanWithdrawWithOverdraftDecorator(GOLD_OVERDRAFT,
                 new MandatoryFeeDecorator(GOLD_FEE,
                         new CoreBankAccount()));
    }
}
