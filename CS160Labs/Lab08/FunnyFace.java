// GCompound, GObject, GOval
import acm.graphics.*;


/**
 * Class that creates a GCompound representing a face
 *
 * @author ***your name here*** based on a template by Lynn Ziegler
 * @version ***today's date here***
 */
public class FunnyFace extends GCompound implements Face
{
  // initial dimensions of the face
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
  private GOval   head;
  private GOval   leftEye;
  private GOval   rightEye;
  private GObject mouth;

  // variable to indicate if eyes are opened (true) or closed (false)
  private boolean eyesAreOpen = true;


  /**
   * Create pieces of funny face
   */
  public FunnyFace()
  {
    this.head     = new GOval(FACE_WIDTH, FACE_HEIGHT);
    this.leftEye  = new GOval(EYE_HEIGHT, EYE_WIDTH);
    this.rightEye = new GOval(EYE_WIDTH, EYE_HEIGHT);
    this.mouth    = new GOval(MOUTH_WIDTH, MOUTH_HEIGHT);

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
  }


  /**
   * Make this face frown
   */
  public void frown()
  {
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
  }


  /**
   * Make this face open its eyes
   */
  public void openEyes()
  {
  }
}
