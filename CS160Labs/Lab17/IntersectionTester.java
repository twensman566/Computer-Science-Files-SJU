import java.util.Scanner;


/**
 * Program to test classes implementing the Intersection interface
 */
public class IntersectionTester
{
  
  private Intersection intersection;


  /**
   * Initialize the Intersection
   */
  public IntersectionTester()
  {
    this.intersection = new TextIntersection();
  }
 

  /**
   * Run the intersection tester
   */
  public void run()
  {
    Scanner in = new Scanner(System.in);

    System.out.print("Please enter the green time in seconds: ");
    double greenTimeSec  = Double.parseDouble(in.nextLine());
    System.out.print("Please enter the yellow time in seconds: ");
    double yellowTimeSec = Double.parseDouble(in.nextLine());
    System.out.print("Please enter the number of cycles: ");
    int numberOfCycles   = Integer.parseInt(in.nextLine());

    this.intersection.turnOn();
    System.out.println("The intersection is: " + this.intersection + "; should be flashing red");
    
    for (int i=0; i<numberOfCycles; i++) {
      System.out.println("Testing advance()");
      this.intersection.advance();
      System.out.println("The intersection is: " + this.intersection);
      System.out.println();
    }
    
    System.out.println("Testing setFlashing()");
    this.intersection.setFlashing();
    System.out.println("The intersection is: " + this.intersection + "; should be flashing red");
    System.out.println();
    
    System.out.println("Testing turnOff()");
    this.intersection.turnOff();
    System.out.println("The intersection is: " + this.intersection + "; should be off");
    System.out.println();
  }
  
  /**
   * Create IntersectionTester and start it
   */
  public static void main(String [] args)
  {
    new IntersectionTester().run();
  }
}
