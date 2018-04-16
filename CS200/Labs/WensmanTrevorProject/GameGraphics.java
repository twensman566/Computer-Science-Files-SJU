import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;


public class GameGraphics
{
  public GameLayout collection;
  public LocationDescription currentLocation;
  public JLabel labelLoc,imageLabel,healthLabel,damageLabel;
  public JFrame frame;
  
  
  
  
  
  
  public GameGraphics(String fileName1, String fileName2)
  {
    this.collection = new GameLayout(fileName1,fileName2);
    
  }
  
  public void createAndShowGUI()
  {
    
    frame = new JFrame("Our Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addComponentsToPane(frame.getContentPane());
    //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    //frame.setLocationRelativeTo(null);
    //JPanel mainPanel = new JPanel();
    frame.pack();
    frame.setVisible(true);
  }
  
  public void addComponentsToPane(Container pane)
  {
    
    JLabel JLabel1 = new JLabel("Welcome to the Game");
    JLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    pane.add(JLabel1, BorderLayout.PAGE_START);
    JButton button;
    
    
    
    //Make the center component big, since that's the
    //typical usage of BorderLayout.
    
    
    //CENTER
    JPanel JPanel2 = new JPanel();
    JPanel2.setLayout(new BorderLayout(0,0));
//    ImageIcon imageIcon = new ImageIcon("image1.jpg");
//    Image image = imageIcon.getImage();
//    Image newimg = image.getScaledInstance(1000, 750,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//    imageIcon = new ImageIcon(newimg);  // transform it back
    //button.setPreferredSize(new Dimension(200, 100));
    pane.add(JPanel2, BorderLayout.CENTER);
    //imageLabel = new JLabel(Your current);
    //JPanel2.add( imageLabel, BorderLayout.CENTER );
    
    
    
    
    
    
    
    
    
    //LEFT PANEL
    JPanel JPanel3 = new JPanel();
    pane.add(JPanel3, BorderLayout.LINE_START);
    
    
    
    //Current Location
    labelLoc = new JLabel("Current Location is: " + collection.getCurrentLocation() + ".");
    JPanel3.setLayout(new BoxLayout(JPanel3, BoxLayout.Y_AXIS));
    JPanel3.add(labelLoc);
    
    //Health
    healthLabel = new JLabel("Your current health is: " +collection.getPlayerHealth() + ".");
    JPanel3.add(healthLabel);
    
    //Damage
     damageLabel = new JLabel("Your current max damage is: " +collection.getPlayerDamage() + ".");
    JPanel3.add(damageLabel);
    
    
    //BOTTOM PANEL
    JPanel JPanel4 = new JPanel();
    pane.add(JPanel4, BorderLayout.PAGE_END);
    button = new JButton("Load Game");
    button.addActionListener(new ButtonListener());
    JPanel4.add(button, BorderLayout.LINE_END);
    button = new JButton("Save Game");
    JPanel4.add(button, BorderLayout.LINE_START);
    button.addActionListener(new ButtonListener());
    
    
    
    
    //Right Panel
    JPanel JPanel1 = new JPanel();
    JPanel1.setLayout(new BorderLayout(0,0));
    pane.add(JPanel1, BorderLayout.LINE_END);
    //Display Current Location Button
    button = new JButton("Display Current Location \nDescription");
    JPanel1.add(button, BorderLayout.NORTH);
    button.addActionListener(new ButtonListener());
    //Move Button - Right Panel
    button = new JButton("-Move to a new Location-");
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    JPanel1.add(button,BorderLayout.CENTER);
    button.addActionListener(new ButtonListener());
    
    
    //Search Button - Right Panel
    button = new JButton("---Search for an Location---");
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    JPanel1.add(button,BorderLayout.SOUTH);
    button.addActionListener(new ButtonListener());
  }
  
  
  
  
  
  
  public static void main(String[] args)
  {
    GameGraphics graphics = new GameGraphics("Locations","Connections");
    graphics.createAndShowGUI();
  }
  
  class ButtonListener implements ActionListener 
  {
    public JFrame intframe1;
    public JPanel intJPanel1;
    ButtonListener() {
    }
    
    public void actionPerformed(ActionEvent e) {
      Scanner scanner = new Scanner(System.in);
      String input;
      //System.out.println("Here");
      
      if (e.getActionCommand().equals("Load Game")) {
        collection.loadNewGame();
        
        
        labelLoc.setText("Current Location is: " + collection.getCurrentLocation()+ ".");
        healthLabel.setText("Current health is: " + collection.getPlayerHealth()+ "."); 
        
        
      }
      
      else if (e.getActionCommand().equals("Save Game")) {
        String location = JOptionPane.showInputDialog("What do you want to name your game file?");
        String playerinfo = JOptionPane.showInputDialog("What do you want to name your player information file?");
        collection.writeToFile(location);
        collection.writePlayer(playerinfo);
      }
      else if (e.getActionCommand().equals("-Move to a new Location-")) {
        box();
        if(Integer.valueOf(collection.getPlayerHealth()) <= 0)
        {
          frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
          frame.dispose();
          
        }
        if(collection.getCurrentLocation().equals("The End"))
        {
          JOptionPane.showMessageDialog(null, "Congratulations you have beaten the game! It will now quit!");
          frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
          frame.dispose();
          
        }
        healthLabel.setText("Current health is: " + collection.getPlayerHealth()+ "."); 
        damageLabel.setText("Current damage is: " + collection.getPlayerDamage()+ "."); 
        
        
        //input = scanner. nextLine();
        //collection.setCurrentLocation(input);
        //System.out.println(collection.getCurrentLocation());
        
      }
      
      else if (e.getActionCommand().equals("Display Current Location \nDescription")) {
        JOptionPane.showMessageDialog(null, collection.getLocationDescription(collection.getCurrentLocation()));
      }
      
      else if (e.getActionCommand().equals("---Search for an Location---")) {
//        input = scanner. nextLine();
//        System.out.println(collection.search("StartingLocation",input));
        
        String search = JOptionPane.showInputDialog("What do you want to search for?");
        //boolean bool = collection.search(collection.getCurrentLocation(),search);
        boolean bool2 = collection.search("The Beginning",search);
//        if(bool)
//        {
//          JOptionPane.showMessageDialog(null,search + " has yet to be explored, it is coming up soon!");
//        }
        if(bool2)
        {
          JOptionPane.showMessageDialog(null,search + "was found in the game!");
        }
        else
        {
          JOptionPane.showMessageDialog(null,search + "was not found in the game. :(");
        }
        
      }
//      else{
//        Iterator<String> locations = collection.locationIterator();
//        while(locations.hasNext())
//        {
//          String temp = locations.next();
//          if (e.getActionCommand().equals(temp)){
//            collection.setCurrentLocation(temp);
//            labelLoc.setText("Current Location is: " + collection.getCurrentLocation()+ ".");
//          }
//        }
//      }
    }
    
    public void box() {
      Object[] options1 = { "", "",
        "Cancel Move" };
      boolean runAway;
      JPanel panel = new JPanel();
      panel.add(new JLabel("Where do you want to move?"));
      //TextField textField = new JTextField(10);
      //panel.add(textField);
      Set<String> connections = collection.connectionsToLocation(collection.getCurrentLocation());
      Iterator<String> iteratorConnect = connections.iterator();
      int count = 0;
      while(iteratorConnect.hasNext())
      {
        options1[count] = iteratorConnect.next(); 
        count++;
      }
      
      
      if(count > 1)
      {
        int result = JOptionPane.showOptionDialog(null, panel, "Move",
                                                  JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                                                  null, options1, null);
        
        if (result == JOptionPane.YES_OPTION){
          //JOptionPane.showMessageDialog(null, "Location");
          collection.setCurrentLocation((String)options1[0]);
          labelLoc.setText("Current Location is: " + collection.getCurrentLocation()+ ".");
          
        }
        else if(result == JOptionPane.NO_OPTION)
        {
          collection.setCurrentLocation((String)options1[1]);
          labelLoc.setText("Current Location is: " + collection.getCurrentLocation()+ ".");
        }
        else if(result == JOptionPane.CANCEL_OPTION)
        {
          
          
        }
      }
      else{
        int result = JOptionPane.showConfirmDialog(null, "Still want to Move?\n Only Location to move is: " + options1[0], "Move", 
                                                   JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.YES_OPTION){
          collection.setCurrentLocation((String)options1[0]);
          labelLoc.setText("Current Location is: " + collection.getCurrentLocation()+ ".");
        }
        
      }
    }
  }
  
  
}