// File: ActiveHare.java

import java.awt.*;
import java.awt.event.*;
import acm.program.*;
import acm.graphics.*;
import acm.util.*;


/**
 * An ActiveHare runs a race on a supplied canvas
 */
public class ActiveHare extends Animator
{
  // ***declare a Hare from the earlier lab. See the ActiveTurtle class and MyTurtle***
  
  private Hare hare;
  private double endLine;
  private int speed;
  private double size;
  private GCanvas canvas;
  private static final int REPORT_X =  50;
  private static final int REPORT_Y = 260;
  
  /**
   * Constructor for an ActiveHare
   *
   * @param x       the x-coordinate of the hare's initial position
   * @param y       the y-coordinate of the hare's initial position
   * @param size    the size of the hare
   * @param endLine the x-coordinate of the race's end line
   * @param canvas  the canvas to draw the hare on
   * @param speed   the speed the hare moves at
   */
  public ActiveHare(double x, double y, double size, double endLine, int speed, GCanvas canvas) {
    
    this.size    = size;
    this.endLine = endLine;
    this.speed   = speed;
    this.canvas  = canvas;
    this.hare  = new Hare(x, y, this.size);
    this.canvas.add(hare);
  }
  
  /**
   * This hare runs the race
   */
  public void run() {
    // ***while loop to move the Hare along at its speed.***
    long startTime = System.currentTimeMillis();
    
    while (hare.getX() < endLine - this.size / 2) {
      hare.move(this.speed, 0);
      hare.pause(50);
    }
    
    // Get end time
    long endTime = System.currentTimeMillis();
    
    // Compute and display elasped time in seconds
    double elapsedTime = (endTime - startTime) / 1000.0;
    
    GLabel hareTimeMsg =
      new GLabel(String.format("The hare ran the race in %5.2f seconds", elapsedTime),
                 REPORT_X, REPORT_Y);
    this.canvas.add(hareTimeMsg);
    
  }
}

