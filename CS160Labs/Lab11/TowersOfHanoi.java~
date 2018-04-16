// GraphicsProgram
import acm.program.GraphicsProgram;


/**
 * This class does an animation of the Towers of Hanoi game. The purpose of the
 * game is to move all disks from the left tower to the right tower without ever
 * placing a bigger disk on top of a smaller disk.
 * 
 * @author  Lynn R. Ziegler
 * @version Spring, 2011
 */
public class TowersOfHanoi extends GraphicsProgram
{
  // x-coordinate for the left-most tower
  private static final double TOWER_X     = 10.0;

  // y-coordinate for the left-most tower
  private static final double TOWER_Y     = 20.0;

  // spacing between two consecutive towers
  private static final double TOWER_SPACE = 10.0;


  // number of disks per tower
  private int numberOfDisks;

  // pause length in milliseconds between moves for visual effect
  private int delay;

  // the three towers
  private Tower left, middle, right;


  /**
   * Get values from the user, create the three towers, and add them to the
   * canvas.
   */
  public void init()
  {
    this.numberOfDisks = this.readInt("Please enter the number of disks per tower: ");
    this.delay         = this.readInt("Please enter the delay between moves in ms: ");

    double leftX = TOWER_X;
    this.left = new Tower(this.numberOfDisks, this.numberOfDisks);
    this.add(this.left, leftX, TOWER_Y);

    double middleX = leftX + this.left.getWidth() + TOWER_SPACE;
    this.middle = new Tower(this.numberOfDisks, 0);
    this.add(this.middle, middleX, TOWER_Y);

    double rightX = middleX + this.middle.getWidth() + TOWER_SPACE;
    this.right  = new Tower(this.numberOfDisks, 0);
    this.add(this.right, rightX, TOWER_Y);
  }


  /**
   * Starts the animation. Calls the move() method, which recursively moves the
   * disks on the left tower to the right tower using the middle tower as an
   * intermediate.
   */
  public void run()
  {
    // entry point for the recursive move method
    this.move(this.numberOfDisks, this.left, this.middle, this.right);      
  }
 

  /**
   * Moves numberOfDisks disks from the source tower to the destination tower
   * using the intermediate tower to hold disks temporarily.
   *
   * @param numberOfDisks the number of disks to move
   * @param source        the tower to move the disk from
   * @param intermediate  the tower to use for disks in transit
   * @param destination   the tower to move the disk to
   */
  public void move(int numberOfDisks, Tower source, Tower intermediate, Tower destination)
  {
    //*** Complete this method -- put the code for the Towers of Hanoi algorithm here

      /* if there's only one disk to move, move it directly from the source to
       * the destination --- end recursion --- */

      /* otherwise, move the stack of n-1 disks recursively from the source to
       * the intermediate tower, using the destination as an intermediate; move
       * the remaining disk to the destination; and finally move the stack of
       * n-1 disks recursively from the intermediate tower to the destination,
       * using the source as an intermediate. */
  }
 

  /**
   * Moves the top disk from the source tower to the destination tower by
   * removing the top disk from the source tower and then adding that disk to
   * the destination tower.
   *
   * @param source      the tower to move the disk from
   * @param destination the tower to move the disk to
   */
  public void move(Tower source, Tower destination)
  {
    // briefly pause for visual effect
    this.pause(this.delay);

    // Remove the top disk from the source tower and add it to the destination tower
    destination.addDisk(source.removeDisk());
  }
}
