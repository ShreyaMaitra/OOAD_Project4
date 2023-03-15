import java.util.Random;

public class DetailedStrategy implements WashStrategy {
    String Newcleanliness;

    public String doWash(String cleanliness)
    {  
        System.out.println("Oldcleanliness: "+cleanliness);
        Random rand = new Random();
        double r = rand.nextDouble();
        if (cleanliness.equals("Dirty"))
        { 
            if (r < 0.6) {
                Newcleanliness = "Clean";
            } else if (r < 0.8) {
                Newcleanliness = "Sparkling";
            }
            else {Newcleanliness = "NA";}
        }

       else if (cleanliness.equals("Clean"))
        { 
            if (r < 0.05) {
                Newcleanliness = "Dirty";
            } else if (r < 0.45) {
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
