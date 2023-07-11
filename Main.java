import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner userInput = new Scanner(System.in);
        while (run){
            System.out.println("A. Inquire account by name. \n" +
                    "B. Inquire account by type/number.");

            String enterProgram = userInput.nextLine(); // Initialize Scanner

            if (enterProgram.equalsIgnoreCase("A")){ // Look Up Name
                System.out.print("Enter Account Name: ");
                enterProgram = userInput.nextLine();
                // Look Up If Name has a corresponding account

            } else if (enterProgram.equalsIgnoreCase("B")){ // Look Up Account
                System.out.println("What is the account type?");
                enterProgram = userInput.nextLine();

                System.out.println("What is the account number?");
                enterProgram = userInput.nextLine();

                // Display Corresponding Account

            } else if(enterProgram.equalsIgnoreCase("Exit")){ // End Program
                System.out.println("Goodbye!");
                run = false;
            } else{
                System.out.println("Invalid Input");
            }




        userInput.close();//closed this bc it bugs me -Devin
        } // end of program
    }
}