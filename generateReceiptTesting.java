import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class generateReceiptTesting {
    public static void main(String[] args) {
        // Create an instance of the class containing the generateReceipt method
        generateReceiptTesting receipt = new generateReceiptTesting();

        // Create a sample account
        CsvImporter importer= new CsvImporter();
        importer.dataImport();
        ArrayList<Customer> custList = importer.getCustList();
        

        // Call the generateReceipt method
       // generateReceiptTesting.generateReceipt(custList.get(1).getChecking());

        // Check if the UserTransactions.txt file was created and its content
        try {
            File file = new File("UserTransactions.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
