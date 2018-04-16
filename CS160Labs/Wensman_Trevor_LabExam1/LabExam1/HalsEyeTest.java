// GraphicsProgram
import acm.program.*;


/**
 * HalsEye testing program
 */
public class HalsEyeTest extends GraphicsProgram
{
  private static final double EYE_X          = 220;
  private static final double EYE_Y          =  80;
  private static final double EYE_SIZE       = 300;
  private static final int FLUCTUATION_COUNT =  20;


  private HalsEye halsEye;


  public void init()
  {
    this.halsEye = new HalsEye(EYE_SIZE);

    this.add(this.halsEye, EYE_X, EYE_Y);
  }


  public void run()
  {
    this.halsEye.fluctuate(FLUCTUATION_COUNT);
  }
}
