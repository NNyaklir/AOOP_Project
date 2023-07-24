import java.util.Random;

//*This class is used to generate credit scores and credit limits */
public class CreditGenerator {
    protected int creditScore;
    protected double creditLimit;
    private int minCreditScore = 300;
    private int maxcreditScore =850;
    Random rand = new Random();

    /**This method generates a random credit score between 0 and 850 */
    protected void generate(){
        
        int randCreditScore = rand.nextInt((maxcreditScore-minCreditScore)+1)+minCreditScore;
        creditScore=randCreditScore;
        generateCreditLimit(randCreditScore);
    }

    /**@param cScore credit score to generate for
     * This method generates a random credit limit between 100 and 25000 based on credit score */
    private void generateCreditLimit(int cScore){
        if(cScore<=580){
           int creditLimitLowest= rand.nextInt((699-100)+1)+100;
           creditLimit=Double.valueOf(creditLimitLowest);
        }
        if(cScore>=581&&cScore<=669){
           int creditLimitLower= rand.nextInt((4999-700)+1)+700;
           creditLimit=Double.valueOf(creditLimitLower);
        }
        if(cScore>=671&&cScore<=739){
           int creditLimitMid= rand.nextInt((7499-5000)+1)+5000;
           creditLimit=Double.valueOf(creditLimitMid);
        }
        if(cScore>=740&&creditScore<=799){
           int creditLimitHigh= rand.nextInt((15999-7500)+1)+7500;
           creditLimit=Double.valueOf(creditLimitHigh);
        }
        if(cScore>=800){
           int creditLimitHighest= rand.nextInt((25000-16000)+1)+16000;
           creditLimit=Double.valueOf(creditLimitHighest);
        }
    }

    //**public method to test this class by printing the generations */
    public void printInfo(){
        System.out.println("Your credit score is: "+creditScore+ " and your credit limit is: "+creditLimit);
        System.out.println("Congratulations!");
    }

}
