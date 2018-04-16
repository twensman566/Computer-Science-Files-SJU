



import acm.program.Program;
import java.util.Scanner;


public class DigitSum extends Program
{
  public void run()
  {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a random integer:  ");
    int num = in.nextInt();
    int sum = 0;
    while (num > 0)
    {
      sum = sum + num % 10;
      num = num / 10;
    }
    System.out.println(sum);
  }
}