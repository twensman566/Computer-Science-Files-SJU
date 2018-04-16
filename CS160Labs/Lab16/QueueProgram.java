// Color
import java.awt.Color;

// MouseEvent
import java.awt.event.MouseEvent;

// ArrayList
import java.util.*;

// GraphicsProgram
import acm.program.GraphicsProgram;

// GLabel, GRoundRect
import acm.graphics.*;


/**
 * Program that adds labels to the canvas when a button is clicked.
 */
public class QueueProgram extends GraphicsProgram
{
  private static final double ADD_X   = 100;
  private static final double ADD_Y   = 200;
  private static final int BOX_WIDTH  = 125;
  private static final int BOX_HEIGHT = 50;
  
  private Queue<GLabel> labelList;
  private GRoundRect box,box2;
  private int max,num=0;
  
  
  /**
   * Initialize by adding one GRoundRect object to the canvas.
   */
  public void init()
  {
    this.max = 3;
    
    this.labelList = new LinkedList<GLabel>();
    this.box       = new GRoundRect(ADD_X, ADD_Y, BOX_WIDTH, BOX_HEIGHT);
    
    this.box.setColor(Color.YELLOW);
    this.box.setFilled(true);
    
    this.add(this.box);
    this.add(new GLabel("Add Client", ADD_X + 30, ADD_Y + 30));
    
    this.box2       = new GRoundRect(ADD_X+200, ADD_Y, BOX_WIDTH, BOX_HEIGHT);
    
    this.box2.setColor(Color.GREEN);
    this.box2.setFilled(true);
    
    this.add(this.box2);
    this.add(new GLabel("Serve Client", ADD_X + 230, ADD_Y + 30));
    
    
    
    this.addMouseListeners();
  }
  
  
  public void mouseClicked(MouseEvent e)
  {
    if (this.box.contains(e.getX(), e.getY()))
    {
      this.add();
    }
    if (this.box2.contains(e.getX(), e.getY()))
    {
      this.serve();
    }
  }
  
  
  private void add()
  {
    if (this.labelList.size() < this.max)
    {
      GLabel newLabel = new GLabel(this.readLine("Enter a name: "));
      
      this.add(newLabel, ADD_X + BOX_WIDTH + 30,  (ADD_Y + (this.labelList.size() % 3) * 30));
      
      this.labelList.add(newLabel);
    }
    else
    {
      this.println("Too many names.");
      
      for (GLabel label: this.labelList)
      {
        label.move(0, -90);
        
      }
      
      this.max += 3;
    }
  }
  
  private void serve() 
  {
    
    if(this.labelList.isEmpty())
    {
     System.out.println("There is no one to serve.");
    }
    else{
      this.remove(labelList.peek());
      
      for(GLabel label: this.labelList)
     {
        
        
        label.move(0,-30);
       
     }
      System.out.println(labelList.remove().getLabel() + " has been served.");
     
    }
    
  }
}
