// Color
import java.awt.Color;

// GCompound, GRect
import acm.graphics.*;


/**
 * TowerDisk is the class that creates a rectangle to represent a disk from the
 * Towers of Hanoi game. A TowerDisk is a recursive structure in that it
 * contains a reference to the next disk below it, if such a disk exists.
 */
public class TowerDisk extends GCompound
{
  // The visual representation of the disk
  private GRect disk;
  
  // The next disk (structural recursion)
  private TowerDisk nextDisk;
  
  
  /**
   * Makes a new TowerDisk at the specified coordinates, with the specified
   * width, height, and color.
   *
   * If count is less than numberOfDisks - 1, then it makes a new TowerDisk of
   * the same color and height, but with a width of width + deltaWidth. It adds
   * this next disk -(deltaWidth / 2.0) to the left and height + diskSpacing
   * below this disk.
   *
   * @param width       the width of this disk
   * @param height      the height of this disk
   * @param deltaWidth  the difference in width between this disk and the next
   * @param diskSpacing the amount of vertical space between disks
   * @param color       the color of this disk
   * @param capacity    the capacity (i.e. number of disks) in the associated tower
   * @param numberAbove the number of disks above this disk
   */
  public TowerDisk(double width, double height, double deltaWidth, double diskSpacing, Color color, int capacity, int numberAbove)
  {
    this.disk = new GRect(width+deltaWidth, height);
    this.disk.setColor(Color.BLUE);
    this.disk.setFilled(true);
    this.add(this.disk,-(deltaWidth/2.0)+8,height);
    //*** Complete this method
    if( numberAbove < capacity-1)
    {
      this.nextDisk = new TowerDisk(width + deltaWidth, height, deltaWidth, diskSpacing, color, capacity, numberAbove+1);
      
      this.add(this.nextDisk,-(deltaWidth/2.0)+8,height+diskSpacing);
    }
  }
  
  
  /**
   * Return the width of this TowerDisk
   *
   * @return the width of the TowerDisk
   */
  public double getWidth()
  {
    return this.disk.getWidth();
  }
  
  
  /**
   * Return the value of the nextDisk private instance variable and remove the
   * reference to the next disk from this object.
   *
   * @return the next disk after this one
   */
  public TowerDisk removeNextDisk()
  {
    //*** Complete this method
    TowerDisk nextD = this.nextDisk;
    this.nextDisk = null;
    if (nextD != null)
    {
      this.remove(nextD); 
    }
    return nextD;
  }
  
  
  /**
   * Set the value of the nextDisk private instance variable and add a reference
   * to it to this object.
   *
   * @param nextDisk the value which is assigned to the nextDisk private
   *                 instance variable
   * @param deltaX   the difference in x coordinates between this disk and
   *                 nextDisk
   * @param deltaY   the difference in y coordinates between this disk and
   *                 nextDisk
   */
  public void addNextDisk(TowerDisk nextDisk2, double deltaX, double deltaY)
  {
    //*** Complete this method
    this.nextDisk = nextDisk2;
    this.add(nextDisk2,deltaX,deltaY);
    
  }
}
