import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**Junit Test For CSV importer*/
public class CsvImporterTest {
    private CsvImporter importer;

    /**Set Up Method used for test*/
    @BeforeEach
    public void setUp() {
        importer = new CsvImporter();
        importer.dataImport();
    }


    /**Test to set Name in CSV*/
    @Test
    public void testSetNameFirst() {
        ArrayList<Customer> test = importer.getCustList();
        test.get(1).setNameFirst("Jack");
        assertEquals("Jack", test.get(1).getNameFirst());
    }

    /**Test to look up customer by name*/
    @Test
    public void testSearchByName() {
        ArrayList<Customer> another = importer.getCustList();
        Searcher search = new Searcher();
        int index = search.searchByName("Cesar", "Cabrera", another);
        assertEquals(13, index);
    }


    /**Test to look up customer by checking account*/
    @Test
    public void testSearchByChecking() {
        ArrayList<Checking> checkList = importer.getCheckList();
        Searcher search = new Searcher();
        int index2 = search.searchByChecking(1075, checkList);
        assertEquals(3, index2);
    }

    /**Test to look up by customer by Savings*/
    @Test
    public void testSearchBySavings() {
        ArrayList<Checking> checkList = importer.getCheckList();
        Searcher search = new Searcher();
        int index2 = search.searchByChecking(1075, checkList);
        assertEquals(3, index2);
    }




}
