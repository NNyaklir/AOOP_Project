
public class Logger{
    private String filePath="AOOP_Project/log.txt";
    private File logFile;

    protected void fileCheck(){
        if(!logFile.exists()){
            logFile= new File(filePath);
            System.out.println("log file initialized");
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
        BufferedWriter writer = new BufferedWriter( FileWriter(logFile));
        String loggedS =("Account:"+sender.getAccountNumber()+" transfered "+amount+" to Account:"+recepient.getAccountNumber());
        writer.append(loggedS);
        writer.newLine();
        writer.flush();
    }

    /**@param deductee account that is getting deducted
     * @param amount amount to be deducted
     * This method will log a single deduction from one account in log.txt
     */
    protected void logDeduction(Account deductee, double amount){
        BufferedWriter writer = new BufferedWriter(FileWriter(logFile));
        String loggedS=("Account:"+deductee.getAccountNumber()+" withdrew "+amount);
        writer.append(loggedS);
        writer.newLine();
        writer.flush();
    }

    /**@param acc the account the money is going into
     * @param amount amount to be added
     * This method will log a single addition to an account in log.txt
     */
    protected void logAddition(Account acc, double amount){
        BufferedWriter Writer= new BufferedWriter(FileWriter(logFile));
        String loggedS=("Account:"+acc.getAccountNumber()+" deposited "+amount);
        writer.append(loggedS);
        writer.newLine();
        writer.flush();
    }
    
}