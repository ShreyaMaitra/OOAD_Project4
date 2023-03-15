// user for user interaction
public class Interaction {
    private CommandPattern command;
    
   // public void setCommand(CommandPattern command) { 
   //     this.command = command;
   // }

    public void executeCommand (CommandPattern command) { 
        command.execute();
    }

    public void setCommand(CommandPattern command) {
        command.setCommand();
    }
    
    
}

