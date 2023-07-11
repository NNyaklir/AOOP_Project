
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
}
