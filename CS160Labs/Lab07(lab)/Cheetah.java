// File: Turtle.example.java

import java.awt.*;
import acm.graphics.*;

/**
 * A class to represent a racing Cheetah
 */

public class Cheetah extends GCompound{
  /**
   * Our hare needs a body, a head, a tail, 2 eyes, and 4 legs
   */
  private GOval body, head, tail, leg1, leg2, leg3, leg4, eye1, eye2, spot1;
  /**
   * We save the scale of our hare.
   */
  double scale=1.0;

  /**
   * Our constructor recieves x and y co-ordinates and a size
   * and places a turtle of that size at those co-ordinates.
   */
  public Cheetah(double x, double y, double size) {
    createOval(head,70,40,30,20,Color.YELLOW);
    createOval(eye1,90,45,3,3,Color.BLACK);
    createOval(eye2,90,52,3,3,Color.BLACK);
    createOval(tail,5,45,30,10,Color.YELLOW);
    createOval(leg1,30,5,10,30,Color.BLACK);
    createOval(leg2,60,5,10,30,Color.YELLOW);
    createOval(leg3,30,65,10,30,Color.BLACK);
    createOval(leg4,60,65,10,30,Color.YELLOW);
    createOval(body,20,20,60,60,Color.YELLOW);
    createOval(spot1,40,37,43,40,Color.BLACK);
    setLocation(x,y);
    scale(size/100);
  }
  
  private void createOval(GOval oval, double x, double y, double width, double height, Color color) {
    oval=new GOval(x,y,width,height);
    oval.setFilled(true);
    oval.setFillColor(color);
    add(oval);
  }
  
  /**
   * resize(double factor) resizes the turtle to a size
   * factor times its original size (which is stored in
   * scale). Thus if factor is 2 it will be twice as big.
   */
  public void resize(double factor) {
    scale(factor/scale);
    scale=factor;
  }
}
