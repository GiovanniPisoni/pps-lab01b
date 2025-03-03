package e1.API;

/**
 * Factory interface for creating different types of BankAccount instances.
 */
public interface BankAccountFactory {

    /**
     * Creates a SilverBankAccount with the specified fee.
     *
     * @param fee the fee associated with the SilverBankAccount
     * @return a new instance of SilverBankAccount
     */
    BankAccount createSilverBankAccount(int fee);

}
