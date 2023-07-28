import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/** A class that is used to log transactions into a given .txt file */
public class Logger {
    protected String filePath = "./log.txt";
    protected String custFilePath = "./receipt.txt";
    File logFile = new File(filePath);

    /**
     * This method ensures that there is a file to use before logging information
     */
    protected void fileCheck() {
        if (!logFile.exists()) {
            logFile = new File(filePath);
            System.out.println("log.txt does not exist in current directory");
        } else {
            System.out.println("using existing log file");
        }

    }

    /**
     * @param sender    account that is sending the money
     * @param amount    amount sent between account
     * @param recepient account that recieves the money
     *                  This method will log transactions between two accounts in
     *                  log.txt
     */
    protected void logTransfer(Account sender, double amount, Account recepient) {
        try {
            FileWriter sendWriter = new FileWriter(sender.getCustomer().getLogFile(), true);
            FileWriter recWriter= new FileWriter(recepient.getCustomer().getLogFile(), true);
            FileWriter writer = new FileWriter(logFile, true);

            String sFN=sender.getCustomer().getNameFirst();
            String sLN=sender.getCustomer().getNameLast();
            String sN= sFN + " "+sLN;

            String rFN= recepient.getCustomer().getNameFirst();
            String rLN= recepient.getCustomer().getNameLast();
            String rN= rFN+" "+rLN;

            String loggedS = (sN+ " paid/transfered to "+rN+ " Account:" + sender.getAccountNumber() + " transfered " + amount + " to Account:"
                    + recepient.getAccountNumber() + "\n");

            
            writer.write(loggedS); sendWriter.write(loggedS); recWriter.write(loggedS);
            writer.flush(); sendWriter.flush(); recWriter.flush();
            writer.close(); sendWriter.close(); recWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }

    }

    /**
     * @param deductee account that is getting deducted
     * @param amount   amount to be deducted
     *                 This method will log a single deduction from one account in
     *                 log.txt
     */
    protected void logDeduction(Account deductee, double amount) {
        try {
            FileWriter dedWriter = new FileWriter(deductee.getCustomer().getLogFile(), true);
            FileWriter writer = new FileWriter(logFile, true);

            String dFN= deductee.getCustomer().getNameFirst();
            String dLN= deductee.getCustomer().getNameFirst();
            String dN= dFN+" "+dLN;

            String loggedS = (dN+"'s "+"Account:" + deductee.getAccountNumber() + " withdrew " + amount + "\n");
            writer.write(loggedS); dedWriter.write(loggedS);
            writer.flush(); dedWriter.flush();
            writer.close(); dedWriter.close();
        } catch (Exception e) {
        }
    }

    /**
     * @param acc    the account the money is going into
     * @param amount amount to be added
     *               This method will log a single addition to an account in log.txt
     */
    protected void logAddition(Account acc, double amount) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            FileWriter addWriter = new FileWriter(acc.getCustomer().getLogFile(), true);

            String aFN= acc.getCustomer().getNameFirst();
            String aLN= acc.getCustomer().getNameLast();
            String aN = aFN+" "+aLN;

            String loggedS = (aN+"'s "+"Account:" + acc.getAccountNumber() + " deposited " + amount + "\n");
            writer.write(loggedS); addWriter.write(loggedS);
            writer.flush(); addWriter.flush();
            writer.close();addWriter.close();
        } catch (Exception e) {
        }
    }

    /**
     * @param cust customer that has made the inquiry
     *             This method will log a single account inquiry into log.txt
     */
    protected void logInquiry(Customer cust, String type) {
        try {
            FileWriter inqWriter= new FileWriter(cust.getLogFile(),true);
            FileWriter writer = new FileWriter(filePath, true);
            String loggedS = (cust.getNameFirst() + " " + cust.getNameLast() + " made an inquiry into " + type
                    + " Acount");
            writer.write(loggedS); inqWriter.write(loggedS);
            writer.flush(); inqWriter.flush();
            writer.close(); inqWriter.close();
        } catch (Exception e) {

        }
    }

    /* 
    protected void generateReceipt(Customer cust, String type) {
        try {
            FileWriter writer = new FileWriter(custFilePath, true);

            String accountInfo = "Account Information:\n";
            accountInfo += "Account Number: " + accountInfo + "\n";
            accountInfo += "Account Holder: " + cust.getNameFirst() + " " + cust.getNameLast() + "\n";
            String dateOfStatement = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            StringBuilder receipt = new StringBuilder();

            // @TODO: find a way to pull starting and ending balances into these variables.
            // could be solved if transactions pulling does it
            receipt.append(accountInfo);
            receipt.append("Starting Balance: " + startingBalance + "\n");
            receipt.append("Ending Balance: " + endingBalance + "\n");
            receipt.append("Transactions:\n");

            // add a way to pull the transaction logs from the above methods.
            for (String transaction : transactions) {
                receipt.append(transaction + "\n");
            }

            receipt.append("Date of Statement: " + dateOfStatement);

            writer.write(receipt);
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    } */

}