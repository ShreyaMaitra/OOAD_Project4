public class Driver extends Staff {
    public String staffType ()
    {
        return "Driver";
    }
    // Below is an example of inheritance
    public double determineStaffsalary ()
    {
        //Random random = new Random();
       // System.out.println("i m in salesperson");
       //staffType();
        double min = 380;
        double max = 880;
        double salary = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return salary;
    }
    

   
   
}

