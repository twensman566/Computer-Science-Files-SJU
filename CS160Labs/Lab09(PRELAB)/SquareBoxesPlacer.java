// Color
import java.awt.Color;

// MouseEvent
import java.awt.event.MouseEvent;

// GraphicsProgram
import acm.program.GraphicsProgram;


/**
 * Class to place a set of boxes on a canvas
 * 
 * @author  J. Andrew Whitford Holey
 * @version November 13, 2013
 */
public class SquareBoxesPlacer extends GraphicsProgram
{
  // the number of rows of boxes
  private static final int NUM_BOXES = 5;
   // default location of the boxes
  private static final double DEFAULT_X = 100;
  private static final double DEFAULT_Y = 100;

  // private instance of the SquareBoxes class
  private SquareBoxes squareBoxes;


  /**
   * Create a new set of square boxes on the canvas
   */
  public void init()
  {
    this.addMouseListeners();

    this.squareBoxes = new SquareBoxes(NUM_BOXES);

    this.add(this.squareBoxes, DEFAULT_X, DEFAULT_Y);
  }
 

  /**
   * Re-color a box on each mouse click
   *
   * @param e the event generated by the mouse click
   */
  public void mouseClicked(MouseEvent e)
  {
    int boxNum = readInt("Enter the box to change color: ", 0, NUM_BOXES-1);
    int red    = readInt("Enter the new red value: ", 0, 255);
    int green  = readInt("Enter the new green value: ", 0, 255);
    int blue   = readInt("Enter the new blue value: ", 0, 255);
    this.squareBoxes.setColor(boxNum, new Color(red, green, blue));
  }
 

  /**
   * Create a BoxController and start it
   */
  public static void main(String [] args)
  {
    new SquareBoxesPlacer().start();
  }
}
