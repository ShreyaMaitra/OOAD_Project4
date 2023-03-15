public class RoadRescueCoverage extends AddonPurchaseDecorator {
    public RoadRescueCoverage(Vehicle vehicle) {
        super(vehicle);
     
    }

    public  double getVehicleAddon()
    {
        return this.vehicle.getVehicleSP() * 0.02 ;
    }
    
    
}
