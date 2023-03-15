import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class SelectTimeCommand implements CommandPattern{
   
    @Override
    public void execute() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        
     System.out.println("Current date time is :"+  dtf.format(now));
        //return salesperson;
       
    }

    @Override
    public void setCommand() {
        
    }
}
