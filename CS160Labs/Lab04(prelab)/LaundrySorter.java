// Color
import java.awt.*;

// MouseEvent
import java.awt.event.*;

// GraphicsProgram
import acm.program.*;

// GObject, GLabel, GRect
import acm.graphics.*;


/**
 * ***LaundrySorter.java simulates sorting laundry. A rectangle
 * -the hamper- that is white, black, or red, representing a white, dark, or
 *  colored clothing item at the top of the hamper. Below this rectangle is 3
 *  rectangles that represent 3 tubs of laundry
 * -Whites,Darks, and Colors with appropriate colors and labels. The user is to
 *  look at the color of the "clothing item" in the hamper and select the
 *  appropriate tub. If selected correctly, the hamper will randomly replace it
 *  with a new clothing item. If not selected correctly, an error message tells
 *  the user and the clothing item does not change until the user selects the
 *  appropriate bin.***
 */
public class LaundrySorter extends GraphicsProgram
{
  // constant variables dictating the positions and sizes of the bins and hampers
  private static final int BIN_X     = 240;
  private static final int WHITE_Y   =  50;
  private static final int COLOR_Y   = 160;
  private static final int DARK_Y    = 270;
  private static final int BIN_SIZE  = 100;
  private static final int HAMP_X    =  50;
  private static final int HAMP_Y    =  50;
  private static final int HAMP_SIZE = 140;

  // graphical objects for the simulation
  private GRect whiteBinOutline, whiteBinInterior, darkBin, colorBin,
          hamperOutline, hamperInterior;
  private GLabel lblWrong;


  /**
   * Initialize the display with a colored rectangle for the hamper containing
   * the first article of clothing along with 3 hampers labeled and colored
   * "White", "Dark", and "Colored".
   */
  public void init()
  {
    // add 'listener' for mouse events
    this.addMouseListeners();

    // create the white bin (outline and interior)
    this.whiteBinOutline  = new GRect(BIN_X,   WHITE_Y,   BIN_SIZE,   BIN_SIZE);
    this.whiteBinInterior = new GRect(BIN_X+1, WHITE_Y+1, BIN_SIZE-2, BIN_SIZE-2);

    // set the white bin outline as unfilled and the interior as filled
    this.whiteBinOutline.setFilled(false);
    this.whiteBinInterior.setFilled(true);

    // set the color of the white bin
    this.whiteBinOutline.setColor(Color.BLACK);
    this.whiteBinInterior.setColor(Color.WHITE);

    // add the white bin to the canvas
    this.add(this.whiteBinOutline);
    this.add(this.whiteBinInterior);

    // create the color bin (no outline needed)
    this.colorBin = new GRect(BIN_X, COLOR_Y, BIN_SIZE, BIN_SIZE);

    // set the color bin as filled
    this.colorBin.setFilled(true);

    // set the color of the color bin
    this.colorBin.setColor(Color.RED);

    // add the color bin to the canvas
    this.add(this.colorBin);

    // *** create and add the dark bin

    // *** choose a random color from WHITE, RED, or BLACK to be the initial
    // *** color of the hamper

    // create the hamper (outline and interior)
    this.hamperOutline  = new GRect(HAMP_SIZE,   HAMP_SIZE);
    this.hamperInterior = new GRect(HAMP_SIZE-2, HAMP_SIZE-2);

    // set the hamper outline as unfilled and the interior as filled
    this.hamperOutline.setFilled(false);
    this.hamperInterior.setFilled(true);

    /* set the initial color of the hamper outline as black and the hamper
       interior as selected by the if statement above */
    this.hamperOutline.setColor(Color.BLACK);

    // *** set the hamper interior to be the randomly chosen color from above

    // add the white bin to the canvas
    this.add(this.hamperOutline,  HAMP_X,   HAMP_Y);
    this.add(this.hamperInterior, HAMP_X+1, HAMP_Y+1);

    // create a label to display the message if a wrong selection is made
    this.lblWrong = new GLabel("WRONG BIN!");

    // set the color of the wrong message
    this.lblWrong.setColor(Color.RED);

    // make the wrong message hidden initially
    this.lblWrong.setVisible(false);

    // add the wrong message to the canvas
    this.add(this.lblWrong, 400, 400);
  }


  /**
   * If the hamper selected matches the color of the new laundry item, we "move"
   * the item from the hamper to the right bin. If not, we display a nasty
   * message.
   *
   * @param e Information about the mouse pressed event (including its location)
   */
  public void mouseClicked(MouseEvent e)
  {
    // *** use an if statement to tell if the color in the selected bin is the
    // *** same as the color in the hamper (Use the getColor() method from
    // *** GObject.) If so, randomly change the color in the hamper and
    // *** continue. If not, display a message stating that a wrong choice was
    // *** made.
  }
}
