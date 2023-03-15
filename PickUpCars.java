import java.util.Random;

// Below is an example of inheritance
public class PickUpCars extends Vehicle{
    
    
    public PickUpCars() {
    }
    public  double getVehicleAddon()
    {
        return Sp;
    }
    public String VehicleType ()
    {
        return "PickUpCar";
    }

    public Double VehicleCost() // example of polymorphism
    {   
        Random r = new Random ();
        int min = 10000;
        int max = 40000;
        double carCost = r.nextInt(max-min) + min;
        return carCost;
    }

    public int VehicleWashBonus ()
    {
        return 300;
    }

    public double VehicleRepairBonus ()
    {
        return 350;
    }

    public double VehicleSaleBonus ()
    {
        return 2000;
    }

    public double VehicleWinBonus ()
    {
        return 1100;
    }
}
