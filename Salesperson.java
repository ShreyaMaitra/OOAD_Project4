
public class Salesperson extends Staff {
   
    // Below is an example of inheritance
    public double determineStaffsalary ()
    {
        //Random random = new Random();
       // System.out.println("i m in salesperson");
       //staffType();
        double min = 80;
        double max = 100;
        double salary = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return salary;
    }
    public String staffType ()
    {
        return "Salesperson";
    }

   
}

    

