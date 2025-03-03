package e1.API;

public interface BankAccount {

    /**
     * Return the actual BankAccount balance
     *
     * @return actual balance
     */
    int getBalance();

    /**
     * Deposit the amount on the BankAccount
     *
     * @param amount amount to deposit
     */
    void deposit(int amount);

    /**
     * Withdraw the amount on the BankAccount
     *
     * @param amount amount to withdraw
     */
    void withdraw(int amount);
}
