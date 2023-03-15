import java.io.FileWriter;
import java.io.IOException;

// singleton class by Eager Initialization
public class Logger implements PublisherObserver {
   private String s="";
   private int day;
   FileWriter writer;
  
 
   
 

  // Eager instantiation
  private Logger() {}
 
  public static Logger getInstance()
  { Logger logger = new Logger();
      return logger;
  }

   public void writeToFile() 
   {
    String filename = "Logger-" + day + ".txt";
   FileWriter writer;
try {
    writer = new FileWriter(filename);
    writer.write("Simulation day " + day + ":\n");
    writer.write(s + "\n");
    writer.close();
} catch (IOException e) {
    
    e.printStackTrace();
}
   
   
    } 


public void getDate(int day) {
    this.day = day;
   }

   public void setDescription(String s) {
    this.s = this.s+s+"\n";
   }
    
}
