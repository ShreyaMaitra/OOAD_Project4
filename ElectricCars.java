import java.util.Random;

public class ElectricCars extends Vehicle {
    private String carCondition;
   

    public  double getVehicleAddon()
    {
        return Sp;
    }
   

    public String VehicleType ()
    {
        return "ElectricCars";
    }

    public int VehicleWashBonus ()
    {
        return 125;
    }

    public double VehicleRepairBonus ()
    {
        return 325;
    }
    public double VehicleSaleBonus ()
    {
        return 2200;
    }

   
 
    public Double VehicleCost()   // example of polymorphism
    {   
        Random r = new Random ();
        int min = 23000;
        int max = 44000;
        double carCost = r.nextInt(max-min) + min;       
        return carCost;
    }

}
