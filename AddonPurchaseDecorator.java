public abstract class AddonPurchaseDecorator extends Vehicle {
    protected Vehicle vehicle;
    
    // implementing the decorator pattern
    public AddonPurchaseDecorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public  abstract double getVehicleAddon();
    }
        
    

    

