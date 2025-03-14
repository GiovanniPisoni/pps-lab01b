package e1.API;

/**
 * Factory interface for creating different types of BankAccount instances.
 */
public interface BankAccountFactory {

    /**
     * Creates a BronzeBankAccount with the specified fee.
     *
     * @return a new instance of BronzeBankAccount
     */
    BankAccount createBronzeBankAccount();

    /**
     * Creates a SilverBankAccount with the specified fee.
     *
     * @return a new instance of SilverBankAccount
     */
    BankAccount createSilverBankAccount();

    /**
     * Creates a GoldBankAccount with the specified fee.
     *
     * @return a new instance of GoldBankAccount
     */
    BankAccount createGoldBankAccount();

}
