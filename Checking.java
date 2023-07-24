/**A subclass of Account, that models bank checking accounts */
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
    public Checking() {

    }

    // Implementing methods from the Account interface

    public void setAccountNumber(int n) {
        this.accountNumber = n;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setCustomer(Customer c) {
        this.customer = c;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBalance(double bal) {
        this.balance = bal;
    }

    public double getBalance() {
        return balance;
    }

    public void charge(double c) {
        if (balance >= c) {
            balance -= c;
        } else {
            System.out.println("Insufficient funds for charge/withdrawal");
        }
    }

    public void deposit(double d) {
        balance += d;
    }

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

    public void displayInformation() {
        System.out.println("---------------------------------------");
        System.out.println(customer.getNameFirst() + " " + customer.getNameLast() + "'s Information");
        System.out.println("Account " + accountNumber + " has a balance of " + balance + ".");
        System.out.println("---------------------------------------");
    }


}
