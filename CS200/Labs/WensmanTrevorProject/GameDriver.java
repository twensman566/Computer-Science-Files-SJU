import java.util.*;
import javax.swing.*;
import java.io.*;



public class GameDriver
{
  
  public GameLayout collection;
  public GameDriver(String fileName1, String fileName2)
  {
    System.out.println("Welcome to the Game Driver Manager");
    collection = new GameLayout(fileName1,fileName2 );
  }
  private void menu() {
    System.out.println();
    System.out.println("\tD ----- Display the description of your current location.");
    System.out.println("\tL ----- List all possible locations");
    //System.out.println("\tM ----- List Possible Locations to Move");
    System.out.println("\tS ----- Search for a Location");
    //System.out.println("\tC ----- Display all Connections");
    System.out.println("\tW ----- Saves the current game.");
    System.out.println("\tP ----- Loads a past game.");
    //System.out.println("\tR ----- Removes a Location from the Game");
    //System.out.println("\tH ----- Displays Locations With Connections");
    System.out.println("\tA ----- Move to a new location");
    System.out.println("\tQ Quit the program");
    System.out.println();
  }
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
  
   private void doCommand(char cmd) {
    Scanner scanner = new Scanner(System.in);
    String input;
    switch (cmd)
    {
      case 'd': case 'D':
        //input = scanner. nextLine();
        System.out.println(collection.getLocationDescription(collection.getCurrentLocation()));
        break;
      case 'r': case 'R':
        input = scanner. nextLine();
        collection.remove(input);
        break;
      case 'm': case 'M':
       //input = scanner. nextLine();
       System.out.println(collection.listConnectionsToLocation(collection.getCurrentLocation()));
        break;
      case 'c': case 'C':
       System.out.println(collection.displayAllConnections());
        break;
      case 's': case 'S':
       input = scanner. nextLine();
       System.out.println(collection.search("StartingLocation",input));
        break;
      case 'l': case 'L':
        System.out.println(collection.displayAllLocations());
        break;
      case 'w': case 'W':
       input = scanner. nextLine();
       collection.writeToFile(input);
        break;
      case 'H': case 'h':
       System.out.println(collection.displayLocationsAndTheirConnections());
        break;
//      case 'P': case 'p':
//        GameLayout newLayout = collection.loadNewGame();
//        collection = newLayout;
//        break;
      case 'A': case 'a':
        System.out.println(collection.getCurrentLocation());
        System.out.println(collection.listConnectionsToLocation(collection.getCurrentLocation()));
        input = scanner. nextLine();
        collection.setCurrentLocation(input);
        System.out.println(collection.getCurrentLocation());
        break;
        
      default:
        System.out.println("Invalid command--try again");
    }
  }
   
    private char acceptCommand() {
    char cmd;
    String s = JOptionPane.showInputDialog("Enter command: ");
    cmd = s.charAt(0);
    return cmd;
  }
  
  public static void main(String[] args){
    GameDriver col = new GameDriver("Locations","Connections");
    col.runManager();
    
  }
}