// File: HalsEye.java

// Color
import java.awt.*;

// GOval
import acm.graphics.*;


/**
 * A GCompound subclass to create Hal's eye (a red circle with a white dot in
 * the center)
 */
public class HalsEye extends GCompound
{
  // Ratio of the center diameter to the overall diameter when contracted
  // When dilated, the center has a diameter ratio of 1.0 - CENTER_RATIO
  private static final double CENTER_RATIO = 0.2;
  
  // Default location of the eye
  private static final double DEFAULT_X = 0.0;
  private static final double DEFAULT_Y = 0.0;
  
  
  // private instance variables
  private GOval outerEye;
  private GOval innerEye;
  private double x;    // will store the x coordinate of the outerEye
  private double y;    // ...            y
  private double size; // ...           size
  
  
  /**
   * Create and initialize the HalsEye object.
   *
   * @param size the diameter of the outer eye
   */
  public HalsEye (double size)
  {
    this.x    = DEFAULT_X;
    this.y    = DEFAULT_Y;
    this.size = size;
    
    this.outerEye = new GOval(size, size);
    this.outerEye.setColor(new Color(159, 0, 0));
    this.outerEye.setFilled(true);
    
    double inSize = size * CENTER_RATIO;
    double offset = (size - inSize) / 2.0;
    this.innerEye = new GOval(inSize, inSize);
    this.innerEye.setColor(Color.WHITE);
    this.innerEye.setFilled(true);
    
    this.add(this.outerEye, this.x, this.y);
    this.add(this.innerEye, this.x + offset, this.y + offset); // must come after adding outerEye
  }
  
  
  /**
   * Cause the program to pause for a desired number of milliseconds.
   *
   * @param millies the number of milliseconds to pause for
   */
  private void pause(long millis)
  {
    try
    {
      Thread.sleep(millis);
    }
    catch (InterruptedException e)
    {
      // do nothing
    }
  }
  
  
  /**
   * Cause the inner eye to dilate (get bigger). Simply increase the size of the
   * inner eye, but be sure it stays centered in the outer eye.
   */
  private void dilate()
  {
    //***Your code goes here
    innerEye.scale(6);
  }
  
  
  /**
   * Cause the inner eye to contract (back to its starting size). Simply
   * decrease the size of the inner eye, but be sure it stays centered in the
   * outer eye.
   */
  private void contract()
  {
    //***Your code goes here
    innerEye.Scale(6);
  }
  
  
  /**
   * Cause the inner eye to dilate or contract every two seconds for the
   * specified number of times.
   *
   * @param count      the number of times to dilate and contract
   */
  public void fluctuate(int count)
  {
    int count2 = 0;
    //***Your code goes here. Do a loop count/2 times. Each time
    //   through the loop dilate, pause, contract pause.
    while(count>0)
    {
      if (count%2 == 0)
      {
        if(count2%2 ==0);
        {
          dilate();
        }
        if(count2%2 == 1);
        {
          contract();
        }
      }
      
      else
      {
      }
      count -=1;
    }
  }
}
