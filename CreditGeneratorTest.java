public class CreditGeneratorTest {
    public static void main(String[]args){
        CreditGenerator gen1 = new CreditGenerator();
        CreditGenerator gen2 = new CreditGenerator();
        CreditGenerator gen3 = new CreditGenerator();

        gen1.generate();
        gen2.generate();
        gen3.generate();

        gen1.printInfo();
        gen2.printInfo();
        gen3.printInfo();
    }
    
}
