import java.util.Random;

public class ElbowGreaseStrategy implements WashStrategy {
    String Newcleanliness;

    public String doWash(String cleanliness)
    {  
        System.out.println("Oldcleanliness: "+cleanliness);
        Random rand = new Random();
        double r = rand.nextDouble();
        if (cleanliness.equals("Dirty"))
        { 
            if (r < 0.7) {
                Newcleanliness = "Clean";
            } else if (r < 0.75) {
                Newcleanliness = "Sparkling";
            }
            else {Newcleanliness = "NA";}
        }

       else if (cleanliness.equals("Clean"))
        { 
            if (r < 0.15) {
                Newcleanliness = "Dirty";
            } else if (r < 0.3) {
                Newcleanliness = "Sparkling";
            }
            else {Newcleanliness = "NA";}
        }

        else {
            Newcleanliness= cleanliness;
        }

        System.out.println("Newcleanliness: "+Newcleanliness);
        return Newcleanliness;
    }
}
