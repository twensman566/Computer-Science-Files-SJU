import acm.program.*;
import java.util.*;
/** This function is used to call the Fraction.java class to calculate the sum, difference,
  * product, and quotient of two fractions.
  */

public class FractionMath extends Program
{
  /** This run method asks for the users input to get two fractions.
    * It then calls the methods from the Fraction.java class to calculate and print the sum, difference,
    * product, and quotient of the fractions.
    * 
    * 
    */
  public void run()
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the first Fraction: ");
    String fraction1 = sc.nextLine();
    int slash = fraction1.indexOf('/');
    int numerator1 = Integer.parseInt(fraction1.substring(0,slash));
    int denominator1 = Integer.parseInt(fraction1.substring(slash+1));
    Fraction fract1 = new Fraction(numerator1,denominator1);
    
    System.out.println("Enter the second Fraction: ");
    String fraction2 = sc.nextLine();
    int slash2 = fraction2.indexOf('/');
    int numerator2 = Integer.parseInt(fraction2.substring(0,slash2));
    int denominator2 = Integer.parseInt(fraction2.substring(slash2+1));
    Fraction fract2 = new Fraction(numerator2,denominator2);
    
    System.out.println("Sum: " + fract1.add(fract2).toString());
    System.out.println("Difference: " + fract1.add(fract2.negate()).toString());
    System.out.println("Product: " + fract1.multiply(fract2).toString());
    System.out.println("Division: " + fract1.multiply(fract2.inverse()).toString());
    
  }
}