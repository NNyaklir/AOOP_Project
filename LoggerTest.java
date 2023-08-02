import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTest {

    private Saving dave;
    private Saving dan;
    private Logger log;

    @BeforeEach
    public void setUp() {
        dave = new Saving();
        dave.setAccountNumber(228922);

        dan = new Saving();
        dan.setAccountNumber(48849392);

        log = new Logger();
    }

    @Test
    public void testFileCheck() {
        assertEquals("using existing log file",log.fileCheck());
    }
    @Test
    public void manualCheck() {
        log.logTransfer(dave, 948, dan);
        log.logAddition(dave, 39.33);
        log.logDeduction(dan, 78.33);
    }
}
