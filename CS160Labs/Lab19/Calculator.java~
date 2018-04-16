// File: Calculator.java

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import acm.gui.*;

/**
 * In this class we are constructing a simple calculator which will perform
 * operations on the numbers in the first and second boxes and put the answers
 * in the third.
 * As given here, the calculator has an addition button. 
 * You are to add: -, *, /, log, exp, +/- First, +/- Second, sin, cos, tan, 
 * Clear First, Clear Second, and Clear All buttons, and make them work.
 * All of the buttons should 
 * be put in a single button panel with a GridBagLayout. 
 * Also add a Quit button which stops the program by
 * executing the statement: System.exit(0);
 *
 * @author  Lynn Ziegler, modified by J. Andrew Holey
 * @version November 18, 2011
 */
public class Calculator extends JFrame implements ActionListener, FocusListener {
  
  private DoubleField firstBox, secondBox, answerBox;
  private JPanel numberPanel,buttonPanel,buttonPanel2;
  private double first  = 0.0;
  private double second = 0.0;
  private double answer = 0.0;
  private Container contentPane,buttonPane;
  private JButton addValues, subValues, divValues, multValues, quit, log, tan, sin, cos;
  
  /**
   * The constructor must lay out all the components for the GUI, set up action
   * listeners (and things) and start the JFrame action.
   */
  public Calculator() {

    //Create the box for the first number
    firstBox = new DoubleField(first);
    firstBox.setFormat("##0.000");
    firstBox.addFocusListener(this);
    firstBox.setHorizontalAlignment(JTextField.RIGHT);

    //Create the box for the second number
    secondBox = new DoubleField(second);
    secondBox.setFormat("##0.000");
    secondBox.addFocusListener(this);
    secondBox.setHorizontalAlignment(JTextField.RIGHT);

    //Create the box for the answer
    answerBox = new DoubleField(answer);
    answerBox.setFormat("##0.000");
    answerBox.setEditable(false);
    answerBox.setHorizontalAlignment(JTextField.RIGHT);

    /* Create a panel for the boxes and add them to it
     * along with labels and appropriate spacing */
    numberPanel = new JPanel();
    numberPanel.setLayout(new GridLayout(5, 2));
    numberPanel.add(new JLabel("First"));
    numberPanel.add(firstBox);
    numberPanel.add(new JLabel("Second"));
    numberPanel.add(secondBox);
    numberPanel.add(new JLabel(""));
    numberPanel.add(new JLabel(""));
    numberPanel.add(new JLabel("Answer"));
    numberPanel.add(answerBox);
    numberPanel.add(new JLabel(""));
    

    


    //Create the content pane to add things to.
    contentPane = this.getContentPane();
    
    //Add the number panel north
    contentPane.add(numberPanel, BorderLayout.NORTH);
   
    buttonPane = this.getContentPane();
    buttonPanel = new JPanel();
    
    buttonPanel.setLayout(new GridLayout(2, 4));
    addValues = new JButton("+");
    subValues = new JButton("-");
    multValues = new JButton("*");
    divValues = new JButton("/");
    log = new JButton("Log");
    sin = new JButton("Sin");
    cos = new JButton("Cos");
    tan = new JButton("Tan");
    
    

    buttonPanel.add(addValues);
    buttonPanel.add(subValues);
    buttonPanel.add(divValues);
    buttonPanel.add(multValues);
    buttonPanel.add(log);
    buttonPanel.add(sin);
    buttonPanel.add(cos);
    buttonPanel.add(tan);
    
    
    buttonPanel2 = new JPanel();
    buttonPanel.setLayout(new GridLayout(1, 1));
    quit = new JButton("Quit");
    buttonPanel2.add(quit);
    
    buttonPane.add(buttonPanel2,BorderLayout.SOUTH);
    buttonPane.add(buttonPanel, BorderLayout.CENTER);
    
    


    //Create the Add button

    addValues.addActionListener(this);
    subValues.addActionListener(this);
    divValues.addActionListener(this);
    multValues.addActionListener(this);
    log.addActionListener(this);
    tan.addActionListener(this);
    sin.addActionListener(this);
    cos.addActionListener(this);
    quit.addActionListener(this);
    
    

    buttonPane.validate();
    




    /* You will eventually add this button to a
     * buttonPanel instead of the CENTER.
     */

    //set the size and make the JFrame visible
    this.setSize(500,300);
    this.setVisible(true);
  }
  
  /**
   * Whenever you leave the firstBox and secondBox, the focus is lost for that box 
   * and this method is called and first and second are set to the values in
   * the JTextFields firstBox and secondBox. If you enter a bad value, the exception
   * handling handles it and pops up a box and resets the box to the previous value.
   */
  public void focusLost(FocusEvent firstEvent) { 
    Object source = firstEvent.getSource();
    if (source == firstBox) {
      first  = firstBox.getValue();
    }
    else if (source == secondBox) {
      second = secondBox.getValue();
    }      
  }

  /**
   * Even though we do not need focusGained, it must be created when you implement
   * the FocusListener interface.
   */
  public void focusGained(FocusEvent e) {
  }
  
  /**
   * The actionPerformed method handles the button actions.
   */
  public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == addValues) {
      answer = first + second;
      answerBox.setValue(answer);
    }
    else if(source == subValues)
    {
      answer = first-second;
      answerBox.setValue(answer);
    }
    else if(source == divValues)
    {
     answer = first/second;
     answerBox.setValue(answer);
    }
    else if(source == multValues)
    {
     answer = first * second;
     answerBox.setValue(answer);
    }
    else if(source == log)
    {
     answer = Math.log(first); 
     answerBox.setValue(answer);
    }
    else if(source == tan)
    {
     answer = Math.tan(first);
     answerBox.setValue(answer);
    }
    else if(source == cos)
    {
     answer = Math.cos(first);
     answerBox.setValue(answer);
    }
    else if(source == sin)
    {
     answer = Math.sin(first);
     answerBox.setValue(answer);
    }
    else if(source == quit)
    {
      System.exit(0);
    }
  }

  public static void main(String [] args) {
    new Calculator();
  }
}
