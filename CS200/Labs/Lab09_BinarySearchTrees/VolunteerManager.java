import java.util.*;
import worker.*;
import javax.swing.*;
import java.io.*;

/**
 * Manages the volunteer.
 * 
 * @author Zachary Vetter, Trevor Wensman, Alexis Neas
 * @version 9/17/2017
 */
public class VolunteerManager
{
  /**
   * The volunteer being managed
   */
  private Volunteer theVolunteer;
  
  /**
   * Creates a manager for a volunteer
   * 
   * @param worker the volunteer
   */
  public VolunteerManager(Worker worker)
  {
    theVolunteer = (Volunteer) worker;
    runManager();
  }
  
  /**
   * Runs the manager.
   */
  public void runManager() {
    char cmd;
    do
    {
      menu ();
      cmd = acceptCommand ();
      doCommand (cmd);
    }
    while ((cmd != 'q') && (cmd != 'Q'));
  }
  
  /**
   * Prints the menu options out
   */
  private void menu() {
    System.out.println();
    System.out.println("\tA Add hours");
    System.out.println("\tP rePort on worker");
    System.out.println("\tQ Return to main menu");
    System.out.println();
  }
  
  /**
   * Gets a command from the user.
   * 
   * @return the character entered
   */
  private char acceptCommand() {
    char cmd;
    String s = JOptionPane.showInputDialog("Enter command: ");
    cmd = s.charAt(0);
    return cmd;
  }
  
  /**
   * Runs the command given
   * 
   * @param cmd the command entered by the user
   */
  private void doCommand(char cmd) {
    switch (cmd)
    {
      case 'a': case 'A':
        int hours = Integer.parseInt(JOptionPane.showInputDialog("Enter the hours to add for the Volunteer: "));
        theVolunteer.addHours(hours);
        break;
      case 'p': case 'P':
        report();
        break;
      case 'q': case 'Q':
        System.out.println("Now returning to main screen");
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  
  /**
   * Gives a report on the volunteer
   */
  private void report()
  {
    System.out.println(theVolunteer.getName() + "\tHours: " + theVolunteer.getHours());
  }
}