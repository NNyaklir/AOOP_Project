import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**This a class that will proccess transactions in a .csv file through the system */
public class TransactionRunner {
    private int rows;
    private int columns;
    private String transactionPathfile= "./Transactions.csv";
    String [][] data;



    public void runTransactions(ArrayList<Customer> custList,ArrayList<Checking> checkingList,ArrayList<Saving> savingList,ArrayList<Credit> creditList){
        //col 0 is from first name, col 1 is from last name, col 2 is from account type, col 3 is the action
        //col 4 is recepient first name, col 5 is recepient last name, co 6 is recepient account type
        // col 7 is the ammount.


        for(int i=1; i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                

            }
        }
    }


     /**
     * @return a 2d array that stores data from an csv file, only used in 
     * Returns a 2d array that stores data from a csv file, only used in 
     */
    protected String[][] importCSVto2darray() {
        String[][] data = null;
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(transactionPathfile));
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
            br = new BufferedReader(new FileReader(transactionPathfile));
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

  
}
