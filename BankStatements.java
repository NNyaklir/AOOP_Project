import java.util.Scanner;

//@TODO: Finish implementation
public class BankStatements {
    Scanner scan = new Scanner(System.in);
    Searcher search = new Searcher();

    try
    {
        boolean validInput = false;
            while (!validInput) {
                System.out.println(
                        "Generate Statement via: \n 1. Account name \n 2. Account ID \n return to previous menu");
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
                                    "What is the account ID? \n");
                            String accountType = scan.nextLine();
                            if (accountType.length()==4){
                                    int accNum = Integer.parseInt(scan.nextLine());
                                    int checkIndex = search.searchByChecking(accNum, checkList);
                                    checkList.get(checkIndex).displayInformation();
                                    adminLogIn();
                                    validInput2 = true;
                                    break;
                            }
                                else{
                                    adminLogIn();
                                    validInput2 = true;
                                    break;
                                }
                                default:
                                    System.out.println("Incorrect input please try again");
                                    adminLogIn();
                                    break;
                            }
                        }
                 } 
            }
}}