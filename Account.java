
public interface Account {
    void setAccountNumber(int n); // Sets the account number

    int getAccountNumber(); // Gets the account number

    void setCustomer(Customer c); // Sets the customer

    Customer getCustomer(); // Gets the customer

    void setBalance(double bal); // Sets initial balance

    double getBalance(); // Gets balance

    void charge(double c); // Charges the account the specified amount

    void deposit(double d); // Deposits the specified amount into the account

    void transferTo(Account recipient, double amount); // Transfers the specified amount to the recipient account

    void displayInformation(); // Displays customer's information
}
