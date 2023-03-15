import java.util.Random;

public class ElectricTrucks extends Vehicle{
   
    public  double getVehicleAddon()
    {
        return Sp;
    }
    public String VehicleType ()
    {
        return "ElectricTrucks";
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
        final String[] TRUCK_NAMES ={"Air Force Afterburner Electric", "Avenger Electric","BAd News Travels Fast Electric","Batman Electric","Backwards Bob Electric","BearFoot (1979) Electric", "Bear Foot (F-150) Electric", "Bear Foot (2xtreme) Electric","Bear Foot (Silverado) Electric", "Bear Foot USA Electric", "Bigfoot Electric", "Black STallion Electric","Blacksmith Electric",
        "Blue Thunder Electric", "Bounty Hunter Electric", "Brutus Electric", "Bulldozer Electric","Captain's Curse Electric","Cyborg Electric", "El Toro Loco Electric", "Grave Digger Electric", "Grinder Electric","Gunslinger Electric",
    "Jurassic Attack Electric","King Krunch Electric","Lucas Oil Crusader Electric","Madusa Electric","Maximum Destruction (Max-D) Electric","Mohawk Warrior Electric", "Monster Mutt Electric", "Monster Mutt Dalmatian Electric",
    "Predator Electric","Shell Camino Electric","Raminator Electric","Snake Bite Electric","Stone Crusher Electric","Sudden Impact Electric","Swamp Thing Electric","The Destroyer Electric","The Felon Electric","USA-1 Electric","War Wizard Electric",
    "WCW Nitro Machine Electric", "Zombie Electric"};
         Random random1 = new Random();
      String truckName = TRUCK_NAMES[random1.nextInt(TRUCK_NAMES.length)];
      String fullcarname = truckName + "_" + random1.nextInt() ;
      return fullcarname;

    }
    
}
