
public interface Account {
    /** A method that sets a given account number*/
    void setAccountNumber(int n);
    /** A method that returns a given account number */
    int getAccountNumber();
    /** A method that set a given Customer */
    void setCustomer(Customer c);
    /** A method that returns a given Customer */
    Customer getCustomer();
    /** A method that sets initial balance */
    void setBalance(double bal);
    /** A method that returns balance */
    double getBalance();
    /** A method that deposits a specified amount into the account */
    void deposit(double d);
    /** A method that charges the account a specified amount */
    void charge(double c);
    /**@param recipient Account to be transferred too
     * @param amount Amount to be deposited
     *Method that transfers funds from account to another */
    void transferTo(Account recipient, double amount);

    /** Method to display account information*/
    void displayInformation(); // Displays customer's information
}
