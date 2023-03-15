import java.util.Random;

public class ChemicalStrategy implements WashStrategy {
    String Newcleanliness;

    public void doWash(Vehicle vehicle)
    {  
        System.out.println("Oldcleanliness: "+vehicle.VehicleCleanliness()); 
        String cleanliness = vehicle.VehicleCleanliness();
        Random rand = new Random();
        double r = rand.nextDouble();
        if (cleanliness.equals("Dirty"))
        { 
            if (r < 0.8) {
                Newcleanliness = "Clean";
                vehicle.setCleanliness(Newcleanliness);

            } else if (r < 0.9) {
                Newcleanliness = "Sparkling";
                vehicle.setCleanliness(Newcleanliness);
            }
            else {Newcleanliness = "NA";}
        }

       else if (cleanliness.equals("Clean"))
        { 
            if (r < 0.1) {
                Newcleanliness = "Dirty";
                vehicle.setCleanliness(Newcleanliness);
            } else if (r < 0.3) {
                Newcleanliness = "Sparkling";
                vehicle.setCleanliness(Newcleanliness);
            }
            else {Newcleanliness = "NA";}
        }

        else {
            Newcleanliness= cleanliness;
            vehicle.setCleanliness(Newcleanliness);
        }
        System.out.println("Newcleanliness: "+Newcleanliness);
       // return vehicle;
    }
}
