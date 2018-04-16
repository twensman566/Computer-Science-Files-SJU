/*
 * File: GameLayout.java
 */

import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 * Put an appropriate class header here
 */
public class GameLayout {
  
//associates a given location label with a set of connected locations
  private HashMap <String, Set<String>> connections;
//associates a given location with its description object
  private HashMap <String, LocationDescription> descriptions;
  private String currentLoc;
  
  //player info
  private int playerdamage,playerhp;
  private String playerWep,playerarmor;
  
  
  
  /**
   * Makes an empty book collection.
   * 
   */
//  public GameLayout()
//  {
//    
//    descriptions = new HashMap<String, LocationDescription>();
//    
//  }
  /**
   * This constructor will read in all the information for books and
   * insert the author name associated with this book entry into the
   * library. You will need to organize your file in such a way that
   * this is reasonably easy to do. I have included a very short
   * sample library showing one way to organize. (I use a _ to separate
   * one book from the next.)
   * 
   * @param fileName the path to the file containing the book information
   * @throws FILL IN APPROPRIATE EXCEPTION INFORMATION.
   */
  public GameLayout(String locations, String connects)
  {
    this.currentLoc ="The Beginning";
    descriptions = new HashMap<String, LocationDescription>();
    File file = new File(locations);
    try{
      Scanner scanner = new Scanner(file);
      
      while(scanner.hasNextLine())
      {      
        String location = (scanner.nextLine());
        String enemy = (scanner.nextLine());
        String enemyHealth = (scanner.nextLine());
        String enemyDamage = (scanner.nextLine());
        String shop = (scanner.nextLine());
        String weapon = (scanner.nextLine());
        String armor = (scanner.nextLine());
        
        
        
        LocationDescription description = new LocationDescription(location,enemy,enemyHealth,enemyDamage,shop,weapon,armor);
        addLocations(description);
        
        
      }
      
      
      connections = new HashMap<String, Set<String>>();
      file = new File(connects);
      scanner = new Scanner(file);
      
      
      while(scanner.hasNextLine())
      {
        String currentLocation = scanner.nextLine();
        //System.out.println(currentLocation);
        String numConnects = scanner.nextLine();
        // System.out.println(numConnects);
        int num = Integer.parseInt(numConnects);
        Set<String> set = new HashSet<String>();
        while(num > 0)
        {
          num--;
          set.add(scanner.nextLine());
        }
        
        addConnections(currentLocation,set);
        
        
      }
      player();
      
      
      
      
      
      //System.out.println(descriptions.values());
      //System.out.println(connections.values());
    }catch(FileNotFoundException e){
      
    }
  }
  public void player()
  {
    this.playerhp = 2;
    this.playerdamage = 2;
  }
  
  public void loadNewGame()
  {
    JFileChooser fc = new JFileChooser();
    fc.getSelectedFile();
    fc.showOpenDialog(null);
    this.descriptions.clear();
    descriptions = new HashMap<String, LocationDescription>();
    File file = new File(fc.getSelectedFile().getName());
    try{
      Scanner scanner = new Scanner(file);
      
      while(scanner.hasNextLine())
      {      
        String location = (scanner.nextLine());
        String enemy = (scanner.nextLine());
        String enemyHealth = (scanner.nextLine());
        String enemyDamage = (scanner.nextLine());
        String shop = (scanner.nextLine());
        String weapon = (scanner.nextLine());
        String armor = (scanner.nextLine());
        
        
        
        LocationDescription description = new LocationDescription(location,enemy,enemyHealth,enemyDamage,shop,weapon,armor);
        addLocations(description);
        
        
      }
      
      
    }catch(FileNotFoundException e){
      
    }
    
    
    
    
    
    
    loadPlayer();
  }
  public void loadPlayer()
  {
    System.out.println("INSIDE LOADPLAYER METHOD");
    JFileChooser fc = new JFileChooser();
    fc.getSelectedFile();
    fc.showOpenDialog(null);
    File file = new File(fc.getSelectedFile().getName());
    try{
      Scanner scanner = new Scanner(file);
      
      this.playerdamage = Integer.valueOf((scanner.nextLine()));
      this.playerhp = Integer.valueOf((scanner.nextLine()));
      String newLoc = (scanner.nextLine());
      this.currentLoc = newLoc;
      
      System.out.println(this.currentLoc);
      System.out.println(this.playerhp);
    }catch(FileNotFoundException e){
      
    }
  }
  public void writePlayer(String fileName)
  {
    try{
      PrintWriter printer = new PrintWriter(fileName);
      String info = this.playerdamage + "\n" + this.playerhp + "\n" + this.currentLoc + "\n";
      printer.write(info);
      printer.close();
    }catch(FileNotFoundException e){
      
    }
  }
  
  
  /**
   * Adds the connections for the locations.
   * 
   * @param currentLocation the location to add connections to.
   * @param theConnections what connections to add to the location.
   * 
   * 
   */
  public void addConnections(String currentLocation, Set<String> theConnections)
  {
    //System.out.println(currentLocation);
    connections.put(currentLocation,theConnections);
  }
  
  /**
   * Adds the Locations to the map.
   * 
   * @param locationToAdd the location to add to the map.
   * 
   */
  public void addLocations(LocationDescription locationToAdd)
  {
    descriptions.put(locationToAdd.getLocation(),locationToAdd);
  }
  /**
   //   * Get a description for a location
   //   * 
   //   * @param location the author
   //   * 
   //   * @return the location description
   //   */
  public String getLocationDescription(String location)
  {
    LocationDescription theDescription = descriptions.get(location);
    //BookDescription book = newMap.get(title);
    //System.out.println("in the method" + theDescription.getLocation());
    //return theDescription.toString();
    if(theDescription.getLocation().equals("The Beginning"))
    {
      return "You are at the beginning, there is nothing here."; 
    }
    if(!theDescription.getEnemyHealth().equals("*"))
    {
      return "Current Location is " + theDescription.getLocation() + "\n" + "Enemy Name:" + theDescription.getEnemy() + "\n" + "Current enemies health is:" + theDescription.getEnemyHealth() + "\n" + "Current enemies damage is: " +theDescription.getEnemyDamage();
    }
    
    else
    {
      return "Current Location is " + theDescription.getLocation() + "\n" + theDescription.getArmor() + "\n" + theDescription.getWeapon();
    }
  }
  /**
   * Lists all the connections for a certain location
   * 
   * @param location the current location
   * 
   * @return a string with the connections to the current location.
   * 
   */
  public String listConnectionsToLocation(String location)
  {
    return location + " is connected to " + connections.get(location);
  }
  
  
  
  /**
   * Removes a location from the map.
   * 
   */
  public void remove(String locationToRemove)
  {
//    System.out.println(locationToRemove);
//    System.out.println(descriptions.get(locationToRemove));
//    System.out.println(connections.get(locationToRemove));
    descriptions.remove(locationToRemove);
    connections.remove(locationToRemove);
    removeConnectionReference(locationToRemove);
  }
  
  public void removeConnectionReference(String locationToRemove)
  {
    Iterator<String> locations = locationIterator();
    while(locations.hasNext())
    {
      Set<String> set = connections.get(locations.next());
      if(set != null)
      {
        if(set.contains(locationToRemove))
        {
          set.remove(locationToRemove);
        }
      }
      //Iterator<String> iteratorConnect = set.iterator();
      
      
      
    }
  }
  
  /**
   * Updates a dungeon when it is beaten by a user.
   * 
   */
  public void updateBeatenDungeon(String dungeontoUpdate)
  {
    LocationDescription theDescription = descriptions.get(dungeontoUpdate);
    theDescription.setEnemyHealth("0");
    
  }
  /**
   * Returns an iterator over all the locations.
   */
  public Iterator<String> locationIterator()
  {
    return this.descriptions.keySet().iterator();
  }
  /**
   * Returns an iterator over all the connections.
   */
  public Iterator<String> connectionsIterator()
  {
    return this.connections.keySet().iterator();
  }
  /**
   * Returns a set of the connections for a location/
   * 
   * @param location the current location
   * 
   * @return a set of the connections 
   */
  public Set<String> connectionsToLocation(String location)
  {
    return connections.get(location);
  }
  /**
   * Displays all the connections for all locations
   * 
   * @param location the current location
   * @return all the connections
   */
  public String displayLocationsAndTheirConnections()
  {
    Iterator<String> locations = locationIterator();
    //Iterator<String> locations = connectionsIterator(location);
    String theLocation = "";
    while(locations.hasNext())
    {
      String tempLoc = locations.next();
      Set<String> connections = connectionsToLocation(tempLoc);
      //Iterator<String> connectionsIterator = connectionsIterator(tempLoc);
      if(connections != null){
        theLocation += tempLoc + "    ";
        Iterator<String> iteratorConnect = connections.iterator();
        while(iteratorConnect.hasNext())
        {
          theLocation += iteratorConnect.next() + "   ";
        }
        
        theLocation += "\n";
      }
    }
    return theLocation;
  }
  
  public String displayAllConnections()
  {
    Iterator<String> locations = locationIterator();
    String theLocation = "";
    while(locations.hasNext())
    {
      theLocation += locations.next() + "\n";
    }
    return theLocation;
  }
  /**
   * Displays all the locations.
   * 
   * @return all the Locations.
   */
  public String displayAllLocations()
  {
    Iterator<String> locations = locationIterator();
    String theLocation = "";
    while(locations.hasNext())
    {
      theLocation += locations.next() + "\n";
    }
    return theLocation;
  }
  
  /**
   * Saves the users games to a file.
   * 
   */
  public void writeToFile(String fileName)
  {
    try{
      PrintWriter printer = new PrintWriter(fileName);
      Iterator<String> locations = locationIterator();
      while(locations.hasNext())
      {
        String location = locations.next();
        LocationDescription theDescription = descriptions.get(location);
        String info = theDescription.toString();
        printer.write(info);
        // System.out.println(info);
//        String enemy =
//        String enemyHealth =
//        String enemyDamage =
//        String shop =
//        String weapon =
//        String armor =
        
      }
      printer.close();
    }
    catch(FileNotFoundException e){
      System.out.println("The file was not found."); 
    }
  }
  
  
  /**
   * This method searches for a the object you are looking for.
   * 
   * @param location a location
   * @param object the object you are looking for
   * @return location of the object
   * 
   */
  public boolean search(String location, String object)
  {
    ArrayDeque<String> locations = new ArrayDeque<String>();
    LocationDescription theDescription = descriptions.get(location);
    //System.out.println(theDescription.toString());
    locations.add(location);
    theDescription.mark();
    
    while(!locations.isEmpty())
    {
      System.out.println(locations);
      String currentLocation = locations.poll(); 
      if(object.equals(currentLocation))
      {
        unmarkAll();
        return true;
      }
      
      //Iterator<String> connections = connectionsIterator(location);
      Set<String> connections = connectionsToLocation(currentLocation);
      System.out.println("Set of the connections" + connections);
      //System.out.println(currentLocation + connections + object);
      if(connections !=null)
      {
        Iterator<String> iteratorConnect = connections.iterator();
        //System.out.println(connections);
        //System.out.println(iteratorConnect);
        while(iteratorConnect.hasNext())
        {
          //System.out.println("INSIDE ADDING CONNECITONS");
          String temp = iteratorConnect.next();
          
          //System.out.println(temp);
          theDescription = descriptions.get(temp);
          //System.out.println(temp + "    lOCATION");
          // System.out.println(theDescription.getMark());
          //System.out.println(theDescription);
          if(theDescription.getMark() == false)
          {
           // System.out.println("Location to add to queue" + theDescription);
            theDescription.mark();
            locations.add(temp);
          }
          else if(theDescription.getMark() == true)
          {
           // System.out.println("hi");
          }
          
        }
      }
      
      
      
      
      
    }
    unmarkAll();
    return false;
  }
  
  
  
  public void unmarkAll()
  {
    Iterator<String> locations = locationIterator();
    while(locations.hasNext())
    {
      String location = locations.next();
      LocationDescription theDescription = descriptions.get(location);
      theDescription.unmark();
    }
  }
  
  
  public void setCurrentLocation(String location)
  {
    System.out.println("location   " + location);
    System.out.println(this.currentLoc);
    String tempLocation = this.currentLoc;
    this.currentLoc = location;
    
    System.out.println(this.currentLoc);
    
    LocationDescription locDes = descriptions.get(this.currentLoc);
    if(locDes.getEnemyHealth().equals("BEATEN"))
    {
      JPanel panel = new JPanel();
      JOptionPane.showMessageDialog(panel , "You have already beaten this enemy!");
    }
    else if(!locDes.getEnemyHealth().equals("*"))
    {
      fight(locDes,tempLocation);
    }
    else
    {
      
      town(locDes);
    }
  }
  
  public String getCurrentLocation()
  {
    return this.currentLoc; 
  }
  
  public String getPlayerHealth()
  {
    return Integer.toString(this.playerhp);
  }
  
  public String getPlayerDamage()
  {
    return Integer.toString(this.playerdamage);
  }
  
  
  public void town(LocationDescription location)
  {
    if(Integer.valueOf(location.getWeapon()) > this.playerdamage)
    {
      this.playerdamage = Integer.valueOf(location.getWeapon());
      JPanel panel = new JPanel();
      JOptionPane.showMessageDialog(panel , "You found a weapon! \n Your new max damage is :" + this.playerdamage);  
    }
    else if(Integer.valueOf(location.getArmor()) > 0)
    {
      this.playerhp = this.playerhp + Integer.valueOf(location.getArmor());
      JPanel panel = new JPanel();
      JOptionPane.showMessageDialog(panel , "You found some health for your character! " + Integer.valueOf(location.getArmor()) + " Health added!");
      location.setArmor("0");
    }
  }
  
  
  
  
  
  
  public boolean fight(LocationDescription location, String thelocation)
  {
    Random rand = new Random();
    boolean runAway = true;
    int newEnemyhp;
    while(Integer.valueOf(location.getEnemyHealth()) > 0 && runAway && this.playerhp > 0)
    {
      System.out.println("Enemy hp "+location.getEnemyHealth());
      System.out.println("Player hp " + playerhp);
      int playerDamage = rand.nextInt(this.playerdamage);
      int enemyDamage = rand.nextInt(10);
      
      runAway = box(playerDamage,Integer.valueOf(location.getEnemyHealth()), location);
     if(runAway == false)
      {
        this.currentLoc = thelocation;
        break;
      }
      else if(runAway == true)
      {
        newEnemyhp = Integer.valueOf(location.getEnemyHealth()) - playerDamage;
        if(newEnemyhp < 0)
        {
          newEnemyhp = 0; 
        }
        location.setEnemyHealth(Integer.toString(newEnemyhp));
        
        if(Integer.valueOf(location.getEnemyHealth()) > 0)
        {
          this.playerhp = this.playerhp - enemyDamage;
          JPanel panel = new JPanel();
          JOptionPane.showMessageDialog(panel , "Enemy Damage was" + enemyDamage + "\nYour current health is now: " + this.playerhp);
        }
        if(this.playerhp < 0)
        {
         this.playerhp = 0; 
        }
        
        
        
        
      }
  
      
    }
    if(Integer.valueOf(location.getEnemyHealth()) ==  0)
    {
      JPanel panel = new JPanel();
      JOptionPane.showMessageDialog(panel , "Nice job you have beaten the enemy!");
      
      location.setEnemyHealth("BEATEN");
      location.setEnemyDamage("BEATEN");
      return true;
    }
    if(this.playerhp == 0)
    {
      JPanel panel = new JPanel();
      JOptionPane.showMessageDialog(panel , "You have lost the game! It will now quit! >:(");
      return false;
    }
    return true;
  }
  
  
  
  public boolean box(int playerDamage, int enemyHp, LocationDescription locationnDes) {
    Object[] options1 = { "Attack the Enemy", "Run Away"};
    
    JPanel panel = new JPanel();
    //panel.add(new JLabel("Enter number between 0 and 1000"));
    //JTextField textField = new JTextField(10);
    // panel.add(textField);
    
    int result = JOptionPane.showOptionDialog(null, panel, "You are Fighting " + locationnDes.getEnemy() + "!",
                                              JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                                              null, options1, null);
    if (result == JOptionPane.YES_OPTION){
      int hp = enemyHp-playerDamage;
      if(hp<0)
      {
        playerDamage = hp + playerDamage;
        hp = 0;
        
      }
      JOptionPane.showMessageDialog(null, "You damage " + locationnDes.getEnemy() + " for: " + playerDamage + "!" + "\nEnemy's new health is: " + hp);
      return true;
    }
    
    else if(result == JOptionPane.NO_OPTION)
    {
      JOptionPane.showMessageDialog(null, "You ran away from " + locationnDes.getEnemy() + "!");
      return false;
    }
    return false;
  }
  
  
  
  
  
  
  /**
   * Add a book to a specific author.
   * 
   */
  
  /**
   * Removes a book from the collection.
   * 
   * @return boolean true if removed.
   * 
   */
//  public boolean remove(BookDescription book)
//  {
//    if(!library.containsKey(book.getAuthor()))
//    {
//      return false;
//    }
//    HashMap<String,BookDescription> newMap = library.get(book.getAuthor());
//    if(!newMap.containsKey(book.getTitle()))
//    {
//      return false;
//    }
//    else
//    {
//      newMap.remove(book.getTitle());
//      return true;
//    }
//  }
//  /**Checks to see if map is empty.
//   * 
//   */
//  public boolean isEmpty()
//  {
//    return this.library.isEmpty(); 
//  }
//  /**
//   * Updates the description.
//   * 
//   * 
//   * @param author the author
//   * @param title the title
//   * @param description the new description
//   * 
//   * @return boolean true if added
//   * 
//   */
//  public boolean updateDescription(String author, String title, String description)
//  {
//    if(!library.containsKey(author))
//    {
//      throw new NoSuchElementException();
//    }
//    HashMap<String,BookDescription> newMap = library.get(author);
//    if(!newMap.containsKey(title))
//    {
//      return false;
//    }
//    else
//    {
//      BookDescription book = newMap.get(title);
//      book.setDescription(description);
//      return true;
//    }
//  }
// /**
//  * Writes the book info to a file.
//  * 
//  */ 
//  public void writeToFile(String fileName)
//  {
//    try{
//      PrintWriter printer = new PrintWriter(fileName);
//      Iterator<String> authors = authorIterator();
//      while(authors.hasNext())
//      {
//        String author = authors.next();
//        HashMap<String,BookDescription> inner = library.get(author);
//        Iterator<String> titles = titleIterator(author);
//        while(titles != null && titles.hasNext())
//        {
//          printer.println(inner.get(titles.next()));
//        }
//      }
//      printer.close();
//    }
//    catch(FileNotFoundException e){
//      System.out.println("The file was not found."); 
//    }
//  }
//  /**
//   * The size of the map.
//   * 
//   */
//  public int size()
//  {
//    int size = 0;
//    Set<String> authors = library.keySet();
//    for(String author : authors)
//    {
//      Set<String> titles = library.get(author).keySet();
//      for(String title : titles)
//        size++;
//    }
//    return size;
//  }
//  
//  /**
//   * gets an iterator for the authors
//   * 
//   * @return the iterator
//   */
//  public Iterator<String> authorIterator()
//  {
//    return this.library.keySet().iterator();
//  }
//  /**
//   * gets an iterator for the titles.
//   * 
//   */
//  public Iterator<String> titleIterator(String author)
//  {
//    HashMap<String,BookDescription> inner = library.get(author);
//    return inner.keySet().iterator();
//  }
//  /**
//   * Prints the authors out.
//   * 
//   * 
//   */
//  public void theAuthors(){
//    Iterator<String> authors = authorIterator();
//    while(authors.hasNext())
//    {
//      System.out.print(authors.next());
//      if(authors.hasNext())
//        System.out.print(" - ");
//    }
//  }
//  
//  /**
//   * Prints the titles for a specific author.
//   * 
//   */
//  public void specificAuthor(String author)
//  {
//    HashMap<String,BookDescription> inner = library.get(author);
//    Iterator<String> titles = titleIterator(author);
//    while(titles != null && titles.hasNext())
//    {
//      System.out.println(inner.get(titles.next()));
//    }
//  }
//  
//  /**
//   * Prints the authors and the books
//   */
//  public void authorsAndBooks()
//  {
//    Iterator<String> authors = authorIterator();
//    while(authors.hasNext())
//    {
//      String author = authors.next();
//      HashMap<String,BookDescription> inner = library.get(author);
//      Iterator<String> iter = inner.keySet().iterator();
//      System.out.print(author + ": ");
//      while(iter.hasNext())
//      {
//        System.out.print(iter.next());
//        if(iter.hasNext())
//          System.out.print(" - ");
//      }
//      System.out.println();
//    }
//  }
//  
//  
//  
//  
//  
//  
//  
//  
//  
//  
//  
//  
//// put in appropriate methods
  
}
