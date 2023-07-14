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

    // bug found: if 1 oe 2 is pressed at any moment, it takes it as if you were
    // re-loging in as a cust. or BM and gets you back to these options
    public static void inquireAccount(Scanner userInput) { // moved the account inquiry to its own separate method to
                                                           // declutter
                                                           // @TODO: Need to pull bank user info into this method.
        System.out.println("A. Inquire account by name. \n" +
                "B. Inquire account by type/number.");
        String inquiryType = userInput.nextLine();

        if (inquiryType.equalsIgnoreCase("A")) { // chaned this so that in order to log in, we require with name and acc
                                                 // num or type and acc num
            System.out.print("Enter Account Name: ");
            String accountName = userInput.nextLine();// Look Up If Name has a corresponding account

            System.out.println("What is the account number?");
            String accountNumber = userInput.nextLine();// Display Corresponding Account
            System.out.println("Welcome, " + "INSERT USERNAME");
            // @TODO: Need to integrate account information here.

        } else if (inquiryType.equalsIgnoreCase("B")) {
            System.out.println("What is the account type?");
            String accountType = userInput.nextLine();

            System.out.println("What is the account number?");
            String accountNumber = userInput.nextLine();// Display Corresponding Account
            System.out.println("Welcome, " + "INSERT USERNAME");
            // @TODO: Need to integrate account information here.

            System.out.println("Would you like to access our money services? \n" + "Yes \n" + "No \n");
            Scanner scanner = new Scanner(System.in); // Create a new Scanner object

            if (inquiryType.equalsIgnoreCase("Yes")) {
                moneyServices(scanner); // sends the client into money services method

            } else if (inquiryType.equalsIgnoreCase("No")) {
                System.out.println(":)");
                // @TODO: redisplays account information
            }

        }
    }

    // This method provides the money services to the user.
    protected static void moneyServices(Scanner userInput) {

        // Ask the user for the account type.
        System.out.println("What is the account type?");
        String accountType = userInput.nextLine();

        // Display the options for the user to select the service they want to access.
        System.out.println("Choose the service you would like to access: \n" +
                "1. Deposit \n" +
                "2. Withdraw \n" +
                "3. Transfer Money");

        // Get the service type from the user input.
        String serviceType = userInput.nextLine();

        // Use a switch statement to perform actions based on the selected service.
        switch (serviceType.toLowerCase()) {

            // If the user selects 1, they have chosen to deposit money.
            case "1":
                System.out.println("You have chosen to deposit money.");
                // @TODO: Implement functionality to allow user to deposit money.
                break;

            // If the user selects 2, they have chosen to withdraw money.
            case "2":
                System.out.println("You have chosen to withdraw money.");
                // @TODO: Implement functionality to allow user to withdraw money.
                break;

            // If the user selects 3, they have chosen to transfer money.
            case "3":
                System.out.println("You have chosen to transfer money.");
                // @TODO: Implement functionality to allow user to transfer money between
                // accounts
                // @TODO: need to also implement money transfer/bill payment between other
                // people's accounts
                break;

            // If the user enters any other input, it's considered as invalid and they're
            // asked to try again.
            default:
                System.out.println("Invalid input, please try again.");
                break;
        }
    }

}
