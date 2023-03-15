import java.util.Random;

public class Motorcycles extends Vehicle {
    
    
    public String VehicleType ()
    {
        return "Motorcycles";
    }
    public  double getVehicleAddon()
    {
        return Sp;
    }
    public int VehicleWashBonus ()
    {
        return 25;
    }

    public double VehicleRepairBonus ()
    {
        return 235;
    }
    public double VehicleSaleBonus ()
    {
        return 1335;
    }

    public double VehicleWinBonus ()
    {
        return 1935;
    }

 
    public Double VehicleCost()   // example of polymorphism
    {   
        Random r = new Random ();
        int min = 13500;
        int max = 23500;
        double carCost = r.nextInt(max-min) + min;       
        return carCost;
    }
}
