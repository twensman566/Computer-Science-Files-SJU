// GridLayout, JPanel
import java.awt.*;

// ActionEvent
import java.awt.event.ActionEvent;

// JButton, JTextField
import javax.swing.*;

// GraphicsProgram
import acm.program.GraphicsProgram;


/**
 *  This program  uses the PigLatin class to convert a line of text to pig
 *  latin; it displays all text in a graphics window.
 *
 *  @author  Jim Schnepf, modified by J. Andrew Whitford Holey
 *  @version October 31, 2013
 */
public class GraphicsPigLatin extends GraphicsProgram
{
  private JTextField original, translated;
 

  /**
   * Initialize the program layout
   */
  public void init()
  {
    this.original   = new JTextField(50);
    this.translated = new JTextField(50);

    this.original.addActionListener(this);

    JPanel p = new JPanel();
    p.setLayout(new GridLayout(4, 1));
    p.add(new JLabel("Original:"));
    p.add(this.original);
    p.add(new JLabel("Pig Latin:"));
    p.add(this.translated);
    this.add(p, NORTH);

    this.validate();
  }


  /**
   * Display the pig latin text in the translated field when you press Enter on
   * the keyboard.
   */
  public void actionPerformed(ActionEvent event)
  {
    Object o = event.getSource();

    if (o == original)
    {
      this.translated.setText(PigLatin.convertLine(this.original.getText()));
    }
  }
}
