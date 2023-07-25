/** Factory account class used in factory design in CSVImporter */
public class AccountFactory {
    public static Account createAccount(String accountType) {
        if ("Checking".equalsIgnoreCase(accountType)) {
            return new Checking();
        } else if ("Savings".equalsIgnoreCase(accountType)) {
            return new Saving();
        } else if ("Credit".equalsIgnoreCase(accountType)) {
            return new Credit();
        }
        return null;
    }
}
