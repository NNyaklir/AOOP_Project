import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * A class designed to import data from a csv file and export any changed data
 * back. Based on banking and
 * customer accounts.
 */
public class CsvImporter {
    protected ArrayList<Customer> custList = new ArrayList<Customer>();
    protected ArrayList<Checking> checkingList = new ArrayList<Checking>();
    protected ArrayList<Saving> savingList = new ArrayList<Saving>();
    protected ArrayList<Credit> creditList = new ArrayList<Credit>();
    private int rows;
    private int columns;
    protected String csvFile = "./BankUsers.csv";
    //BankUsers.csv

    /**
     * method to import data from a csv and store it into specified objects and
     * variables
     */
    protected void dataImport() {

        String[][] data = importCSVto2darray();

        //assume column names will be formatted specified following
        int idIndex= returnInd(data, "Identification Number");
        int nameFirstIndex = returnInd(data, "First Name");
        int nameLastIndex= returnInd(data, "Last Name");
        int dobIndex = returnInd(data, "Date of birth");
        int addressIndex= returnInd(data, "Address");
        int phoneNumIndex= returnInd(data, "Phone Number");
        int checcAccNumIndex = returnInd(data, "Checking Account Number");
        int checcAccBalIndex= returnInd(data, "Checking Starting Balance");
        int savAccNumIndex = returnInd(data, "Savings Account Number");
        int savAccBalIndex = returnInd(data, "Savings Starting Balance");
        int credAccNumIndex = returnInd(data, "Credit Account Number");
        int credAccBalMaxIndex = returnInd(data, "Credit Max");
        int credAccBalIndex = returnInd(data, "Credit Starting Balance");



        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {

                // yes i know there are a lot of errors ill fix it before final push, this is
                // more like skeleton than anything else rn

                Customer cust = new Customer();

                cust.id = Integer.parseInt(data[i][idIndex]);
                j++;

                cust.nameFirst = data[i][nameFirstIndex];
                j++;

                cust.nameLast = data[i][nameLastIndex];
                j++;

                cust.dob = data[i][dobIndex];
                j++;

                cust.address = data[i][addressIndex];
                j++;

                cust.phoneNumber = data[i][phoneNumIndex];
                custList.add(cust);
                j++;

                // starts checking accounts
                Checking check = new Checking();
                check.setCustomer(cust);
                
                check.accountNumber = Integer.parseInt(data[i][checcAccNumIndex]);
                j++;

                check.balance = Double.parseDouble(data[i][checcAccBalIndex]);
                checkingList.add(check);
                cust.setChecking(check);
                j++;

                // starts saving accounts
                Saving sav = new Saving();
                sav.setCustomer(cust);;
                
                sav.accountNumber = Integer.parseInt(data[i][savAccNumIndex]);
                j++;

                sav.balance = Double.parseDouble(data[i][savAccBalIndex]);
                cust.setSaving(sav);
                savingList.add(sav);
                j++;

                // starts credit accounts
                Credit cred = new Credit();
                cred.setCustomer(cust);
                
                cred.accountNumber = Integer.parseInt(data[i][credAccNumIndex]);
                j++;

                cred.maxCredit = Double.parseDouble(data[i][credAccBalMaxIndex]);
                j++;

                cred.balance = Double.parseDouble(data[i][credAccBalIndex]);
                j++;
                cust.setCredit(cred);
                creditList.add(cred);

            }
        }
    }

    /**
     * @return a 2d array that stores data from an csv file, only used in importCSVto2d
     * Returns a 2d array that stores data from a csv file, only used in importCSVto2d
     */
    protected String[][] importCSVto2darray() {
        String[][] data = null;
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            int rows = 0;
            int columns = 0;

            // this counts rows and columns
            while ((line = br.readLine()) != null) {
                rows++;
                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                columns = Math.max(columns, values.length);
            }
            this.rows = rows;
            this.columns = columns;

            data = new String[rows][columns]; // 2d array to store values
            br.close();
            br = new BufferedReader(new FileReader(csvFile));
            int row = 0;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                for (int col = 0; col < values.length; col++) {
                    data[row][col] = values[col];
                }
                row++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * @return a 2d array
     * data stored from this class's array lists, only used in export.
     */
    protected String[][] arrayListTo2d() {
        String[][] data = new String[rows][columns];

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data[0].length; j++) {
                // System.out.println("data[0].length is:"+data[0].length);
                // System.out.println(j);
                data[i][j] = Integer.toString(custList.get(i).getId());
                j++;

                data[i][j] = custList.get(i).getNameFirst();
                j++;

                data[i][j] = custList.get(i).getNameLast();
                j++;

                data[i][j] = custList.get(i).getDob();
                j++;

                data[i][j] = custList.get(i).getAddress();
                j++;

                data[i][j] = custList.get(i).getPhoneNumber();
                j++;

                data[i][j] = Integer.toString(checkingList.get(i).getAccountNumber());
                j++;

                data[i][j] = Double.toString(checkingList.get(i).getBalance());
                j++;

                data[i][j] = Integer.toString(savingList.get(i).getAccountNumber());
                j++;

                data[i][j] = Double.toString(savingList.get(i).getBalance());
                j++;

                data[i][j] = Integer.toString(creditList.get(i).getAccountNumber());
                j++;

                data[i][j] = Double.toString(creditList.get(i).getMaxCredit());
                j++;

                data[i][j] = Double.toString(creditList.get(i).getBalance());
                j++;
            }
        }
        //System.out.println(data[77][8]);
        return data;
    }

    /** a method that exports updated data to the given csv file */
    protected void export() {
        char seperator = ',';
        String[][] array = arrayListTo2d();
        try {

            FileWriter writer = new FileWriter("./BankExportCheck.csv");

            for (String[] row : array) {
                for (int i = 1; i < row.length; i++) {
                    writer.append(String.valueOf(row[i]));
                    if (i < row.length - 1) {
                        writer.append(seperator);
                    }
                }
                writer.append("\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** @return an array list of customers 
     * gets array list of customers*/
    protected ArrayList<Customer> getCustList() {
        return custList;
    }

    /** @return an array list of checking accounts
     * gets array list of checking accounts */
    protected ArrayList<Checking> getCheckList() {
        return checkingList;
    }

    /** @return an array list of saving accounts 
     * gets array list of saving accounts*/
    protected ArrayList<Saving> getSavingList() {
        return savingList;
    }

    /** @return an array list of saving accounts 
     * gets array list of credit accounts*/
    protected ArrayList<Credit> getCreditList() {
        return creditList;
    }

    /** @param filePath path of files in directory 
     * sets the csv path*/
    protected void setCSVFile(String filePath) {
        this.csvFile = filePath;
    }

    /**@param array 2d array to be searched
     * @param stringToSearch the string that is being searched for
     * This program and takes a 2d array and searches the first row for column headers.
     */
    private int returnInd(String [][] array, String stringToSearch){
        for(int i=0;i<1;i++){
            for (int j=0; j < array[0].length; j++){
                String current =array[i][j];
                if(stringToSearch.equalsIgnoreCase(current)){
                    return j;
                }
                
            }
        }
        return -1;
    }

    /**This method increments row to account for new users during export. */
    public void incrementUser(){
        rows+=1;
    }

}