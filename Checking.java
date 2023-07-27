/**An implementation of Account, that models bank Checking accounts */
public class Checking implements Account {
    protected int accountNumber;
    protected Customer customer;
    protected double balance;
    protected double interestRate; // The interest rate for the savings account

    /** @param accNum the account number for the savings account
     * @param cust the customer associated with the savings account
     * @param bal the starting balance for the savings account
     * @param rate the interest rate for the savings account
     * Constructor for the Saving class */
    public Checking(int accNum, Customer cust, double bal, double rate) {
        this.accountNumber = accNum;
        this.customer = cust;
        this.balance = bal;
        this.interestRate = rate;
    }

    /** Default no-args constructor */
    public Checking() { }

    // Implementing methods from the Account interface
    /** A method that sets a given account number, implemented from Account interface*/
    public void setAccountNumber(int n) { this.accountNumber = n; }

    /** A method that returns a given account number, implemented from Account interface */
    public int getAccountNumber() {
        return accountNumber;
    }

    /** A method that set a given Customer, implemented from Account interface */
    public void setCustomer(Customer c) {
        this.customer = c;
    }

    /** A method that returns a given Customer, implemented from Account interface */
    public Customer getCustomer() {
        return customer;
    }

    /** A method that sets initial balance, implemented from Account interface */
    public void setBalance(double bal) {
        this.balance = bal;
    }

    /** A method that returns balance, implemented from Account interface */
    public double getBalance() {
        return balance;
    }

    /** A method that deposits a specified amount into the account, implemented from Account interface*/
    public void deposit(double d) {
        balance += d;
    }

    /** A method that charges the account a specified amount, implemented from Account interface */
    public void charge(double c) {
        if (balance >= c) {
            balance -= c;
        } else {
            System.out.println("Insufficient funds for charge/withdrawal");
        }
    }

    /**@param recipient Account to be transferred too
     * @param amount Amount to be deposited
     *Method that transfers funds from account to another, implemented from Account interface */
    public void transferTo(Account recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            int accID1 = this.getAccountNumber();
            int accID2 = recipient.getAccountNumber();
            System.out.println("Successfully transferred " + amount + " from Account:" + accID1 + " to Account:" + accID2);
        } else {
            System.out.println("Insufficient funds for transfer");
        }
    }

    /** Method to display account information, implemented from Account interface*/
    public void displayInformation() {
        System.out.println("---------------------------------------");
        System.out.println(customer.getNameFirst() + " " + customer.getNameLast() + "'s Information");
        System.out.println("Account " + accountNumber + " has a balance of " + balance + ".");
        System.out.println("---------------------------------------");
    }


}
