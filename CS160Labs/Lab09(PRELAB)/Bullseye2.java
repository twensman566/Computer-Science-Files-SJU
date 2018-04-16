// Color
import java.awt.Color;

// GCompound, GRect
import acm.graphics.*;


/**
 * Class that displays a row of colored boxes
 * 
 * @author  J. Andrew Whitford Holey
 * @version November 13, 2013
 */
public class Bullseye2 extends GCompound
{
  // The size of a box
  private static final int   DEFAULT_SIZE    = 30;
  // The horizontal distance (center to center) between boxes
  private static final int   DEFAULT_SPACING = 10;
  // The default color of a box
  private static final Color DEFAULT_COLOR   = Color.RED;
  private static final Color DEFAULT_COLOR2   = Color.BLACK;
  
  private final double RING_SPACE = 20;
  // total number of desired rings
  //private final int NUMBER_OF_RINGS = 6;
  // diameter of outermost ring
  private final int LARGEST_RING = 200;
  
  // array instance variable to hold the boxes
  private GOval [] boxes;
  
  
  /**
   * Construct a new SquareBoxes object with numBoxes boxes
   *
   * @param numBoxes the number of boxes in the row
   */
  public Bullseye2(int numBoxes)
  {
    double SPACE = 180;
    
    this.boxes = new GOval[numBoxes];
    int COUNT = 0;
    int x = 0;
    int y=0;
    for (int i = 0; i < numBoxes; i++)
    {
      this.boxes[i] = new GOval(SPACE,SPACE);
      if(i%2 == 0)
      {
        this.boxes[i].setColor(DEFAULT_COLOR);
      }
      else
      {
        this.boxes[i].setColor(DEFAULT_COLOR2);
      }
      
      this.boxes[i].setFilled(true);
      
      
      
      SPACE -=20;
      /*if (COUNT%2 == 0)
       {
       this.boxes[i].setColor(Color.RED);      
       }
       else
       {
       this.boxes[i].setColor(Color.BLACK);
       }*/
      
      this.boxes[i].setFilled(true);
      this.add(this.boxes[i],x,y);
      ++COUNT;
      x+=10;
      y+=10;
      
    }
    
  }
  
  
  /**
   * Set color of desired box.
   *
   * @param boxNum the internal number for the box to change the color of
   * @param color  the color to change the box to
   */
  public void setColor(boolean outer, Color color)
  {
    
    if( outer == true)
    {
      for (int i = 0; i<boxes.length; i+=2)
      {
        int startRing = 0; 
      }
    }
    else
    {
      for (int i = 1; i<boxes.length; i+=2)
      {
        int startRing = 1;
      }
    }
    
  }
  
  
  /**
   * Check if a box number is valid wrt the boxes array.
   *
   * @param boxNum the box number to check
   *
   * @return true if boxNum is valid, false otherwise
   */
  private boolean isValidNum(int boxNum)
  {
    return (boxNum >= 0 && boxNum < this.boxes.length);
  }
  
}

