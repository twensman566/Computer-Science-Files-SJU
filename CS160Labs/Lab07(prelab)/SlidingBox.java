// Animator
import acm.util.Animator;

// GCanvas, GRect
import acm.graphics.*;


/**
 * A box that slides across a supplied canvas
 */
public class SlidingBox extends Animator
{
  // constant variables
  private static final double BOX_SIZE   = 20;
  private static final double DELAY_TIME = 33;
  private static final double X_SPEED    =  4;

  // instance variables
  private GCanvas canvas;
  private GRect box;


  /**
   * Constructor for a SlidingBox
   *
   * @param x       the x-coordinate of the box's initial position
   * @param y       the y-coordinate of the box's initial position
   * @param canvas  the canvas to draw the box on
   */
  public SlidingBox(double x, double y, GCanvas canvas)
  {
    // ***create the box and add it to the canvas***
  }
  

  /**
   * This box slides across the canvas
   */
  public void run()
  {
    // ***Move the box across the screen using a while loop.
    // ***Stop the box when its right edge gets near the right side
    // ***of the drawing area of the canvas.
    // ***Use getWidth() to determine that right side.
  }
}
