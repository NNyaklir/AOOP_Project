public class LoggerTest{

    public static void main(String[]args){
        Saving dave = new Saving();
        dave.setAccountNumber(228922);
        Saving dan = new Saving();
        dan.setAccountNumber(48849392);

        Logger log= new Logger();

        log.fileCheck();
        log.logTransfer(dave,948,dan);
        log.logAddition(dave, 39.33);
        log.logDeduction(dan, 78.33);
    }
}