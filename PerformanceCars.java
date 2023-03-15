import java.util.Random;

// Below is an example of inheritance
public class PerformanceCars extends Vehicle {

    

    public String VehicleType ()
    {
        return "PerformanceCar";
    }
    public  double getVehicleAddon()
    {
        return Sp;
    }
    public int VehicleWashBonus ()
    {
        return 200;
    }

    public double VehicleRepairBonus ()
    {
        return 250;
    }
    public double VehicleSaleBonus ()
    {
        return 3000;
    }

    public double VehicleWinBonus ()
    {
        return 1200;
    }
 
    public Double VehicleCost()   // example of polymorphism
    {   
        Random r = new Random ();
        int min = 20000;
        int max = 40000;
        double carCost = r.nextInt(max-min) + min;       
        return carCost;
    }
}
