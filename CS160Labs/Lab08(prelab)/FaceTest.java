// MouseEvent
import java.awt.event.MouseEvent;

// GraphicsProgram
import acm.program.GraphicsProgram;

// GObject
import acm.graphics.GObject;


/**
 * Program that tests classes implementing the Face interface; currently, only
 * the FunnyFace class is tested. This shows how to use an interface like a
 * class.
 *
 * @author  J. Andrew Holey, from another program by Lynn Ziegler
 * @version 2011/09/20
 */
public class FaceTest extends GraphicsProgram
{
  // Note that since FunnyFace implements Face, it is ok
  // to have a Face variable set to refer to a FunnyFace.
  // This will allow us to use different kinds of faces later.
  private Face face1;
  private Face face2;
  private Face oddface;
  


  /**
   * Set up a canvas with two faces
   */
  public void init()
  {
    this.addMouseListeners();

    this.face1 = new FunnyFace();
    this.face1.frown();
    this.add((GObject)face1, 50.0, 50.0);

    this.face2 = new OvalFace();
    this.face2.smile();
    this.face2.closeEyes();
    this.add((GObject)face2, 300.0, 300.0);
    
    this.oddface = new OddFace();
    this.add((GObject)oddface, 500.0, 300.0);
  }


  /**
   * Action to take when the mouse is pressed; behavior depends on where the
   * press occured
   *
   * @param e the associated mouse event
   */
  public void mousePressed(MouseEvent e)
  {
    if (this.face1.contains(e.getX(), e.getY()))
    {
      this.face1.move(10.0, 10.0);
    }
    if (this.oddface.contains(e.getX(), e.getY()))
    {
      this.oddface.move(10.0, 10.0);
    }
    else if (this.face2.contains(e.getX(), e.getY()))
    {
      this.face2.move(-10.0, -10.0);
    }
    else
    {
      this.face1.smile();
      this.face1.closeEyes();
      
      this.face2.frown();
      this.face2.openEyes();
      
      this.oddface.smile();
      this.oddface.closeEyes();
    }
  }

  /**
   * Action to take when the mouse is released behavior depends on where the
   * press occured
   *
   * @param e the associated mouse event
   */
  public void mouseReleased(MouseEvent e)
  {
    if (this.face1.contains(e.getX(), e.getY()))
    {
      this.face1.frown();
      this.face2.closeEyes();
      this.oddface.frown();
    }
    else if (this.face2.contains(e.getX(), e.getY()))
    {
      this.face2.smile();
      this.face1.openEyes();
      this.oddface.openEyes();
    }
    else
    {
      this.face1.smile();
      this.face2.frown();
      this.oddface.smile();
    }
  }
}
