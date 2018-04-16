// MouseEvent
import java.awt.event.MouseEvent;

// GraphicsProgram
import acm.program.GraphicsProgram;

// GLabel
import acm.graphics.GLabel;


/**
 * A program that makes a box and let's it slide across the canvas
 */
public class BoxController extends GraphicsProgram
{
  // instruction location
  private static final double INSTRUCTION_X = 100.0;
  private static final double INSTRUCTION_Y =  25.0;

  // program instructions
  private GLabel instructions;


  /**
   * Initialize the canvas
   */
  public void init()
  {
    // enable mouse click events
    this.addMouseListeners();

    // display instructions
    this.instructions = new GLabel("Click to make a box that moves");
    this.add(this.instructions, INSTRUCTION_X, INSTRUCTION_Y);
  }


  /**
   * Create and start the box
   *
   * @param e the event generated by the mouse click
   */
  public void mouseClicked(MouseEvent e)
  {
    // hide the instructions
    this.instructions.setVisible(false);

    // make a new sliding box and start it
    new ActiveBox(e.getX(), e.getY(), this.getGCanvas()).start();
  }
}
