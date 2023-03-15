import java.util.ArrayList;
import java.util.Random;

public class Buyer {
    
    private String buyingIntend ;
    private double buyingAbility;
    private String desiredVehicle;
    private String type;
    static ArrayList<Vehicle> VehicleInv;
    
   

    public Buyer()
    {
       this.buyingIntend = setBuyingIntention();
      this.desiredVehicle = setDesiredVehicle();
         this.type = "buyer";

    }
   
    public double getBuyingAbility() {
        return buyingAbility;
    }

    public void setBuyingAbility(double buyingAbility) {
        this.buyingAbility = buyingAbility;
    }
   

    public String getBuyingIntention() {
        return buyingIntend;
    }
        
    public String setBuyingIntention() {
        
        final String[] cond =  { "Just Looking", "Wants One", "Needs One"};
        Random rand = new Random();
        String condition = cond[rand.nextInt(cond.length)];
        return condition;    
    }
    
    public String getDesiredVehicle() {
        return desiredVehicle;
    }

    public String setDesiredVehicle()
    {   
       
        final String[] cond =  { "RegularCar", "PerformanceCar", "PickUpCar"};
        Random rand = new Random();
        String condition = cond[rand.nextInt(cond.length)];
        return condition;
    }
    
    public static void setVehicleInventory (Vehicle v)
    {
        System.err.println("i m in buyer");
        VehicleInv.add(v);
    }


}

