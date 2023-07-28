import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**A helper class for UI to show a customer log */
public class ShowCustomerLog {

    /**Public method that will print the customer log file and other relevant information in the terminal */
    
    protected void printLog(Customer cust){

        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));

        System.out.println("Current date and time : "+dtf.format(now));
        System.out.println("Customer Log:");

        //outputfile to terminal
        

        try {
            InputStream input = new BufferedInputStream(new FileInputStream(cust.getLogPath()));
            byte[] buffer = new byte[8192];
            for (int length = 0; (length = input.read(buffer)) != -1;) {
                System.out.write(buffer, 0, length);
                }
            input.close();
        }
        catch(Exception e){
            System.out.println("Unable to generate log");
        }
        
     


        System.out.println("Current customer basic information:");
        cust.displayInformation();


    }

    
}
