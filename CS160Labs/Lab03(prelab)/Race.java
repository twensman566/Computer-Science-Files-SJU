// Color
import java.awt.Color;

// MouseEvent
import java.awt.event.MouseEvent;

// GLine, GOval, GRect
import acm.graphics.*;

// GraphicsProgram
import acm.program.GraphicsProgram;


/**
 * A race program between a turtle (oval) and a hare (square)
 * 
 * @author <your name>, based on a template by Lynn Ziegler
 */
public class Race extends GraphicsProgram
{
  // instance variables
  private GOval turtle;
  private GRect hare;
  private GLine startLine, finishLine;
  /**
   *  Entry point for ACM Program -- this is where the program will start.
   */
  public void init()
  {
      this.turtle = new GOval(30, 20);
      this.add(this.turtle, 10, 10);
      this.turtle.setColor(Color.GREEN);
      this.turtle.setFilled(true);
      
      this.hare = new GRect(30, 20);
      this.add(this.hare, 10, 40);
      this.hare.setColor(Color.GRAY);
      this.hare.setFilled(true);
      
      this.startLine = new GLine(40,10,40,70);
      this.add(this.startLine);
      this.finishLine = new GLine(150,10,150,70);
      this.add(this.finishLine);
    //*** Fill in the code to draw the raceway and place the racers into their
    //*** starting positions
  }
 

  /**
   * Move the racers forward with each click
   */
  public void mouseClicked(MouseEvent e)
  {
    // local variables
    double moveAmount;

    //*** Fill in the code to move the two races
  }
}
