// GraphicsProgram
import acm.program.GraphicsProgram;


/**
 * Class to place a Bullseye on a canvas
 * 
 * @author <your name> based on a template by the CSB|SJU Computer Science faculty
 */
public class BullseyePlacer extends GraphicsProgram
{
  // default location of the Bullseye
  private static final double DEFAULT_X = 140;
  private static final double DEFAULT_Y = 110;
  
  
  /**
   * Entry point for ACM Program -- this is where the program will start --
   * create a new set of Bullseyes on the canvas.
   */
  public void init()
  {
    Bullseye bullseye = new Bullseye();

    this.add(bullseye, DEFAULT_X, DEFAULT_Y);
  } 
}
