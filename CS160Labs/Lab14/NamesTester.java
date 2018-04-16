// ConsoleProgram
import acm.program.ConsoleProgram;


/**
 * A program that displays a table of a cannon ball's travel from firing until it
 * hits the ground for a specified initial velocity and angle.
 */
public class NamesTester extends ConsoleProgram
{
  private HeadTailList<String> list;
  private String cmd, newname, nametofind, nametoremove;
  
  
  /**
   * Creat NamesTester and start it
   */
  public static void main(String [] args)
  {
    new NamesTester().start();
  }
  
  
  /**
   * Initializes the NamesTester
   */
  public void init()
  {
    list = HTLUtilities.readStringListSig(getConsole(), "quit", "Enter a string to add:  ");
  }
  
  
  /**
   * Run the NamesTester
   */
  public void run()
  {
    do {
      //read command from user
      cmd = readLine("\n\nAvailable commands:\tadd\n \t\tfind\n \t\tremove\n \t\tdisplay\n \t\tquit\n\n Enter a command: ");
      // while(!cmd.equals("quit")) {
      if(cmd.equals("add"))
      {
        String userInput = this.readLine("Enter a name to add to the list: ");
        if(!HTLUtilities.find(list,userInput))
        {
          LinkedHeadTailList<String> newList = new LinkedHeadTailList<String>(userInput, list);
          list = newList;
          String string = HTLUtilities.displayList(list);
        
          this.println("This is the list with your new name added: " + string);
        }
        else
        {
          this.println("The name is already in the list"); 
          
        }
        
      }
      
      //TODO: if command cmd is add:
      //TODO: prompt user "Enter a name to add to the list:"
      //TODO: read in the user input
      //TODO: add user input as last element to the current list
      //TODO: print the string "This is the list with your new name added:" followed by updated list
      else if(cmd.equals("find"))
      {
        String userInput = this.readLine("Enter a name to find in the list: ");
        if(HTLUtilities.find(list,userInput))
        {
          this.println("This name is in the list.");
        }
        else{
          this.println("This name was not found."); 
        }
        
      }
      //TODO: if command is find
      //TODO: prompt user "Enter a name to find in the list:"
      //TODO: read in the user input
      //TODO: if element is in the list print string "This name is in the list.", else print "This name is not in the list."
      else if(cmd.equals("remove"))
      {
        String userInput = this.readLine("Enter a name you would like to remove from the list: "); 
        if((HTLUtilities.find(list,userInput)))
        {
          HeadTailList<String> newList = HTLUtilities.cull(list,userInput);
          list = newList;
        }
        else
        {
          this.println("Not in there");
        }
      }
      //TODO: if command is remove
      //TODO: prompt user "Enter a name you would like to remove from the list:"
      //TODO: read in the user input
      //TODO: remove element specified by user from current list
      //TODO: print the string ""This is the list with your name removed:"" followed by updated list
      else if(cmd.equals("display"))
      {
        String string = HTLUtilities.displayList(list);
        this.println(string);
      }
      else{
        this.println("Not a Valid Command"); 
      }
      //TODO: if the command is display
      //TODO: print the current list
    }while(!cmd.equals("quit"));
    
    System.exit(0);
  }
  
}
