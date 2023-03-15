import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class SimulationTestCases {
    ArrayList<Vehicle> inventoryList;
    ArrayList<Vehicle> storeVehicle;
    ArrayList<Staff> s;

    @Test
    public void testInitializecarInventory() {
        ArrayList<Vehicle> inventoryList = new ArrayList<>();
        int num_car_inventory = 10;
        MonthlyWorkingStatistics.InitializecarInventory(inventoryList, num_car_inventory);
        int i =inventoryList.size();
        this.inventoryList = inventoryList;
        assertEquals(i, 90);
    }

    @Test
    public void testInitializeStaffInventory() {
        ArrayList<Staff> s = new ArrayList<>();
        int num_staff_inventory = 3;
        MonthlyWorkingStatistics.InitializeStaffInventory(s, num_staff_inventory);
        int j =s.size();
        this.s = s;
        assertEquals(j, 12);
    }


    @Test
    public void testCheckStaffsize() {
        ArrayList<Staff> ss = new ArrayList<>();
        int num_staff_inventory = 3;
        MonthlyWorkingStatistics.InitializeStaffInventory(ss, num_staff_inventory);
        int i = 0;
        int m = 0;
        int d = 0;
        int s = 0;
        for (Staff person : ss)
        {
            if(person.staffType().equals("Intern")) 
            {i +=1;}
           else  if(person.staffType().equals("Mechanic")) 
            {m +=1;}
            else  if(person.staffType().equals("Driver")) 
            {d +=1;}
            else  if(person.staffType().equals("Salesperson")) 
            {s +=1;}
        }
        assertEquals(i, 3);
        assertEquals(m, 3);
        assertEquals(d, 3);
        assertEquals(s, 3);
    }


    @Test
    public void testCreateStoreVehicleList() {
        ArrayList<Vehicle> v1 = new ArrayList<>();
        ArrayList<Vehicle> inventoryList = new ArrayList<>();
        MonthlyWorkingStatistics.InitializecarInventory(inventoryList, 10);
        int num_store_vehicle = 6;
       MonthlyWorkingStatistics.CreateStoreVehicleList(v1, inventoryList,num_store_vehicle);
        int k =v1.size();
        this.storeVehicle = v1;
        assertEquals(k, 54);
    }

    @Test
    public void testCheckStoreVehiclesize() {
      
        ArrayList<Vehicle> v1 = new ArrayList<>();
        ArrayList<Vehicle> inventoryList = new ArrayList<>();
        MonthlyWorkingStatistics.InitializecarInventory(inventoryList, 10);
        int num_store_vehicle = 6;
       MonthlyWorkingStatistics.CreateStoreVehicleList(v1, inventoryList,num_store_vehicle);

        int i = 0;
        int m = 0;
        int d = 0;
        int s = 0;
        int ii = 0;
        int mm = 0;
        int dd = 0;
        int ss = 0;
        int ee = 0;
        for (Vehicle v : v1)
        {
            if(v.VehicleType().equals("PerformanceCar")) 
            {i +=1;}
           else   if(v.VehicleType().equals("PickUpCar")) 
            {m +=1;}
            else   if(v.VehicleType().equals("RegularCar")) 
            {d +=1;}
            else   if(v.VehicleType().equals("ElectricCars")) 
            {s +=1;}
           else if(v.VehicleType().equals("MonsterTrucks")) 
            {ii +=1;}
           else   if(v.VehicleType().equals("Motorcycles")) 
            {mm +=1;}
            else   if(v.VehicleType().equals("ElectricTrucks")) 
            {dd +=1;}
            else   if(v.VehicleType().equals("Formula1Cars")) 
            {ss +=1;}
            else   if(v.VehicleType().equals("RacingMotorcycles")) 
            {ee +=1;}
        }
        assertEquals(i, 6);
        assertEquals(m, 6);
        assertEquals(d, 6);
        assertEquals(s, 6);
        assertEquals(ii, 6);
        assertEquals(mm, 6);
        assertEquals(dd, 6);
        assertEquals(ss, 6);
        assertEquals(ee, 6);
    }

    @Test
    public void testupdateVehicleAndStaffDetails() {
        double operatingbudget = 10000;
        Tracker tracker = Tracker.getInstance();
        ArrayList<Vehicle> inventoryList = new ArrayList<>();
        ArrayList<Staff> s = new ArrayList<>();
        ArrayList<Vehicle> v1 = new ArrayList<>();
        MonthlyWorkingStatistics.InitializecarInventory(inventoryList, 10);
        MonthlyWorkingStatistics.InitializeStaffInventory(s,3);
        MonthlyWorkingStatistics.CreateStoreVehicleList(v1, inventoryList,6);
        Staff f1 = s.get(6);
        Interaction interaction = new Interaction();
        interaction.executeCommand(new ShowCarDetailsCommand(v1.get(6)));
        FNCD_North.updateVehicleAndStaffDetails(operatingbudget, s, v1, inventoryList,f1, tracker);
        boolean checkemployee = false;
        for (Staff person : s)
        {
        if (person.getStaffname().equals(f1.getStaffname()))
        {
            checkemployee = true;
        }
    }
        assertTrue(checkemployee);
          
    }  


    @Test
    public void testhireIntern() throws IOException {
        FileWriter writer = new FileWriter("SimulationTesting.txt", false);
        Logger logger = Logger.getInstance();
        ArrayList<Staff> s = new ArrayList<>();
        ArrayList<Staff> s1 = new ArrayList<>();
        MonthlyWorkingStatistics.InitializeStaffInventory(s,3);
        for (Staff person : s)
        {
        if ( !person.getStaffType().equals("Intern"))
        {
            s1.add(person);
        }
      }
        FNCD_North.hireIntern(3, s, s, writer, logger );
        writer.close();
        assertEquals(3, s.size() - s1.size());
    }

   @Test
   public void testcheckOperatingBudgetForNegativeScenario() throws IOException
   {
    FileWriter writer = new FileWriter("SimulationTesting.txt", false);
    Tracker tracker = Tracker.getInstance();
    double operatingBudget = -10000; //giving negative amount in input
    boolean budget = false;
    FNCD_South.checkOperatingBudget(operatingBudget, writer,tracker );
 if (operatingBudget < 0)
 {budget = true;}
 else {budget = false;}
 assertTrue(budget);
}



@Test
public void testcheckOperatingBudgetforPositiveScenario() throws IOException
{
 FileWriter writer = new FileWriter("SimulationTesting.txt", false);
 Tracker tracker = Tracker.getInstance();
 double operatingBudget = 10000; //giving negative amount in input
 boolean budget = false;
 FNCD_South.checkOperatingBudget(operatingBudget, writer,tracker );
if (operatingBudget == 10000)
{budget = true;}
else {budget = false;}
assertTrue(budget);
}

     @Test
    public void testaddVehicle() throws IOException
        {
                    FileWriter writer = new FileWriter("SimulationTesting.txt", false);
                    Logger logger = Logger.getInstance();
                    ArrayList<Vehicle> carList = new ArrayList<>();
                    ArrayList<Vehicle> carList1 = new ArrayList<>();
                    MonthlyWorkingStatistics.InitializecarInventory(carList, 10);
                    for (Vehicle veh : carList)
                {
                    if ( !veh.VehicleType().equals("RegularCar"))
            {carList1.add(veh);}
        }
                    FNCD_North.addVehicle(3, carList1, carList1, "RegularCar", 20000, writer, logger);
                    writer.close();
                    boolean size = false;
                    if (carList.size() > carList1.size())
                        {size = true;}
                  else {size = false;}
                                        
                    assertTrue(size);

        }


        @Test
        public void testupdateCarPrice()
            {
                ArrayList<Vehicle> inventoryList = new ArrayList<>();
                MonthlyWorkingStatistics.InitializecarInventory(inventoryList, 10);
                Vehicle repairVehicle = inventoryList.get(9);
                FNCD_South.updateCarPrice(inventoryList, repairVehicle, 1.2);
                boolean costcheck;
                if (repairVehicle.getVehicleCost()< inventoryList.get(9).getVehicleCost())
                {costcheck = true;}
                else { costcheck = false;}
                assertFalse(costcheck);
            }  
            
        @Test
        public void testhireDriver() throws IOException
            {
                FileWriter writer = new FileWriter("SimulationTesting.txt", false);
                Logger logger = Logger.getInstance();
                ArrayList<Staff> s = new ArrayList<>();
                ArrayList<Staff> s1 = new ArrayList<>();
               
                MonthlyWorkingStatistics.InitializeStaffInventory(s,3);
                for (Staff person : s)
                {
                if ( !person.getStaffType().equals("Driver"))
                {
                    s1.add(person);
                }
              }
               FNCD_North.hireDriver (3, s , s,  writer, logger);
                writer.close();
                assertEquals(3, s.size() - s1.size());
            }

            @Test
            public void testupdateStaffInv()
                {
                    
                    ArrayList<Staff> s = new ArrayList<>();
                    MonthlyWorkingStatistics.InitializeStaffInventory(s,3);
                    Staff f = s.get(5);
                    f.setStaffType("Change employee");
                    FNCD_South.updateStaffInv(s,f);
                    boolean updStaffcheck;
                    if (f.getStaffType().equals(s.get(5).getStaffType()))
                    {updStaffcheck = true;}
                    else { updStaffcheck = false;}
                    assertTrue(updStaffcheck);  
                }
                @Test
                public void testupdateVehicleInv()
                    {
                        ArrayList<Vehicle> v1 = new ArrayList<>();
                        MonthlyWorkingStatistics.InitializecarInventory(v1, 10);
                        Vehicle v = v1.get(9);
                        v.setCondition("New condition");
                        FNCD_North.updateVehicleInv(v1, v);
                        boolean updcondcheck;
                        if(v1.get(9).VehicleCondition().equals(v.VehicleCondition()))
                        {updcondcheck= true;}
                        else {updcondcheck= false;}
                        assertTrue(updcondcheck);
                    }

                    @Test
                public void testWashUpd()
                    {
                        ArrayList<Vehicle> v1 = new ArrayList<>();
                        MonthlyWorkingStatistics.InitializecarInventory(v1, 10);
                        Vehicle v = v1.get(5);
                        v.setCleanliness("Dirty");
                        ChemicalStrategy cm = new ChemicalStrategy();
                        cm.doWash(v);
                        boolean washcheck;
                        if (!v.VehicleCleanliness().equals("Dirty"))
                        { washcheck = true;}
                        else {washcheck = false;}
                        assertTrue(washcheck);
                    }

   }

   

