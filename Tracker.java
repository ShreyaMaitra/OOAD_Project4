import java.io.FileWriter;
import java.io.IOException;

//singleton class With Lazy initialization
public class Tracker implements PublisherObserver {
    
    private static Tracker instance;
 
    private Tracker()
    {
      // private constructor
    }
   
    //method to return instance of class
    public static Tracker getInstance()
    {
      if (instance == null)
      {
        // if instance is null, initialize
        instance = new Tracker();
      }
      return instance;
    }

    private String t="";

    public void setTrackerDescription(String t) {
        this.t = this.t+t+"\n";
       }

       public void writeToFile() 
   {
    String filename = "Tracker.txt";
    try (FileWriter writer = new FileWriter(filename)) {
        writer.write(t + "\n");

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
