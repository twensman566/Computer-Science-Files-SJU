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
public class BowlingPins2 extends GCompound
{
  // The size of a pin
  private final double PIN_SIZE = 20.0;
  // The horizontal distance (center to center) between pins
  private final double H_OFFSET = 60.0;
  // The vertical distance between rows
  private final double V_OFFSET = 52.0;
  // The number of rows of pins
  private final int NUM_ROWS = 4;
  private static final Color DEFAULT_COLOR   = Color.RED;
  
  private GOval [] pin;
  
  
  /**
   * Draws a set of bowling pins on the canvas.  The lowest pin is at pinStart.
   * Note that we pass the GraphicsProgram that we need to add things to that
   * GraphicsProgram.
   *
   * @param xPinStart the x-coordinate of the bottom center pin
   * @param yPinStart the y-coordinate of the bottom center pin
   * @param canvas    the canvas on which to draw the pins
   */
  public BowlingPins2(int numRows)
  {
    int g = 0;
    
    this.pin = new GOval[numRows * (numRows + 1) / 2];
    for (int rows = 0; rows<numRows; rows++)
    {
      
      double pinSpot = 0;
      double xPinStart= 0;
      double yPinStart= 0;
      double rowStart = 0;
      
      for (int i = 0; i < numRows-rows; i++)
      {
        this.pin[g] = new GOval(pinSpot, 0, PIN_SIZE, PIN_SIZE);
        
        this.pin[g].setColor(DEFAULT_COLOR);
        
        this.pin[g].setFilled(true);
        this.add(this.pin[g],xPinStart+H_OFFSET*(rows) + rowStart, yPinStart+V_OFFSET*(i));
        
        
        pinSpot += (PIN_SIZE + V_OFFSET);
        rowStart+=30;
        g++;
      }
      
    }
  }
  public void setColor(int boxNum, Color color)
  {
    if (this.isValidNum(boxNum) == true)
    {
      this.pin[boxNum].setColor(color);
    }
  }
  
  
  /**
   * Check if a box number is valid wrt the boxes array.
   *
   * @param boxNum the box number to check
   *
   * @return true if boxNum is valid, false otherwise
   */
  private boolean isValidNum(int boxNum)
  {
    return (boxNum >= 0 && boxNum < this.pin.length);
  }
  
  
}

/* *** Complete the code to place the bowling pins. Be sure to call
 *** canvas.add() to add your pins to the GraphicsProgram canvas.*/



// *** not a program--no main() needed ***

