/** This function takes two fractions and adds, subtracts, multiplys, and divides them.
  * 
  */

public class Fraction
{
  private int numerator, denominator;
  
  /** This method defines the fraction
    * 
    * @param theNumerator is the integer value of the numerator
    * @param theDenominator is the integer value of the denominator
    */
  
  public Fraction( int theNumerator, int theDenominator)
  {
    this.numerator = theNumerator;
    this.denominator = theDenominator;
    
  }
  /** This method defines the fraction as an integer.
    * @param aNumerator is the integer value of the numerator.
    */
  public Fraction( int aNumerator)
  {
    this.numerator = aNumerator;
    this.denominator = 1;
  }
  /** This method defines a Fraction as the numerator = 0 and the denominator = 1;
    */
  
  public Fraction ()
  {
    
    this.numerator = 0;
    this.denominator = 1;
  }
  /** This method gets the Numerator
    * @return numerator returns the numerator.
    */
  public int getNumerator()
  {
    return numerator; 
  }
  /** This method gets the Denominator.
    * @return denominator returns the Denominator.
    */
  public int getDenominator()
  {
    return denominator; 
  }
  /** This method adds the two fractions to get a sum of them.
    * 
    * @param theFraction Takes the second fraction as a parameter.
    * @return  the sum of the two fractions.
    */
  
  public Fraction add(Fraction theFraction)
  {
    int newDenominator = theFraction.getDenominator() * this.denominator;
    int newNumerator = (theFraction.getNumerator() * this.denominator) + (this.numerator * theFraction.getDenominator());
    return new Fraction(newNumerator,newDenominator);
  }
  /** This method adds the two fractions to get a sum of them.
    * 
    * @param theFraction Takes the second fraction as a parameter.
    * @return  the difference of the two fractions.
    */
  public Fraction multiply(Fraction theFraction)
  {
    int newDenominator = this.denominator * theFraction.getDenominator();
    int newNumerator = this.numerator * theFraction.getNumerator();
    return new Fraction(newNumerator,newDenominator);
  }
  /** This method sets the numerator to negative.
    * @return    the new fraction.
    */
  
  public Fraction negate()
  {
    int newNumerator = -(this.numerator);
    int newDenominator = this.denominator;
    return new Fraction(newNumerator,newDenominator);
  }
  /** This method switches the numerator and denominator of the fraction to get an inverse
    * @return the flipped fraction.
    */
  
  public Fraction inverse()
  {
    return new Fraction(this.denominator,this.numerator);
    
    /** This method converts the final fraction to a string so it can be printed
      * @return the Fraction */
  }
  public String toString()
  {
    return(getNumerator() + " / " + getDenominator());
  }
}
