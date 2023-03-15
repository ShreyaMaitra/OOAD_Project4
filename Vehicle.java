import java.util.ArrayList;
import java.util.Random;

//Example of cohesion as all the methods related to Vehicle are desribed in one class
public  abstract class Vehicle 
 {
    
    private Double carCost;
    private String carName;
    private String carCondition;
    private String carCleanliness;
    private String carType;
    private int bonus;
    protected double Sp;
    private ArrayList<Vehicle> v;
    //private ArrayList<Vehicle> soldCarlist;
    private String carStatus;
    private int raceCount;
    private int carRange;
    private int engineSize;
    public double mean = 700;
    private static double stdDev = 300;
    private static double lowerBound = 50;

    
    public Vehicle()
    {   
       this.carName = getCarname();
      this.carCondition = determineCondition();
       this.carType = VehicleType();
       this.carCost = VehicleCost();
       //setVehicleSP(this.carCost);
       this.carRange = setVehicleRange();
       this.Sp = getVehicleSP();
      this.carCleanliness = determineCleanliness();
      this.carStatus = "In Stock";
      //this.Sp = set2 * this.carCost;

    }

    public  abstract double getVehicleAddon();

    public double getVehicleSP()
{
    return Sp;
}

public int setVehicleRange()   
{   
    Random r = new Random ();
    int min = 60;
    int max = 400;
    int carRange = r.nextInt(max-min) + min;       
    return carRange;
}

//setting the engine size
public int setVehicleEngineSize()   
{   
    double value;
     Random rand = new Random();
    
    do {
        value = rand.nextGaussian() * stdDev + mean;
    } while (value < lowerBound);

    engineSize = (int) Math.round(value);
    return engineSize;
}



public int getVehicleRange()
{
    return carRange;
}

public void setVehicleRange( int carRange)
{
    this.carRange = carRange;
}

    public void setVehicleSP(double Cp) {
        this.Sp = 2* Cp;
    }
    
    public String getVehicleStatus()
    {
        return carStatus;
    }

    public void setVehicleStatus(String carStatus )
    {
        
        this.carStatus = carStatus;
    }

    public String VehicleName()
    {
        return carName;
    }

    public String getVehicleName()
    {
        return carName;
    }
    //The below method is also defined in Class PerformanceCars, PickUpCars, RegularCars.. hence example of polymorphism
    public Double VehicleCost()   
    {
        return carCost;
    }

    public Double getVehicleCost()
    {
        return carCost;
    }

    public String VehicleCondition()
    {
        return carCondition;
    }
    public String VehicleCleanliness()
    {
        return carCleanliness;
    }
    public String VehicleType()
    {
        return carType;
    }

    public String VehicleStatus()
    {
       
     return carStatus;
    }

    public void setRaceCount(int raceCount)
    {
        this.raceCount= raceCount;
    }

    public int getRaceCount()
    {
        
        return raceCount;
    }
    public String getCarname ()
    {
        final String[] FIRST_NAMES =  { "Tesla","Ford","RAM", "Subaru","Ferrari", "Lamborghini", "Porsche", "Audi", "Bentley", "BMW", "Maruti", "i10","i20",
        "Bugatti", "Mercedes", "Jaguar" };
         final String[] LAST_NAMES = { "XL", "XS", "SUV", "Sedan", "LUX", "Sumo", "Racer", "Sports", "Hatchback", "Sports","Outback", "Edge","Forester", "EXL","DX", "AC"  };
   
      Random random = new Random();
      String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
      String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
      String fullcarname = firstName + "_" + lastName+"_"+ random.nextInt() ;
      return fullcarname;

    }
    
    public String determineCondition ()
    {
        final String[] cond =  { "Like New", "Used", "Broken"};
        Random rand = new Random();
        String condition = cond[rand.nextInt(cond.length)];
        return condition;
    }

    public String determineCleanliness ()
    {
        String[] cleanlinessStates = {"Sparkling", "Clean", "Dirty"};
        Random random = new Random();
            int randNum = random.nextInt(100);
        if (randNum < 5) {
            carCleanliness = cleanlinessStates[0];
        } else if (randNum < 40) {
            carCleanliness = cleanlinessStates[1];
        } else {
            carCleanliness = cleanlinessStates[2];
        }
        return carCleanliness;
    }
    

    public void setCleanliness(String cleanliness) {
        this.carCleanliness = cleanliness;
    }

    public void setCondition(String carCondition) {
        this.carCondition = carCondition;
    }

    public void setCarPrice(Double carCost) {
        this.carCost = carCost;
    }

    public void setCarSellingPrice(Double Sp) {
        this.Sp = Sp;
    }

    public int VehicleWashBonus() {
        return bonus;
    }

    public double VehicleRepairBonus() {
        return bonus;
    }

    public double VehicleSaleBonus() {
        return bonus;
    }
    

    /*public void addSoldCarList(Vehicle mostExpensive)
    {
        
        soldCarlist.add(mostExpensive);
    }
    */

    
    public ArrayList<Vehicle> getInventory()
    {
       
    return v; 
    }

    public double VehicleWinBonus() {
        return bonus;
    }


}
