
// Below is an example of inheritance
public class Mechanic extends Staff{
    public double determineStaffsalary ()
    {
       // System.out.println("i m in mechanic");
       //staffType();
        double min = 20;
        double max = 50;
        double salary = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return salary;
    }

    public String staffType ()
    {
        return "Mechanic";
    }


}
