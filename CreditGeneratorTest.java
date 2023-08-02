/**This is a class to test the functionality of the CreditGenerator.java class */
public class CreditGeneratorTest {
    public static void main(String[]args){

        //before all, this creates new instances of credit generator
        CreditGenerator gen1 = new CreditGenerator();
        CreditGenerator gen2 = new CreditGenerator();
        CreditGenerator gen3 = new CreditGenerator();

        /*General test expectations:
         * 1.   The generator will generate a random credit score between 300 and 850
         * 2.   if the credit score <=580, a random maximum credit between 100-699 will be generated
         *      if 580<credit score <=669, a random maximum credit between 700-4999 will be generated
         *      if 670<credit score <=739, a random maximum credit between 5000-7499 will be generated
         *      if 740<credit score <=799, a random maximum credit between 7500-15999 will be generated
         *      if credit score >800, a random maximum credit between 16000-25000 will be generated
         * 3.   The genrated values will then be printed out
         * 4.   typically i compared these values by eye as it is pretty much impossible to determine automatically if 
         *      it fell within acceptable ranges.
         */

         //test1
        gen1.generate();
        gen1.printInfo();

        //test2
        gen2.generate();
        gen2.printInfo();

        //test3
        gen3.generate();
        gen3.printInfo();

    }
    
}
