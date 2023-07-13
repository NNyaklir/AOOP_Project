import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to the El Paso Miners Banking system");
        System.out.println("please log-in below");
        System.out.println("1. Customer log-in \n" +
                "2. Bank Management log-in");

        while (run) {
            String loginType = userInput.nextLine();

            if (loginType.equalsIgnoreCase("1")) { // directly into inqury if customer
                inquireAccount(userInput);
            } else if (loginType.equalsIgnoreCase("2")) { // echos message for management and then into inquiry
                System.out.println("Hello Management, what would you like to enquire about your client?");
                inquireAccount(userInput);
            } else if (loginType.equalsIgnoreCase("Exit")) {
                System.out.println("Goodbye!");
                run = false;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }

        userInput.close();
    }

    public static void inquireAccount(Scanner userInput) { // moved the account inquiry to its own separate method to
                                                           // declutter
        System.out.println("A. Inquire account by name. \n" +
                "B. Inquire account by type/number.");
        String inquiryType = userInput.nextLine();

        if (inquiryType.equalsIgnoreCase("A")) {
            System.out.print("Enter Account Name: ");
            String accountName = userInput.nextLine();// Look Up If Name has a corresponding account

        } else if (inquiryType.equalsIgnoreCase("B")) {
            System.out.println("What is the account type?");
            String accountType = userInput.nextLine();

            System.out.println("What is the account number?");
            String accountNumber = userInput.nextLine();// Display Corresponding Account
            System.out.println("Welcome, " + "INSERT USERNAME");
        }
    }
}
