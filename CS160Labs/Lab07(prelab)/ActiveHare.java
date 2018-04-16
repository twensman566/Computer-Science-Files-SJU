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
    // ***create your Hare.***
  }

  /**
   * This hare runs the race
   */
  public void run() {
    // ***while loop to move the Hare along at its speed.***
  }
}
