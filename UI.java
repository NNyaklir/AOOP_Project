import java.util.ArrayList;
import java.util.Scanner;

/** A class that provides a UI for main */
public class UI {
    private ArrayList<Customer> custList;
    private ArrayList<Checking> checkList;
    private ArrayList<Saving> savList;
    private ArrayList<Credit> creditList;

    public void runStartUp() {
        CsvImporter importer = new CsvImporter();
        importer.dataImport();
        this.custList = importer.getCustList();
        this.checkList = importer.getCheckList();
        this.savList = importer.getSavingList();
        this.creditList = importer.getCreditList();

    }

    public void runUI() {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the El Paso Miners Banking system");
            System.out.println("please log-in below");

            boolean validInput = false;
            while (!validInput) {
                System.out.println("1. Customer log-in \n" + "2. Bank Management log-in");
                System.out.println("Type EXIT to exit application");

                int c = Integer.parseInt(scan.nextLine());
                switch (c) {
                    case 1:
                        customerLogIn();
                        validInput = true;
                        break;

                    case 2:
                        validInput = true;
                        adminLogIn();
                        break;

                    default:
                        System.out.println("Incorrect input please try again");
                        break;
                }
                if (scan.nextLine().equals("EXIT")) {
                    CsvImporter importer = new CsvImporter();
                    importer.export();
                    break;
                }
                if (scan.nextLine().equals("EXIT")) {
                    CsvImporter importer = new CsvImporter();
                    importer.export();
                    break;
                }
            }

            scan.close();
        }
    }

    private void adminLogIn() {
        Scanner scan = new Scanner(System.in);
        Searcher search = new Searcher();

        boolean validInput = false;
        while (!validInput) {
            System.out.println(
                    "Welcome Admin. What would you like to do today?\n 1.Inquire account by name\n 2.Inquire account by type/number\n 3.Go back");
            int c = Integer.parseInt(scan.nextLine());
            switch (c) {
                case 1:
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
                    }

                    break;

                case 2:

                    boolean validInput2 = false;
                    while (!validInput2) {
                        System.out.println("What is the account type?\n 1.Checking\n 2.Saving\n 3.Credit\n 4.Go back");
                        int z = Integer.parseInt(scan.nextLine());
                        switch (z) {

                            case 1:
                                System.out.println("Please enter account number");
                                int accNum = Integer.parseInt(scan.nextLine());
                                int checkIndex = search.searchByChecking(accNum, checkList);
                                checkList.get(checkIndex).displayInformation();
                                adminLogIn();
                                validInput2 = true;
                                break;

                            case 2:
                                System.out.println("Please enter account number");
                                int accNum2 = Integer.parseInt(scan.nextLine());
                                int savIndex = search.searchBySaving(accNum2, savList);
                                savList.get(savIndex).displayInformation();
                                adminLogIn();
                                validInput2 = true;
                                break;

                            case 3:
                                System.out.println("Please enter account number");
                                int accNum3 = Integer.parseInt(scan.nextLine());
                                int credIndex = search.searchByCredit(accNum3, creditList);
                                creditList.get(credIndex).displayInformation();
                                adminLogIn();
                                validInput2 = true;
                                break;

                            case 4:
                                adminLogIn();
                                validInput2 = true;
                                break;

                            default:
                                System.out.println("Incorrect input please try again");
                                break;

                        }
                    }
                    validInput = true;
                    break;

                case 3:
                    runUI();
                    validInput = true;
                    break;

                default:
                    System.out.println("Incorrect input please try again");
                    break;
            }
        }
        scan.close();

    }

    private void customerLogIn() {
        System.out.println("Please enter your first and last name");

        Scanner scan = new Scanner(System.in);
        String accountName = scan.nextLine();

        String[] parts = accountName.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];

        Searcher search = new Searcher();
        int index = search.searchByName(firstName, lastName, custList);

        if (index > 0) {
            System.out.println("Welcome " + firstName + " " + lastName
                    + "!\n What would you like to do?\n 1.Make an inquiry\n 2.Access money services \n 3.Return to the previous menu");
            int c = Integer.parseInt(scan.nextLine());
            boolean validInput = false;
            while (!validInput) {
                switch (c) {
                    case 1:
                        inquiry(custList.get(index));
                        validInput = true;
                        break;

                    case 2:
                        moneyServices(custList.get(index));
                        validInput = true;
                        break;

                    case 3:
                        validInput = true;
                        customerLogIn();
                        break;

                    default:
                        System.out.println("Incorrect input please try again");
                        customerLogIn();
                        break;
                }
            }
        } else {
            System.out.println("User not found, please make sure you input the name correctly");
        }
        scan.close();
    }

    private void moneyServices(Customer primary) {
        System.out.println("Thank you for accessing our money services, what would you like to do?");
        System.out.println(" 1.Deposit\n 2.Withdraw\n 3.Transfer\n 4.Make a Payment \n 5. Return to Log-In");
        Scanner scan = new Scanner(System.in);
        int c = Integer.parseInt(scan.nextLine());
        Logger log = new Logger();
        log.fileCheck();

        boolean validInput = false;
        while (!validInput) {
            switch (c) {
                case 1:
                    deposit(primary);
                    validInput = true;
                    break;

                case 2:
                    withdraw(primary);
                    validInput = true;
                    break;

                case 3:
                    transfer(primary);
                    validInput = true;
                    break;

                case 4:
                    makePayment(primary);
                    validInput = true;
                    break;

                case 5:
                    validInput = true;
                    customerLogIn();
                    break;

                default:
                    System.out.println("Incorrect input please try again");

            }
        }
        scan.close();
    }

    private void makePayment(Customer primary) {
        Scanner scan = new Scanner(System.in);
        Logger log = new Logger();

        System.out.println("Which account would you like to make a payment from?");
        System.out.println(" 1.Checking\n 2.Saving\n 3.Credit");
        int c = Integer.parseInt(scan.nextLine());
        Searcher search = new Searcher();

        boolean validInput = false;
        while (!validInput) {
            switch (c) {
                case 1:
                    Checking check = primary.getChecking();
                    System.out.println(
                            "What Account type are you making a payment to?\n 1.Checking\n 2.Saving\n 3.Credit");
                    int s = Integer.parseInt(scan.nextLine());

                    boolean validInput2 = false;
                    while (!validInput2) {
                        switch (s) {
                            case 1:
                                System.out.println("Please input the account number to make a payment to it");
                                int acc = Integer.parseInt(scan.nextLine());
                                int accIn = search.searchByChecking(acc, checkList);
                                Checking check2 = checkList.get(accIn);
                                System.out.println("please enter the amount to transfer");
                                double transfer = Double.parseDouble(scan.nextLine());
                                check.transferTo(check2, transfer);
                                log.logTransfer(check, transfer, check2);
                                System.out.println("Succesfully transfered " + transfer + " from Checking to Account"
                                        + check2.getAccountNumber());
                                validInput2 = true;
                                break;

                            case 2:
                                System.out.println("Please input the account number to make a payment to it");
                                int acc2 = Integer.parseInt(scan.nextLine());
                                int accIn2 = search.searchBySaving(acc2, savList);
                                Checking sav = checkList.get(accIn2);
                                System.out.println("please enter the amount to transfer");
                                double transfer2 = Double.parseDouble(scan.nextLine());
                                check.transferTo(sav, transfer2);
                                log.logTransfer(check, transfer2, sav);
                                System.out.println("Succesfully transfered " + transfer2 + " from Checking to Account"
                                        + sav.getAccountNumber());
                                validInput2 = true;
                                break;

                            case 3:
                                System.out.println("Please input the account number to make a payment to it");
                                int acc3 = Integer.parseInt(scan.nextLine());
                                int accIn3 = search.searchByCredit(acc3, creditList);
                                Checking cred = checkList.get(accIn3);
                                System.out.println("please enter the amount to transfer");
                                double transfer3 = Double.parseDouble(scan.nextLine());
                                check.transferTo(cred, transfer3);
                                log.logTransfer(check, transfer3, cred);
                                System.out.println("Succesfully transfered " + transfer3 + " from Checking to Account"
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

                case 2:
                    Saving sav = primary.getSaving();
                    System.out.println(
                            "What Account type are you making a payment to?\n 1.Checking\n 2.Saving\n 3.Credit");
                    int x = Integer.parseInt(scan.nextLine());

                    boolean validInput3 = false;
                    while (!validInput3) {
                        switch (x) {
                            case 1:
                                System.out.println("Please input the account number to make a payment to it");
                                int acc = Integer.parseInt(scan.nextLine());
                                int accIn = search.searchByChecking(acc, checkList);
                                Checking check2 = checkList.get(accIn);
                                System.out.println("please enter the amount to transfer");
                                double transfer = Double.parseDouble(scan.nextLine());
                                sav.transferTo(check2, transfer);
                                log.logTransfer(sav, transfer, check2);
                                System.out.println("Succesfully transfered " + transfer + " from Checking to Account"
                                        + check2.getAccountNumber());
                                validInput3 = true;
                                break;

                            case 2:
                                System.out.println("Please input the account number to make a payment to it");
                                int acc2 = Integer.parseInt(scan.nextLine());
                                int accIn2 = search.searchBySaving(acc2, savList);
                                Checking sav2 = checkList.get(accIn2);
                                System.out.println("please enter the amount to transfer");
                                double transfer2 = Double.parseDouble(scan.nextLine());
                                sav.transferTo(sav, transfer2);
                                log.logTransfer(sav, transfer2, sav2);
                                System.out.println("Succesfully transfered " + transfer2 + " from Checking to Account"
                                        + sav2.getAccountNumber());
                                validInput3 = true;
                                break;

                            case 3:
                                System.out.println("Please input the account number to make a payment to it");
                                int acc3 = Integer.parseInt(scan.nextLine());
                                int accIn3 = search.searchByCredit(acc3, creditList);
                                Checking cred = checkList.get(accIn3);
                                System.out.println("please enter the amount to transfer");
                                double transfer3 = Double.parseDouble(scan.nextLine());
                                sav.transferTo(cred, transfer3);
                                log.logTransfer(sav, transfer3, cred);
                                System.out.println("Succesfully transfered " + transfer3 + " from Checking to Account"
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

                case 3:
                    Credit cred2 = primary.getCredit();
                    System.out.println(
                            "What Account type are you making a payment to?\n 1.Checking\n 2.Saving\n 3.Credit");
                    int m = Integer.parseInt(scan.nextLine());

                    boolean validInput4 = false;
                    while (!validInput4) {
                        switch (m) {
                            case 1:
                                System.out.println("Please input the account number to make a payment to it");
                                int acc = Integer.parseInt(scan.nextLine());
                                int accIn = search.searchByChecking(acc, checkList);
                                Checking check2 = checkList.get(accIn);
                                System.out.println("please enter the amount to transfer");
                                double transfer = Double.parseDouble(scan.nextLine());
                                cred2.transferTo(check2, transfer);
                                log.logTransfer(cred2, transfer, check2);
                                System.out.println("Succesfully transfered " + transfer + " from Checking to Account"
                                        + check2.getAccountNumber());
                                validInput4 = true;
                                break;

                            case 2:
                                System.out.println("Please input the account number to make a payment to it");
                                int acc2 = Integer.parseInt(scan.nextLine());
                                int accIn2 = search.searchBySaving(acc2, savList);
                                Checking sav2 = checkList.get(accIn2);
                                System.out.println("please enter the amount to transfer");
                                double transfer2 = Double.parseDouble(scan.nextLine());
                                cred2.transferTo(sav2, transfer2);
                                log.logTransfer(cred2, transfer2, sav2);
                                System.out.println("Succesfully transfered " + transfer2 + " from Checking to Account"
                                        + sav2.getAccountNumber());
                                validInput4 = true;
                                break;

                            case 3:
                                System.out.println("Please input the account number to make a payment to it");
                                int acc3 = Integer.parseInt(scan.nextLine());
                                int accIn3 = search.searchByCredit(acc3, creditList);
                                Checking cred = checkList.get(accIn3);
                                System.out.println("please enter the amount to transfer");
                                double transfer3 = Double.parseDouble(scan.nextLine());
                                cred.transferTo(cred, transfer3);
                                log.logTransfer(cred, transfer3, cred);
                                System.out.println("Succesfully transfered " + transfer3 + " from Checking to Account"
                                        + cred.getAccountNumber());
                                validInput4 = true;
                                break;

                            default:
                                System.out.println("Incorrect input please try again");
                                break;
                        }
                    }
                    validInput = true;
                    break;

                default:
                    System.out.println("Incorrect input please try again");
                    break;
            }
        }
        scan.close();
    }

    private void transfer(Customer primary) {
        Scanner scan = new Scanner(System.in);
        Logger log = new Logger();

        System.out.println("Which account would you like to transfer from?");
        System.out.println(" 1.Checking\n 2.Saving\n 3.Credit");
        int c = Integer.parseInt(scan.nextLine());

        boolean validInput = false;
        while (!validInput) {
            switch (c) {
                case 1:
                    System.out.println("What account would you like to transfer to?\n 1.Saving\n 2.Credit");
                    int s = Integer.parseInt(scan.nextLine());
                    boolean validInput2 = false;
                    while (!validInput2) {
                        switch (s) {
                            case 1:
                                System.out.println("Please enter the amount to transfer");
                                double transfer = Double.parseDouble(scan.nextLine());
                                Checking check = primary.getChecking();
                                Saving sav = primary.getSaving();
                                check.transferTo(sav, transfer);
                                log.logTransfer(check, transfer, sav);
                                System.out.print("Successfully transferred " + transfer + " from Checking to Savings");
                                validInput2 = true;
                                break;

                            case 2:
                                System.out.println("Please enter the amount to transfer");
                                double transfer2 = Double.parseDouble(scan.nextLine());
                                Checking check2 = primary.getChecking();
                                Credit cred = primary.getCredit();
                                check2.transferTo(cred, transfer2);
                                log.logTransfer(check2, transfer2, cred);
                                System.out
                                        .println("Successfully transferred " + transfer2 + " from Checking to Credit");
                                validInput = true;
                                break;

                            default:
                                System.out.println("Incorrect input please try again");
                                break;
                        }
                    }
                    validInput = true;
                    break;

                case 2:
                    System.out.println("What account would you like to transfer to?\n 1.Checking\n 2.Credit");
                    int z = Integer.parseInt(scan.nextLine());
                    boolean validInput3 = false;
                    while (!validInput3) {
                        switch (z) {
                            case 1:
                                System.out.println("Please enter the amount to transfer");
                                double transfer = Double.parseDouble(scan.nextLine());
                                Saving sav = primary.getSaving();
                                Checking check = primary.getChecking();
                                sav.transferTo(check, transfer);
                                log.logTransfer(sav, transfer, check);
                                System.out.println("Succesfully transferred " + transfer + " from Savings to Checking");
                                validInput3 = true;
                                break;

                            case 2:
                                System.out.println("Please enter the amount to transfer");
                                double transfer2 = Double.parseDouble(scan.nextLine());
                                Saving sav2 = primary.getSaving();
                                Credit cred = primary.getCredit();
                                sav2.transferTo(cred, transfer2);
                                log.logTransfer(sav2, transfer2, cred);
                                System.out.println("Successfully transferred " + transfer2 + " from Savings to Credit");
                                validInput3 = true;
                                break;

                            default:
                                System.out.println("Incorrect input please try again");
                                break;
                        }
                    }
                    validInput = true;
                    break;

                case 3:
                    System.out.println("What account would you like to transfer to?\n 1.Checking\n 2.Saving");
                    int x = Integer.parseInt(scan.nextLine());
                    boolean validInput4 = false;
                    while (!validInput4) {
                        switch (x) {
                            case 1:
                                System.out.println("Please enter the amount to transfer");
                                double transfer = Double.parseDouble(scan.nextLine());
                                Credit cred = primary.getCredit();
                                Checking check = primary.getChecking();
                                cred.transferTo(check, transfer);
                                log.logTransfer(cred, transfer, check);
                                System.out.println("Successfully transferred " + transfer + " from Credit to Checking");
                                validInput4 = true;
                                break;

                            case 2:
                                System.out.println("Please enter the amount to transfer");
                                double transfer2 = Double.parseDouble(scan.nextLine());
                                Credit cred2 = primary.getCredit();
                                Saving sav = primary.getSaving();
                                cred2.transferTo(sav, transfer2);
                                log.logTransfer(cred2, transfer2, sav);
                                System.out.println("Successfully transferred " + transfer2 + " from Credit to Savings");
                                validInput4 = true;
                                break;

                            default:
                                System.out.println("Incorrect input please try again");
                                break;
                        }
                    }
                    validInput = true;
                    break;

                default:
                    System.out.println("Incorrect input please try again");
                    break;

            }
        }
        scan.close();
    }

    private void withdraw(Customer primary) {
        Scanner scan = new Scanner(System.in);
        Logger log = new Logger();

        System.out.println("Which account would you like to make a withdrawal from?");
        System.out.println(" 1.Checking\n 2.Savings\n 3.Credit");
        int sw = Integer.parseInt(scan.nextLine());
        String withdrawWords = ("Please enter a withdrawal amount");
        String success = ("Succesfully withdrew: ");
        boolean validInput = false;
        while (!validInput) {
            switch (sw) {
                case 1:
                    System.out.println(withdrawWords);
                    Double withdraw = Double.parseDouble(scan.nextLine());
                    Checking wCheck = primary.getChecking();
                    wCheck.charge(withdraw);
                    log.logDeduction(wCheck, withdraw);
                    System.out.println(success + withdraw);
                    validInput = true;
                    break;

                case 2:
                    System.out.println(withdrawWords);
                    double withdraw2 = Double.parseDouble(scan.nextLine());
                    Saving wSav = primary.getSaving();
                    wSav.charge(withdraw2);
                    log.logDeduction(wSav, withdraw2);
                    System.out.println(success + withdraw2);
                    validInput = true;
                    break;

                case 3:
                    System.out.println(withdrawWords);
                    double withdraw3 = Double.parseDouble(scan.nextLine());
                    Credit cred = primary.getCredit();
                    cred.charge(withdraw3);
                    log.logDeduction(cred, withdraw3);
                    System.out.println(success + withdraw3);
                    validInput = true;
                    break;

                default:
                    System.out.println("Incorrect input please try again");
                    break;
            }
        }
        scan.close();

    }

    private void deposit(Customer primary) {
        Scanner scan = new Scanner(System.in);
        Logger log = new Logger();
        System.out.println("Which account would you like to make a deposit in?");
        System.out.println(" 1.Checking\n 2.Savings\n 3.Credit");
        int s = Integer.parseInt(scan.nextLine());
        boolean validInput = false;
        while (!validInput) {
            switch (s) {
                case 1:
                    Checking check = primary.getChecking();
                    System.out.println("Please enter deposit amount");
                    double deposit = Double.parseDouble(scan.nextLine());
                    check.deposit(deposit);
                    log.logAddition(check, deposit);
                    System.out.println("Succesfully deposited: " + deposit);
                    validInput = true;
                    break;

                case 2:
                    Saving sav = primary.getSaving();
                    System.out.println("Please enter deposit amount");
                    double deposit2 = Double.parseDouble(scan.nextLine());
                    sav.deposit(deposit2);
                    log.logAddition(sav, deposit2);
                    System.out.println("Succesfully deposited: " + deposit2);
                    validInput = true;
                    break;

                case 3:
                    Credit cred = primary.getCredit();
                    System.out.println("Please enter a deposit amount");
                    double deposit3 = Double.parseDouble(scan.nextLine());
                    cred.deposit(deposit3);
                    log.logAddition(cred, deposit3);
                    System.out.println("Succesfully deposited: " + deposit3);
                    validInput = true;
                    break;

                default:
                    System.out.println("Incorrect input please try again");
                    break;
            }
        }
        scan.close();

    }

    private void inquiry(Customer cust) {
        System.out.println("What would you like to inquire about?\n 1.Everything\n 2.Checkings\n 3.Savings\n 4.Credit");
        Scanner scan = new Scanner(System.in);
        int c = Integer.parseInt(scan.nextLine());
        Logger log = new Logger();
        log.fileCheck();

        boolean validInput = false;
        while (!validInput) {
            switch (c) {
                case 1:
                    cust.displayInformation();
                    validInput = true;
                    break;

                case 2:
                    Checking check = cust.getChecking();
                    check.displayInformation();
                    log.logInquiry(cust, "Checking");
                    validInput = true;
                    break;

                case 3:
                    Saving sav = cust.getSaving();
                    sav.displayInformation();
                    log.logInquiry(cust, "Savings");
                    validInput = true;
                    break;

                case 4:
                    Credit cred = cust.getCredit();
                    cred.displayInformation();
                    log.logInquiry(cust, "Credit");
                    validInput = true;
                    break;

                default:
                    System.out.println("Incorrect input please try again");
                    break;
            }
        }
        scan.close();

    }

}
