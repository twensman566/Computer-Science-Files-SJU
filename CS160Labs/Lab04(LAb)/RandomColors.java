// Color
import java.awt.Color;

// MouseEvent
import java.awt.event.MouseEvent;

// GLine
import acm.graphics.GLine;

// GraphicsProgram
import acm.program.GraphicsProgram;


/**
 * *** PUT IN YOUR DESCRIPTION OF THIS PROGRAM ***
 *
 * @author <your name>, based on a template by Lynn Ziegler
 */
public class RandomColors extends GraphicsProgram
{
  // constant variable for default color (used to initialize)
  private static final Color DEFAULT_COLOR = Color.GREEN;

  // x- and y-coordinate of last mouse event
  private double lastX, lastY;
  // current color of line to be drawn
  private Color currentColor;


  /**
   *  Entry point for ACM Program -- this is where the program will start --
   *  setup action listeners and default values.
   */
  public void init()
  {
    // set up mouse action functionality
    this.addMouseListeners();

    // set current color to GREEN
    this.currentColor = Color.GREEN;
  }


  /**
   * Remember where the mouse was when you first pressed the left mouse button
   *
   * @param e Information about the mouse pressed event (including its location)
   */
  public void mousePressed(MouseEvent e)
  {
    // capture the location of this mouse press event
    this.lastX = e.getX();
    this.lastY = e.getY();
  }


  /**
   * Scribbles with the currently set color as long as you continue to hold the
   * left mouse button down.
   *
   * @param e Information about the mouse dragged event (including its location)
   */
  public void mouseDragged(MouseEvent e)
  {
    /* create a new line segment (GLine object) from the location of the last
     * mouse event to the location of this mouse event */
    GLine lineSegment = new GLine(lastX, lastY, e.getX(), e.getY());

    // set the color of the newly created line segment
    lineSegment.setColor(currentColor);

    // add the newly created line segment to the canvas
    this.add(lineSegment);

    // capture the location of this mouse event
    this.lastX = e.getX();
    this.lastY = e.getY();
  }


  /**
   * Change colors to a randomly chosen color among RED, GREEN, BLUE, BLACK, or
   * YELLOW.
   *
   * @param e Information about the mouse released event (including its location)
   */
  public void mouseReleased(MouseEvent e)
  {
    //*** Fill in the code to change the current color 
  }
}
