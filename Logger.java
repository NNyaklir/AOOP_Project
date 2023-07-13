
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
        FileWriter writer = new FileWriter(logFile);
        
    }
}