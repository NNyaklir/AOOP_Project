import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**A helper class for UI to show a customer log */
public class ShowCustomerLog {

    protected void printLog(Customer cust){

        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));

        System.out.println("Current date and time : "+dtf.format(now));
        

        System.out.println("Current customer basic information:");
        cust.displayInformation();


    }

    
}
