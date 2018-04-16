// Color
import java.awt.Color;

// GCompound, GRect
import acm.graphics.*;


/**
 * Class that displays a row of colored boxes
 * 
 * @author  J. Andrew Whitford Holey
 * @version November 13, 2013
 */
public class SquareBoxes extends GCompound
{
  // The size of a box
  private static final int   DEFAULT_SIZE    = 30;
  // The horizontal distance (center to center) between boxes
  private static final int   DEFAULT_SPACING = 10;
  // The default color of a box
  private static final Color DEFAULT_COLOR   = Color.RED;
  
  // array instance variable to hold the boxes
  private GRect [] boxes;
 

  /**
   * Construct a new SquareBoxes object with numBoxes boxes
   *
   * @param numBoxes the number of boxes in the row
   */
  public SquareBoxes(int numBoxes)
  {
    double xBoxSpot = 0;

    this.boxes = new GRect[numBoxes];

    for (int i = 0; i < numBoxes; i++)
    {
      this.boxes[i] = new GRect(xBoxSpot, 0, DEFAULT_SIZE, DEFAULT_SIZE);

      this.boxes[i].setColor(DEFAULT_COLOR);

      this.boxes[i].setFilled(true);

      this.add(this.boxes[i]);

      xBoxSpot += (DEFAULT_SIZE + DEFAULT_SPACING);
    }
  }


  /**
   * Set color of desired box.
   *
   * @param boxNum the internal number for the box to change the color of
   * @param color  the color to change the box to
   */
  public void setColor(int boxNum, Color color)
  {
    if (this.isValidNum(boxNum) == true)
    {
      this.boxes[boxNum].setColor(color);
    }
  }


  /**
   * Check if a box number is valid wrt the boxes array.
   *
   * @param boxNum the box number to check
   *
   * @return true if boxNum is valid, false otherwise
   */
  private boolean isValidNum(int boxNum)
  {
    return (boxNum >= 0 && boxNum < this.boxes.length);
  }
}
