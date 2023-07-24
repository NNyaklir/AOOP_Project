import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** This is a class that is used to access id/account numbers used for creation of new accounts */
public class AccessNumbers {
    private static String IDFilepath= "./IDnum.txt";
    private static String checkNumFilepath="./CheckingNum.txt";
    private static String savNumFilepath="./SavingNum.txt";
    private static String credNumFilepath="./CreditNum.txt";
    
    private static int IDNum;
    private static int checkNum;
    private static int savNum;
    private static int credNum;

    public int getIDNum(){
        try (BufferedReader reader = new BufferedReader(new FileReader(IDFilepath))){
            String line = reader.readLine();
            if(line != null){
                IDNum = Integer.parseInt(line);
            }
        }
        catch (IOException | NumberFormatException e){
            System.out.println("Error loading relevant number:"+ e.getMessage());
        }
        return IDNum;
    }

}
