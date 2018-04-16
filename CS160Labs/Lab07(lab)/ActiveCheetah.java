// File: ActiveTurtle.java

   import acm.graphics.*;
   import acm.util.*;

/**
 * An ActiveTurtle runs a race on a supplied canvas
 */
   public class ActiveCheetah extends Animator {
   
      private static final int REPORT_X =  50;
      private static final int REPORT_Y = 300;
   
      private Cheetah cheetah;
      private double endLine;
      private int speed;
      private double size;
      private GCanvas canvas;
   
   /**
   * Constructor for an ActiveCheetah
   *
   * @param x       the x-coordinate of the turtle's initial position
   * @param y       the y-coordinate of the turtle's initial position
   * @param size    the size of the turtle
   * @param endLine the x-coordinate of the race's end line
   * @param canvas  the canvas to draw the turtle on
   * @param speed   the speed the turtle moves at
   */
      public ActiveCheetah(double x, double y, double size, double endLine, int speed, GCanvas canvas) {
         this.size    = size;
         this.endLine = endLine;
         this.speed   = speed;
         this.canvas  = canvas;
         this.cheetah  = new Cheetah(x, y, this.size);
         this.canvas.add(cheetah);
      }
   
   /**
   * This turtle runs the race
   */
      public void run() {
      // Get start time in milliseconds
         long startTime = System.currentTimeMillis();
      
      // Run the race
         while (cheetah.getX() < endLine - this.size / 2) {
            cheetah.move(this.speed, 0);
            cheetah.pause(50);
         }
      
      // Get end time
         long endTime = System.currentTimeMillis();
      
      // Compute and display elasped time in seconds
         double elapsedTime = (endTime - startTime) / 1000.0;
         
         GLabel cheetahTimeMsg =
            new GLabel(String.format("The cheetah ran the race in %5.2f seconds", elapsedTime),
                  REPORT_X, REPORT_Y);
         this.canvas.add(cheetahTimeMsg);
         
      }
      
   }
