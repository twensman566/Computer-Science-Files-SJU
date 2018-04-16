import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import acm.gui.*;
import java.lang.*;
import acm.graphics.*;
/*This creates a typing game where you have to select difficulty and then select start and then type in the correct
 * word that is scrolling across the screen.
 * 
 * 
 * 
 * 
 */
public class GUIGame extends JFrame implements ActionListener, FocusListener, KeyListener
{
  private JButton start, exit, easy,medium,hard;
  private Container game, lower;
  private JTextField typeWords;
  private IntField score, strikes;
  private int strikeNum = 0, scoreNum = 0;
  private JPanel panel1, panel2, panel3, panel4;
  private GCanvas canvas;
  public String textFile;
  public int PAUSE = 50;
  private double speed;
  private RandomWord word;
  private String theWord;
  private BannerMover banner;
  
  /*This is a constuctor that makes the GUI for the game.
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   */
  public GUIGame()
  {
    score = new IntField(scoreNum);
    strikes = new IntField(strikeNum);
    score.setEditable(false);
    strikes.setEditable(false);
    
    panel1 = new JPanel();
    panel1.setLayout(new GridLayout(3, 1));
    panel1.add(new JLabel("Score"));
    panel1.add(score);
    panel1.add(new JLabel("Strikes"));
    panel1.add(strikes);
    
    canvas = new GCanvas();
    
    typeWords = new JTextField();
    typeWords.addFocusListener(this);
    typeWords.setHorizontalAlignment(JTextField.RIGHT);
    panel2 = new JPanel();
    panel2.setLayout(new GridLayout(1,2));
    panel2.add(new JLabel("Type Words-->"));
    panel2.add(typeWords);
    
    panel3 = new JPanel();
    panel3.setLayout(new GridLayout(1,3));
    easy = new JButton("Easy");
    medium = new JButton("Medium");                   
    hard = new JButton("Hard");
    
    panel3.add(easy);
    panel3.add(medium);
    panel3.add(hard);
    
    
    panel4 = new JPanel();
    panel4.setLayout(new GridLayout(1,2));
    exit = new JButton("Exit");
    start = new JButton("Start");
    panel4.add(start);
    panel4.add(exit);
    
    
    
    
    
    
    
    //creates the container
    game = this.getContentPane();
    lower = this.getContentPane();
    
    //add the canvas/panels
    game.add(panel1, BorderLayout.NORTH);
    game.add(panel2, BorderLayout.SOUTH);
    game.add(panel3, BorderLayout.EAST);
    game.add(panel4, BorderLayout.WEST);
    game.add(canvas);
    
    
    
    
    
    
    this.setSize(900,600);
    this.setVisible(true);
    
    exit.addActionListener(this);
    start.addActionListener(this);
    hard.addActionListener(this);
    easy.addActionListener(this);
    medium.addActionListener(this);
    typeWords.addKeyListener(this);
    
  }   
  /*This method listens for the JButtons to be pushed.
   * 
   * @param evt is the button that was pushed.
   * 
   */
  public void actionPerformed(ActionEvent evt)
  {
    Object source = evt.getSource();   
    //System.out.println(textFile);
    
    if(source == easy)
    {
      textFile = "smallWords.txt";
      speed = 10.0;
    }
    else if(source == medium)       
    {
      textFile = "mediumWords.txt";
      speed = 20.0;
    }
    else if(source == hard)
    {
      textFile = "largeWords.txt";
      speed = 30.0;
    }
    else if(source == start && textFile != null)
    {
      
      this.word = new RandomWord(textFile);
      theWord = this.word.next();
      this.banner = new BannerMover(canvas,theWord, speed);
      banner.start();
      
      
    }
    else if(source == exit)
    {
      System.exit(0);
    }
    else
    {
      System.out.println("You did not pick a difficulty, please select a difficulty!"); 
    }
  }
  /* Returns a random word.
   * 
   * @return theWord a random word.
   */
  public String theNewWord()
  {
    this.word = new RandomWord(textFile);
    theWord = this.word.next();
    return theWord;
  }
  /*Listen for a key to be pressed.
   * @param e a KeyEvent
   * 
   */
  public void keyPressed(KeyEvent e) 
  {
    int key = e.getKeyCode();
    if(key == 10)
    {
      String text = typeWords.getText();
      System.out.println("bye");
      if(text.equals(theWord))
      {
        score.setValue(++scoreNum);
        this.banner.remove();
        theWord = this.word.next();
        this.banner = new BannerMover(canvas,theWord, speed);
        this.banner.start();
        typeWords.setText("");
      }
      else if(theWord != null)
      {
       strikes.setValue(++strikeNum);
       this.banner.remove();
       theWord = this.word.next();
       this.banner = new BannerMover(canvas, theWord, speed);
       this.banner.start();
       typeWords.setText("");
      }
    }
  }
  
  /*
   * 
   */

  
  
  
  
  
  public void keyReleased(KeyEvent e){}
  
  public void keyTyped(KeyEvent e){}
  
  public void focusLost(FocusEvent firstEvent){}
  
  
  public void focusGained(FocusEvent e){}
  
  /*Main method used to start the program.
   * @param args User passed arguments.
   */
  public static void main(String [] args) 
  {
    new GUIGame();
    
  }
}