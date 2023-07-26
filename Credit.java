/**An implementation of Account, that models bank Credit accounts */
public class Credit implements Account {
    protected int accountNumber;
    protected Customer customer;
    protected double balance;
    protected double maxCredit; // should be a negative double amount that cannot be surpassed

    /** @param maxC max amount of credit in credit account
     * @param bal starting balance
     * constructor for testing only */
    public Credit(double maxC, double bal) {
        this.maxCredit = maxC;
        this.balance = bal;
    }

    /** Default no-args constructor */
    public Credit() { }

    // Implementing methods from the Account interface
    /** A method that sets a given account number*/
    public void setAccountNumber(int n) { this.accountNumber = n; }

    /** A method that returns a given account number, implemented from Account interface */
    public int getAccountNumber() { return accountNumber; }

    /** A method that set a given Customer, implemented from Account interface */
    public void setCustomer(Customer c) { this.customer = c;}

    /** A method that returns a given Customer, implemented from Account interface */
    public Customer getCustomer() { return customer; }

    /** A method that sets initial balance, implemented from Account interface */
    public void setBalance(double bal) { this.balance = bal; }

    /** A method that returns balance, implemented from Account interface */
    public double getBalance() { return balance; }

    /** A method that deposits a specified amount into the account, implemented from Account interface*/
    public void deposit(double d) { balance += d; }

    /** A method that charges the account a specified amount, implemented from Account interface */
    public void charge(double c) {
        double reverseC = -c;
        double over = balance - reverseC;
        if (!(over > maxCredit)) {
            balance -= c;
        } else {
            System.out.println("Insufficient funds for charge/withdrawal");
        }
    }

    /**@param recipient Account to be transferred too
     * @param amount Amount to be deposited
     *Method that transfers funds from account to another, implemented from Account interface */
    public void transferTo(Account recipient, double amount) {
        double maxC = -maxCredit;
        if (amount > maxC) {
            System.out.println("Insufficient funds for transfer");
        } else {
            balance -= amount;
            recipient.deposit(amount);
            int accID1 = this.getAccountNumber();
            int accID2 = recipient.getAccountNumber();
            System.out.println("Successfully transferred " + amount + " from Account:" + accID1 + " to Account:" + accID2);
        }
    }

    /** Method to display account information, implemented from Account interface*/
    public void displayInformation() {
        System.out.println("---------------------------------------");
        System.out.println(customer.getNameFirst() + " " + customer.getNameLast() + "'s Information");
        System.out.println("Account " + accountNumber + " has a balance of " + balance + ".");
        System.out.println("---------------------------------------");
    }

    // Credit Specific Functions

    /** @return current max credit
     * gets max credit */
    public double getMaxCredit() {
        return maxCredit;
    }

    /** @param maxC max credit amount for current
     * sets max credit */
    public void setMaxCredit(double maxC) {
        if (maxC < 0) {
            this.maxCredit = maxC;
        } else if (!(maxC < 0)) {
            maxC = -maxC;
            this.maxCredit = maxC;
        }
    }

    /** @param addlCredit increased credit value
     * increases the max credit limit on account
     */
    public void extendCredit(double addlCredit) {
        try {
            if (balance >= addlCredit && maxCredit > addlCredit) {
                maxCredit = addlCredit;
            }
        } catch (Exception e) {
            System.out.println("Max Credit cannot be extended below current limit");
        }
    }
}
