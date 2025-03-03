package e1.API;

/**
 * Factory interface for creating different types of BankAccount instances.
 */
public interface BankAccountFactory {

    /**
     * Creates a SilverBankAccount with the specified fee.
     *
     * @return a new instance of SilverBankAccount
     */
    BankAccount createSilverBankAccount();

}
