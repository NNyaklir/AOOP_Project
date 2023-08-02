import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**Junit Test For Credit Class*/
class CreditTest {
    Credit test = new Credit(-500,0);

    /**Test to get Credit details*/
    @Test
    public void testGetBalanceAndCredit() {
        assertEquals(0, test.getBalance());
        assertEquals(-500, test.getMaxCredit());
    }

    /**Test to charge account*/
    @Test
    public void testCharge() {
        test.charge(200);
        assertEquals(0.0,test.getBalance());
    }

    /**Test to extend Max Credit*/
    @Test
    public void extendCredit() {
        test.extendCredit(-1000);
        assertEquals(-1000, test.getMaxCredit());
    }

    /**Test for decimal type charge */
    @Test
    public void decimalCharge() {
        test.charge(39.99);
        assertEquals(0.0,test.getBalance());
    }

    /**Test for deposit*/
    @Test
    public void Deposit() {
        test.deposit(200);
        assertEquals(200,test.getBalance());
    }

    /**Test for decimal type Deposit*/
    @Test
    public void decimalDeposit() {
        test.deposit(.69);
        assertEquals(.69,test.getBalance());
    }


}