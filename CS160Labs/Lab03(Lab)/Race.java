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
  private GOval turtle, turtleHead,hareHead ,ear1 , ear2 ;
  private GRect hare, leg1, leg2, leg3, leg4;
  private GLine startLine, finishLine;
  /**
   *  Entry point for ACM Program -- this is where the program will start.
   */
  public void init()
  {
      this.addMouseListeners();
      
      
      // TURTLE      
      this.turtle = new GOval(30, 20);
      this.add(this.turtle, 23, 10);
      this.turtle.setColor(Color.GREEN);
      this.turtle.setFilled(true);
      
      this.turtleHead = new GOval(10,15);
      this.add(this.turtleHead,53,13);
      this.turtleHead.setColor(Color.GREEN);
      this.turtleHead.setFilled(true);
      
      this.leg1 = new GRect(10,15);
      this.add(this.leg1,22,5);
      this.leg1.setColor(Color.GREEN);
      this.leg1.setFilled(true);
      
      this.leg2 = new GRect(10,15);
      this.add(this.leg2,42,5);
      this.leg2.setColor(Color.GREEN);
      this.leg2.setFilled(true);
      
      this.leg3 = new GRect(10,15);
      this.add(this.leg3,22,22);
      this.leg3.setColor(Color.GREEN);
      this.leg3.setFilled(true);
      
      this.leg4 = new GRect(10,15);
      this.add(this.leg4,42,22);
      this.leg4.setColor(Color.GREEN);
      this.leg4.setFilled(true);
      
      
      //HARE
      this.hare = new GRect(30, 20);
      this.add(this.hare, 10, 50);
      this.hare.setColor(Color.GRAY);
      this.hare.setFilled(true);
      
      this.hareHead = new GOval(10,15);
      this.add(this.hareHead,40,53);
      this.hareHead.setColor(Color.GRAY);
      this.hareHead.setFilled(true);
      
      this.ear1 = new GOval(15,3);
      this.add(this.ear1, 48, 56);
      this.ear1.setColor(Color.GRAY);
      this.ear1.setFilled(true);
      
      this.ear2 = new GOval(15,3);
      this.add(this.ear2, 48, 63);
      this.ear2.setColor(Color.GRAY);
      this.ear2.setFilled(true);
      
      //Lines
      this.startLine = new GLine(63,10,63,90);
      this.add(this.startLine);
      this.finishLine = new GLine(300,10,300,90);
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
    
    moveAmount = 10 + 10 * Math.random();
    this.turtle.move(moveAmount,0);
    this.turtleHead.move(moveAmount,0);
    this.leg1.move(moveAmount,0);
    this.leg2.move(moveAmount,0);
    this.leg3.move(moveAmount,0);
    this.leg4.move(moveAmount,0);
    
    
    moveAmount = 2+(23*Math.random());
    this.hare.move(moveAmount,0);
    this.hareHead.move(moveAmount,0);
    this.ear1.move(moveAmount,0);
    this.ear2.move(moveAmount,0);

    //*** Fill in the code to move the two races
  }
}
