public class ShowCarDetailsCommand implements CommandPattern{
    static Vehicle v1;

        public ShowCarDetailsCommand(Vehicle v1) {
            this.v1 = v1;
        }

        public static Vehicle getVehicleBuy()
    {  
        return v1;
    }


        @Override
    public void execute() {
        System.out.println("Name : " + v1.getVehicleName());
        System.out.println("Type : " + v1.VehicleType());
        System.out.println("Condition : " + v1.VehicleCondition());
        System.out.println("Cleanliness : " + v1.VehicleCleanliness());
        System.out.println("Price : " + v1.getVehicleSP());
    }

        @Override
        public void setCommand() {
            
        }
    }

    
