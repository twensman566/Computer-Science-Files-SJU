// Color
import java.awt.Color;

// MouseEvent
import java.awt.event.MouseEvent;

// ArrayList
import java.util.ArrayList;

// GraphicsProgram
import acm.program.GraphicsProgram;

// GLabel, GRoundRect
import acm.graphics.*;


/**
 * Program that adds labels to the canvas when a button is clicked.
 */
public class LabelSample extends GraphicsProgram
{
  private static final double ADD_X   = 100;
  private static final double ADD_Y   = 200;
  private static final int BOX_WIDTH  = 125;
  private static final int BOX_HEIGHT = 50;

  private ArrayList<GLabel> labelList;
  private GRoundRect box;
  private int max;


  /**
   * Initialize by adding one GRoundRect object to the canvas.
   */
  public void init()
  {
    this.max = 3;

    this.labelList = new ArrayList<GLabel>();
    this.box       = new GRoundRect(ADD_X, ADD_Y, BOX_WIDTH, BOX_HEIGHT);

    this.box.setColor(Color.YELLOW);
    this.box.setFilled(true);

    this.add(this.box);
    this.add(new GLabel("Box", ADD_X + 30, ADD_Y + 30));

    this.addMouseListeners();
  }
 

  public void mouseClicked(MouseEvent e)
  {
    if (this.box.contains(e.getX(), e.getY()))
    {
      this.add();
    }
  }
 

  private void add()
  {
    if (this.labelList.size() < this.max)
    {
      GLabel newLabel = new GLabel(this.readLine("Enter a name: "));

      this.add(newLabel, ADD_X + BOX_WIDTH + 30,  (ADD_Y + (this.labelList.size() % 3) * 30));

      this.labelList.add(newLabel);
    }
    else
    {
      this.println("Too many names.");

      for (GLabel label: this.labelList)
      {
        label.move(0, -90);
      }

      this.max += 3;
    }
  }
}
