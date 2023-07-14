
/** A super class for many child classes. Represents a theoretical bank account */
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

    /** @param recepient this is the account that the money will go to
     * @param amount this is the amount transfered
     * This method will transfer from the account called in the function, to the account named in the constuctor
     */
    protected void transferTo( Account recepient, double amount){
        if(amount>balance){
            System.out.println("Insufficient funds for transfer");
        }
        else{
            balance -= amount;
            recepient.balance+=amount;
            int accID1= this.getAccountNumber();
            int accID2=recepient.getAccountNumber();
            System.out.println("Successfully transferred "+amount+" from Account:"+accID1+" to Account:"+accID2);
        }
    }
}