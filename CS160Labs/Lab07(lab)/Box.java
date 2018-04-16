// Color
import java.awt.Color;

// GCompound, GRect
import acm.graphics.*;


/**
 * A box
 */
public class Box extends GCompound
{
  // constant variables
  private static final double BOX_X      = 0;
  private static final double BOX_Y      = 0;
  private static final double BOX_WIDTH  = 40;
  private static final double BOX_HEIGHT = BOX_WIDTH / 2.0:


  // instance variables
  private GRect boxOutline;
  private GRect boxInterior;


  /**
   * Constructor for a Box
   */
  public Box()
  {
    GRect outline = new GRect(BOX_WIDTH, BOX_HEIGHT);
    GRect interior = new GRect(BOX_WIDTH - 2.0, BOX_HEIGHT - 2.0);

    outline.setFilled(true);
    interior.setFilled(true);

    outline.setColor(Color.BLACK);
    interior.setColor(Color.WHITE);

    this.add(outline, BOX_X, BOX_Y);
    this.add(interior, BOX_X + 1.0, BOX_Y + 1.0);
  }
}
