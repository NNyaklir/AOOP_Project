
/**A class that is modeled after the information a bank would store on its customer */
public class Customer extends Person {
    protected Checking custChecking;
    protected Credit custCredit;
    protected Saving custSaving;
    
    /**@param c checking acc 
     * sets the checking account for a customer*/
    protected void setChecking(Checking c){
        this.custChecking=c;
    }

    /**@return checking account
     * gets the checking account from customer */
    protected Checking getChecking(){
        return custChecking;
    }

    /**@param c credit acc 
     * sets the credit account for customer*/
    protected void setCredit(Credit c){
        this.custCredit=c;
    }

    /**@return credit account
     * gets the credit account from customer*/
    protected Credit getCredit(){
        return custCredit;
    }

    /**@param s saving account 
     * sets the saving acccount for customer*/
    protected void setSaving(Saving s){
        this.custSaving=s;
    }

    /**@return saving account
     * gets the saving account from customer */
    protected Saving getSaving(){
        return custSaving;
    }

    /**Prints in terminal all variables in class with relevant statements*/
    protected void displayInformation(){
        System.out.println(nameFirst+" "+nameLast+", user ID:"+id);
        System.out.println("Phone Number: "+phoneNumber);
        System.out.println("Address: "+address);
        System.out.println("DOB: "+dob);
        System.out.println("Checking Account "+custChecking.getAccountNumber()+":"+custChecking.getBalance());
        System.out.println("Savings Account "+custSaving.getAccountNumber()+":"+custSaving.getBalance());
        System.out.println("Credit Account "+custCredit.getAccountNumber()+":"+custCredit.getBalance());
    }
}
