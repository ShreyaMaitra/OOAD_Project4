import java.io.IOException;
import java.io.Writer;

public class AddonListCommand implements CommandPattern {

    String addon;
    static double addOnfactor ;
    Writer writer;
    Logger logger;
    Staff f;
    

    public AddonListCommand(int choice3, Writer writer, Logger logger, Staff f) {
        if (choice3 == 1)
        { addon = "Road Rescue Coverage";
        addOnfactor= 0.02;}
        else if (choice3 == 2)
        { addon = "Undercoating";
        addOnfactor= 0.05;}
        else if (choice3 == 3)
        { addon = "Extended Warranty";
        addOnfactor= 0.2;}
        else if (choice3 == 4)
        { addon = "Satellite Radio";
        addOnfactor= 0.05;}
        else if (choice3 == 5)
        {addon = "None";
        addOnfactor= 0;}
this.writer = writer;
this.logger = logger;
this.f =f;
        }
    
       
    public static double getaddonFactor()
    {
        return addOnfactor;
    }

    public AddonListCommand() {
    }

    @Override
    public void execute() {
        double FinalSpp;
        double FinalSp = ShowCarDetailsCommand.getVehicleBuy().getVehicleSP();
        double extra = addOnfactor * ShowCarDetailsCommand.getVehicleBuy().getVehicleSP();
       // increasing price as it has won a race
        if(ShowCarDetailsCommand.getVehicleBuy().getRaceCount()>1)
       {
        FinalSpp = (extra + FinalSp) * 1.1;
       }
      else {FinalSpp = (extra + FinalSp);
    }
    System.out.println("Salesperson "+f.getStaffname()+ " sold "+ShowCarDetailsCommand.getVehicleBuy().getVehicleName()+
    " to user interface buyer with Addon: "+addon
    + " (Price Increased by $"+extra +") for $"+FinalSpp +"(earned bonus $"+
    ShowCarDetailsCommand.getVehicleBuy().VehicleSaleBonus()+" bonus)");
    
    try {
        writer.write("Salesperson "+f.getStaffname()+ " sold "+ShowCarDetailsCommand.getVehicleBuy().getVehicleName()+
        " to user interface buyer with Addon: "+addon
        + " (Price Increased by $"+extra +") for $"+FinalSpp +"(earned bonus $"+
        ShowCarDetailsCommand.getVehicleBuy().VehicleSaleBonus()+" bonus)");
        writer.write("Total Sales : " + FinalSpp+" ");
    } catch (IOException e) {
        e.printStackTrace();
    }

    logger.setDescription("Salesperson "+f.getStaffname()+ " sold "+ShowCarDetailsCommand.getVehicleBuy().getVehicleName()+
    " to user interface buyer with Addon: "+addon
    + " (Price Increased by $"+extra +") for $"+FinalSpp +"(earned bonus $"+
    ShowCarDetailsCommand.getVehicleBuy().VehicleSaleBonus()+" bonus)");
    
    }

    @Override
    public void setCommand() {
        System.out.println("Please choose any of the following add-on");
        System.out.println("1. Road Rescue Coverage ");
        System.out.println("2. Undercoating " );
        System.out.println("3. Extended Warranty ");
        System.out.println("4. Satellite Radio"); 
        System.out.println("5. None");    
    }
}
