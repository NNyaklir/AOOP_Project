public class LoggerTest{

    public static void main(String[]args){

        //this creates a new Saving account instance of name dave
        Saving dave = new Saving();
        //this sets the account number
        dave.setAccountNumber(228922);
        //this makes a new Saving account instance of name dan
        Saving dan = new Saving();
        //this sets the account number
        dan.setAccountNumber(48849392);
        //this creates a new log instance
        Logger log= new Logger();
        //the above can be before all

        //this verifies that log.txt exits
        log.fileCheck();

        //the following code writes into the log account which was manually checked
        //to ensure that it was being output into the file correctly.
        log.logTransfer(dave,948,dan);
        log.logAddition(dave, 39.33);
        log.logDeduction(dan, 78.33);
    }
}