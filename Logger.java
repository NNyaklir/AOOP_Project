import java.io.*;


/**A class that is used to log transactions into a given .txt file */
public class Logger{
    protected String filePath=
    "C:\\Users\\devin\\Documents\\VSCode Workstations\\Computer-Organization-Freudenthal\\AOOP_Project\\log.txt";
    File logFile = new File(filePath);

    protected void fileCheck(){
        if(!logFile.exists()){
            logFile= new File(filePath);
            System.out.println("log.txt does not exist in current directory");
        }
        else{
            System.out.println("using existing log file");
        }
        
    }

    /**@param sender account that is sending the money
     * @param amount amount sent between account
     * @param recepient account that recieves the money
     * This method will log transactions between two accounts in log.txt
     */
    protected void logTransfer(Account sender,double amount, Account recepient){
        try{
        FileWriter writer = new FileWriter(logFile, true);
        String loggedS =("Account:"+sender.getAccountNumber()+" transfered "+amount+" to Account:"+recepient.getAccountNumber()+"\n");
        writer.write(loggedS);
        writer.flush();
        writer.close();
        }
        catch (Exception e){
            e.printStackTrace();;  
        }
        
    }

    /**@param deductee account that is getting deducted
     * @param amount amount to be deducted
     * This method will log a single deduction from one account in log.txt
     */
    protected void logDeduction(Account deductee, double amount){
        try{
        FileWriter writer = new FileWriter(logFile,true);
        String loggedS=("Account:"+deductee.getAccountNumber()+" withdrew "+amount+"\n");
        writer.write(loggedS);
        writer.flush();
        writer.close();
        }
        catch (Exception e){  
        }
    }

    /**@param acc the account the money is going into
     * @param amount amount to be added
     * This method will log a single addition to an account in log.txt
     */
    protected void logAddition(Account acc, double amount){
        try{
        FileWriter writer = new FileWriter(filePath,true);
        String loggedS=("Account:"+acc.getAccountNumber()+" deposited "+amount+"\n");
        writer.write(loggedS);
        writer.flush();
        writer.close();
        }
        catch (Exception e){  
        }
    }

    /**@param cust customer that has made the inquiry
     * This method will log a single account inquiry into log.txt
     */
    protected void logInquiry(Customer cust){
        try{
            FileWriter writer = new FileWriter(filePath, true);
            String loggedS=(cust.getNameFirst()+" "+cust.getNameLast()+" made an inquiry into their account");
            writer.write(loggedS);
            writer.flush();
            writer.close();
        }
        catch (Exception e){

        }
    }
    
}