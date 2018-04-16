// GraphicsProgram
import acm.program.*;


/**
 * Class to place a set of pins on a canvas
 * 
 * @author  <your name>
 *          based on a template by the CSB|SJU Computer Science faculty
 * @version <today's date>
 */
public class BowlingPinPlacer extends GraphicsProgram
{
  // default location of the lowest pin
  private final double DEFAULT_X = 100;
  private final double DEFAULT_Y = 200;
  
  
  /**
   * create a new set of Bowling Pins on the canvas
   */ 
  public void init()
  {
    // constructing the object does all the work,
    // nothing more to do
    new BowlingPins(DEFAULT_X, DEFAULT_Y, this.getGCanvas());
  }  
 

  /**
   * main() launches this program.
   */
  public static void main(String [] args)
  {
    new BowlingPinPlacer().start();
  }
}
