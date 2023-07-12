
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
        this.maxCredit=maxC;
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


}
