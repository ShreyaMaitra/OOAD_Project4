public class ExtendedWarranty extends AddonPurchaseDecorator {


    public ExtendedWarranty(Vehicle vehicle) {
        super(vehicle);    }

    public  double getVehicleAddon()
    {
        return this.vehicle.getVehicleSP() * 0.2 ;
    }
    
    
}
