public class CreateFactoryPattern  {

    // below enum taken reference from Bruce shared code
    public enum vehicleType {ElectricCars,ElectricTrucks,Formula1Cars,MonsterTrucks,Motorcycles,PerformanceCars,PickUpCars,RacingMotorcycles,RegularCars}
    public enum staffType {Driver,Intern,Mechanic,Salesperson}
    public enum staffWashSTrategy {ChemicalStrategy,DetailedStrategy,ElbowGreaseStrategy}
   
    
    

    public static Vehicle createVehicle(vehicleType type) {

        switch (type) {
            case ElectricCars:
            return new ElectricCars();
            case ElectricTrucks:
            return new ElectricTrucks();
            case Formula1Cars:
            return new Formula1Cars();
            case MonsterTrucks:
            return new MonsterTrucks();
            case Motorcycles:
            return new Motorcycles();
            case PerformanceCars:
            return new PerformanceCars();
            case PickUpCars:
            return new PickUpCars();
            case RacingMotorcycles:
            return new RacingMotorcycles();
            case RegularCars:
            return new RegularCars();
            default:
            throw new IllegalArgumentException("Unknown vehicle type");
       
}   }

public static Staff createStaff(staffType type) {

    switch (type) {
        case Driver:
        return new Driver();
        case Intern:
        return new Intern();
        case Mechanic:
        return new Mechanic();
        case Salesperson:
        return new Salesperson();
        default:
        throw new IllegalArgumentException("Unknown staff type");
    }

   }

   public static Intern createStaffWashSTrategy(staffWashSTrategy type) {

    switch (type) {
        case ChemicalStrategy:
        return new Intern(new ChemicalStrategy());
        case DetailedStrategy:
        return new Intern(new DetailedStrategy());
        case ElbowGreaseStrategy:
        return new Intern(new ElbowGreaseStrategy());
        default:
        throw new IllegalArgumentException("Unknown staff wash stratgy type");
    }

   }

  
    }
