// Color
import java.awt.Color;

// GOval, GPoint
import acm.graphics.*;


/**
 * This class implements a head segment for a segmented worm.
 *
 * @author  <your name> and J. Andrew Holey, including elements designed by Lynn Ziegler
 * @version 2011/10/07
 */
public class HeadSegment extends WormSegment
{
  private static final double EYE_SIZE = 2.0;
  //!!! In poor form, the X and Y coordinates are hard-coded, primarily to keep
  //    the code /relatively/ simple to understand
  private static final double EYE1_X   = 10.0;
  private static final double EYE1_Y   = 16.0;
  private static final double EYE2_X   = EYE1_X;
  private static final double EYE2_Y   = 24.0;
  private static final double ORIG_X   = 20.0;
  private static final double ORIG_Y   = 20.0;
  private GOval eye1, eye2;

  /**
   * Construct a new HeadSegment with the specified color and construct
   * numWormSegments - 1 more body segments after it.
   *
   * @param segmentColor    The color of this segment
   * @param numWormSegments The number of worm segments, including this one
   */
  public HeadSegment(Color color, int numSegments, double angle)
  {
    //*** Call the constructor method from the super class to create the body
    //*** segment which will become the head.
    super(color,numSegments,angle);
    //*** Make the two eyes and add them to this HeadSegment.
    this.eye1 = new GOval(EYE1_X,EYE1_Y,EYE_SIZE,EYE_SIZE);
    this.eye2 = new GOval(EYE2_X,EYE2_Y,EYE_SIZE,EYE_SIZE);
    this.add(this.eye1,this.rotateXY(EYE1_X,EYE1_Y,angle));
    this.add(this.eye2,this.rotateXY(EYE2_X,EYE2_Y,angle));
    
  }


  /**
   * Create a new point that is the result of rotating a given point, angle
   * degrees around a pre-defined origin.
   *
   * @param ptX   x-coordinate of the point being rotated
   * @param ptY   y-coordinate of the point being rotated
   * @param angle angle in degrees around the pre-defined origin to rotate the
   *              input point
   *
   * @return a new GPoint which is the result of point (ptX,ptY) being rotated
   *         angle degrees around a pre-defined point.
   */
  private GPoint rotateXY(double ptX, double ptY, double angle)
  {
    // Convert angle to radians
    double theta = Math.toRadians(angle);

    // Pre-compute cosine and sin of angle
    double cos = Math.cos(theta);
    double sin = Math.sin(theta);

    // Compute points rotated angle degrees around a hard-coded origin
    double x = (cos * (ptX - ORIG_X) - sin * (ptY - ORIG_Y)) + ORIG_X;
    double y = (sin * (ptX - ORIG_X) + cos * (ptY - ORIG_Y)) + ORIG_Y;

    // Create new GPoint with computed x and y coordinates
    return new GPoint(x, y);
  }
}
