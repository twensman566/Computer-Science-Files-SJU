/*
 * File: Add2Program.java
 * ----------------------
 * This program adds two numbers and prints their sum.  Because
 * this version is a Program, input and output are assigned to
 * System.in and System.out.
 */
import acm.program.*;

public class Add2Dialog extends DialogProgram
{
  public void run()
  {
    this.println("This program adds two numbers.");
    int n1 = this.readInt("Enter n1: ");
    int n2 = this.readInt("Enter n2: ");
    int total = n1 + n2;
    this.println("The total is " + total + ".");
  }
}
