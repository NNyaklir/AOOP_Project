
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
    public Credit() {

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
        double reverseC = -c;
        double over = balance - reverseC;
        if (!(over > maxCredit)) {
            balance -= c;
        } else {
            System.out.println("Insufficient funds for charge/withdrawal");
        }
    }

    public void deposit(double d) {
        balance += d;
    }

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

    public void displayInformation() {
        System.out.println("---------------------------------------");
        System.out.println(customer.getNameFirst() + " " + customer.getNameLast() + "'s Information");
        System.out.println("Account " + accountNumber + " has a balance of " + balance + ".");
        System.out.println("---------------------------------------");
    }

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
