import java.util.ArrayList;

public class ShowStoreInventoryCommand implements CommandPattern{
    ArrayList<Vehicle> v;
    public ShowStoreInventoryCommand(ArrayList<Vehicle> v) {
       this.v = v;
	}


    @Override
    public void execute() {
        int i = 1;
     System.out.println("Please select the number which you want to purchase");
        for (Vehicle car : v){
     System.out.println(i + " " + car.getVehicleName());
        i ++;
        }
    }


    @Override
    public void setCommand() {
        
    }
}
