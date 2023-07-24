import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    /**@return the relevant ID number for new customer */
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
        incrementNumAndSave(IDNum, IDFilepath);
        return IDNum;
    }

    /**@return the relevant Checking number for new customer */
    public int getCheckNum(){
        try (BufferedReader reader = new BufferedReader(new FileReader(checkNumFilepath))){
            String line = reader.readLine();
            if(line != null){
                checkNum = Integer.parseInt(line);
            }
        }
        catch (IOException | NumberFormatException e){
            System.out.println("Error loading relevant number:"+ e.getMessage());
        }
        incrementNumAndSave(checkNum, checkNumFilepath);
        return checkNum;
    }

    /**@return the relevant Savings number for new customer */
    public int getSavNum(){
        try (BufferedReader reader = new BufferedReader(new FileReader(savNumFilepath))){
            String line = reader.readLine();
            if(line != null){
                savNum = Integer.parseInt(line);
            }
        }
        catch (IOException | NumberFormatException e){
            System.out.println("Error loading relevant number:"+ e.getMessage());
        }
        incrementNumAndSave(savNum, savNumFilepath);
        return savNum;
    }

    /**@return the relevant Credit number for new customer */
    public int getCredNum(){
        try (BufferedReader reader = new BufferedReader(new FileReader(credNumFilepath))){
            String line = reader.readLine();
            if(line != null){
                credNum = Integer.parseInt(line);
            }
        }
        catch (IOException | NumberFormatException e){
            System.out.println("Error loading relevant number:"+ e.getMessage());
        }
        incrementNumAndSave(credNum, credNumFilepath);
        return credNum;
    }

    /** @param num the number which needs to be updated
     * @param filepath relevant filepath of the number that needs to be updated
     * This method will increment the relevant id/account number and then save it into
     * the relevant file. Only used in AccessNumbers.java
     */
    private void incrementNumAndSave(int num, String filepath){
        num+=1;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(String.valueOf(num));
        } catch (IOException e) {
            // Handle file write errors
            System.err.println("Error saving last account number: " + e.getMessage());
        }
    }

}
