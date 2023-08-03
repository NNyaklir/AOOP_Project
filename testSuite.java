import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
@RunWith(JUnitPlatform.class)
@Suite
@SelectClasses({ CsvImporterTest.class, CreditGeneratorTest.class, TransactionRunnerTest.class })
public class testSuite {

    @Test
    public void allTest(){
        // You can leave this method empty or add any additional logic if needed
        // This method is not necessary for running the test suite.
    }
}
