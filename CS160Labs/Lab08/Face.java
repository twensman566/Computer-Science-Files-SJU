/**
 * A simple interface for manipulating graphical faces.
 *
 * @author  J. Andrew Holey
 * @version 2011/09/20
 */
public interface Face
{
  /**
   * Move this face by dx in x direction and dy in y direction
   *
   * Note: GCompound, which will be the base class for faces already implements
   * the move() method
   *
   * @param dx the distance to move in the horizontal direction
   * @param dy the distance to move in the vertical direction
   */
  public void move(double dx, double dy);


  /**
   * Determine whether the point (x, y) is contained in this face
   *
   * Note: GCompound, which will be the base class for faces already implements
   * the contains() method
   *
   * @param x the x-coordinate of the point to test
   * @param y the y-coordinate of the point to test
   */
  public boolean contains(double x, double y);


  /**
   * Make this face smile
   */
  public void smile();


  /**
   * Make this face frown
   */
  public void frown();


  /**
   * Make this face neutral (neither smiling nor frowning)
   */
  public void neutral();


  /**
   * Make this face close its eyes
   */
  public void closeEyes();


  /**
   * Make this face open its eyes
   */
  public void openEyes();
}
