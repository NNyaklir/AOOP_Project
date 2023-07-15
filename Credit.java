
/** a sublcass of Account, represents a credit account */
public class Credit extends Account{
    protected double maxCredit;//should be a negative double amount that cannot be surpassed
    
    protected Credit(double maxC,double bal){
        this.maxCredit=maxC;
        this.balance=bal;

    }

    protected Credit(){
        
    }

    /**@return current max credit */
    protected double getMaxCredit(){
        return maxCredit;
    }

    /**@param maxC max credit amount for current  */
    protected void setMaxCredit(double maxC){
        if(maxC<0){
            this.maxCredit=maxC;
        }
        else if(!(maxC<0)){
            maxC= -maxC;
            this.maxCredit=maxC;
        }
    }

    /**@param addlCredit increased credit value 
     * increases the max credit limit on account
    */
    protected void extendCredit(double maxC){
        try{
            if(balance>=maxC && maxCredit>maxC){
                maxCredit=maxC;
            }
        }
        catch( Exception e){
            System.out.println("Max Credit cannot be extended below current limit");
        }
    }

     /** @param recepient this is the account that the money will go to
     * @param amount this is the amount transfered
     * This method will transfer from the account called in the function, to the account named in the constuctor overloaded for credit
     */
    protected void transferTo( Account recepient, double amount){
        double maxC= +(maxCredit);
        if(amount>maxC){
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

    /** @param c an amount charged to the balance
     * Modified for credit class
     */
    protected void charge(double c){
        double reverseC= -c;
        double over= balance-reverseC;
        if(!(over>maxCredit)){
            balance-=c;
        }
        else{
            System.out.println("Insufficent fund for charge/withdrawal");
        }
    }

}
