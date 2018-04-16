// Color
import java.awt.Color;

// GObject, GOval
import acm.graphics.*;


/**
 * Class that displays a bullseye -- does not belong to any particular canvas
 * 
 * @author <your name> based on a template by the CSB|SJU Computer Science faculty
 */
public class Bullseye extends GCompound
{
  // space between two consecutive rings
  private final double RING_SPACE = 20;
  // total number of desired rings
  private final int NUMBER_OF_RINGS = 6;
  // diameter of outermost ring
  private final int LARGEST_RING = 120;
  
  private GOval circle;
  
  
  /**
   * Construct a new Bullseye
   */
  public Bullseye()
  {
    double SPACE =120;
    double x = 0;
    double y = 0;
    double counter = 0;
    //*** Your code here
    for (counter=0;counter <6; counter++)
    {
      this.circle = new GOval(SPACE,SPACE);
      this.add(this.circle,x,y);
      x=x+10;
      y=y+10;
      SPACE = SPACE - 20;
      if (counter%2 == 0)
      {
        this.circle.setColor(Color.RED);        
      }
      else
      {
        this.circle.setColor(Color.BLACK);
      }
      
      this.circle.setFilled(true);
    }
  }
  
  
  
  // *** not a program -- no main() needed ***
}
