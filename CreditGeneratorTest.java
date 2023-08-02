import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
public class CreditGeneratorTest {
    private static CreditGenerator gen1;
    private static CreditGenerator gen2;
    private static CreditGenerator gen3;

    @BeforeAll
    public static void setUp() {
        gen1 = new CreditGenerator();
        gen2 = new CreditGenerator();
        gen3 = new CreditGenerator();
    }
    @Test
    public void testCreditGeneration1() {
        gen1.generate();
        gen1.printInfo();
    }
    @Test
    public void testCreditGeneration2() {
        gen2.generate();
        gen2.printInfo();
    }
    @Test
    public void testCreditGeneration3() {
        gen3.generate();
        gen3.printInfo();

    }
}
