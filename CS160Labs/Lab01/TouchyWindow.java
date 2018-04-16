/* File: TouchyWindow.java */

   import java.awt.event.*;
   import acm.program.*;
   import acm.graphics.*;

/**
 * This program uses the mouseRelased and mousePressed methods
 * to create a program reacting to those events.
 * 
 * @author Your Name, based on a program adapted from Kim Bruce
 */
   public class TouchyWindow extends GraphicsProgram {
   
   /**
   * touchLabel and label hold the text to appear on the
   * screen.
   */
      private GLabel touchLabel, startLabel;
   
   /**
   * init() is the initialization program for acm classes.
   * In this case, addMouseListeners(); causes the program
   * to be set up to react to mouse events. We then create
   * and add a label with user instructions and create
   * another label.
   */
      public void init() {
         this.addMouseListeners();
         this.startLabel = new GLabel("Click in this window.", 70 ,70);
         this.startLabel.setFont("SanSerif-50");
         this.add(startLabel);
         this.touchLabel = new GLabel("I'm touched!", 150, 150);
         this.touchLabel.setFont("SanSerif-50");
      }
   
   /**
   * mousePressed reacts to a mouse press by adding some text.
   */
      public void mousePressed(MouseEvent e) {
         this.add(touchLabel);
      }
   
   /**
   * mouseReleased reacts to a mouse release by removing some text.
   */
      public void mouseReleased(MouseEvent e) {
         this.remove(touchLabel);
      }

   /**
   * main starts the program.
   */
      public static void main(String [] args) {
         new TouchyWindow().start();
      }
   }
