
/**a class to test aspects of the Account and Credit objects */
public class CreditTesting {

	public static void main(String[] args) {
		
		Credit test = new Credit(-500,0);
		
		System.out.println("expected:0, actual:"+test.getBalance());
		System.out.println("expected:-500, actual:"+test.getMaxCredit());
		
		test.charge(200);
		System.out.println("expected balance:-200, actual:"+test.getBalance());
		
		test.extendCredit(-200);//this should provide an error, it doesn't throw an error but it also doesnt extend max credit, working as expected?
		System.out.println(test.getMaxCredit());
		
		test.extendCredit(-1000);
		System.out.println(test.getMaxCredit());
		
		test.charge(39.99);
		System.out.println("testing decimal balance"+test.getBalance());
		
		test.deposit(20);
		System.out.println("testing deposit non decimal " + test.getBalance());
		
		test.deposit(73.81);
		System.out.println("testing deposit with decimal "+test.getBalance());
	}

}
