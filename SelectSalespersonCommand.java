import java.util.ArrayList;

public class SelectSalespersonCommand implements CommandPattern{
    public static  Staff salesperson;
    

    public SelectSalespersonCommand(ArrayList<Staff> s) {
        String name = null ;
       
        for (Staff person : s) {
           // System.out.println(person.staffType());
            if (person.getStaffType().equals("Salesperson"))
           {// System.out.println("i m in sales person");
            // SalesStaff.add(person);
             name = person.getStaffname();
             this.salesperson= person;
             break;
            }
        }
 
	}

   

    public static Staff getSalesperson()
    {  
        return salesperson;
    }

    
	
    @Override
    public void execute() {
     System.out.println("\n Hi I am Salesperson :"+ salesperson.getStaffname());
        //return salesperson;
       
    }

    @Override
    public void setCommand() {
        
    }
}
