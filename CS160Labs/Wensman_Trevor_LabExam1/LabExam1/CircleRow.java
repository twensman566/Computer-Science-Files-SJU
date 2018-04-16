// Color
import java.awt.Color;

// GCanvas, GOval
import acm.graphics.*;


/**
 * A GCompound subclass that represents a horizontal row of circles
 */
public class CircleRow extends GCompound
{
  /**
   * Complete the constructor for the CircleRow class to create a horizontal
   * row of n circles with the specified position, size, spacing and color.
   * Don't forget to add each GOval to this so that they become visible.
   *
   * @param n          the number of circles in the row
   * @param size       the diameter of the circles
   * @param spacing    the distance from one circle to the next.
   * @param color      the color of the circles
   */
  private GOval circle;
  private GCanvas canvas;
  public CircleRow(int n, double size, double spacing, Color color)
  {
    //*** >>>>> Your code goes here
    int count = 0;
    while(n > 0)
    {
      this.circle = new GOval(size,size);
      this.circle.setColor(color);
      this.circle.setFilled(true);
      this.add(this.circle,count +size+spacing,0);
      n -=1;
      count += size + spacing;
    }
  }
}
