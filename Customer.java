import java.io.File;
import java.io.FileWriter;

/**A class that is modeled after the information a bank would store on its customer */
public class Customer extends Person {
    protected Checking custChecking;
    protected Credit custCredit;
    protected Saving custSaving;
    protected String custLogPath;
    protected File custLogFile; 
    // example pathfile is "./CustomerLogs/Customer98.txt"


    

    /**
     * A method to check if the customer log file exits, creates it if it does not.
     * Generates with relevant imformation
     */
    protected void fileCheck(){
        custLogPath="./CustomerLogs/Customer"+Integer.toString(this.getId())+".txt";
        custLogFile= new File(custLogPath);
        if(!custLogFile.exists()){
            try{
                custLogFile.createNewFile();
                FileWriter writer = new FileWriter(custLogFile, true);
                writer.write("---------------------------------------\n");
                writer.flush();
                writer.write(nameFirst+" "+nameLast+", user ID:"+id+"\n");
                writer.flush();
                writer.write("Phone Number: "+phoneNumber+"\n");
                writer.flush();
                writer.write("Address: "+address+"\n");
                writer.flush();
                writer.write("DOB: "+dob+"\n");
                writer.flush();
                writer.write("Checking Account "+custChecking.getAccountNumber()+":"+custChecking.getBalance()+"\n");
                writer.flush();
                writer.write("Savings Account "+custSaving.getAccountNumber()+":"+custSaving.getBalance()+"\n");
                writer.flush();
                writer.write("Credit Account "+custCredit.getAccountNumber()+":"+custCredit.getBalance()+"\n");
                writer.flush();
                writer.write("---------------------------------------\nS");
                writer.flush();
                writer.close();
                
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("Error occured when creating customer file");
            }

        }
        else{
            System.out.println("Customer file confirmed");

        }

    }
    
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
        System.out.println("---------------------------------------");
        System.out.println(nameFirst+" "+nameLast+", user ID:"+id);
        System.out.println("Phone Number: "+phoneNumber);
        System.out.println("Address: "+address);
        System.out.println("DOB: "+dob);
        System.out.println("Checking Account "+custChecking.getAccountNumber()+":"+custChecking.getBalance());
        System.out.println("Savings Account "+custSaving.getAccountNumber()+":"+custSaving.getBalance());
        System.out.println("Credit Account "+custCredit.getAccountNumber()+":"+custCredit.getBalance());
        System.out.println("---------------------------------------");
    }

    /**@return the file for customer logs */
    protected File getLogFile(){
        return custLogFile;

    }

    /**@return the file path for customer log */
    protected String getLogPath(){
        return custLogPath;
    }
}
