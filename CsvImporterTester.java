import java.util.ArrayList;

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

        System.out.println(test.get(1).getCredit());
    }
}