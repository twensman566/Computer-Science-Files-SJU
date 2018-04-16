// Animator
import acm.util.Animator;

// GCanvas
import acm.graphics.GCanvas;


/**
 * A box that slides across a supplied canvas
 */
public class ActiveBox extends Animator
{
  // constant variables
  private static final double DELAY_TIME = 33.0;
  private static final double X_SPEED    = 4.0;

  // instance variables
  private GCanvas canvas;
  private Box box;


  /**
   * Constructor for a ActiveBox
   *
   * @param x       the x-coordinate of the box's initial position
   * @param y       the y-coordinate of the box's initial position
   * @param canvas  the canvas to draw the box on
   */
  public ActiveBox(double x, double y, GCanvas canvas)
  {
    // store reference to canvas for use later
    this.canvas = canvas;

    // create the Box object and store a reference to it
    this.box = new Box();

    // add the newly created Box object to the canvas
    this.cavnas.add(this.box, x, y);
  }


  /**
   * This box slides across the canvas
   */
  public void run()
  {
    // *** Move the box across the screen using a while loop.
    // *** Stop the box when its right edge gets near the right side
    // *** of the drawing area of the canvas.
    // *** Use the getWidth() method to determine that right side.
  }
}
