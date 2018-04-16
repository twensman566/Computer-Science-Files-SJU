// Color
import java.awt.Color;

// GCompound, GRect
import acm.graphics.*;


/**
 * Tower is the class that creates a Towers of Hanoi tower with a specified
 * number of disks in a specified location.
 *
 * @author  J. Andrew Holey, based on a class by Lynn R. Ziegler
 * @version October 11, 2011
 */
public class Tower extends GCompound
{
  // The height of each disk
  private static final double DISK_HEIGHT = 10.0;

  // The width of the topmost disk
  private static final double TOP_WIDTH = 50.0;

  // The width of the spindle
  private static final double SPINDLE_WIDTH = 10.0;

  // The difference in width between adjacent disks
  private static final double DELTA_WIDTH = 16.0;

  // The spacing between disks
  private static final double DISK_SPACING = 5.0;

  // The color of the disks
  private static final Color DISK_COLOR = Color.BLUE;


  // A visual representation of the base of the tower
  private GRect base;

  /* A reference to the top disk on the tower, it will be null if there are no
   * disks on the tower. */
  private TowerDisk topDisk;


  /**
   * The constructor -- it will create a tower which can hold up to capacity
   * disks; a tower consists of a base, a spindle, and numberOfDisks disks.
   *
   * @param capacity      total number of disks that the tower can hold
   * @param numberOfDisks number of disks to be drawn at time of creation
   */
  public Tower(int capacity, int numberOfDisks)
  {
    // draw and place the base
    double baseWidth = TOP_WIDTH + (DELTA_WIDTH * capacity);
    double baseX     = 0;
    double baseY     = (DISK_HEIGHT + DISK_SPACING) * capacity + DISK_SPACING;

    this.base = new GRect(baseWidth, DISK_HEIGHT);
    this.add(this.base, baseX, baseY);

    // draw and place the spindle
    double spindleHeight = (DISK_HEIGHT + DISK_SPACING) * capacity + DISK_SPACING;
    double spindleX      = baseX + baseWidth / 2.0 - SPINDLE_WIDTH / 2.0;
    double spindleY      = 0;

    this.add(new GRect(SPINDLE_WIDTH, spindleHeight), spindleX, spindleY);

    /* draw and place the top disk -- this disk will recursively draw and place
     * the remaining disks */
    if (numberOfDisks > 0)
    {
      this.topDisk = new TowerDisk(TOP_WIDTH, DISK_HEIGHT, DELTA_WIDTH, DISK_SPACING, DISK_COLOR, numberOfDisks, 0);

      double diskX  = (capacity * DELTA_WIDTH) / 2.0;
      double diskY  = DISK_SPACING;

      this.add(this.topDisk, diskX, diskY);
    }
  }


  /**
   * Adds disk to the top of this tower
   *
   * @param disk the disk to be added
   */
  public void addDisk(TowerDisk disk)
  {
    double x, y;

    /* If the current top disk is null, then you can draw disk directly above
     * the base, otherwise, draw it above the current top disk. If the current
     * top disk is not null, then before adding disk to this, you should remove
     * it from this and add it to disk. Finally you should update the reference
     * to the top disk, i.e., this.topDisk to refer to disk. */
    if (this.topDisk == null)
    {
      double deltaX = (this.base.getWidth() - disk.getWidth()) / 2.0;
      double deltaY = DISK_HEIGHT + DISK_SPACING;

      x = this.base.getX() + deltaX;
      y = this.base.getY() - deltaY;
    }
    else
    {
      double deltaX = (this.topDisk.getWidth() - disk.getWidth()) / 2.0;
      double deltaY = DISK_HEIGHT + DISK_SPACING;

      x = this.topDisk.getX() + deltaX;
      y = this.topDisk.getY() - deltaY;

      this.remove(this.topDisk);

      disk.addNextDisk(this.topDisk, -deltaX, deltaY);
    }

    this.add(disk, x, y);

    this.topDisk = disk;
  }


  /**
   * Removes the top disk from this Tower and returns that disk.
   *
   * @return the disk top disk before this method was called
   */
  public TowerDisk removeDisk()
  {
    /* Get the current top disk. Set the new top disk, to the current top disk's
     * next disk. If the new top disk is not null, then you should add it to
     * this tower, in the correct location. That location can be specified
     * relative to the current top disk. Finally you should remove the current
     * top disk. */

    // get the current top disk and call it disk
    TowerDisk disk = this.topDisk;

    // get the next disk after the top
    this.topDisk = disk.removeNextDisk();

    // re-add the new top disk
    if (this.topDisk != null)
    {
      double deltaX = (this.topDisk.getWidth() - disk.getWidth()) / 2.0;
      double deltaY = DISK_HEIGHT + DISK_SPACING;

      double x = disk.getX() - deltaX;
      double y = disk.getY() + deltaY;

      this.add(this.topDisk, x, y);
    }

    // remove disk from this tower
    this.remove(disk);

    // return the disk
    return disk;
  }
}
