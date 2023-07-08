

public abstract class Account{
    protected int accountNumber;
    protected Customer customer;
    protected double balance;

    /** @param n new account number */
    protected void setAccountNumber(int n){
        this.accountNumber=n;
    }

    /**@return the account number */
    protected int getAccountNumber(){
        return accountNumber;
    }

    /** @param customer */
    protected void setCustomer(Customer c){
        this.customer=c;
    }

    /**@return customer */
    protected Customer getCustomer(){
        return customer;
    }
    
    /** @param bal sets initail balance */
    protected void setBalance(double bal){
        this.balance=bal;
    }

    /** @return current balance */ 
    protected double getBalance(){
        return balance;
    }

    /** @param c an amount charged to the balance */
    protected void charge(double c){
        balance-=c;
    }

    /**@param d an amount deposited to account */
    protected void deposit(double d){
        balance+=d;
    }
}