import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**JUnit Test for Transaction Runner*/
public class TransactionRunnerTest {
    @Test
    public void testImportCSVto2darray() {
        TransactionRunner runner = new TransactionRunner();
        String[][] data = runner.importCSVto2darray();
        // Test if data is not null
        assertNotNull(data);
        // Test if the data array has at least one row and one column
        assertTrue(data.length > 0);
        assertTrue(data[0].length > 0);
        assertNotNull(data[7][1]);
    }
}

