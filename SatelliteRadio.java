public class SatelliteRadio extends AddonPurchaseDecorator {
    
    public SatelliteRadio(Vehicle vehicle) {
        super(vehicle);
    }

    public  double getVehicleAddon()
    {
        return this.vehicle.getVehicleSP() * 0.05 ;
    }
    
   
}
