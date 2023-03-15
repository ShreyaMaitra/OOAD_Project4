import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FNCD_South extends Buyer {

  public static double updateVehicleAndStaffDetails(double operatingBudget, ArrayList<Staff> s, ArrayList<Vehicle> v, ArrayList <Vehicle>inventoryList, Staff f,Tracker tracker  )
  { double FinalSp;
    double extra =  AddonListCommand.getaddonFactor() * ShowCarDetailsCommand.getVehicleBuy().getVehicleSP();
    if (ShowCarDetailsCommand.getVehicleBuy().getRaceCount()>1)
    {
      FinalSp = (extra+ ShowCarDetailsCommand.getVehicleBuy().getVehicleSP()) * 1.1;
    }
    else{FinalSp = (extra+ ShowCarDetailsCommand.getVehicleBuy().getVehicleSP());}
  
    // Updating Staff bonus
    for (Staff person : s)
  {
  if (person.getStaffname().equals(f.getStaffname()))
  {
    person.updateStaffBonus(ShowCarDetailsCommand.getVehicleBuy().VehicleSaleBonus());
    person.setStaffStatus("Worked"); 
  }
  }
  //removing from car list
  v.remove(ShowCarDetailsCommand.getVehicleBuy());
  
  //update car inventory
  for (Vehicle v2 : inventoryList)
  {
    if (v2.getVehicleName().equals(ShowCarDetailsCommand.getVehicleBuy().getVehicleName())) 
    {
      v2.setVehicleStatus("Sold");
      v2.setCarSellingPrice(FinalSp);
  }
  }
    // adding salesprice to operating budget
  operatingBudget = operatingBudget + FinalSp;
  System.out.println("Total Sales : " + FinalSp);
  tracker.setTrackerDescription("Total money  earned by FNCD : $"+FinalSp);
  return operatingBudget;
  }


    // method to add intern
    public static void hireIntern (int c,ArrayList<Staff> s , ArrayList<Staff> allStaffs, FileWriter writer, Logger logger) throws IOException
        {
            for (int i = c; i < 3; i++)
            {
                //Intern intn = new Intern(new ChemicalStrategy()); //assuming the new interns added use Chemical wash stategy
                Intern intn = CreateFactoryPattern.createStaffWashSTrategy(CreateFactoryPattern.staffWashSTrategy.ChemicalStrategy);

                intn.setWorkCount(0);
                intn.setStaffStatus("Working"); 
                intn.setStaffHealthStatus("Healthy");
                s.add(intn);
            allStaffs.add(intn);
            writer.write("Hired Intern "+ s.get(i).getStaffname()+"\n");
            System.out.println("Hired Intern "+ s.get(i).getStaffname());
            logger.setDescription("Hired Intern "+ s.get(i).getStaffname());
        }
        
        }
        
        // tracking if operating budget is required and update operating budget accrdingly
        public static double checkOperatingBudget (double operatingBudget, FileWriter writer, Tracker tracker) throws IOException
        {
           if (operatingBudget <0)
           {
            tracker.setTrackerDescription("Old Operating Budget : $"+operatingBudget);
            operatingBudget = operatingBudget+250000;
            writer.write(" ***  Adding operating budget of $250000   ***\n");
            
           tracker.setTrackerDescription("Adding $250000 to operating budget  ");
           tracker.setTrackerDescription("New Operating Budget : $"+operatingBudget);
            System.out.println(" ***  Adding operating budget of $250000   ***\n");
        }
           
            return operatingBudget;
        }

      
      // method to add vehicle
        public static double addVehicle (int c,ArrayList<Vehicle> v ,ArrayList<Vehicle> inventoryList, String type, 
        double operatingBudget, FileWriter writer, Logger logger) throws IOException
        {   System.out.println("i m in add vehicle" + type );         
            double cost= 0;
            if ( type.equals("RegularCar"))
            { System.out.println("i m RegularCar add vehicle");  
            for (int i = c; i < 6; i++)
            {   

              Vehicle newCar = CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.RegularCars);
                //RegularCars newCar = new RegularCars(); 
                if (newCar.VehicleCondition().equals("Used"))            {               
                  newCar.setCarPrice(newCar.getVehicleCost()*0.8);  
                  newCar.setVehicleSP(newCar.getVehicleCost());          }
             else if (newCar.VehicleCondition().equals("Broken"))            {
              newCar.setCarPrice(newCar.getVehicleCost()*0.5);   
              newCar.setVehicleSP(newCar.getVehicleCost());          }
             else {newCar.setVehicleSP(newCar.getVehicleCost()); }
                v.add(newCar);
                System.out.println("after i m RegularCar add vehicle"); 
                inventoryList.add(newCar);
                inventoryList.add(newCar); // add new vehicles to the inventory list 
                cost = newCar.VehicleCost();
                operatingBudget = operatingBudget - cost;
                writer.write("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
                +newCar.VehicleType()+" for $"+ cost + " Cost\n");
                System.out.println("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
                +newCar.VehicleType()+" for $"+ cost + " Cost");
                logger.setDescription("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
                +newCar.VehicleType()+" for $"+ cost + " Cost");
            }
        }
            if ( type.equals("PerformanceCar"))
            { System.out.println("i m PerformanceCar add vehicle");  
            for (int j = c; j < 6; j++)
            {   Vehicle newCar = CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.PerformanceCars);
                //PerformanceCars newCar = new PerformanceCars();
                if (newCar.VehicleCondition().equals("Used"))            {               
                  newCar.setCarPrice(newCar.getVehicleCost()*0.8);  
                  newCar.setVehicleSP(newCar.getVehicleCost());          }
             else if (newCar.VehicleCondition().equals("Broken"))            {
              newCar.setCarPrice(newCar.getVehicleCost()*0.5);   
              newCar.setVehicleSP(newCar.getVehicleCost());          }
             else {newCar.setVehicleSP(newCar.getVehicleCost()); }
                v.add(newCar);
                System.out.println("after i m PerformanceCar add vehicle"); 
                inventoryList.add(newCar); // add new vehicles to the inventory list
                System.out.println("i m here");
                cost = newCar.VehicleCost();
                operatingBudget = operatingBudget - cost;
                writer.write("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
                +newCar.VehicleType()+" for $"+ cost + " Cost\n");
                System.out.println("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
                +newCar.VehicleType()+" for $"+ cost + " Cost");
                logger.setDescription("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
                +newCar.VehicleType()+" for $"+ cost + " Cost");
            }
        }
            if ( type.equals("PickUpCar"))
            { System.out.println("i m PickUpCar add vehicle");  
            for (int k = c; k < 6; k++)
            {  Vehicle newCar = CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.PickUpCars);
               // PickUpCars newCar = new PickUpCars();
                if (newCar.VehicleCondition().equals("Used"))            {               
                  newCar.setCarPrice(newCar.getVehicleCost()*0.8);  
                  newCar.setVehicleSP(newCar.getVehicleCost());          }
             else if (newCar.VehicleCondition().equals("Broken"))            {
              newCar.setCarPrice(newCar.getVehicleCost()*0.5);   
              newCar.setVehicleSP(newCar.getVehicleCost());          }
             else {newCar.setVehicleSP(newCar.getVehicleCost()); }
                v.add(newCar);
                System.out.println("after i m PickUpCar add vehicle");  
                inventoryList.add(newCar); // add new vehicles to the inventory list
                cost = newCar.VehicleCost();
                operatingBudget = operatingBudget - cost;
                writer.write("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
                +newCar.VehicleType()+" for $"+ cost + " Cost\n");
                System.out.println("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
                +newCar.VehicleType()+" for $"+ cost + " Cost");
                logger.setDescription("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
                +newCar.VehicleType()+" for $"+ cost + " Cost");
            }
        
        }
        if ( type.equals("ElectricCars"))
        { System.out.println("i m ElectricCars add vehicle");  
        for (int i = c; i < 6; i++)
        {   Vehicle newCar = CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.ElectricCars);
           //ElectricCars newCar = new ElectricCars(); 
            // if electric car is like new then add range
            if (newCar.VehicleCondition().equals("Like New"))
            {
              newCar.setVehicleRange(newCar.getVehicleRange()+100);
            }
           if (newCar.VehicleCondition().equals("Used"))            {               
            newCar.setCarPrice(newCar.getVehicleCost()*0.8);  
            newCar.setVehicleSP(newCar.getVehicleCost());          }
       else if (newCar.VehicleCondition().equals("Broken"))            {
        newCar.setCarPrice(newCar.getVehicleCost()*0.5);   
        newCar.setVehicleSP(newCar.getVehicleCost());          }
       else {newCar.setVehicleSP(newCar.getVehicleCost()); }
            v.add(newCar);
            System.out.println("after i m ElectricCars add vehicle"); 
            inventoryList.add(newCar); // add new vehicles to the inventory list 
            cost = newCar.VehicleCost();
            operatingBudget = operatingBudget - cost;
            writer.write("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost\n");
            System.out.println("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost");
            logger.setDescription("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost");
        }
    }
        if ( type.equals("MonsterTrucks"))
        { System.out.println("i m MonsterTrucks add vehicle");  
        for (int j = c; j < 6; j++)
        {   Vehicle newCar = CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.MonsterTrucks);
          //MonsterTrucks newCar = new MonsterTrucks();
          if (newCar.VehicleCondition().equals("Used"))            {               
            newCar.setCarPrice(newCar.getVehicleCost()*0.8);  
            newCar.setVehicleSP(newCar.getVehicleCost());          }
       else if (newCar.VehicleCondition().equals("Broken"))            {
        newCar.setCarPrice(newCar.getVehicleCost()*0.5);   
        newCar.setVehicleSP(newCar.getVehicleCost());          }
       else {newCar.setVehicleSP(newCar.getVehicleCost()); }
            v.add(newCar);
            System.out.println("after i m MonsterTrucks add vehicle"); 
            inventoryList.add(newCar); // add new vehicles to the inventory list
            System.out.println("i m here");
            cost = newCar.VehicleCost();
            operatingBudget = operatingBudget - cost;
            writer.write("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost\n");
            System.out.println("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost");
            logger.setDescription("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost");
        }
    }
        if ( type.equals("Motorcycles"))
        { System.out.println("i m Motorcycles add vehicle");  
        for (int k = c; k < 6; k++)
        {   Vehicle newCar = CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.Motorcycles);
          //Motorcycles newCar = new Motorcycles();
          if (newCar.VehicleCondition().equals("Used"))            {               
            newCar.setCarPrice(newCar.getVehicleCost()*0.8);  
            newCar.setVehicleSP(newCar.getVehicleCost());          }
       else if (newCar.VehicleCondition().equals("Broken"))            {
        newCar.setCarPrice(newCar.getVehicleCost()*0.5);   
        newCar.setVehicleSP(newCar.getVehicleCost());          }
       else {newCar.setVehicleSP(newCar.getVehicleCost()); }
            v.add(newCar);
            System.out.println("after i m Motorcycles add vehicle");  
            inventoryList.add(newCar); // add new vehicles to the inventory list
            cost = newCar.VehicleCost();
            operatingBudget = operatingBudget - cost;
            writer.write("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost\n");
            System.out.println("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost");
            logger.setDescription("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost");
        }
    
    }

    if ( type.equals("RacingMotorcycles"))
    { System.out.println("i m RacingMotorcycles add vehicle");  
    for (int m = c; m < 6; m++)
    {   Vehicle newCar = CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.RacingMotorcycles);
      //RacingMotorcycles newCar = new RacingMotorcycles();
      if (newCar.VehicleCondition().equals("Used"))            {               
        newCar.setCarPrice(newCar.getVehicleCost()*0.8);  
        newCar.setVehicleSP(newCar.getVehicleCost());          }
   else if (newCar.VehicleCondition().equals("Broken"))            {
    newCar.setCarPrice(newCar.getVehicleCost()*0.5);   
    newCar.setVehicleSP(newCar.getVehicleCost());          }
   else {newCar.setVehicleSP(newCar.getVehicleCost()); }
        v.add(newCar);
        System.out.println("after i m RacingMotorcycles add vehicle");  
        inventoryList.add(newCar); // add new vehicles to the inventory list
        cost = newCar.VehicleCost();
        operatingBudget = operatingBudget - cost;
        writer.write("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
        +newCar.VehicleType()+" for $"+ cost + " Cost\n");
        System.out.println("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
        +newCar.VehicleType()+" for $"+ cost + " Cost");
        logger.setDescription("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
        +newCar.VehicleType()+" for $"+ cost + " Cost");
    }

}
if ( type.equals("ElectricTrucks"))
        { System.out.println("i m ElectricTrucks add vehicle");  
        for (int n = c; n < 6; n++)
        {   Vehicle newCar = CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.ElectricTrucks);
          //ElectricTrucks newCar = new ElectricTrucks();
          if (newCar.VehicleCondition().equals("Used"))            {               
            newCar.setCarPrice(newCar.getVehicleCost()*0.8);  
            newCar.setVehicleSP(newCar.getVehicleCost());          }
       else if (newCar.VehicleCondition().equals("Broken"))            {
        newCar.setCarPrice(newCar.getVehicleCost()*0.5);   
        newCar.setVehicleSP(newCar.getVehicleCost());          }
       else {newCar.setVehicleSP(newCar.getVehicleCost()); }
            v.add(newCar);
            System.out.println("after i m ElectricTrucks add vehicle"); 
            inventoryList.add(newCar); // add new vehicles to the inventory list
            System.out.println("i m here");
            cost = newCar.VehicleCost();
            operatingBudget = operatingBudget - cost;
            writer.write("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost\n");
            System.out.println("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost");
            logger.setDescription("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
            +newCar.VehicleType()+" for $"+ cost + " Cost");
        }
    }
      
    if ( type.equals("Formula1Cars"))
    { System.out.println("i m Formula1Cars add vehicle");  
    for (int q = c; q < 6; q++)
    {   Vehicle newCar = CreateFactoryPattern.createVehicle(CreateFactoryPattern.vehicleType.Formula1Cars);
        //Formula1Cars newCar = new Formula1Cars();
        if (newCar.VehicleCondition().equals("Used"))            {               
          newCar.setCarPrice(newCar.getVehicleCost()*0.8);  
          newCar.setVehicleSP(newCar.getVehicleCost());          }
     else if (newCar.VehicleCondition().equals("Broken"))            {
      newCar.setCarPrice(newCar.getVehicleCost()*0.5);   
      newCar.setVehicleSP(newCar.getVehicleCost());          }
     else {newCar.setVehicleSP(newCar.getVehicleCost()); }
        v.add(newCar);
        System.out.println("after i m Formula1Cars add vehicle"); 
        inventoryList.add(newCar); // add new vehicles to the inventory list
        System.out.println("i m here");
        cost = newCar.VehicleCost();
        operatingBudget = operatingBudget - cost;
        writer.write("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
        +newCar.VehicleType()+" for $"+ cost + " Cost\n");
        System.out.println("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
        +newCar.VehicleType()+" for $"+ cost + " Cost");
        logger.setDescription("Purchased "+ newCar.VehicleCondition()+" , "+newCar.VehicleCleanliness()+" "
        +newCar.VehicleType()+" for $"+ cost + " Cost");
    }
}
        
        return operatingBudget;
    }

    // updateCarPrice
    public static void updateCarPrice(ArrayList<Vehicle> vehicle, Vehicle repairVehicle, double factor){
        for (Vehicle v : vehicle) {
            if (v.getVehicleName().equals(repairVehicle.getVehicleName()))
            {
                v.setCarPrice(repairVehicle.VehicleCost()* factor);// update cost              
                v.setVehicleSP(v.getVehicleCost());
                v.setCondition(repairVehicle.VehicleCondition());

                // electric cars repaired ti like New update range
                if (repairVehicle.VehicleType().equals("ElectricCars") && repairVehicle.VehicleCondition().equals("Like New"))
                {
                  repairVehicle.setVehicleRange(repairVehicle.getVehicleRange()+100);
                }
                //double cost = repairVehicle.VehicleCost()* factor ;
                //updateVehicleInventoryCP(repairVehicle.getVehicleName(),cost);
            }
        }

    }
        // method to add driver
    public static void hireDriver (int c,ArrayList<Staff> s , ArrayList<Staff> allStaffs, FileWriter writer,Logger logger) throws IOException
    {
        for (int i = c; i < 3; i++)
        {  Staff dr = CreateFactoryPattern.createStaff(CreateFactoryPattern.staffType.Driver);
          //  Driver dr = new Driver();
            dr.setWorkCount(0);
            dr.setStaffStatus("Working"); 
            dr.setStaffHealthStatus("Healthy");
        s.add(dr);
        allStaffs.add(dr);
        writer.write("Hired Driver "+ s.get(i).getStaffname()+"\n");
        System.out.println("Hired Driver "+ s.get(i).getStaffname());
        logger.setDescription("Hired Driver "+ s.get(i).getStaffname());
    }
    
    }

    public static double opening(Double operatingBudget, ArrayList<Staff> s,ArrayList<Staff> allStaffs, ArrayList<Vehicle> v,
    ArrayList<Vehicle> inventoryList,FileWriter writer, Logger logger, Tracker tracker) throws IOException {
       writer.write("Opening South Branch....(current budget $"+operatingBudget+")\n");
        System.out.println("Opening South Branch....(current budget $"+operatingBudget+")");
        logger.setDescription("\n Opening South Branch....");
        tracker.setTrackerDescription("Opening South Branch budget $"+operatingBudget);

        int counter =0;
        int dcounter =0;
        int ccounter= 0;
        int pcounter = 0;
        int ucounter =0 ;
        int ecounter= 0;
        int mtcounter = 0;
        int mccounter =0 ;
        int rmcounter=0;
        int fcounter = 0;
        int etcounter=0;

        double val = operatingBudget;
        
        //check if number of interns are three or not
        for (Staff person : s) {
             if (person.getStaffType().equals("Intern"))
              { 
                 counter++ ;
              }
              if (person.getStaffType().equals("Driver"))
              { 
                dcounter++ ;
              }
        }
        
        // if interns are less then hire intern
        if ( counter < 3)
        {
            hireIntern(counter, s, allStaffs, writer, logger);
        }

        // if drivers are less then add driver as three drivers must me active all the time
        if ( dcounter < 3)
        {
            hireDriver(dcounter, s, allStaffs, writer, logger);
        }

        System.out.println("Count of cars before" + v.size());
        
        // Check vehicle count in inventory
        for (Vehicle car : v) {
            if (car.VehicleType().equals("RegularCar"))
              { 
                ccounter+=1 ;
              }
              if (car.VehicleType().equals("PerformanceCar"))
              { 
                pcounter+=1 ;
              }
              if (car.VehicleType().equals("PickUpCar"))
              { 
                ucounter+=1 ;
              }
              if (car.VehicleType().equals("ElectricCars"))
              { 
                ecounter+=1 ;
              }
              if (car.VehicleType().equals("MonsterTrucks"))
              { 
                mtcounter+=1 ;
              }
              if (car.VehicleType().equals("Motorcycles"))
              { 
                mccounter+=1 ;
              }

              if (car.VehicleType().equals("RacingMotorcycles"))
              { 
                rmcounter+=1 ;
              }
              if (car.VehicleType().equals("Formula1Cars"))
              { 
                fcounter+=1 ;
              }
              if (car.VehicleType().equals("ElectricTrucks"))
              { 
                etcounter+=1 ;
              }
        }

        // if vehicle count is less then add vehicle
        if ( ccounter < 6)
        {     System.out.println("i m in ccounter"+ccounter);
         val= addVehicle(ccounter, v,inventoryList, "RegularCar",operatingBudget, writer,logger)  ;      
        }
        
        if ( pcounter < 6)
        {    
            System.out.println("i m in pcounter"+pcounter);
             val=  addVehicle(pcounter, v, inventoryList,"PerformanceCar", operatingBudget, writer,logger);
        }
        if ( ucounter < 6)
        {     System.out.println("i m in ucounter"+ucounter);
         val= addVehicle(ucounter, v,inventoryList, "PickUpCar", operatingBudget, writer,logger);      
        }
        if ( ecounter < 6)
        {     System.out.println("i m in ecounter"+ecounter);
         val= addVehicle(ecounter, v,inventoryList, "ElectricCars",operatingBudget, writer,logger)  ;      
        }
        
        if ( mtcounter < 6)
        {    
            System.out.println("i m in mtcounter"+mtcounter);
             val=  addVehicle(mtcounter, v, inventoryList,"MonsterTrucks", operatingBudget, writer,logger);
        }
        if ( mccounter < 6)
        {     System.out.println("i m in mccounter"+mccounter);
         val= addVehicle(mccounter, v,inventoryList, "Motorcycles", operatingBudget, writer,logger);      
        }

        if ( rmcounter < 6)
        {     System.out.println("i m in rmcounter"+rmcounter);
         val= addVehicle(rmcounter, v,inventoryList, "RacingMotorcycles",operatingBudget, writer,logger)  ;      
        }
        
        if ( fcounter < 6)
        {    
            System.out.println("i m in fcounter"+fcounter);
             val=  addVehicle(fcounter, v, inventoryList,"Formula1Cars", operatingBudget, writer,logger);
        }
        if ( etcounter < 6)
        {     System.out.println("i m in etcounter"+etcounter);
         val= addVehicle(etcounter, v,inventoryList, "ElectricTrucks", operatingBudget, writer,logger);      
        }


        // checking operating budget
        System.out.println("Count of cars after" + v.size());
        double val1 = checkOperatingBudget(val,writer, tracker);
        return val1;
}

public static void washing( ArrayList<Staff> s, ArrayList<Vehicle> v, FileWriter writer, Logger logger) throws IOException {
    writer.write("Washing South Branch....\n");
    System.out.println("Washing South Branch....");
    logger.setDescription("\n");
    //logger.setDescription("\n Washing....");
    int washCount = 0;

   // for (Staff person : s) {
     //   System.out.println("person name : "+ person.getStaffname()+" "+ person.getWorkCount());
    //}
    // Washing to be done by Interns
    for (Staff person : s) {
        // also checking that each intern can wash just two cars per day
        if (person.getStaffType().equals("Intern") && person.getWorkCount() <2)
       {   
             
       Random random = new Random();
       int i = random.nextInt(v.size());
        Vehicle WashCar = v.get(i);
        String prevCarCleanliness = WashCar.VehicleCleanliness();
        System.out.println("Car name " +WashCar.getVehicleName() +" "+ WashCar.VehicleType()+ " Cleanliness condition : "+prevCarCleanliness);
        String newCarCleanliness = prevCarCleanliness;
      

        // Wash behavious used based on what was assigned to the interns during initiation
        // Strategy pattern implemented where intern is using wash metod
        if (person.getWashBehaviour().equals("Chemical"))
        {   
           ChemicalStrategy cs = new ChemicalStrategy();
           cs.doWash(WashCar);
           
         
           // Update cleaniliness condition
           v.get(i).setCleanliness(WashCar.VehicleCleanliness());

           Random rand = new Random();
           double r = rand.nextDouble();
           if (r < 0.1 && !WashCar.VehicleCondition().equals("Broken"))
           WashCar.setCondition("Broken");
          
       }
        else if (person.getWashBehaviour().equals("Elbow Grease"))
        {
            ElbowGreaseStrategy cs = new ElbowGreaseStrategy();
           newCarCleanliness=  cs.doWash(prevCarCleanliness);
           
          
          v.get(i).setCleanliness(WashCar.VehicleCleanliness());

           Random rand = new Random();
           double r = rand.nextDouble();
           if (r < 0.1 && !WashCar.VehicleCondition().equals("Like New"))
           WashCar.setCondition("Like New");
         
        }
        else if (person.getWashBehaviour().equals("Detailed"))
        {
            DetailedStrategy cs = new DetailedStrategy();
           newCarCleanliness=  cs.doWash(prevCarCleanliness);
           
          
          v.get(i).setCleanliness(WashCar.VehicleCleanliness());
            
        }
        else {  System.out.println("-----------Washing method not defined--------");
          }
   
        if (prevCarCleanliness.equals("Sparkling") || newCarCleanliness.equals("NA"))
        {
            System.out.println("-----------No Changes in Cleanliness condition--------");
        }
        else{

            //interns earns bonus based on car cleaned
            person.setBonusAmount(WashCar.VehicleWashBonus());
            person.setStaffStatus("Worked");
            washCount = person.getWorkCount();
            person.setWorkCount(washCount+1);
   
                   
            writer.write("Intern "+ person.getStaffname()+" washed "+ WashCar.VehicleType()+" "+
            WashCar.VehicleName()+" using Wash method "+person.getWashBehaviour()+" and made it "+WashCar.VehicleCleanliness() +" (earned $"+WashCar.VehicleWashBonus()+")\n");
            System.out.println("Intern "+ person.getStaffname()+" washed "+ WashCar.VehicleType()+" "+
            WashCar.VehicleName()+" using Wash method "+person.getWashBehaviour()+" and made it "+WashCar.VehicleCleanliness() +" (earned $"+WashCar.VehicleWashBonus()+")");
            logger.setDescription("Intern "+ person.getStaffname()+" washed "+ WashCar.VehicleType()+" "+
            WashCar.VehicleName()+" using Wash method "+person.getWashBehaviour()+" and made it "+WashCar.VehicleCleanliness() +" (earned $"+WashCar.VehicleWashBonus()+")");
            
          }
         
       }
       /////
    }

  }

public static void repairing(ArrayList<Staff> s, ArrayList<Vehicle> v,FileWriter writer, Logger logger ) throws IOException {
    
   writer.write("Repairing South Branch....\n");
    System.out.println("Repairing South Branch....");
    logger.setDescription("\n");
  //  logger.setDescription("\n Repairing....");

    ArrayList<Vehicle> repairCarsList = new ArrayList<Vehicle>();
    int fixCount =0; // Each mechanic can fix two cars in a day
    
    // Repair is done on Broken and Used Vehicles so creating the list of vehicles to be repaired
    for (Vehicle car : v) {
        if (car.VehicleCondition().equals("Broken") || car.VehicleCondition().equals("Used") )
       { 
        repairCarsList.add(car);
        }
    }
    
   // System.out.println("repairCarsList size" + repairCarsList.size());

    for (Staff person : s) {
        // Mechanics will perform the repair activity
        // also checking that each mechanic can fix just two cars per day
        if (person.getStaffType().equals("Mechanic") && person.getWorkCount() <2 ) 
       {   
       
        if (repairCarsList.size() != 0)
    {   Random random = new Random();
        Vehicle firstrepairCar = repairCarsList.get(random.nextInt(repairCarsList.size()));
        double chanceRepair = random.nextDouble();
       
         // Checking repair probability and cnt to count number of vehicles repaired as each Mechanic can repair just two vehicles
        if (chanceRepair < 0.8 ) {
            if (firstrepairCar.VehicleCondition().equals("Broken"))
             {

                // Updating car condition after repair
                firstrepairCar.setCondition("Used");
                //inc cost price of car
                updateCarPrice(v, firstrepairCar,1.5) ;

                //calculating bonus earned and daily salary
                person.updateStaffBonus(firstrepairCar.VehicleRepairBonus());
               // person.setBonusAmount(firstrepairCar.VehicleRepairBonus());
                person.setStaffStatus("Worked");
                fixCount = person.getWorkCount();
                person.setWorkCount(fixCount+1);

                
                writer.write("Mechanic "+ person.getStaffname()+" repaired Broken "+firstrepairCar.VehicleName()+
                " and made it "+firstrepairCar.VehicleCondition()+" (earned $"+firstrepairCar.VehicleRepairBonus()+")\n");
                System.out.println("Mechanic "+ person.getStaffname()+" repaired Broken "+firstrepairCar.VehicleName()+
                " and made it "+firstrepairCar.VehicleCondition()+" (earned $"+firstrepairCar.VehicleRepairBonus()+")");
                logger.setDescription("Mechanic "+ person.getStaffname()+" repaired Broken "+firstrepairCar.VehicleName()+
                " and made it "+firstrepairCar.VehicleCondition()+" (earned $"+firstrepairCar.VehicleRepairBonus()+")");
                
                //System.out.println("Cost current" +firstrepairCar.VehicleCost()); 
             }
            else if (firstrepairCar.VehicleCondition().equals("Used"))
            {    // Updating car condition after repair
                firstrepairCar.setCondition("Like New");
                // update range for electric car
                if (firstrepairCar.VehicleType().equals("ElectricCars"))
           {
            firstrepairCar.setVehicleRange(firstrepairCar.getVehicleRange()+100);
           }
             //inc cost price of car
                updateCarPrice(v, firstrepairCar,1.25) ;

                //calculating bonus earned and daily salary
                person.updateStaffBonus(firstrepairCar.VehicleRepairBonus());
                person.setStaffStatus("Worked");
                fixCount = person.getWorkCount();
                person.setWorkCount(fixCount+1);
                

                writer.write("Mechanic "+ person.getStaffname()+" repaired Used "+
                firstrepairCar.VehicleName()+" and made it "+firstrepairCar.VehicleCondition()+" (earned $"+
                firstrepairCar.VehicleRepairBonus()+")\n");

                System.out.println("Mechanic "+ person.getStaffname()+" repaired Used "+
                firstrepairCar.VehicleName()+" and made it "+firstrepairCar.VehicleCondition()+" (earned $"+
                firstrepairCar.VehicleRepairBonus()+")");

                logger.setDescription("Mechanic "+ person.getStaffname()+" repaired Broken "+firstrepairCar.VehicleName()+
                " and made it "+firstrepairCar.VehicleCondition()+" (earned $"+firstrepairCar.VehicleRepairBonus()+")");

                //System.out.println("Cost current" +firstrepairCar.VehicleCost()); 
            }
             if (firstrepairCar.VehicleCleanliness().equals("Sparkling"))
                { firstrepairCar.setCleanliness("Clean");}
                else if (firstrepairCar.VehicleCleanliness().equals("Clean"))
                { firstrepairCar.setCleanliness("Dirty");}     
            }
        }
    
       }
    }

  }
  
  public static double selling(Double operatingBudget, ArrayList<Staff> s, ArrayList<Vehicle> v, String dayOfWeek, 
  ArrayList<Vehicle> invList , FileWriter writer, Logger logger, Tracker tracker) throws IOException
  {
    
    System.out.println("Selling South Branch....");
    writer.write("Selling South Branch....\n");
    logger.setDescription("\n");
   // logger.setDescription("\nSelling....");
    int numOfBuyers =0;
    Random random = new Random();
    double SellingPrice=0;
    // Based on days of the week we determine the number of buyers
    if (dayOfWeek.equals("Friday") || dayOfWeek.equals("Saturday")) 
     { numOfBuyers = random.nextInt(7) + 2;
    }
     else {
         numOfBuyers = random.nextInt(6);
     }

     System.out.println("numOfBuyers" + numOfBuyers);
     System.out.println("num of cars before" + v.size());
     System.out.println("num of inv cars before" + invList.size());
     
     String desiredVehicle="";
     ArrayList<Vehicle> buyCarsList = new ArrayList<Vehicle>();
     ArrayList<Vehicle> buyInvCarsList = new ArrayList<Vehicle>();
     Vehicle mostExpensive = new PickUpCars();
     ArrayList<Vehicle> SoldVehicle = new ArrayList<Vehicle>();
     
     // Creating the list of buyers
     ArrayList<Buyer> Buyers = new ArrayList<Buyer>();
     for (int k = 0 ; k <numOfBuyers; k++)
     {Buyers.add(new Buyer());}
    
     for (Buyer b:Buyers)
     {
    desiredVehicle = b.getDesiredVehicle();
    // setting buying ability based buying intention
    if (b.getBuyingIntention().equals("Just Looking"))
    {b.setBuyingAbility(0.1);  }
    if (b.getBuyingIntention().equals("Wants One"))
    {b.setBuyingAbility(0.4);  }
    if(b.getBuyingIntention().equals("Needs One"))
    {b.setBuyingAbility(0.7);  }
     
       
    ArrayList<Staff> SalesStaff = new ArrayList<Staff>();
    for (Staff person : s) {
        System.out.println(person.staffType());
        if (person.getStaffType().equals("Salesperson"))
       {// System.out.println("i m in sales person");
         SalesStaff.add(person);
         //System.out.println(SalesStaff.staffType());
        }
    }
        
       // randomly selecting a salesperson)
       Random rand = new Random();
       //Staff selectedSalesperson = SalesStaff.get(rand.nextInt(SalesStaff.size()));
      System.out.println("i am above index printing ..."+ SalesStaff.size());
       int index = rand.nextInt(SalesStaff.size());
      System.out.println("index printing ..." + index);
       Staff selectedSalesperson = SalesStaff.get(index);

     // creating the list of cars based on the buyers choice which are not broken 
      for (Vehicle car : v) {
        if (car.VehicleType().equals(desiredVehicle) && !car.VehicleCondition().equals("Broken") )
       { 
        buyCarsList.add(car);
        }
     }
     double FinalSP;
     // find the most expensive car out of the created list of cars which are desired by the buyer
        if (buyCarsList.size() != 0){
        mostExpensive = buyCarsList.get(0);  
        for (Vehicle buyCarsLst : buyCarsList) {
            if (buyCarsLst.getVehicleCost() > mostExpensive.getVehicleCost()) {
              mostExpensive = buyCarsLst;
                          }
        }
     
        Random checkSale = new Random();
        double ifSold = checkSale.nextDouble() ;
          // System.out.println("i m here above if" + b.getBuyingIntention()+" "+ifSold);   

        
        if(b.getBuyingIntention().equals("Needs One") &&  ifSold < 0.7)
        {   System.out.println("------ i m here above if " + b.getBuyingIntention()+" "+ifSold);   
            b.setBuyingAbility(0.7);         
            SoldVehicle.add(mostExpensive); // Creating List of sold cars        
            v.remove(mostExpensive); // removing from list of vehicles
            double addOnPrice ;
            String addOn;

          // Buyer provided to choose any one addon
          if (Math.random() < 0.05) // Chances of adding RoadRescueCoverage
          { addOn = "Road Rescue Coverage";
          System.out.println("Addon type :" +addOn);
          System.out.println("Car SP current "+ mostExpensive.getVehicleSP() );
          RoadRescueCoverage ew = new RoadRescueCoverage(mostExpensive);
          addOnPrice = ew.getVehicleAddon();
          }
          else if (Math.random() < 0.1) // Chances of adding Undercoating
          { addOn = "Undercoating";
          System.out.println("Addon type :" +addOn);
          System.out.println("Car SP current "+ mostExpensive.getVehicleSP() );
          Undercoating ew = new Undercoating(mostExpensive);
          addOnPrice = ew.getVehicleAddon();
          } 
          else if (Math.random() < 0.25) // Chances of adding ExtendedWarranty
          { addOn = "Extended Warranty";
          System.out.println("Addon type :" +addOn);
          System.out.println("Car SP current "+ mostExpensive.getVehicleSP() );
            ExtendedWarranty ew = new ExtendedWarranty(mostExpensive);
            addOnPrice = ew.getVehicleAddon();
          }
          else if (Math.random() < 0.4) // Chances of adding SatelliteRadio
          { addOn = "Satellite Radio";
          System.out.println("Addon type :" +addOn);
          System.out.println("Car SP current "+ mostExpensive.getVehicleSP() );
          SatelliteRadio ew = new SatelliteRadio(mostExpensive);
          addOnPrice = ew.getVehicleAddon();
          }
          else {  addOn = "None";
          System.out.println("Addon type :" +addOn);
          System.out.println("Car SP current "+ mostExpensive.getVehicleSP() );
          addOnPrice = 0;
            
        }
        // increasing the selling price if it has won any race
        if(mostExpensive.getRaceCount() >1)
        { 
          FinalSP = (addOnPrice + mostExpensive.getVehicleSP())*1.1;
        }
        else
        {FinalSP = addOnPrice + mostExpensive.getVehicleSP();}
            // Updating the car status in inventory as sold
            for (Vehicle InvCarsLst : invList) {
                 if (InvCarsLst.getVehicleName().equals(mostExpensive.getVehicleName())) {
                    InvCarsLst.setVehicleStatus("Sold");
                    InvCarsLst.setCarSellingPrice(FinalSP);
            }
            }
            
            SellingPrice += FinalSP;
            selectedSalesperson.updateStaffBonus(mostExpensive.VehicleSaleBonus());
            selectedSalesperson.setStaffStatus("Worked");
            mostExpensive.setCarSellingPrice(FinalSP);
            
            writer.write("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")"+" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)\n");
            System.out.println("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)\n");
            logger.setDescription("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)");
        }
        else if (b.getBuyingIntention().equals("Wants One") && ifSold < 0.4)
        {   System.out.println("----- i m here above if" + b.getBuyingIntention()+" "+ifSold);   
            b.setBuyingAbility(0.4);  

            SoldVehicle.add(mostExpensive); // Creating List of sold cars        
            v.remove(mostExpensive); // removing from list of vehicles


            double addOnPrice ;
            String addOn;
            
          // Buyer provided to choose any one addon
          if (Math.random() < 0.05) // Chances of adding RoadRescueCoverage
          { addOn = "Road Rescue Coverage";
          System.out.println("Addon type :" +addOn);
          RoadRescueCoverage ew = new RoadRescueCoverage(mostExpensive);
          addOnPrice = ew.getVehicleAddon();
          }
          else if (Math.random() < 0.1) // Chances of adding Undercoating
          { addOn = "Undercoating";
          System.out.println("Addon type :" +addOn);
          Undercoating ew = new Undercoating(mostExpensive);
          addOnPrice = ew.getVehicleAddon();
          } 
          else if (Math.random() < 0.25) // Chances of adding ExtendedWarranty
          { addOn = "Extended Warranty";
          System.out.println("Addon type :" +addOn);
            ExtendedWarranty ew = new ExtendedWarranty(mostExpensive);
            addOnPrice = ew.getVehicleAddon();
          }
          else if (Math.random() < 0.4) // Chances of adding SatelliteRadio
          { addOn = "Satellite Radio";
          System.out.println("Addon type :" +addOn);
          SatelliteRadio ew = new SatelliteRadio(mostExpensive);
          addOnPrice = ew.getVehicleAddon();
          }
          else { addOn = "None";
            System.out.println("Addon type :" +addOn);
            addOnPrice = 0;
        }
        if(mostExpensive.getRaceCount() >1)
        { 
          FinalSP = (addOnPrice + mostExpensive.getVehicleSP())*1.1;
        }
        else
        {FinalSP = addOnPrice + mostExpensive.getVehicleSP();}
            // Updating the car status in inventory as sold
            for (Vehicle InvCarsLst : invList) {
                 if (InvCarsLst.getVehicleName().equals(mostExpensive.getVehicleName())) {
                    InvCarsLst.setVehicleStatus("Sold");
                    InvCarsLst.setCarSellingPrice(FinalSP);
            }
            }
            selectedSalesperson.updateStaffBonus(mostExpensive.VehicleSaleBonus());
            
            selectedSalesperson.setStaffStatus("Worked");
            mostExpensive.setCarSellingPrice(FinalSP);
            SellingPrice += FinalSP;
            writer.write("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)\n");
            System.out.println("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)\n");
            logger.setDescription("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)");
        }
        else if (b.getBuyingIntention().equals("Just Looking") && ifSold < 0.1)
        {   System.out.println("------ i m here above if" + b.getBuyingIntention()+" "+ifSold);   
            b.setBuyingAbility(0.1); 
            SoldVehicle.add(mostExpensive); // Creating List of sold cars        
            v.remove(mostExpensive); // removing from list of vehicles
            double addOnPrice ;
            String addOn;
             // Buyer provided to choose any one addon
          if (Math.random() < 0.05) // Chances of adding RoadRescueCoverage
          { addOn = "Road Rescue Coverage";
          System.out.println("Addon type :" +addOn);
          RoadRescueCoverage ew = new RoadRescueCoverage(mostExpensive);
          addOnPrice = ew.getVehicleAddon();
          }
          else if (Math.random() < 0.1) // Chances of adding Undercoating
          { addOn = "Undercoating";
          System.out.println("Addon type :" +addOn);
          Undercoating ew = new Undercoating(mostExpensive);
          addOnPrice = ew.getVehicleAddon();
          } 
          else if (Math.random() < 0.25) // Chances of adding ExtendedWarranty
          { addOn = "Extended Warranty";
          System.out.println("Addon type :" +addOn);
            ExtendedWarranty ew = new ExtendedWarranty(mostExpensive);
            addOnPrice = ew.getVehicleAddon();
          }
          else if (Math.random() < 0.4) // Chances of adding SatelliteRadio
          { addOn = "Satellite Radio";
          System.out.println("Addon type :" +addOn);
          SatelliteRadio ew = new SatelliteRadio(mostExpensive);
          addOnPrice = ew.getVehicleAddon();
          }
          else { addOn = "None";
          System.out.println("Addon type :" +addOn);
          addOnPrice = 0;
            
        }
        if(mostExpensive.getRaceCount() >1)
        { 
          FinalSP = (addOnPrice + mostExpensive.getVehicleSP())*1.1;
        }
        else
        {FinalSP = addOnPrice + mostExpensive.getVehicleSP();}
            // Updating the car status in inventory as sold
            for (Vehicle InvCarsLst : invList) {
                 if (InvCarsLst.getVehicleName().equals(mostExpensive.getVehicleName())) {
                    InvCarsLst.setVehicleStatus("Sold");
                    InvCarsLst.setCarSellingPrice(FinalSP);
            }
            }
           
            selectedSalesperson.updateStaffBonus(mostExpensive.VehicleSaleBonus());
            selectedSalesperson.setStaffStatus("Worked"); 
            mostExpensive.setCarSellingPrice(FinalSP);
            SellingPrice += FinalSP;
            writer.write("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)\n");
            System.out.println("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)\n");
            logger.setDescription("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)");
        }
        else { 
            System.out.println("No car sold"); 
        //  logger.setDescription("No car sold");
          }
      
        }
        else { 

            // check for the available cars desired by the buyer in the inventory which are in stock
            for (Vehicle invcar : invList) {
                if (invcar.VehicleType().equals(desiredVehicle) && !invcar.VehicleCondition().equals("Broken") 
                && invcar.getVehicleStatus().equals("In Stock"))
               { 
                buyInvCarsList.add(invcar);
                }
            }
            if (buyInvCarsList.size() != 0){
                mostExpensive = buyInvCarsList.get(0);  
                for (Vehicle buyInvCarsLst : buyInvCarsList) {
                    if (buyInvCarsLst.getVehicleCost() > mostExpensive.getVehicleCost()) {
                      mostExpensive = buyInvCarsLst;}
                    }
                      
                    Random checkSale = new Random();
                    double ifSold = checkSale.nextDouble() ;
                          // checking chances of buying when checking from vehicle inventory
                    if(b.getBuyingIntention().equals("Needs One") &&  ifSold < (0.7*0.8))
                    {b.setBuyingAbility(0.7);         
                        SoldVehicle.add(mostExpensive); // Creating List of sold cars        
                        v.remove(mostExpensive); // removing from list of vehicles
                    System.out.println("------ i m in buyer willng to buy");
                        double addOnPrice ;
                        String addOn;
                         // Buyer provided to choose any one addon
                      if (Math.random() < 0.05) // Chances of adding RoadRescueCoverage
                      { addOn = "Road Rescue Coverage";
                      System.out.println("Addon type :" +addOn);
                      RoadRescueCoverage ew = new RoadRescueCoverage(mostExpensive);
                      addOnPrice = ew.getVehicleAddon();
                      }
                      else if (Math.random() < 0.1) // Chances of adding Undercoating
                      { addOn = "Undercoating";
                      System.out.println("Addon type :" +addOn);
                      Undercoating ew = new Undercoating(mostExpensive);
                      addOnPrice = ew.getVehicleAddon();
                      } 
                      else if (Math.random() < 0.25) // Chances of adding ExtendedWarranty
                      { addOn = "Extended Warranty";
                      System.out.println("Addon type :" +addOn);
                        ExtendedWarranty ew = new ExtendedWarranty(mostExpensive);
                        addOnPrice = ew.getVehicleAddon();
                      }
                      else if (Math.random() < 0.4) // Chances of adding SatelliteRadio
                      { addOn = "Satellite Radio";
                      System.out.println("Addon type :" +addOn);
                      SatelliteRadio ew = new SatelliteRadio(mostExpensive);
                      addOnPrice = ew.getVehicleAddon();
                      }
                      else { addOn = "None";
                      System.out.println("Addon type :" +addOn);
                      addOnPrice = 0;
                        
                    }
                    if(mostExpensive.getRaceCount() >1)
                    { 
                      FinalSP = (addOnPrice + mostExpensive.getVehicleSP())*1.1;
                    }
                    else
                    {FinalSP = addOnPrice + mostExpensive.getVehicleSP();}
                        // Updating the car status in inventory as sold
                        for (Vehicle InvCarsLst : invList) {
                             if (InvCarsLst.getVehicleName().equals(mostExpensive.getVehicleName())) {
                                InvCarsLst.setVehicleStatus("Sold");
                                InvCarsLst.setCarSellingPrice(FinalSP);
                        }
                        }
                       
                        selectedSalesperson.updateStaffBonus(mostExpensive.VehicleSaleBonus());
                        selectedSalesperson.setStaffStatus("Worked");
                        mostExpensive.setCarSellingPrice(FinalSP);
                        SellingPrice += FinalSP;
                        writer.write("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
                        mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
                        mostExpensive.VehicleSaleBonus() +" bonus)\n");
                        System.out.println("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
                        mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
                        mostExpensive.VehicleSaleBonus() +" bonus)\n");
                        logger.setDescription("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)");

                    }
                    else if (b.getBuyingIntention().equals("Wants One") && ifSold < (0.4*0.8))
                    {b.setBuyingAbility(0.4);  
                        SoldVehicle.add(mostExpensive); // Creating List of sold cars        
                        v.remove(mostExpensive); // removing from list of vehicles
                        System.out.println("------ i m in buyer willng to buy");
                        double addOnPrice ;
                        String addOn;
                        
                         // Buyer provided to choose any one addon
                      if (Math.random() < 0.05) // Chances of adding RoadRescueCoverage
                      { addOn = "Road Rescue Coverage";
                      System.out.println("Addon type :" +addOn);
                      RoadRescueCoverage ew = new RoadRescueCoverage(mostExpensive);
                      addOnPrice = ew.getVehicleAddon();
                      }
                      else if (Math.random() < 0.1) // Chances of adding Undercoating
                      { addOn = "Undercoating";
                      System.out.println("Addon type :" +addOn);
                      Undercoating ew = new Undercoating(mostExpensive);
                      addOnPrice = ew.getVehicleAddon();
                      } 
                      else if (Math.random() < 0.25) // Chances of adding ExtendedWarranty
                      { addOn = "Extended Warranty";
                      System.out.println("Addon type :" +addOn);
                        ExtendedWarranty ew = new ExtendedWarranty(mostExpensive);
                        addOnPrice = ew.getVehicleAddon();
                      }
                      else if (Math.random() < 0.4) // Chances of adding SatelliteRadio
                      { addOn = "Satellite Radio";
                      System.out.println("Addon type :" +addOn);
                      SatelliteRadio ew = new SatelliteRadio(mostExpensive);
                      addOnPrice = ew.getVehicleAddon();
                      }
                      else {  addOn = "None";
                       System.out.println("Addon type :" +addOn);
                       addOnPrice = 0;
                       
                    }
                    if(mostExpensive.getRaceCount() >1)
                    { 
                      FinalSP = (addOnPrice + mostExpensive.getVehicleSP())*1.1;
                    }
                    else
                    {FinalSP = addOnPrice + mostExpensive.getVehicleSP();}
                        // Updating the car status in inventory as sold
                        for (Vehicle InvCarsLst : invList) {
                             if (InvCarsLst.getVehicleName().equals(mostExpensive.getVehicleName())) {
                                InvCarsLst.setVehicleStatus("Sold");
                                InvCarsLst.setCarSellingPrice(FinalSP);
                        }
                        }
                       
                        selectedSalesperson.updateStaffBonus(mostExpensive.VehicleSaleBonus());
                        selectedSalesperson.setStaffStatus("Worked");
                        mostExpensive.setCarSellingPrice(FinalSP);
                        SellingPrice += FinalSP;
                        writer.write("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
                        mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
                        mostExpensive.VehicleSaleBonus() +" bonus)\n");
                        System.out.println("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
                        mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
                        mostExpensive.VehicleSaleBonus() +" bonus)\n");
                        logger.setDescription("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)");
                    }
                    else if (b.getBuyingIntention().equals("Just Looking") && ifSold < (0.1*0.8))
                    {b.setBuyingAbility(0.1); 
                        SoldVehicle.add(mostExpensive); // Creating List of sold cars        
                        v.remove(mostExpensive); // removing from list of vehicles
                        System.out.println("------ i m in buyer willng to buy");
                        double addOnPrice ;
                        String addOn;
                         // Buyer provided to choose any one addon
                      if (Math.random() < 0.05) // Chances of adding RoadRescueCoverage
                      { addOn = "Road Rescue Coverage";
                      System.out.println("Addon type :" +addOn);
                      RoadRescueCoverage ew = new RoadRescueCoverage(mostExpensive);
                      addOnPrice = ew.getVehicleAddon();
                      }
                      else if (Math.random() < 0.1) // Chances of adding Undercoating
                      { addOn = "Undercoating";
                      System.out.println("Addon type :" +addOn);
                      Undercoating ew = new Undercoating(mostExpensive);
                      addOnPrice = ew.getVehicleAddon();
                      } 
                      else if (Math.random() < 0.25) // Chances of adding ExtendedWarranty
                      { addOn = "Extended Warranty";
                      System.out.println("Addon type :" +addOn);
                        ExtendedWarranty ew = new ExtendedWarranty(mostExpensive);
                        addOnPrice = ew.getVehicleAddon();
                    }
                      else if (Math.random() < 0.4) // Chances of adding SatelliteRadio
                      { addOn = "Satellite Radio";
                      System.out.println("Addon type :" +addOn);
                      SatelliteRadio ew = new SatelliteRadio(mostExpensive);
                      addOnPrice = ew.getVehicleAddon();
                      }
                      else {   addOn = "None";
                      System.out.println("Addon type :" +addOn);
                      addOnPrice = 0;
                       
                    }
                    if(mostExpensive.getRaceCount() >1)
                    { 
                      FinalSP = (addOnPrice + mostExpensive.getVehicleSP())*1.1;
                    }
                    else
                    {FinalSP = addOnPrice + mostExpensive.getVehicleSP();}
                        // Updating the car status in inventory as sold
                        for (Vehicle InvCarsLst : invList) {
                             if (InvCarsLst.getVehicleName().equals(mostExpensive.getVehicleName())) {
                                InvCarsLst.setVehicleStatus("Sold");
                                InvCarsLst.setCarSellingPrice(FinalSP);
                        }
                        }
                       
                        selectedSalesperson.updateStaffBonus(mostExpensive.VehicleSaleBonus());
                        selectedSalesperson.setStaffStatus("Worked"); 
                        mostExpensive.setCarSellingPrice(FinalSP);
                        SellingPrice += FinalSP;
                        writer.write("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
                        mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer  with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
                        mostExpensive.VehicleSaleBonus() +" bonus)\n");
                        System.out.println("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
                        mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer  with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
                        mostExpensive.VehicleSaleBonus() +" bonus)\n");
                        logger.setDescription("Salesperson "+ selectedSalesperson.getStaffname()+" sold "+mostExpensive.VehicleCondition() +" "+
            mostExpensive.VehicleType()+" "+ mostExpensive.VehicleName()+" to Buyer with Addon: "+ addOn+" (Price Increased by $"+addOnPrice+")" +" for $" + FinalSP +" (earned $ "+
            mostExpensive.VehicleSaleBonus() +" bonus)");
                    }
                    else {}     
                     System.out.println("No car sold");  
                   //  logger.setDescription("No car sold");
                    }
        }
       
   
    }

    System.out.println("num of cars after" + v.size());
    System.out.println("num of inv cars after" + invList.size());
    System.out.println("Total Sales : " + SellingPrice);
    writer.write("Total Sales : " + SellingPrice+" ");
    tracker.setTrackerDescription("Total money  earned by FNCD : $"+SellingPrice);
    double operatingBudgetf = operatingBudget + SellingPrice;
    double val = checkOperatingBudget(operatingBudgetf, writer, tracker);
    return val;
    
}


public static void racing( ArrayList<Vehicle> v,ArrayList<Vehicle> invList, ArrayList<Staff> s, FileWriter writer, Logger logger) throws IOException
{ int raceCount = 0;
  int carCount = 0;
  int count =0;
  System.out.println("Racing South Branch............");
  writer.write("\n Racing South Branch............ \n");
  logger.setDescription("Racing South Branch............");
 // int[] pos =  {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
  
 List<Integer> pos = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
  for (Vehicle v1 : v)
  {
     if (!v1.VehicleType().equals("ElectricCars") && !v1.VehicleType().equals("RegularCar") && 
     !v1.VehicleCondition().equals("Broken") && carCount <3) //only three cars can participate in the race from FNCD
     {   
         //Sending the car for racing
         //Randomly deciding the car position in race
        Random rand = new Random();
        int indx =rand.nextInt(pos.size());
        int position = pos.get(indx);
      
        count =0;
        for (Staff person : s) {
          //System.out.println(person.getStaffType());
          // only if the driver is not injured then can participate
          //each day one driver is associated with one car    
          if (person.getStaffType().equals("Driver") && !person.getStaffHealthStatus().equals("Injured")  && person.getWorkCount() <1 && count <1) 
       { count+=1;
       // logger.setDescription(person.getStaffname()+ "       "+ person.getStaffHealthStatus()+ "    "+person.getWorkCount());
        if( position == 1 || position == 2 || position == 3)
        {      pos.remove(indx); // once a position is achieved that cannot be achieved by other car
               // Car is winner
              v1.setRaceCount(raceCount+1);
              person.setWorkCount(raceCount+1);// storing the value of number of races won by the driver
              person.updateStaffBonus(v1.VehicleWinBonus());// driver gets bonus
              writer.write(person.getStaffType()+" "+person.getStaffname()+" driving "+v1.VehicleType()+" "+v1.getVehicleName()+" secured position "+position+"\n ");
        System.out.println(person.getStaffType()+" "+person.getStaffname()+" driving "+v1.VehicleType()+" "+v1.getVehicleName()+" secured position "+position);
        logger.setDescription(person.getStaffType()+" "+person.getStaffname()+" driving "+v1.VehicleType()+" "+v1.getVehicleName()+" secured position "+position);
        carCount+=1;
        person.setStaffStatus("Worked"); 
        person.setWorkCount(1); 
        }
        else if (position == 15 || position == 16 ||position == 17 ||position == 18 ||position == 19 ||position == 20 )
        {   pos.remove(indx); // once a position is achieved that cannot be achieved by other car
            
          writer.write(person.getStaffType()+" "+person.getStaffname()+" driving "+v1.VehicleType()+" "+v1.getVehicleName()+" secured position "+position+"\n ");
        System.out.println(person.getStaffType()+" "+person.getStaffname()+" driving "+v1.VehicleType()+" "+v1.getVehicleName()+" secured position "+position);
        logger.setDescription(person.getStaffType()+" "+person.getStaffname()+" driving "+v1.VehicleType()+" "+v1.getVehicleName()+" secured position "+position);
        carCount+=1;
        person.setStaffStatus("Worked"); 
        person.setWorkCount(1);

          if (v1.VehicleCondition().equals("Damaged"))
          {
            v1.setCondition("Broken");
          updateVehicleInv(invList,v1);
           // 30 % chance of driver to get injured     
           //Math.random()
           if (Math.random() < 0.3) {
          person.setStaffHealthStatus("Injured"); 
          logger.setDescription(person.getStaffType()+" "+person.getStaffname()+" has got injured");
           }    
        }
          else{         
          v1.setCondition("Damaged");
          updateVehicleInv(invList,v1);
          }        
        }
        else{
          pos.remove(indx); // once a position is achieved that cannot be achieved by other car
          writer.write(person.getStaffType()+" "+person.getStaffname()+" driving "+v1.VehicleType()+" "+v1.getVehicleName()+" secured position "+position+"\n ");
        System.out.println(person.getStaffType()+" "+person.getStaffname()+" driving "+v1.VehicleType()+" "+v1.getVehicleName()+" secured position "+position);
        logger.setDescription(person.getStaffType()+" "+person.getStaffname()+" driving "+v1.VehicleType()+" "+v1.getVehicleName()+" secured position "+position);
       
        person.setStaffStatus("Worked"); 
   person.setWorkCount(1);
        }
        
      }
      }
    
     }
  }
}


  public static double ending(double operatingBudget, ArrayList<Staff> s,  ArrayList<Staff> allStaffs, FileWriter writer, 
  Logger logger, Tracker tracker)   throws IOException
  { 
    System.out.println("Ending South Branch....");
    logger.setDescription("\n Ending South Branch ....");
    double perDaySalary = 0;
    //for (Staff p : s) 
    ////{
  //System.out.println(p.getStaffname()+p.getWorkingDays());
   // }

    System.out.println("size of staff before " + s.size());


    for (Staff person : s) {
    if (person.getStaffStatus().equals("Worked")) // adding salary only for those who have worked
   {     
    // person.updateStaffBonus(person.getBonusAmount());
     person.updateTotalStaffSalary(person.getStaffsalary());
     person.updateWorkingDays();
     perDaySalary = perDaySalary + person.getStaffsalary() + person.getBonusAmount();
     person.setStaffStatus("Working");
     person.setWorkCount(0); // setting work count 0 at the end
    }
  }

  tracker.setTrackerDescription("Total money  earned by FNCD Staff : $"+perDaySalary);
 
  int SalespersonQuit =0;
            int InternQuit =0;
            int MechanicQuit =0;
           
            // Randomly quiting
            Random rand = new Random();
           
            for (Staff person : allStaffs) {
                if (person.getStaffStatus().equals("Working")){
              if (person.getStaffType().equals("Intern") && (rand.nextDouble() < 0.1) && InternQuit <1)
              {
                  person.setStaffStatus("Quit"); // updating in staff type that they have quit
                    s.remove(person);
               InternQuit+=1;
              writer.write(person.getStaffType()+" "+person.getStaffname()+" has quit the FNCD");
              System.out.println(person.getStaffType()+" "+person.getStaffname()+" has quit the FNCD");
              logger.setDescription(person.getStaffType()+" "+person.getStaffname()+" has quit the FNCD");}

              if (person.getStaffType().equals("Salesperson") && (rand.nextDouble() < 0.1) && SalespersonQuit <1 )
              { 
                  person.setStaffStatus("Quit");
                  s.remove(person);
                  SalespersonQuit+=1;
                  writer.write(person.getStaffType()+" "+person.getStaffname()+" has quit the FNCD \n");
                  System.out.println(person.getStaffType()+" "+person.getStaffname()+" has quit the FNCD");
                  logger.setDescription(person.getStaffType()+" "+person.getStaffname()+" has quit the FNCD");
                }
               
              if (person.getStaffType().equals("Mechanic") && (rand.nextDouble() < 0.1) && MechanicQuit <1)
              {
                  person.setStaffStatus("Quit");
                  s.remove(person);
                  MechanicQuit+=1;
          
              writer.write(person.getStaffType()+" "+person.getStaffname()+" has quit the FNCD"+"\n");
              System.out.println(person.getStaffType()+" "+person.getStaffname()+" has quit the FNCD");
              logger.setDescription(person.getStaffType()+" "+person.getStaffname()+" has quit the FNCD");
              }

              if (person.getStaffType().equals("Driver") && (person.getStaffHealthStatus().equals("Injured")))
              {
                  person.setStaffStatus("Left");
                  s.remove(person);
                 
              writer.write(person.getStaffType()+" "+person.getStaffname()+" has left the FNCD as he was "+person.getStaffHealthStatus()+"\n");
              System.out.println(person.getStaffType()+" "+person.getStaffname()+" has left the FNCD as he was "+person.getStaffHealthStatus());
              logger.setDescription(person.getStaffType()+" "+person.getStaffname()+" has left the FNCD");
            }
            }
            }
        System.out.println("MechanicQuit: "+MechanicQuit);
        System.out.println("SalespersonQuit: "+SalespersonQuit);
        System.out.println("InternQuit: "+InternQuit);

        logger.setDescription("\n");
           int madd = 0;
        // Adding mechanics
            for (int y = 0; y < MechanicQuit; y++)
            {  System.out.println("Adding Mechanics ----------");
            madd = 0;
                for (Staff p : s) {
                    if (p.getStaffType().equals("Intern") && p.getStaffStatus().equals("Working") && madd <1)
                    { p.setStaffType("Mechanic");
                    p.getStaffType();
                    System.out.println("added Mechanic ----------" +p.getStaffname()+" value was updated to "+p.getStaffType());
                        logger.setDescription(p.getStaffname()+" has shifted to the position of a "+p.getStaffType());   
                        updateStaffInv(allStaffs, p);
                        madd+=1;
                      }
            }
        }
        int sadd = 0;
            //Add Salesperson
            for (int z = 0; z < SalespersonQuit; z++ )
            {   System.out.println("Adding Salesperson ----------");
            sadd = 0;
                for (Staff p1 : s) {
                    if (p1.getStaffType().equals("Intern") && p1.getStaffStatus().equals("Working") && sadd <1)
                    {     p1.setStaffType("Salesperson");
                    p1.getStaffType();
                    System.out.println("added Salesperson ----------"  +p1.getStaffname()+" value was updated to "+p1.getStaffType());
                    logger.setDescription(p1.getStaffname()+" has shifted to the position of a "+p1.getStaffType());
                    updateStaffInv(allStaffs, p1);
                    sadd+=1; 
                    }
                }
            }

        

                   System.out.println("size of s" + s.size());
  operatingBudget = operatingBudget - perDaySalary;

  //after paying the salary per day checking operating bonus
  double val = checkOperatingBudget(operatingBudget, writer, tracker);
      
  
  writer.write("Total Operating Cost : " + val+"\n");     
            return val;
                    }


public static void updateStaffInv(ArrayList<Staff> allStaffs, Staff p) {
    for (Staff p3 : allStaffs)
    {
  if (p3.getStaffname().equals(p.getStaffname()))
  {
       p3.setStaffType(p.getStaffType());
      
  }
    }
}

public static void updateVehicleInv(ArrayList<Vehicle> invList, Vehicle c) {
  for (Vehicle c3 : invList)
  {
if (c3.getVehicleName().equals(c.getVehicleName()))
{
    c3.setCondition(c.VehicleCondition());
}
  }
}

}
