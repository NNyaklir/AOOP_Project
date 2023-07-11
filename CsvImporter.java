import java.io.*;
import java.util.ArrayList;

public class CsvImporter {
    protected ArrayList<Customer> custList;
    protected ArrayList<Checking> checkingList;


    /** method to import csv files, this will be hardcoded. should only be used once. */
    protected void importCSV(){

        String file="AOOP_Project\\BankUsers.csv";

        BufferedReader reader=null;
        String line="";

        try{
            reader=new BufferedReader(new FileReader(file));

            while((line=reader.readLine()) !=null){

                int i=0;//there are 13 things to go through
                int j=0;
                if(j==0){
                    while(i<=12){
                        String[] row=line.split(",");
                        i++;
                    }
                    j+=1;  
                    i=0;
                }
                else{
                    switch(i){
                        //yes i know there are a lot of errors ill fix it before final push, this is more like skeleton than anything else rn
                        case 0:
                        Customer cust= new Customer();
                        cust.id=Integer.parseInt(line.split(","));
                        i++;
                        break;

                        case 1:
                        cust.nameFirst=line.split(",");
                        i++;
                        break;

                        case 2:
                        cust.nameLast=line.split(",");
                        i++;
                        break;

                        case 3:
                        cust.dob=line.split(",");
                        i++;
                        break;

                        case 4:
                        cust.address=line.split(",");
                        i++;
                        break;

                        case 5:
                        cust.phoneNumber=line.split(",");
                        custList.add(cust);
                        i++;
                        break;

                        case 6:
                        Checking check= new Checking();
                        check.customer=cust;
                        check.accountNumber=line.split(",");
                        i++;
                        break;

                        case 7:
                        check.balance=line.split(",");
                        i++;
                        
                        break;

                        case 8:



                    }
                } 
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        finally{
            reader.close();
        }
    }
    
}
