/*
 * File: HelloGraphics.java
 * ------------------------
 * This program displays the message "hello, world" and is inspired
 * by the first program "The C Programming Language" by Brian
 * Kernighan and Dennis Ritchie.  This version displays the message
 * graphically.
 */

import acm.graphics.*;
import acm.program.*;

public class HelloGraphics extends GraphicsProgram
{
  public void run()
  {
    GLabel label = new GLabel("hello, world");
    label.setFont("SansSerif-100");
    double x = (this.getWidth() - label.getWidth()) / 2;
    double y = (this.getHeight() + label.getAscent()) / 2;
    this.add(label, x, y);
  }
}
