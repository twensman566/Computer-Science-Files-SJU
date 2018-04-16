// GCanvas, GOval
import acm.graphics.*;

// Color
import java.awt.*;

//Scanner
import java.util.Scanner;


/**
 * A set of Bowling pins viewed from the top
 *
 * @author <your name> based on a template by the CSB|SJU Computer Science faculty
 */
public class BowlingPins
{
  // The size of a pin
  private final double PIN_SIZE = 20.0;
  // The horizontal distance (center to center) between pins
  private final double H_OFFSET = 60.0;
  // The vertical distance between rows
  private final double V_OFFSET = 52.0;
  // The number of rows of pins
  private final int NUM_ROWS = 4;
  
  private GOval pin;
  
  
  /**
   * Draws a set of bowling pins on the canvas.  The lowest pin is at pinStart.
   * Note that we pass the GraphicsProgram that we need to add things to that
   * GraphicsProgram.
   *
   * @param xPinStart the x-coordinate of the bottom center pin
   * @param yPinStart the y-coordinate of the bottom center pin
   * @param canvas    the canvas on which to draw the pins
   */
  public BowlingPins(double xPinStart, double yPinStart, GCanvas canvas)
  {
    double xPinSpot = xPinStart;
    double yPinSpot = yPinStart;
    Scanner in = new Scanner(System.in);
    System.out.print("Enter number of rows you wish to make:  ");
    int numRows = in.nextInt();
    double counter1 = 0;
    double counter2 = 4;
    double ONE = 0;
    double THIRTY = 30;
    while(counter1<numRows)
    {
      counter1 = counter1 + 1;
      counter2 = 0 + ONE;
      ONE = ONE + 1;
      yPinSpot = yPinSpot + V_OFFSET;
      xPinSpot = xPinStart;
      THIRTY = THIRTY + 30;
      while(counter2<numRows)
      {
        this.pin = new GOval(PIN_SIZE,PIN_SIZE);
        canvas.add(this.pin,xPinSpot+THIRTY,yPinSpot);
        xPinSpot = xPinSpot + H_OFFSET;
        counter2 = counter2 + 1;
      }
    }
    
    /* *** Complete the code to place the bowling pins. Be sure to call
     *** canvas.add() to add your pins to the GraphicsProgram canvas.*/
  }
  
  
  // *** not a program--no main() needed ***
}
