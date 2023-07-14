import java.io.*;
import java.util.ArrayList;

public class CsvImporter {
    protected ArrayList<Customer> custList= new ArrayList<Customer>();
    protected ArrayList<Checking> checkingList;
    protected ArrayList<Saving> savingList;
    protected ArrayList<Credit> creditList;

    /** method to import csv files, this will be hardcoded. should only be used once. */
    protected void dataImport(){

        String file="C:\\Users\\devin\\Documents\\VSCode Workstations\\Computer-Organization-Freudenthal\\AOOP_Project\\BankUsers.csv";

        String[][] data= importCSVto2darray(file);

        for (int i=1;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                
                    //yes i know there are a lot of errors ill fix it before final push, this is more like skeleton than anything else rn
                        
                    Customer cust= new Customer();
                        
                    cust.id=Integer.parseInt(data[i][j]);
                    j++;
                        
                    cust.nameFirst=data[i][j];
                    j++;
                        
                    cust.nameLast=data[i][j];
                    j++;
                        
                    cust.dob=data[i][j];
                    j++;
                        
                    cust.address=data[i][j];
                    j++;
                        
                    cust.phoneNumber=data[i][j];
                    custList.add(cust);
                    j++;
                        
                    //starts checking accounts
                    Checking check= new Checking();
                    check.customer=cust;
                    cust.setChecking(check);
                    check.accountNumber=Integer.parseInt(data[i][j]);
                    j++;
                        
                    check.balance=Integer.parseInt(data[i][j]);
                    checkingList.add(check);
                    j++;
                    
                    //starts saving accounts
                    Saving sav= new Saving();
                    sav.customer=cust;
                    cust.setSaving(sav);
                    sav.accountNumber=Integer.parseInt(data[i][j]);
                    j++;
                    
                    sav.balance=Integer.parseInt(data[i][j]);
                    savingList.add(sav);
                    j++;
                        

                    //starts credit accounts
                    Credit cred = new Credit();
                    cred.customer=cust;
                    cust.custCredit=cred;
                    cred.accountNumber=Integer.parseInt(data[i][j]);
                    j++;
                        
                    cred.maxCredit=Integer.parseInt(data[i][j]);
                    j++;
                    
                    cred.balance=Integer.parseInt(data[i][j]);
                    j++;
                    creditList.add(cred);
                    
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
                String[] values=line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                columns=Math.max(columns,values.length);
            }
            data= new String[rows][columns]; //2d array to store values

            br.close();
            br = new BufferedReader(new FileReader(csvFile));

            int row=0;
            while((line=br.readLine())!=null){
                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
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