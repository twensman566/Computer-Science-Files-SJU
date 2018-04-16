// Color
import java.awt.Color;

// GCompound, GOval
import acm.graphics.*;


/**
 * This class implements a segment for a segmented worm. All segments, including
 * the head are WormSegments; however, the head segment requires a separate
 * subclass of this class.
 *
 * @author  <your name> and J. Andrew Holey, including elements designed by Lynn Ziegler
 * @version October 3, 2013
 */
public class WormSegment extends GCompound
{
  private static final double SIZE    = 40.0; // the size of the segment
  private static final double OVERLAP = -5.0; // overlap of segments
  
  
  private GOval       bodySegment;
  private WormSegment nextSegment;
  
  
  /**
   * Construct a new WormSegment with the specified color and construct
   * numWormSegments - 1 more body segments after this one.
   *
   * @param segmentColor    The color of this segment
   * @param numWormSegments The number of worm segments, including this one
   */
  public WormSegment(Color segmentColor, int numWormSegments, double angle)
  {
    //*** make this segment
    this.makeWormSegment(segmentColor);
    
    //*** make the next segment
    this.makeNextSegment(segmentColor, numWormSegments-1, angle);
  }
  
  
  /**
   * Change the color of this segment.
   *
   * @param color the new color to be used to set the color of this segment
   */
  public void setColor(Color newColor)
  {
    //*** set the new color of this segment
    if(this.nextSegment != null)
    {
      this.nextSegment.setColor(newColor);
      
    }
    this.bodySegment.setColor(newColor);
    //*** then call the setColor() method on the next segment -- only if a
    //*** next segment exists, i.e., it is not null
    
  }
  
  
  /**
   * Utility method to make the body --that is the visible parts-- of the
   * current segment and add it to this segment
   *
   * @param segmentColor The color to make the segment being created
   */
  private void makeWormSegment(Color segmentColor)
  {
    //*** create the new GOval and assign it to the private instance variable
    //*** bodySegment, using the SIZE constant for the width and height.
    this.bodySegment = new GOval(SIZE,SIZE);
    //*** set body segment as filled
    this.bodySegment.setFilled(true);
    //*** set the specified color
    this.bodySegment.setColor(segmentColor);
    //*** add the new body segment to this object at the default location
    this.add(this.bodySegment);
  }
  
  
  /**
   * Utility method to construct the next segment and add it to this segment
   *
   * @param segmentColor    The color of this segment
   * @param numWormSegments The number of worm segments, including this one
   */
  private void makeNextSegment(Color segmentColor, int numWormSegments, double angle)
  {
    double sine = Math.sin(Math.toRadians(angle));
                           
    double cosine = Math.cos(Math.toRadians(angle));
    if( numWormSegments > 0)
    {
      this.nextSegment = new WormSegment(segmentColor, numWormSegments, angle);
      //*** create the next body segment
      this.nextSegment.setColor(segmentColor);
      //*** add next body segment at appropriate overlap
      this.add(this.nextSegment,cosine*(SIZE+ OVERLAP), sine*(SIZE + OVERLAP));
    }
    else
    {  
      return;
    }
  }
}
