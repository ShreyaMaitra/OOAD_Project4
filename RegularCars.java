import java.util.Random;

// Below is an example of inheritance
public class RegularCars extends Vehicle{
   

    public String VehicleType ()
    {
        return "RegularCar";
    }
    public  double getVehicleAddon()
    {
        return Sp;
    }

    public Double VehicleCost()    // example of polymorphism
    {   
        Random r = new Random ();
        int min = 10000;
        int max = 20000;
        double carCost = r.nextInt(max-min) + min; 
       
        return carCost;
    }

    public int VehicleWashBonus ()
    {
        return 100;
    }

    public double VehicleRepairBonus ()
    {
        return 150;
    }
    public double VehicleSaleBonus ()
    {
        return 1000;
    }
}
