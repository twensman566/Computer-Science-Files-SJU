//***********************************************************
// Assignment: 1
// Problem: 1
// Program: BMI.java
// Author(s): (Your name goes here)
// Description: This program get user input for weight (in
// pounds) and height (in inches), calculates and prints Body
// Mass Index.
//***********************************************************


// Program
import acm.program.Program;
import java.util.Scanner;


public class BMI extends Program
{
  public void run()
  {
    // *** fill in your solution here
    Scanner in = new Scanner(System.in);
    System.out.print("Enter your weight in pounds:  ");
    double weight = in.nextDouble();
    

    System.out.print("Enter your height in inches:  ");
    double height = in.nextDouble();
    
    double bmi = (weight * 703) / (height* height);
    System.out.printf("Your BMI is: %8.2f" , bmi);
    System.out.println();
  }
}
