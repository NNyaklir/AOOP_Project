
/**A class to test mechanics of TransactionRunner.java */
public class TransactionRunnerTest {
    public static void main(String[]args){
        TransactionRunner runner = new TransactionRunner();
        String[][] data=runner.importCSVto2darray();
        //no errors from this

        System.out.println("test");
        System.out.println(data[7][1]);
        //testing determined that for deposits the first 3 columns will be blank and not pose a problem
    }
}
