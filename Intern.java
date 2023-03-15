import java.util.Random;

public class Intern extends Staff{

    public String washBehaviour;
    private WashStrategy washStrategy;

    // Implementing Strategy Pattern
    public Intern(WashStrategy washStrategy)
    {    
        this.washStrategy = washStrategy;
        
      washBehaviour = determineWashingStrategy();     
    
    }

    public Intern()
    {    
             
    }

    public String getWashBehaviour()
    {
        return washBehaviour;
    }
 
    public double determineStaffsalary ()
    {
       // System.out.println("i m in intern");
       // staffType();
        double min = 50;
        double max = 80;
        double salary = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return salary;
    }

    public String staffType ()
    {
        return "Intern";
    }

    public Double wash (double washBonus)
    {
        return washBonus;
    }

    public String determineWashingStrategy()
    {
        final String[] cond =  { "Chemical", "Elbow Grease", "Detailed"};
        Random rand = new Random();
        String condition = cond[rand.nextInt(cond.length)];
        return condition;
    }

}
