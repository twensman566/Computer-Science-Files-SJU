/* 
 * File: DrawRobot.java
 * 
 * This file uses four shapes to create a graphical image of a robot like figure.
 * 
 * Trevor Wensman
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class DrawRobot extends GraphicsProgram
{
  public void run()
  {
    GOval oval = new GOval(300,25, 100, 100);
    this.add(oval);
    GRect rect = new GRect(278,125,150,200);
    this.add(rect);
    GRect rect1 = new GRect(300,325,40,150);
    this.add(rect1);
    GRect rect2 = new GRect(360,325,40,150);
    this.add(rect2);
  }
}


