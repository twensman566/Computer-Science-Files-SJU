/* File: MyMouseIndicator.java */

import java.awt.*;
import java.awt.event.*;
import acm.program.*;
import acm.graphics.*;

/**
 * This program uses the mouseReleased and mousePressed methods
 * to create a program reacting to those events.
 * 
 * @author <Your Name>, based on a template by Lynn Ziegler
 * @version <Today's date>
 */
public class MyMouseIndicator extends GraphicsProgram {
  
  /**
   * up and down hold text to appear on the screen.
   */
  private GLabel up, down;
  
  /**
   * Set up the initial state of the graphics window
   */
  public void init() {
    this.addMouseListeners();  // set up to pay attention to the mouse
    this.up = new GLabel("UP", 100, 100);
    this.up.setColor(Color.red);
    this.add(this.up);
    this.down = new GLabel("DOWN", 100, 200);
    this.add(this.down);
    /**************************************************************
     * Fill in the rest of the code for this function below.
     * Set the color of up and add it to the canvas,
     * then create a new GLabel for down, set its color
     * and add it to the canvas.
     **************************************************************/

  }
  
  /**
   * mousePressed reacts to a mouse press by making down red, up black
   */
  public void mousePressed(MouseEvent e) {
    /**************************************************************
     * Fill in the rest of the code for this function below.
     * Change the color of each of the two GLabels up and down.
     **************************************************************/
    this.up.setColor(Color.black);
    this.down.setColor(Color.red);
  }
  
  /**
   * mouseReleased reacts to a mouse release by making up red, down black
   */
  public void mouseReleased(MouseEvent e) {
    /**************************************************************
     * Fill in the rest of the code for this function below.
     * Change the color of each of the two GLabels up and down.
     **************************************************************/
    this.up.setColor(Color.red);
    this.down.setColor(Color.black);
  }

  /**
   * Required boilerplate main() method.
   * Creates a new MouseIndicator object and runs its start method.
   */
  public static void main(String [] args) {
    new MyMouseIndicator().start();
  }
}
