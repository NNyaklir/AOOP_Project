
/**A class that is modeled after the information a bank would store on its customer */
public class Customer extends Person {
    protected Checking custChecking;
    protected Credit custCredit;
    protected Saving custSaving;
    
    /**@param c checking acc */
    protected void setChecking(Checking c){
        this.custChecking=c;
    }

    /**@return checking account */
    protected Checking getChecking(){
        return custChecking;
    }

    /**@param c credit acc */
    protected void setCredit(Credit c){
        this.custCredit=c;
    }

    /**@return credit account */
    protected Credit getCredit(){
        return custCredit;
    }

    /**@param s saving account */
    protected void setSaving(Saving s){
        this.custSaving=s;
    }

    /**@return saving account */
    protected Saving getSaving(){
        return custSaving;
    }

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
