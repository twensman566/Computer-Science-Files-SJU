// GraphicsProgram
import acm.program.GraphicsProgram;


/**
 * Program that makes a Tower with five disks and displays it. This program is
 * purely a test program to see if your Tower class is being //constructed//
 * correctly.
 */
public class TowerTest extends GraphicsProgram
{
  public static void main(String [] args)
  {
    new TowerTest().start();
  }


  public void init()
  {
    // create a new Tower object and add it to the canvas
    this.add(new Tower(5, 5), 10.0, 10.0);
  }
}
