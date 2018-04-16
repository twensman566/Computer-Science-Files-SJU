// Color
import java.awt.Color;

// GraphicsProgram
import acm.program.GraphicsProgram;


/**
 * Animator class that moves a Worm object around a circle of the specified
 * radius.
 */
public class WormTester extends GraphicsProgram
{
  private static final int    ANIMATION_CT = 200;
  private static final double DELTA_THETA  = 0.125;
  private static final double RADIUS       = 200.0;
  private static final double INIT_X       = 600.0;
  private static final double INIT_Y       = 240.0;
  private static final int    NUM_SEGMENTS = 8;

  private int colorNum = 0;
  private HeadSegment segmentedWorm;


  public void init()
  {
    this.segmentedWorm = new HeadSegment(Color.RED, NUM_SEGMENTS, 10);

    this.add(this.segmentedWorm, INIT_X, INIT_Y);
  }


  public void run()
  {
    double theta   = 0.0;
    double oldRelX = RADIUS;
    double oldRelY = 0.0;

    for (int i = 0; i < ANIMATION_CT; i++)
    {
      this.pause(200.0);

      theta = theta + DELTA_THETA;
      while (theta >= 2.0 * Math.PI)
      {
        theta = theta - 2.0 * Math.PI;
      }

      double newRelX = RADIUS * Math.cos(theta);
      double newRelY = RADIUS * Math.sin(theta);

      this.segmentedWorm.move(newRelX - oldRelX, newRelY - oldRelY);
      this.segmentedWorm.setColor(this.getNextColor());

      oldRelX = newRelX;
      oldRelY = newRelY;
    }
  }


  /*
   * Utility method to cycle through the six rgb primary colors (other than
   * white and black).
   */
  private Color getNextColor()
  {
    Color nextColor;

    switch (this.colorNum)
    {
      case 0:
      nextColor = Color.MAGENTA;
      break;

      case 1:
      nextColor = Color.BLUE;
      break;

      case 2:
      nextColor = Color.CYAN;
      break;

      case 3:
      nextColor = Color.GREEN;
      break;

      case 4:
      nextColor = Color.YELLOW;
      break;

      default:
      nextColor = Color.RED;
      break;
    }

    this.colorNum = (this.colorNum + 1) % 6;

    return nextColor;
  }
}
