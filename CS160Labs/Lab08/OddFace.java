// GCompound, GObject, GOval
import acm.graphics.*;
import java.awt.*;

/**
 * Class that creates a GCompound representing a face
 *
 * @author ***your name here*** based on a template by Lynn Ziegler
 * @version ***today's date here***
 */
public class OddFace extends GCompound implements Face
{
  private static final double FACE_WIDTH  = 60.0;
  private static final double FACE_HEIGHT = 60.0;
  
  // eye location and size
  private static final double EYE_OFFSET_X = 20.0;
  private static final double EYE_OFFSET_Y = 20.0;
  private static final double EYE_WIDTH    =  8.0;
  private static final double EYE_HEIGHT   =  8.0;
  // scale factor for opening/closing eyes
  private static final double EYE_FACTOR   =  0.2;
  
  // dimensions, location, and angle of the mouth
  private static final double MOUTH_HEIGHT = 10.0;
  private static final double MOUTH_WIDTH  = FACE_WIDTH / 2.0;
  private static final double MOUTH_X     = (FACE_WIDTH - MOUTH_WIDTH) / 2.0;
  private static final double MOUTH_Y     = 2.0 * FACE_HEIGHT / 3.0;
  private static final double SMILE_START = -25.0;
  private static final double SMILE_SWEEP = -130.0;
  private static final double FROWN_START = -SMILE_START;
  private static final double FROWN_SWEEP = -SMILE_SWEEP;
  
  // variables for head, eyes and mouth
  private GRect   head;
  private GRect   leftEye;
  private GRect   rightEye;
  private GRect mouth;
  
  // variable to indicate if eyes are opened (true) or closed (false)
  private boolean eyesAreOpen = true, mouthIsOpen = true;
  /**
   * Create pieces of odd face
   */
  public OddFace()
  {
    this.head     = new GRect(FACE_WIDTH, FACE_HEIGHT);
    this.leftEye  = new GRect(EYE_HEIGHT, EYE_WIDTH);
    this.rightEye = new GRect(EYE_WIDTH, EYE_HEIGHT);
    this.mouth    = new GRect(MOUTH_WIDTH, MOUTH_HEIGHT);
    
    this.leftEye.setColor(Color.BLACK);
    this.rightEye.setColor(Color.RED);
    this.leftEye.setFilled(true);
    this.rightEye.setFilled(true);
    
    this.mouth.setColor(Color.BLACK);
    this.mouth.setFilled(true);
    
    
    this.add(this.head, 0, 0);
    this.add(this.leftEye, EYE_OFFSET_X - EYE_WIDTH / 2.0, EYE_OFFSET_Y);
    this.add(this.rightEye, FACE_WIDTH - EYE_OFFSET_X - EYE_WIDTH / 2.0, EYE_OFFSET_Y);
    this.add(this.mouth, MOUTH_X, MOUTH_Y);
    
  }
  
  
  /**
   * Make this face smile
   */
  public void smile()
  {
    if (mouthIsOpen == false)
    {
      this.mouth.scale(1,5);
      mouthIsOpen = true;
    }
  }
  
  
  /**
   * Make this face frown
   */
  public void frown()
  {
    if (mouthIsOpen == true)
    {
      this.mouth.scale(1,.2);
      mouthIsOpen = false;
    }
    
  }
  
  
  /**
   * Make this face neutral (neither smiling nor frowning)
   */
  public void neutral()
  {
  }
  
  
  /**
   * Make this face close its eyes
   */
  public void closeEyes()
  {
    if (eyesAreOpen == true)
    {
      this.rightEye.scale(1,.2);
      this.leftEye.scale(1,.2);
      eyesAreOpen = false;
    }
  }
  
  
  /**
   * Make this face open its eyes
   */
  public void openEyes()
  {
    if (eyesAreOpen == false)
    {
      this.rightEye.scale(1,5);
      this.leftEye.scale(1,5);
      eyesAreOpen = true;
    }
  }
}
