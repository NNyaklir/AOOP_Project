import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** A class to test AccessNumbers.java functionality */
public class AccessNumbersTest {


    AccessNumbers a = new AccessNumbers();


    @Test
    public void testCheckNum(){
        assertEquals(1116, a.getCheckNum());
    }

    @Test
    public void testSavingsNum(){
        assertEquals(2116, a.getSavNum());
    }

    @Test
    public void testCreditNum(){
        assertEquals(3116, a.getCredNum());
    }

    @Test
    public void testIDNum(){
        assertEquals(116, a.getIDNum());
    }


    
}
