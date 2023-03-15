import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class MonthlyWorkingStatistics {

       public static void InitializecarInventory( ArrayList<Vehicle> inventoryList, int num_car_inventory)
    {
      
        for (int i = 0; i <num_car_inventory; i++)
          {  
            // adding to inventory using factory pattern
           inventoryList.add(CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.RegularCars));
           inventoryList.add(CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.PickUpCars));
           inventoryList.add(CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.PerformanceCars));
           inventoryList.add(CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.ElectricCars));
           inventoryList.add(CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.MonsterTrucks));
           inventoryList.add(CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.Motorcycles));
           inventoryList.add(CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.RacingMotorcycles));
           inventoryList.add(CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.Formula1Cars));
           inventoryList.add(CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.ElectricTrucks));

          // inventoryList.add(new PickUpCars());
          // inventoryList.add(new PerformanceCars());    
          // inventoryList.add(new ElectricCars());
          // inventoryList.add(new MonsterTrucks());
          // inventoryList.add(new Motorcycles());
          }
              
              
       // Based on condition of the cars reduce their Cost Price and selling Price
          for (Vehicle car : inventoryList) {

              System.out.println("name :"+car.getVehicleName()+"  Car type :"+ car.VehicleType()+"  Vehicle Condition : "+ car.VehicleCondition());
            if (car.VehicleCondition().equals("Used"))            {               
                 car.setCarPrice(car.getVehicleCost()*0.8);  
                 car.setVehicleSP(car.getVehicleCost());          }
            else if (car.VehicleCondition().equals("Broken"))            {
                car.setCarPrice(car.getVehicleCost()*0.5);   
                car.setVehicleSP(car.getVehicleCost());          }
            else {car.setVehicleSP(car.getVehicleCost()); }
            // if electric car is like new then add range
           if (car.VehicleType().equals("ElectricCars") && car.VehicleCondition().equals("Like New"))
           {
            car.setVehicleRange(car.getVehicleRange()+100);
           }
             
        }
        Collections.shuffle(inventoryList); // shuffling the order of vehicles stored in inventory 
    }

    public static void InitializeStaffInventory( ArrayList<Staff> s, int num_staff_inventory)
    {
  // Creating employees using factory pattern
        for (int k = 0; k <num_staff_inventory; k++)
        {  
            System.out.println("creating other staffs");
           s.add(CreateFactoryPattern.createStaff(CreateFactoryPattern.staffType.Mechanic));
            //s.add(new Mechanic());
            s.add(CreateFactoryPattern.createStaff(CreateFactoryPattern.staffType.Salesperson));
          //  s.add(new Salesperson());
            s.add(CreateFactoryPattern.createStaff(CreateFactoryPattern.staffType.Driver));
           // s.add(new Driver()); // new drivers are added
        }
     

        //Adding interns wtith three different wash strategy
        s.add(CreateFactoryPattern.createStaffWashSTrategy(CreateFactoryPattern.staffWashSTrategy.ChemicalStrategy));
        s.add(CreateFactoryPattern.createStaffWashSTrategy(CreateFactoryPattern.staffWashSTrategy.DetailedStrategy));
        s.add(CreateFactoryPattern.createStaffWashSTrategy(CreateFactoryPattern.staffWashSTrategy.ElbowGreaseStrategy));
       // s.add(new Intern(new ChemicalStrategy()));
        //s.add(new Intern(new DetailedStrategy()));
        //s.add(new Intern(new ElbowGreaseStrategy()));

        //to use later to check if each staff can wash or fix two vehicles per day
        for (Staff worker : s) {
              worker.setWorkCount(0);
              worker.setStaffStatus("Working"); // initializing as all ae active workers
              worker.setStaffHealthStatus("Healthy");
        }
    }

    public static void CreateStoreVehicleList( ArrayList<Vehicle> v, ArrayList<Vehicle> inventoryList, int num_store_vehicle)
    {int pc =0;
        int puc =0;
        int rc =0 ; 
        int ec=0;
        int mt=0;
        int mc=0;
        int et=0;
        int fc=0;
        int rm=0;
         // Creating vehicle list consisting 6 of each type
        
         for (Vehicle cars : inventoryList) {
            if (cars.VehicleType().equals("PerformanceCar") && pc <num_store_vehicle)
            {  v.add(cars);
                pc ++;
            }
            if (cars.VehicleType().equals("PickUpCar") && puc <num_store_vehicle)
            {  v.add(cars);
                puc ++;
            }
            if (cars.VehicleType().equals("RegularCar") && rc <num_store_vehicle)
            {  v.add(cars);
                rc ++;
            }
            if (cars.VehicleType().equals("ElectricCars") && ec <num_store_vehicle)
            {  v.add(cars);
                ec ++;
            }
            if (cars.VehicleType().equals("MonsterTrucks") && mt <num_store_vehicle)
            {  v.add(cars);
                mt ++;
            }
            if (cars.VehicleType().equals("Motorcycles") && mc <num_store_vehicle)
            {  v.add(cars);
                mc ++;
            }
            if (cars.VehicleType().equals("ElectricTrucks") && et <num_store_vehicle)
            {  v.add(cars);
                et ++;
            }
            if (cars.VehicleType().equals("Formula1Cars") && fc <num_store_vehicle)
            {  v.add(cars);
                fc ++;
            }
            if (cars.VehicleType().equals("RacingMotorcycles") && rm <num_store_vehicle)
            {  v.add(cars);
                rm ++;
            }
        
        }
    }


    public void start () throws IOException, ParseException{

     
    FileWriter writer = new FileWriter("SimResults.txt", false); // storing the output in the file
        
        
         // Create inventory vehicle list
         ArrayList<Vehicle> inventoryList = new ArrayList<>();  // example of Identity 
         int num_car_inventory = 10;  
       InitializecarInventory(inventoryList, num_car_inventory);
       
      
      // Create StaffList
       ArrayList<Staff> s = new ArrayList<>(); 
       int num_staff_inventory =3;
       InitializeStaffInventory(s, num_staff_inventory );
       
       ArrayList<Vehicle> v = new ArrayList<Vehicle>(); // example of Identity 
       int num_store_vehicle =6;
       CreateStoreVehicleList(v, inventoryList,num_store_vehicle);

 
        ArrayList<Staff> allStaffs = new ArrayList<>(); 
        //List of all Staffs to create inventory
        allStaffs.addAll(s);

        //Initialiszing starting budget
        Double operatingBudget = 10000.00;
        System.out.println("size " + s.size());

        //initiate thetracker at the begining
       // Tracker tracker = new Tracker ();
        //Get the only object available
        System.out.println("vehicle size " + v.size());
        Tracker tracker = Tracker.getInstance();
        
        for (Vehicle c1 : v) {
            System.out.println(c1.getVehicleName()+"  "+ c1.VehicleCleanliness()+"  "+c1.VehicleCondition());
            }
        //Running FNCD for 31 days
        for (int i = 1; i <32; i++)
        {  
           //Initiating the logger at the beginning
          // Logger logger = new Logger();
           
          //Get the only object available
          

          Logger logger = Logger.getInstance();
           

           logger.getDate(i);
           String dateString = "2023-03-"+i;
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           Date  date = dateFormat.parse(dateString);
           Calendar c = Calendar.getInstance();
           c.setTime(date);
           String dayWeekText = new SimpleDateFormat("EEEE").format(date);
           tracker.setTrackerDescription("\n Tracker : Day "+i);

        // Checking if Sunday or not as FNCD is closed on Sunday
        if (dayWeekText.equals("Sunday"))
        {  
            writer.write  ("*** FNCD only runs for Racing Today *** Day "+ i+" "+dayWeekText+ " ***\n")  ;    
            System.out.println("*** FNCD only runs for Racing Today *** Day "+ i+" "+dayWeekText+ " *** "); 
            logger.setDescription("*** FNCD only runs for Racing Today *** Day "+ i+" "+dayWeekText+ " *** ");
            writer.write("....Current budget $"+operatingBudget+")\n");
            System.out.println("......Current budget $"+operatingBudget+")");
            tracker.setTrackerDescription("Current budget $"+operatingBudget);
    
            
            FNCD_North.racing(v,inventoryList,s,writer, logger); // Racing occurs on Sunday
            FNCD_South.racing(v,inventoryList,s,writer, logger); // Racing occurs on Sunday
           
             
        }
        else { 
            writer.write ("*** FNCD Day "+ i+" "+dayWeekText+ " ***\n")  ;    
            System.out.println("*** FNCD Day "+ i+" "+dayWeekText+ " *** ");   
            logger.setDescription("*** FNCD Day "+ i+" "+dayWeekText+ " *** ")  ;  
            // start with opening in FNCD North branch
            operatingBudget= FNCD_North.opening(operatingBudget, s,allStaffs, v, inventoryList, writer,logger, tracker);
             // followed by opening in FNCD South branch
            operatingBudget= FNCD_South.opening(operatingBudget, s,allStaffs, v, inventoryList, writer,logger, tracker);
            FNCD_North.washing(s, v, writer, logger);
            FNCD_South.washing(s, v, writer, logger);
            FNCD_North.repairing( s, v, writer,logger);
            FNCD_South.repairing( s, v, writer,logger);
           
            // using interface to purchase items on 31st day
             if (i == 31){
                Scanner scanner = new Scanner(System.in);
                String location = null;
                Staff salesperson = null;
                String flag = "N";
                String flag1 = "N";
                try {
                    while (true) { 
                Interaction interaction = new Interaction();
                Staff f = null;
                SelectSalespersonCommand ssc = new SelectSalespersonCommand(s);
                System.out.println("1. Select FNCD Location to purchase from"); 
                System.out.println("2. Know your Salesperson's name"); 
                System.out.println("3. To know current time");
                System.out.println("4. To change your salesperson's");
                System.out.println("5. Check the store car inventory to purchase a car");
                System.out.println("6. Purchase any add-on along with the car");
                int choice = scanner.nextInt();

                //choosing FNCD location
                if (choice == 1)
                {
                    System.out.println("Select FNCD Location North or South (N/S) :");
                    String choice1 = scanner.next();
                    if ( choice1.equals("N"))
                    { location = "North";
                System.out.println("Thank you for choosing FNCD North");
                writer.write("\nSelling by user interface in North branch .....");
                logger.setDescription("\nSelling by user interface in North branch .....");
                }
                // N for North and S for South
                    else if ( choice1.equals("S"))
                    {  location = "South";
                        System.out.println("Thank you for choosing FNCD South");
                    writer.write("\nSelling by user interface in South branch .....");
                    logger.setDescription("\nSelling by user interface in South branch .....");
                }
                    else { System.out.println("Sorry wrong input for location, please try again");}
                }
                // to know current salesperson name
                if (choice == 2)
                {
                    interaction.executeCommand(ssc);      
                }
                // to know current date time
                if (choice == 3)
                {
                    interaction.executeCommand(new SelectTimeCommand()); 
                }
                // if want to change salesperson
                if (choice == 4)
                {
                    flag = "Y";
                    interaction.executeCommand(new ChangeStaffCommand(s));
                    
                }
               flag1 = flag;

               // check store invntory
                if (choice == 5)
                {
                    interaction.executeCommand(new ShowStoreInventoryCommand(v));
                    int choice2 = scanner.nextInt();
                    interaction.executeCommand(new ShowCarDetailsCommand(v.get(choice2-1)));
                }
                
                //purchase car with addons
                if (choice == 6)
                {    
                    if (flag1.equals("Y"))
                {
                    f= ChangeStaffCommand.getNewSalesperson();
                }
                else {
                    f= SelectSalespersonCommand.getSalesperson();
                }
                    AddonListCommand ald = new AddonListCommand();
                    interaction.setCommand(ald);
                    int choice3 = scanner.nextInt();
                    interaction.executeCommand(new AddonListCommand(choice3, writer, logger, f));

                    if ( choice3 == 1 || choice3 ==2 || choice3 ==3 || choice3 == 4|| choice3 == 5)
                    {System.out.println("Thank you for the purchase \n");

                    break;
                }
                }     
                
                // for wrong input during user interaction
                if ( choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5 && choice!=6)
                {
                    System.out.println("Sorry wrong input , please try again ");
                }
         
            }  
            //once purchase is done updating inventory accordingly
            if (flag1.equals("Y"))
                {
                    salesperson= ChangeStaffCommand.getNewSalesperson();
                }
                else {
                    salesperson= SelectSalespersonCommand.getSalesperson();
                }
            if (location.equals("North"))
            {
                operatingBudget= FNCD_North.updateVehicleAndStaffDetails(operatingBudget, s, v, inventoryList, salesperson, tracker);
            }
            else if (location.equals("South")){
                operatingBudget= FNCD_South.updateVehicleAndStaffDetails(operatingBudget, s, v, inventoryList, salesperson, tracker);

            }

}   
catch (NumberFormatException e) {
    System.out.println("Input is not a valid integer");
   }
   
             }

      else {
            operatingBudget = FNCD_North.selling(operatingBudget, s, v, dayWeekText, inventoryList, writer, logger, tracker);
            operatingBudget = FNCD_North.selling(operatingBudget, s, v, dayWeekText, inventoryList, writer, logger, tracker);
         }
            if (dayWeekText.equals("Wednesday")) // Racing occurs on wednesday
            {
                FNCD_North.racing(v,inventoryList,s,writer, logger);
                FNCD_South.racing(v,inventoryList,s,writer, logger);
            }
            
            operatingBudget= FNCD_North.ending(operatingBudget, s ,allStaffs, writer,logger, tracker);
            operatingBudget= FNCD_South.ending(operatingBudget, s ,allStaffs, writer,logger, tracker);
         /*    System.out.println("size of inventory day end"+ inventoryList.size());

           System.out.println("size of staff after" + s.size());


            writer.write("\n");
            System.out.println("\n");
            writer.write("Name: \t      No Of Working Days:\t            Total Normal Salary:\t            Total Bonus: \t         Working Status :\t              Health Status : \n");
            System.out.println("Name: \t      No Of Working Days:\t            Total Normal Salary:\t            Total Bonus: \t         Working Status :\t          Health Status : \n");
            
            for (Staff person : allStaffs) {
      
              writer.write(person.getStaffname()+"\t         "+person.getWorkingDays()+"\t                               "+person.getTotalStaffSalary()
              +"\t                      "  +person.getTotalStaffBonus()+"\t               "+person.getStaffStatus() + "\t               "+person.getStaffHealthStatus() + "\n");
             System.out.println(person.getStaffname()+"\t         "+person.getWorkingDays()+"\t                               "+person.getTotalStaffSalary()
             +"\t                      "  +person.getTotalStaffBonus()+"\t               "+person.getStaffStatus()+ "\t               "+person.getStaffHealthStatus());
            }  
           
            writer.write("\n");
            System.out.println("\n");
            writer.write("Name: \t     Cost Price:\t            Sale Price:\t            Condition: \t         Cleanliness : \t           Status:  \t             Races Won: \n");
            System.out.println("Name: \t     Cost Price:\t            Sale Price:\t            Condition: \t         Cleanliness : \t           Status:  \t                Races Won: \n");
            
            for (Vehicle car : inventoryList) {
              //  car.setVehicleSP(car.getVehicleCost());
              writer.write(car.getVehicleName()+"\t         "+car.getVehicleCost()+"\t           "+car.getVehicleSP()    +"\t            "  +car.VehicleCondition()+"\t              "+car.VehicleCleanliness() + "\t             "+car.getVehicleStatus()+"\t             " +car.getRaceCount()+ "\n");
             System.out.println(car.getVehicleName()+"\t         "+car.getVehicleCost()+"\t           "+car.getVehicleSP()    +"\t            "  +car.VehicleCondition()+"\t              "+car.VehicleCleanliness() + "\t             "+car.getVehicleStatus()+"\t             "+car.getRaceCount());
            
            } 
 */
          /*  for (Staff pp : s) {
            logger.setDescription(pp.getStaffname()+"  "+pp.getStaffType() + "  "+pp.getStaffHealthStatus());
            }*/
            
            
            
       }
       logger.writeToFile();
    }
    tracker.writeToFile();   
    writer.close();
    }  
}

