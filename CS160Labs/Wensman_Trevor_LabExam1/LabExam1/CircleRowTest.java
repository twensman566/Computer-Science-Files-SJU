// Color
import java.awt.Color;

// GraphicsProgram
import acm.program.GraphicsProgram;


/**
 * A program to test the circleRow class
 */
public class CircleRowTest extends GraphicsProgram
{
  // Test parameters--change to vary the test
  private static final int    N       = 6;
  private static final double X       = 20.0;
  private static final double Y       = 40.0;
  private static final double SIZE    = 20.0;
  private static final double SPACING = 5.0;
  private static final Color  COLOR   = Color.GREEN;


  /**
   * Create a new CircleRow with privately specified parameters
   */
  public void init()
  {
    CircleRow circleRow = new CircleRow(N, SIZE, SPACING, COLOR);
    
    this.add(circleRow, X, Y);
  }
}
