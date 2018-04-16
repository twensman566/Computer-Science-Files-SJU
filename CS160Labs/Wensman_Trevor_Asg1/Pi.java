import java.util.Scanner;
import acm.program.Program;

public class Pi extends Program
{
  
  public static void main(String[] args) 
  {
    
// Create a Scanner object
    
    System.out.println("Term \t\t\t\tPi\n\n");
    
    // Prompt the user to enter input
    System.out.println("Enter number of terms"); 
    Scanner in = new Scanner(System.in);
    System.out.print("Enter the number of iterations you want:  ");
    int count = in.nextInt();
    double denominator = 1;
// value of num user entered
    double pi = 0;
    int number = 1;
    for( int x=0; x< count; x++)
    {
      if(x%2 == 0) 
      {
// if the remainder of `x` is 0
        pi = pi + (1/denominator);
      }
      else
      {
        pi = pi - (1/denominator);    
      }
      denominator = denominator + 2;
      pi = pi * 4;
      
      System.out.println(number+"\t\t\t\t"+pi);  
      number = number + 1;
      pi = pi /4;

    }
  }
}