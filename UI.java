import java.util.ArrayList;
import java.util.Scanner;

/** A class that provides a UI for main */
public class UI {
    private ArrayList<Customer> custList;
    private ArrayList<Checking> checkList;
    private ArrayList<Saving> savList;
    private ArrayList<Credit> creditList;
    private CsvImporter importer = new CsvImporter();

    /**
     * A method that imports data from a CSV file to prepare for the rest of UI
     * method
     */
    public void runStartUp() {
        importer.dataImport();
        this.custList = importer.getCustList();
        this.checkList = importer.getCheckList();
        this.savList = importer.getSavingList();
        this.creditList = importer.getCreditList();

    }

    /** A method that runs a UI in the terminal */ // bug free
    public void runUI() {

        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to the El Paso Miners Banking system");
            System.out.println("please log-in below\n");

            boolean validInput = false;
            while (!validInput) {
                System.out.println("1. Customer log-in \n" + "2. Bank Management log-in\n3. New User");
                System.out.println("Type EXIT to exit application");

                String c = scan.nextLine();
                switch (c) {
                    case "1":
                        customerLogIn();
                        validInput = true;
                        break;

                    case "2":

                        validInput = true;
                        adminLogIn();
                        break;

                    case "3":
                        validInput = true;
                        newUser();
                        break;

                    case "EXIT":
                        validInput = true;
                        importer.export();
                        importer.writeUpdatedCsv();
                        System.out.println("Application exited");
                        // generateReceipt(null);
                        System.exit(0);

                    default:
                        System.out.println("Incorrect input please try again");
                        break;
                }

            }
            scan.close();

        } catch (Exception e) {
            importer.export();
            System.out.println("Incorrect input please try again");
            runUI();
        }
    }

    /** A method that runs the new user UI, exclusively called by runUI */
    private void newUser() {
        Scanner scan = new Scanner(System.in);
        Customer newCust = new Customer();
        try {

            // User input for relevant data fields
            System.out.println("Please enter your first name");
            newCust.setNameFirst(scan.nextLine());
            System.out.println("Please enter your last name");
            newCust.setNameLast(scan.nextLine());
            System.out.println("Please enter your DOB");
            newCust.setDob(scan.nextLine());
            System.out.println("Please enter your address");
            newCust.setAddress(scan.nextLine());
            System.out.println("Please enter your phone number");
            newCust.setPhoneNumber(scan.nextLine());
            AccessNumbers accessor = new AccessNumbers();

            // generation of id/account numbers and accounts
            int id = accessor.getIDNum();
            newCust.setId(id);
            int checkNum = accessor.getCheckNum();
            Checking newChecking = new Checking();
            newChecking.setAccountNumber(checkNum);
            newCust.setChecking(newChecking);
            newChecking.setCustomer(newCust);
            newChecking.setBalance(0);

            Saving newSaving = new Saving();
            int savNum = accessor.getSavNum();
            newSaving.setAccountNumber(savNum);
            newSaving.setBalance(0);
            newSaving.setCustomer(newCust);
            newCust.setSaving(newSaving);

            Credit newCredit = new Credit();
            int credNum = accessor.getCredNum();
            newCredit.setAccountNumber(credNum);
            newCredit.setBalance(0);
            CreditGenerator generator = new CreditGenerator();
            generator.generate();
            newCredit.setMaxCredit(generator.getMaxCredit());
            newCredit.setCustomer(newCust);
            newCust.setCredit(newCredit);

            System.out.println("Your user ID is: " + id);
            System.out.println("Your Checking Account Number is: " + checkNum);
            System.out.println("Your Savings Account Number is: " + savNum);
            System.out.println("Your Credit Account Number is: " + credNum);
            generator.printInfo();
            custList.add(newCust);
            checkList.add(newChecking);
            savList.add(newSaving);
            creditList.add(newCredit);
            System.out.println("\n\n\nHere is all your information");
            newCust.displayInformation();

            importer.incrementUser();
            importer.export();
            // @TODO add export

            runUI();
        } catch (Exception e) {
            System.out.println("Invalid input for parameter, returning to previous screen");
            runUI();

        }
        scan.close();
    }

    /** A method that runs the admin login UI, exclusively called by runUI */

    private void adminLogIn() {
        Scanner scan = new Scanner(System.in);
        Searcher search = new Searcher();

        try {
            boolean validInput = false;
            while (!validInput) {
                System.out.println(
                        "Welcome Admin. What would you like to do today?\n 1.Inquire account by name\n 2.Inquire account by type/number\n 3.Run Transactions\n 4.Go back");
                String choice = scan.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("Please enter the name of the account");
                        String accountName = scan.nextLine();
                        String[] parts = accountName.split(" ");
                        String firstName = parts[0];
                        String lastName = parts[1];
                        int index = search.searchByName(firstName, lastName, custList);
                        if (index > 0) {
                            custList.get(index).displayInformation();
                            validInput = true;
                            adminLogIn();
                        } else {
                            System.out.println("User not found, please input name correctly");
                            break;
                        }
                    case "2":
                        boolean validInput2 = false;
                        while (!validInput2) {
                            System.out.println(
                                    "What is the account type?\n 1.Checking\n 2.Saving\n 3.Credit\n 4.Go back");
                            String accountType = scan.nextLine();
                            switch (accountType) {
                                case "1":
                                    System.out.println("Please enter account number");
                                    int accNum = Integer.parseInt(scan.nextLine());
                                    int checkIndex = search.searchByChecking(accNum, checkList);
                                    checkList.get(checkIndex).displayInformation();
                                    adminLogIn();
                                    validInput2 = true;
                                    break;

                                case "2":
                                    System.out.println("Please enter account number");
                                    int accNum2 = Integer.parseInt(scan.nextLine());
                                    int savIndex = search.searchBySaving(accNum2, savList);
                                    savList.get(savIndex).displayInformation();
                                    adminLogIn();
                                    validInput2 = true;
                                    break;

                                case "3":
                                    System.out.println("Please enter account number");
                                    int accNum3 = Integer.parseInt(scan.nextLine());
                                    int credIndex = search.searchByCredit(accNum3, creditList);
                                    creditList.get(credIndex).displayInformation();
                                    adminLogIn();
                                    validInput2 = true;
                                    break;
                                case "4":
                                    adminLogIn();
                                    validInput2 = true;
                                    break;
                                default:
                                    System.out.println("Incorrect input please try again");
                                    adminLogIn();
                                    break;
                            }
                        } // end of while
                        validInput = true;
                        break;
                    case "3":
                        TransactionRunner tRunner = new TransactionRunner();
                        tRunner.runTransactions(custList);
                        validInput = true;
                        break;
                    case "4":
                        runUI();
                        validInput = true;
                        break;
                    default:
                        System.out.println("Incorrect input please try again");
                        adminLogIn();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error occured, returning to admin login");
            e.printStackTrace();
            adminLogIn();
        }
        scan.close();

    }

    /** A method that runs the customer login UI, exclusively called by runUI */ // bug free
    private void customerLogIn() {
        try {
            System.out.println("Please enter your first and last name");

            Scanner scan = new Scanner(System.in);
            String accountName = scan.nextLine();

            String[] parts = accountName.split(" ");
            String firstName = parts[0];
            String lastName = parts[1];

            Searcher search = new Searcher();
            int index = search.searchByName(firstName, lastName, custList);

            if (index > 0) {
                boolean validInput = false;
                while (!validInput) {

                    System.out.println("Welcome " + firstName + " " + lastName
                            + "!\n What would you like to do?\n 1.Make an inquiry\n 2.Access money services \n 3.Return to the previous menu");
                    String choice = scan.nextLine();

                    switch (choice) {
                        case "1":
                            inquiry(custList.get(index));
                            validInput = true;
                            break;

                        case "2":
                            moneyServices(custList.get(index));
                            validInput = true;
                            break;

                        case "3":
                            validInput = true;
                            runUI();
                            break;
                        default:
                            System.out.println("Incorrect input please try again");
                            customerLogIn();
                    }
                } // end of loop
            } else {
                System.out.println("User not found, please make sure you input the name correctly");
                customerLogIn();
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Error occured, returing to customer log in");
            customerLogIn();
        }
    }

    /**
     * A method that runs the money services UI, exclusively called by customerLogIn
     */ // bug free
    private void moneyServices(Customer primary) {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Thank you for accessing our money services, what would you like to do?");
                System.out.println(
                        " 1.Deposit\n 2.Withdraw\n 3.Transfer\n 4.Make a Payment \n 5. Return to Log-In\n 6. Return to Main-Menu");
                Scanner scan = new Scanner(System.in);
                String choice = scan.nextLine();
                Logger log = new Logger();
                log.fileCheck();

                switch (choice) {
                    case "1":
                        deposit(primary);
                        validInput = true;
                        break;

                    case "2":
                        withdraw(primary);
                        validInput = true;
                        break;

                    case "3":
                        transfer(primary);
                        validInput = true;
                        break;

                    case "4":
                        makePayment(primary);
                        validInput = true;
                        break;

                    case "5":
                        validInput = true;
                        customerLogIn();
                        break;

                    case "6":
                        validInput = true;
                        runUI();
                        break;

                    default:
                        System.out.println("Incorrect input please try again");
                        moneyServices(primary);
                        break;
                }

                scan.close();

            } catch (Exception e) {
                System.out.println("Error occured, returning to money services menu");
                moneyServices(primary);
            }
        }
    }

    /** A method that runs the payment UI, exclusively called by moneyServices */
    private void makePayment(Customer primary) {
        try {
            Scanner scan = new Scanner(System.in);
            Logger log = new Logger();

            boolean validInput = false;
            while (!validInput) {
                System.out.println("Which account would you like to make a payment from?");
                System.out.println(" 1.Checking\n 2.Saving\n 3.Credit\n 4.Return to Money Services");
                String c = scan.nextLine();
                Searcher search = new Searcher();

                switch (c) {
                    case "1":
                        Checking check = primary.getChecking();
                        int main = search.searchByChecking(check.getAccountNumber(), checkList);
                        System.out.println("What Account type are you making a payment to?");
                        System.out.println(" 1.Checking\n 2.Saving\n 3.Credit");
                        String s = scan.nextLine();
                        boolean validInput2 = false;
                        while (!validInput2) {
                            switch (s) {
                                case "1":
                                    System.out.println("Please input the account number to make a payment to it");
                                    int acc = Integer.parseInt(scan.nextLine());
                                    int accIn = search.searchByChecking(acc, checkList);
                                    Checking check2 = checkList.get(accIn);
                                    System.out.println("please enter the amount to transfer");
                                    double transfer = Double.parseDouble(scan.nextLine());
                                    checkList.get(main).transferTo(checkList.get(accIn), transfer);
                                    log.logTransfer(check, transfer, check2);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer + " from Checking to Account"
                                                    + check2.getAccountNumber());
                                    validInput2 = true;
                                    break;

                                case "2":
                                    System.out.println("Please input the account number to make a payment to it");
                                    int acc2 = Integer.parseInt(scan.nextLine());
                                    int accIn2 = search.searchBySaving(acc2, savList);
                                    Checking sav = checkList.get(accIn2);
                                    System.out.println("please enter the amount to transfer");
                                    double transfer2 = Double.parseDouble(scan.nextLine());
                                    checkList.get(main).transferTo(savList.get(accIn2), transfer2);
                                    log.logTransfer(check, transfer2, sav);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer2 + " from Checking to Account"
                                                    + sav.getAccountNumber());
                                    validInput2 = true;
                                    break;

                                case "3":
                                    System.out.println("Please input the account number to make a payment to it");
                                    int acc3 = Integer.parseInt(scan.nextLine());
                                    int accIn3 = search.searchByCredit(acc3, creditList);
                                    Checking cred = checkList.get(accIn3);
                                    System.out.println("please enter the amount to transfer");
                                    double transfer3 = Double.parseDouble(scan.nextLine());
                                    checkList.get(main).transferTo(creditList.get(accIn3), transfer3);
                                    log.logTransfer(check, transfer3, cred);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer3 + " from Checking to Account"
                                                    + cred.getAccountNumber());
                                    validInput2 = true;
                                    break;

                                default:
                                    System.out.println("Incorrect input please try again");
                                    break;
                            }
                        }
                        validInput = true;
                        break;

                    case "2":
                        Saving sav = primary.getSaving();
                        System.out.println("What Account type are you making a payment to?");
                        System.out.println(" 1.Checking\n 2.Saving\n 3.Credit");
                        String x = scan.nextLine();
                        int savingIn = search.searchBySaving(sav.getAccountNumber(), savList);
                        boolean validInput3 = false;
                        while (!validInput3) {
                            switch (x) {
                                case "1":
                                    System.out.println("Please input the account number to make a payment to it");
                                    int acc = Integer.parseInt(scan.nextLine());
                                    int accIn = search.searchByChecking(acc, checkList);
                                    Checking check2 = checkList.get(accIn);
                                    System.out.println("please enter the amount to transfer");
                                    double transfer = Double.parseDouble(scan.nextLine());
                                    savList.get(savingIn).transferTo(checkList.get(accIn), transfer);
                                    log.logTransfer(sav, transfer, check2);
                                    importer.export();
                                    System.out
                                            .println("Successfully transferred " + transfer + " from Savings to Account"
                                                    + check2.getAccountNumber());
                                    validInput3 = true;
                                    break;

                                case "2":
                                    System.out.println("Please input the account number to make a payment to it");
                                    int acc2 = Integer.parseInt(scan.nextLine());
                                    int accIn2 = search.searchBySaving(acc2, savList);
                                    Checking sav2 = checkList.get(accIn2);
                                    System.out.println("please enter the amount to transfer");
                                    double transfer2 = Double.parseDouble(scan.nextLine());
                                    savList.get(savingIn).transferTo(savList.get(accIn2), transfer2);
                                    log.logTransfer(sav, transfer2, sav2);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer2 + " from Savings to Account"
                                                    + sav2.getAccountNumber());
                                    validInput3 = true;
                                    break;

                                case "3":
                                    System.out.println("Please input the account number to make a payment to it");
                                    int acc3 = Integer.parseInt(scan.nextLine());
                                    int accIn3 = search.searchByCredit(acc3, creditList);
                                    Checking cred = checkList.get(accIn3);
                                    System.out.println("please enter the amount to transfer");
                                    double transfer3 = Double.parseDouble(scan.nextLine());
                                    savList.get(savingIn).transferTo(creditList.get(accIn3), transfer3);
                                    log.logTransfer(sav, transfer3, cred);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer3 + " from Savings to Account"
                                                    + cred.getAccountNumber());
                                    validInput3 = true;
                                    break;
                                default:
                                    System.out.println("Incorrect input please try again");
                                    break;
                            }
                        }
                        validInput = true;
                        break;

                    case "3":
                        Credit cred2 = primary.getCredit();
                        int credIn = search.searchByCredit(cred2.getAccountNumber(), creditList);
                        System.out.println("What Account type are you making a payment to?");
                        System.out.println(" 1.Checking\n 2.Saving\n 3.Credit");
                        String m = scan.nextLine();
                        boolean validInput4 = false;
                        while (!validInput4) {
                            switch (m) {
                                case "1":
                                    System.out.println("Please input the account number to make a payment to it");
                                    int acc = Integer.parseInt(scan.nextLine());
                                    int accIn = search.searchByChecking(acc, checkList);
                                    Checking check2 = checkList.get(accIn);
                                    System.out.println("please enter the amount to transfer");
                                    double transfer = Double.parseDouble(scan.nextLine());
                                    creditList.get(credIn).transferTo(checkList.get(accIn), transfer);
                                    log.logTransfer(cred2, transfer, check2);
                                    importer.export();
                                    System.out
                                            .println("Successfully transferred " + transfer + " from Credit to Account"
                                                    + check2.getAccountNumber());
                                    validInput4 = true;
                                    break;

                                case "2":
                                    System.out.println("Please input the account number to make a payment to it");
                                    int acc2 = Integer.parseInt(scan.nextLine());
                                    int accIn2 = search.searchBySaving(acc2, savList);
                                    Checking sav2 = checkList.get(accIn2);
                                    System.out.println("please enter the amount to transfer");
                                    double transfer2 = Double.parseDouble(scan.nextLine());
                                    creditList.get(credIn).transferTo(savList.get(accIn2), transfer2);
                                    log.logTransfer(cred2, transfer2, sav2);
                                    importer.export();
                                    System.out
                                            .println("Successfully transferred " + transfer2 + " from Credit to Account"
                                                    + sav2.getAccountNumber());
                                    validInput4 = true;
                                    break;
                                case "3":
                                    System.out.println("Please input the account number to make a payment to it");
                                    int acc3 = Integer.parseInt(scan.nextLine());
                                    int accIn3 = search.searchByCredit(acc3, creditList);
                                    Checking cred = checkList.get(accIn3);
                                    System.out.println("please enter the amount to transfer");
                                    double transfer3 = Double.parseDouble(scan.nextLine());
                                    creditList.get(credIn).transferTo(creditList.get(accIn3), transfer3);
                                    log.logTransfer(cred, transfer3, cred);
                                    importer.export();
                                    System.out
                                            .println("Successfully transferred " + transfer3 + " from Credit to Account"
                                                    + cred.getAccountNumber());
                                    validInput4 = true;
                                    break;

                                default:
                                    System.out.println("Incorrect input please try again");
                            }
                        }
                        validInput = true;
                        break;

                    case "4":
                        moneyServices(primary);
                        validInput = true;
                        break;

                    default:
                        System.out.println("Incorrect input please try again");
                        makePayment(primary);
                }
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Error occurred returning to payment menu");
            makePayment(primary);
        }
    }

    /** A method that runs the transfer UI, exclusively called by moneyServices */ // bug free
    private void transfer(Customer primary) {
        try {
            Scanner scan = new Scanner(System.in);
            Logger log = new Logger();
            Searcher search = new Searcher();

            boolean validInput = false;
            while (!validInput) {
                System.out.println("Which account would you like to transfer from?");
                System.out.println(" 1.Checking\n 2.Saving\n 3.Credit\n 4.Return to Money Services");
                String choice = scan.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("What account would you like to transfer to?\n 1.Saving\n 2.Credit");
                        String accountType = scan.nextLine();
                        boolean validInput2 = false;
                        while (!validInput2) {
                            switch (accountType) {
                                case "1":
                                    System.out.println("Please enter the amount to transfer");
                                    double transfer = Double.parseDouble(scan.nextLine());
                                    Checking check = primary.getChecking();
                                    Saving sav = primary.getSaving();
                                    int checkI = search.searchByChecking(check.getAccountNumber(), checkList);
                                    int savI = search.searchBySaving(sav.getAccountNumber(), savList);
                                    checkList.get(checkI).transferTo(savList.get(savI), transfer);
                                    log.logTransfer(check, transfer, sav);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer + " from Checking to Savings");
                                    validInput2 = true;
                                    break;

                                case "2":
                                    System.out.println("Please enter the amount to transfer");
                                    double transfer2 = Double.parseDouble(scan.nextLine());
                                    Checking check2 = primary.getChecking();
                                    Credit cred = primary.getCredit();
                                    int checkI2 = search.searchByChecking(check2.getAccountNumber(), checkList);
                                    int credI = search.searchByCredit(cred.getAccountNumber(), creditList);
                                    checkList.get(checkI2).transferTo(creditList.get(credI), transfer2);
                                    log.logTransfer(check2, transfer2, cred);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer2 + " from Checking to Credit");
                                    validInput2 = true;
                                    break;

                                default:
                                    System.out.println("Incorrect input please try again");
                                    break;
                            }
                            validInput = true;
                            break;
                        }

                    case "2":
                        System.out.println("What account would you like to transfer to?\n 1.Checking\n 2.Credit");
                        String accountType2 = scan.nextLine();
                        boolean validInput3 = false;
                        while (!validInput3) {
                            switch (accountType2) {
                                case "1":
                                    System.out.println("Please enter the amount to transfer");
                                    double transfer = Double.parseDouble(scan.nextLine());
                                    Saving sav = primary.getSaving();
                                    Checking check = primary.getChecking();
                                    int savI = search.searchBySaving(sav.getAccountNumber(), savList);
                                    int checkI = search.searchByChecking(check.getAccountNumber(), checkList);
                                    savList.get(savI).transferTo(checkList.get(checkI), transfer);
                                    log.logTransfer(sav, transfer, check);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer + " from Savings to Checking");
                                    validInput3 = true;
                                    break;

                                case "2":
                                    System.out.println("Please enter the amount to transfer");
                                    double transfer2 = Double.parseDouble(scan.nextLine());
                                    Saving sav2 = primary.getSaving();
                                    Credit cred = primary.getCredit();
                                    int savI2 = search.searchBySaving(sav2.getAccountNumber(), savList);
                                    int credI = search.searchByCredit(cred.getAccountNumber(), creditList);
                                    savList.get(savI2).transferTo(creditList.get(credI), transfer2);
                                    log.logTransfer(sav2, transfer2, cred);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer2 + " from Savings to Credit");
                                    validInput3 = true;
                                    break;

                                default:
                                    System.out.println("Incorrect input please try again");
                                    break;
                            }
                        }
                        validInput = true;
                        break;

                    case "3":
                        System.out.println("What account would you like to transfer to?\n 1.Checking\n 2.Saving");
                        String accountType3 = scan.nextLine();
                        boolean validInput4 = false;
                        while (!validInput4) {
                            switch (accountType3) {
                                case "1":
                                    System.out.println("Please enter the amount to transfer");
                                    double transfer = Double.parseDouble(scan.nextLine());
                                    Credit cred = primary.getCredit();
                                    Checking check = primary.getChecking();
                                    int credI = search.searchByCredit(cred.getAccountNumber(), creditList);
                                    int checkI = search.searchByChecking(check.getAccountNumber(), checkList);
                                    creditList.get(credI).transferTo(checkList.get(checkI), transfer);
                                    log.logTransfer(cred, transfer, check);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer + " from Credit to Checking");
                                    validInput4 = true;
                                    break;

                                case "2":
                                    System.out.println("Please enter the amount to transfer");
                                    double transfer2 = Double.parseDouble(scan.nextLine());
                                    Credit cred2 = primary.getCredit();
                                    Saving sav = primary.getSaving();
                                    int credI2 = search.searchByCredit(cred2.getAccountNumber(), creditList);
                                    int savI = search.searchBySaving(sav.getAccountNumber(), savList);
                                    creditList.get(credI2).transferTo(savList.get(savI), transfer2);
                                    log.logTransfer(cred2, transfer2, sav);
                                    importer.export();
                                    System.out.println(
                                            "Successfully transferred " + transfer2 + " from Credit to Savings");
                                    validInput4 = true;
                                    break;

                                default:
                                    System.out.println("Incorrect input please try again");
                                    break;
                            }
                        }
                        validInput = true;
                        break;

                    case "4":
                        moneyServices(primary);
                        validInput = true;
                        break;

                    default:
                        System.out.println("Incorrect input please try again");
                        break;
                }
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Error returing to transfer menu");
            transfer(primary);
        }
    }

    /** A method that runs the withdraw UI, exclusively called by moneyServices */ // bug free
    private void withdraw(Customer primary) {
        try {
            Scanner scan = new Scanner(System.in);
            Logger log = new Logger();
            Searcher search = new Searcher();

            boolean validInput = false;
            while (!validInput) {
                System.out.println("Which account would you like to make a withdrawal from?");
                System.out.println(" 1.Checking\n 2.Savings\n 3.Credit\n 4.Return to Money Services");
                String choice = scan.nextLine();
                String withdrawWords = ("Please enter a withdrawal amount");
                String success = ("Successfully withdrew: ");

                switch (choice) {
                    case "1":
                        System.out.println(withdrawWords);
                        double withdraw = Double.parseDouble(scan.nextLine());
                        Checking wCheck = primary.getChecking();
                        int checkI = search.searchByChecking(wCheck.getAccountNumber(), checkList);
                        checkList.get(checkI).charge(withdraw);
                        log.logDeduction(wCheck, withdraw);
                        importer.export();
                        System.out.println(success + withdraw);
                        validInput = true;
                        break;

                    case "2":
                        System.out.println(withdrawWords);
                        double withdraw2 = Double.parseDouble(scan.nextLine());
                        Saving wSav = primary.getSaving();
                        int savI = search.searchBySaving(wSav.getAccountNumber(), savList);
                        savList.get(savI).charge(withdraw2);
                        log.logDeduction(wSav, withdraw2);
                        importer.export();
                        System.out.println(success + withdraw2);
                        validInput = true;
                        break;

                    case "3":
                        System.out.println(withdrawWords);
                        double withdraw3 = Double.parseDouble(scan.nextLine());
                        Credit cred = primary.getCredit();
                        int credI = search.searchByCredit(cred.getAccountNumber(), creditList);
                        creditList.get(credI).charge(withdraw3);
                        log.logDeduction(cred, withdraw3);
                        importer.export();
                        System.out.println(success + withdraw3);
                        validInput = true;
                        break;

                    case "4":
                        moneyServices(primary);
                        validInput = true;
                        break;

                    default:
                        System.out.println("Incorrect input please try again");
                        break;
                }
            }
            scan.close();
        }

        catch (Exception e) {
            System.out.println("Error occurred, returning to withdraw menu");
        }
    }

    /** A method that runs the deposit UI, exclusively called by moneyServices */ // bug free
    private void deposit(Customer primary) {
        try {
            Searcher search = new Searcher();
            Scanner scan = new Scanner(System.in);
            Logger log = new Logger();

            System.out.println("Which account would you like to make a deposit in?");
            System.out.println(" 1.Checking\n 2.Savings\n 3.Credit\n 4.Return to Money Services");

            boolean validInput = false;

            while (!validInput) {
                System.out.println("Which account would you like to make a deposit in?");
                System.out.println("1.Checking\n 2.Savings\n 3.Credit\n 4.Return to Money Services");
                String choice = scan.nextLine(); // Moved inside the loop to update choice in each iteration.

                switch (choice) {
                    case "1":
                        Checking check = primary.getChecking();
                        System.out.println("Please enter deposit amount");
                        double deposit = Double.parseDouble(scan.nextLine());
                        int checkIdx = search.searchByChecking(check.getAccountNumber(), checkList);
                        checkList.get(checkIdx).deposit(deposit);
                        log.logAddition(check, deposit);
                        importer.export();
                        System.out.println("Successfully deposited: " + deposit);
                        validInput = true;
                        generateReceipt(check);
                        break;

                    case "2":
                        Saving sav = primary.getSaving();
                        System.out.println("Please enter deposit amount");
                        double deposit2 = Double.parseDouble(scan.nextLine());
                        int savingIdx = search.searchBySaving(sav.getAccountNumber(), savList);
                        savList.get(savingIdx).deposit(deposit2);
                        log.logAddition(sav, deposit2);
                        importer.export();
                        System.out.println("Successfully deposited: " + deposit2);
                        validInput = true;
                        break;

                    case "3":
                        Credit cred = primary.getCredit();
                        System.out.println("Please enter a deposit amount");
                        double deposit3 = Double.parseDouble(scan.nextLine());
                        int credIdx = search.searchByCredit(cred.getAccountNumber(), creditList);
                        creditList.get(credIdx).deposit(deposit3);
                        log.logAddition(cred, deposit3);
                        importer.export();
                        System.out.println("Successfully deposited: " + deposit3);
                        validInput = true;
                        break;
                    case "4":
                        moneyServices(primary);
                        validInput = true;
                        break;

                    default:
                        System.out.println("Incorrect input please try again");
                        break;
                }
            }

            scan.close();
        } catch (Exception e) {
            System.out.println("Error occurred, returning to deposit menu");
            deposit(primary);
        }
    }

    /** A method that runs the inquiry UI, exclusively called by customerLogin */ // bug free
    private void inquiry(Customer cust) {
        boolean validInput = false;
        Scanner scan = new Scanner(System.in);
        Logger log = new Logger();

        while (!validInput) {
            try {
                System.out.println(
                        "What would you like to inquire about?\n 1.Everything\n 2.Checkings\n 3.Savings\n 4.Credit\n 5.Return to login");

                String choice = scan.nextLine();

                switch (choice) {
                    case "1":
                        cust.displayInformation();
                        log.logInquiry(cust, "Everything");
                        break;

                    case "2":
                        Checking check = cust.getChecking();
                        check.displayInformation();
                        log.logInquiry(cust, "Checking");
                        break;

                    case "3":
                        Saving sav = cust.getSaving();
                        sav.displayInformation();
                        log.logInquiry(cust, "Savings");
                        break;

                    case "4":
                        Credit cred = cust.getCredit();
                        cred.displayInformation();
                        log.logInquiry(cust, "Credit");
                        break;

                    case "5":
                        customerLogIn();
                        validInput = true;
                        break;

                    default:
                        System.out.println("Incorrect input please try again");
                }

            } catch (Exception e) {
                System.out.println("Error occurred, returning to inquiry menu");
            }
        }

        // Close the scanner after the loop is finished.
        scan.close();
    }

    /*
     * private void generateReceipt(Account account) {
     * String accountInfo = "Account Information:\n";
     * 
     * accountInfo += "Account Number: " + account.getAccountNumber() + "\n";
     * accountInfo += "Account Holder: " + account.getCustomer() + "\n";
     * 
     * double startingBalance = account.getBalance();
     * double endingBalance = account.getBalance(); //
     * 
     * List<String> transactions = Logger.logInquiry(account.getAccountNumber()); //
     * need to integrate
     * // with the Logger
     * // class to fetch all
     * // transactions for
     * // the account.
     * String dateOfStatement = new SimpleDateFormat("yyyy-MM-dd").format(new
     * Date());
     * StringBuilder receipt = new StringBuilder();
     * 
     * receipt.append(accountInfo);
     * receipt.append("Starting Balance: " + startingBalance + "\n");
     * receipt.append("Ending Balance: " + endingBalance + "\n");
     * receipt.append("Transactions:\n");
     * 
     * for (String transaction : transactions) {
     * receipt.append(transaction + "\n");
     * }
     * 
     * receipt.append("Date of Statement: " + dateOfStatement);
     * 
     * try (PrintWriter out = new PrintWriter(new
     * FileWriter("UserTransactions.txt"))) {
     * out.println(receipt.toString());
     * } catch (IOException e) {
     * System.out.println("Error writing to file: " + e.getMessage());
     * }
     * 
     * }
     */

}
