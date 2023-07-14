import java.io.*;
import java.util.ArrayList;

public class CsvImporter {
    protected ArrayList<Customer> custList;
    protected ArrayList<Checking> checkingList;
    protected ArrayList<Saving> savingList;
    protected ArrayList<Credit> creditList;

    /** method to import csv files, this will be hardcoded. should only be used once. */
    protected void importCSV(){

        String file="C:\\Users\\devin\\Documents\\VSCode Workstations\\Computer-Organization-Freudenthal\\AOOP_Project\\BankUsers.csv";

        String[][] data= importCSVto2darray(file);
        BufferedReader reader=null;
        String line="";

        try{
            reader=new BufferedReader(new FileReader(file));

            while((line=reader.readLine()) !=null){
                String[] values=line.split(",");

                int i=0;//there are 13 things to go through
                int j=13;
                
                for(int k=0;k<values.length;k++){
                    switch(i){
                        //yes i know there are a lot of errors ill fix it before final push, this is more like skeleton than anything else rn
                        case 0:
                        Customer cust= new Customer();
                        //System.out.println(values[i+j]);
                        cust.id=Integer.parseInt(values[i+j]);
                        i++; k++;
                        
                        cust.nameFirst=values[i+j];
                        i++;k++;
                        
                        cust.nameLast=values[i+j];
                        i++;k++;
                        
                        cust.dob=values[i+j];
                        i++; k++;
                        
                        cust.address=values[i+j];
                        i++; k++;
                        
                        cust.phoneNumber=values[i+j];
                        custList.add(cust);
                        i++; k++;
                        
                        //starts checking accounts
                        Checking check= new Checking();
                        check.customer=cust;
                        cust.setChecking(check);
                        check.accountNumber=Integer.parseInt(values[i+j]);
                        i++;k++;
                        
                        check.balance=Integer.parseInt(values[i+j]);
                        checkingList.add(check);
                        i++;k++;
                        
                        //starts saving accounts
                        Saving sav= new Saving();
                        sav.customer=cust;
                        cust.setSaving(sav);
                        sav.accountNumber=Integer.parseInt(values[i+j]);
                        i++;k++;
                        
                        sav.balance=Integer.parseInt(values[i+j]);
                        savingList.add(sav);
                        i++;k++;
                        

                        //starts credit accounts
                        Credit cred = new Credit();
                        cred.customer=cust;
                        cust.custCredit=cred;
                        cred.accountNumber=Integer.parseInt(values[i+j]);
                        i++;k++;
                        
                        cred.maxCredit=Integer.parseInt(values[i+j]);
                        i++;k++;
                        

                        cred.balance=Integer.parseInt(values[i+j]);
                        i=0;k++;
                        creditList.add(cred);
                    }
                } 
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
            reader.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }   


    protected String[][] importCSVto2darray(String csvFile){
        String[][] data=null;
        String line="";

        try{
            BufferedReader br= new BufferedReader(new FileReader(csvFile));
            int rows=0;
            int columns=0;

            //this counts rows and columns
            while((line=br.readLine())!=null){
                rows++;
                String[] values=line.split(",");
                columns=Math.max(columns,values.length);
            }
            data= new String[rows][columns]; //2d array to store values

            br.close();
            br = new BufferedReader(new FileReader(csvFile));

            int row=0;
            while((line=br.readLine())!=null){
                String[] values = line.split(",");
                for(int col=0;col<values.length;col++){
                    data[row][col]=values[col];
                }
                row++;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
}