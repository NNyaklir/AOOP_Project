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
    protected static void moneyServices(Scanner userInput, Account account) {

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
                System.out.println("Enter the amount to deposit: ");
                double depositAmount = userInput.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
                break;

            // If the user selects 2, they have chosen to withdraw money.
            case "2":
                System.out.println("You have chosen to withdraw money.");
                System.out.println("Enter the amount to withdraw: ");
                double withdrawAmount = userInput.nextDouble();
                if (withdrawAmount <= account.getBalance()) {
                    account.charge(withdrawAmount);
                    System.out.println("Withdrawal successful. Your new balance is: " + account.getBalance());
                } else {
                    System.out.println("Insufficient funds for withdrawal");
                }
                break;

            // If the user selects 3, they have chosen to transfer money.
            case "3":
                System.out.println("You have chosen to transfer money.");
                System.out.println("Enter the account number to which you want to transfer: ");
                int transferAccountNumber = userInput.nextInt();
                System.out.println("Enter the amount to transfer: ");
                double transferAmount = userInput.nextDouble();

                // You'll need to replace `getAccountByNumber` with the actual method that
                // retrieves an account by its number
                Account recipientAccount = getAccountByNumber(transferAccountNumber);
                if (recipientAccount != null) {
                    account.transferTo(recipientAccount, transferAmount);
                } else {
                    System.out.println("The recipient account number you entered does not exist.");
                }
                break;

            // If the user enters any other input, it's considered as invalid and they're
            // asked to try again.
            default:
                System.out.println("Invalid input, please try again.");
                break;
        }
    }

}
