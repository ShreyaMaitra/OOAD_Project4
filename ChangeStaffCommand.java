import java.util.ArrayList;

public class ChangeStaffCommand implements CommandPattern{
    private static Staff newSalesperson;
    
    
    public ChangeStaffCommand(ArrayList<Staff> s) {
       String s1 = SelectSalespersonCommand.getSalesperson().getStaffname();
        
        String name = null ;
        for (Staff person : s) {
           // System.out.println(person.staffType());
            if (person.getStaffType().equals("Salesperson") && !person.getStaffname().equals(s1))
           {
             name = person.getStaffname();
             newSalesperson = person;
             break;
            }
        }
  

  //System.out.println("new salesperson is "+name);
	}

    public static Staff getNewSalesperson()
    {  
        return newSalesperson;
    }
    
    @Override
    public void execute() {
     System.out.println("\n Hi I am your new Salesperson :"+ newSalesperson.getStaffname());
        //return salesperson;
       
    }


    @Override
    public void setCommand() {
        
    }
}
