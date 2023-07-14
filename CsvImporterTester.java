import java.util.ArrayList;
/**A class to test the functionality of CsvImproter */
public class CsvImporterTester{
    
    public static void main(String[]args){

        CsvImporter importer=new CsvImporter();

        importer.dataImport();

        
        ArrayList<Customer> test = importer.getCustList();

        //System.out.println(test);

        
        //jack = test.get(1);

        System.out.println(test.get(1).getNameFirst());

        test.get(1).setNameFirst("jack");
        System.out.println(test.get(1).getNameFirst());

        //System.out.println(test.get(1).getCredit());

        ArrayList<Customer> another = importer.getCustList();

        System.out.println(another.get(0).getNameFirst());

        importer.export();
    }
}