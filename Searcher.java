import java.util.ArrayList;

/**A utility class to search array lists */
public class Searcher {

    /**@param first first name of the customer to be found
     * @param last last name of the customer to be found
     * @param custList array list that has the customer objects
     * @return index in the given list of where the relevant item is
     * Searches for name of person in given array list of customers and returns the index when found
     * if not found returns -1
     */
    protected int searchByName(String first, String last, ArrayList<Customer> custList){
        
        for (int i=0;i<custList.size();i++){
            String firstCheck=custList.get(i).getNameFirst();
            String lastCheck=custList.get(i).getNameLast();
            if((firstCheck.equalsIgnoreCase(first))&&(lastCheck.equalsIgnoreCase(last))){
                return i;  
            }
            else{
                continue;
            }
        } 
        return -1;
    }

    /**@param accountNumber the account number to search for
     * @param accList the list of checking accounts to search through
     * @return the index in the given list of where the relevant item is
     * searches for the checking account number in array list of checking accounts and returns the index when found
     * returns -1 if not found
     */
    protected int searchByChecking(int accountNumber, ArrayList<Checking> accList){
        for(int i=0;i<accList.size();i++){
            int accCheck=accList.get(i).getAccountNumber();
            if(accCheck==accountNumber){
                return i;
            }
        }
        return -1;
    }

    /**@param accountNumber the account number to search for
     * @param accList the list of saving accounts to search through
     * @return the index in the given list of where the relevant item is
     * searches for the account number in array list of saving accounts and returns index when found
     * if not found, returns -1
     */
    protected int searchBySaving(int accountNumber, ArrayList<Saving> accList){
        for(int i=0;i<accList.size();i++){
            int accCheck=accList.get(i).getAccountNumber();
            if(accCheck==accountNumber){
                return i;
            }
        }
        return -1;
    }

    /**@param accountNumber the account number to search for
     * @param accList the list of credit accounts to search through
     * @return the index in the given list of where the relevant item is
     * searches for the account number in array list of saving accounts and returns index when found
     * if not found, returns -1
     */
    protected int searchByCredit(int accountNumber, ArrayList<Credit> accList){
        for(int i=0;i<accList.size();i++){
            int accCheck=accList.get(i).getAccountNumber();
            if(accCheck==accountNumber){
                return i;
            }
        }
        return -1;
    }
    
}
