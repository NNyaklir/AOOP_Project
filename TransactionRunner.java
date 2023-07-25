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
        Searcher search =new Searcher();
        Logger log = new Logger();

        for(int i=1; i<data.length;i++){
            for(int j=0;j<data[0].length;){
                switch(data[i][3]){
                    case "pays":
                        int sender = search.searchByName(data[i][0], data[i][1], custList);
                        int recepient=search.searchByName(data[i][4],data[i][5],custList);
                        switch(data[i][2]){
                            case "Checking":
                            switch(data[i][6]){
                                case "Checking":
                                    custList.get(sender).getChecking().transferTo(custList.get(recepient).getChecking(), Double.parseDouble(data[i][7]));
                                    log.logTransfer(custList.get(sender).getChecking(), Double.parseDouble(data[i][7]), custList.get(recepient).getChecking());
                                    j+=8;
                                    break;

                                case "Savings":
                                    custList.get(sender).getChecking().transferTo(custList.get(recepient).getSaving(), Double.parseDouble(data[i][7]));
                                    log.logTransfer(custList.get(sender).getChecking(), Double.parseDouble(data[i][7]), custList.get(recepient).getSaving());
                                    j+=8;

                                case "Credit":
                                    custList.get(sender).getChecking().transferTo(custList.get(recepient).getCredit(), Double.parseDouble(data[i][7]));
                                    log.logTransfer(custList.get(sender).getChecking(), Double.parseDouble(data[i][7]), custList.get(recepient).getCredit());
                                    j+=8;
                                    break;

                                default:
                                    System.out.println("Error occured during transcation processing in row "+i+"\nMoving to next transaction");
                                    j+=8;
                                    break;
                            }
                            case "Savings":
                            switch(data[i][6]){
                                case "Checking":
                                    custList.get(sender).getSaving().transferTo(custList.get(recepient).getChecking(), Double.parseDouble(data[i][7]));
                                    log.logTransfer(custList.get(sender).getSaving(), Double.parseDouble(data[i][7]), custList.get(recepient).getChecking());
                                    j+=8;
                                    break;

                                case "Savings":
                                    custList.get(sender).getSaving().transferTo(custList.get(recepient).getSaving(), Double.parseDouble(data[i][7]));
                                    log.logTransfer(custList.get(sender).getSaving(), Double.parseDouble(data[i][7]), custList.get(recepient).getSaving());
                                    j+=8;

                                case "Credit":
                                    custList.get(sender).getSaving().transferTo(custList.get(recepient).getCredit(), Double.parseDouble(data[i][7]));
                                    log.logTransfer(custList.get(sender).getSaving(), Double.parseDouble(data[i][7]), custList.get(recepient).getCredit());
                                    j+=8;
                                    break;

                                default:
                                    System.out.println("Error occured during transcation processing in row "+i+"\nMoving to next transaction");
                                    j+=8;
                                    break;
                            }
                            case "Credit":
                            switch(data[i][6]){
                                case "Checking":
                                    custList.get(sender).getCredit().transferTo(custList.get(recepient).getChecking(), Double.parseDouble(data[i][7]));
                                    log.logTransfer(custList.get(sender).getCredit(), Double.parseDouble(data[i][7]), custList.get(recepient).getChecking());
                                    j+=8;
                                    break;

                                case "Savings":
                                    custList.get(sender).getCredit().transferTo(custList.get(recepient).getSaving(), Double.parseDouble(data[i][7]));
                                    log.logTransfer(custList.get(sender).getCredit(), Double.parseDouble(data[i][7]), custList.get(recepient).getSaving());
                                    j+=8;

                                case "Credit":
                                    custList.get(sender).getCredit().transferTo(custList.get(recepient).getCredit(), Double.parseDouble(data[i][7]));
                                    log.logTransfer(custList.get(sender).getCredit(), Double.parseDouble(data[i][7]), custList.get(recepient).getCredit());
                                    j+=8;
                                    break;

                                default:
                                    System.out.println("Error occured during transcation processing in row "+i+"\nMoving to next transaction");
                                    j+=8;
                                    break;
                            }

                        }
                    case "Transfer":
                        

                }

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
