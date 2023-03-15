public class Undercoating extends AddonPurchaseDecorator {
    public Undercoating(Vehicle vehicle) {
        super(vehicle);
    }

    public  double getVehicleAddon()
    {
        return this.vehicle.getVehicleSP() * 0.05 ;
    }
    
    
}
