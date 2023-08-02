
/** A class to test AccessNumbers.java functionality */
public class AccessNumbersTest {
    
    public static void main(String[]args){
        //before all, creates a new instance of access numbers
        AccessNumbers a = new AccessNumbers();

        //test1(?)
        //this test should first retrun, and then print the current number inside of CheckingNum.txt
        //should then increment number inside of CheckingNum.txt by one
        //expected current number is 1116 and the number after the test is run should be 1117
        int test1 = a.getCheckNum();
        System.out.println(test1);
        
        //test2(?)
        //This test should first return and then print out the current number inside of SavingNum.txt
        //it should alos increment it by one
        // excpected current number is 2116 and the number after test should be 2117
        int test2 = a.getSavNum();
        System.out.println(test2);

        //test3(?)
        //this test should return and pring the current number inside of CreditNum.txt
        //it should also increment it by one
        // expected current number is 3116 and the number after the test should be 3117
        int test3 = a.getCredNum();
        System.out.println(test3);

        //test4(?)
        //this test should return and then print the current number inside of IDnum.txt
        //should also increment by one after method call
        //expected current number is 116 after should be 117
        int test4 = a.getIDNum();
        System.out.println(test4);
        
        
        //after running this test be sure to delete any changes made to the .txt files 
        
    }
    
}
