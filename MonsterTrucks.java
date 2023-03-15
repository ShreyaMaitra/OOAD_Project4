import java.util.Random;

public class MonsterTrucks extends Vehicle{
   
    public  double getVehicleAddon()
    {
        return Sp;
    }
    public String VehicleType ()
    {
        return "MonsterTrucks";
    }

    public int VehicleWashBonus ()
    {
        return 115;
    }

    public double VehicleRepairBonus ()
    {
        return 305;
    }
    public double VehicleSaleBonus ()
    {
        return 2300;
    }

    public double VehicleWinBonus ()
    {
        return 900;
    }

 
    public Double VehicleCost()   // example of polymorphism
    {   
        Random r = new Random ();
        int min = 23300;
        int max = 44400;
        double carCost = r.nextInt(max-min) + min;       
        return carCost;
    }

    public String getCarname ()
    {
        final String[] TRUCK_NAMES ={"Air Force Afterburner", "Avenger","BAd News Travels Fast","Batman","Backwards Bob","BearFoot (1979)",
        "Bear Foot (F-150)", "Bear Foot (2xtreme)","Bear Foot (Silverado)", "Bear Foot USA", "Bigfoot", "Black STallion","Blacksmith",
    "Blue Thunder", "Bounty Hunter", "Brutus", "Bulldozer","Captain's Curse","Cyborg", "El Toro Loco", "Grave Digger", "Grinder","Gunslinger",
"Jurassic Attack","King Krunch","Lucas Oil Crusader","Madusa","Maximum Destruction (Max-D)","Mohawk Warrior", "Monster Mutt", "Monster Mutt Dalmatian",
"Predator","Shell Camino","Raminator","Snake Bite","Stone Crusher","Sudden Impact","Swamp Thing","The Destroyer","The Felon","USA-1","War Wizard",
"WCW Nitro Machine", "Zombie"};
         Random random1 = new Random();
      String truckName = TRUCK_NAMES[random1.nextInt(TRUCK_NAMES.length)];
      String fullcarname = truckName + "_" + random1.nextInt() ;
      return fullcarname;

    }
    
}
