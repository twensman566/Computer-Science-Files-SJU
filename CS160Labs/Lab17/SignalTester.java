/**
 * Program to test classes implementing the TrafficSignal interface
 */
public class SignalTester
{
  
  private TrafficSignal signal;


  /**
   * Initialize the TrafficSignal
   */
  public SignalTester()
  {
    this.signal = new TextTrafficSignal();
  }
 

  /**
   * Run the signal tester
   */
  public void run()
  {
    System.out.println("Testing initial state");
    System.out.println("The signal is: " + this.signal + "; should be OFF");
    System.out.println();
    
    System.out.println("Testing turnOn()");
    this.signal.turnOn();
    System.out.println("The signal is: " + this.signal + "; should be FLASHING_RED");
    System.out.println();
    
    for (int i = 0; i < 4; i++) {
      System.out.println("Testing advance() and getState()");
      this.signal.advance();
      System.out.println("The signal is: " + this.signal);
      System.out.println("  its state is:" + this.signal.getState());
      System.out.println();
    }
    System.out.println();
    
    System.out.println("Testing turnOn() when signal is already on");
    this.signal.turnOn();
    System.out.println("The signal is: " + this.signal + "; should be unchanged");
    System.out.println();
    
    System.out.println("Testing setFlashing()");
    this.signal.setFlashing();
    System.out.println("The signal is: " + this.signal + "; should be FLASHING_RED");
    System.out.println();
    
    System.out.println("Testing turnOff()");
    this.signal.turnOff();
    System.out.println("The signal is: " + this.signal + "; should be OFF");
    System.out.println();
  }
  
  /**
   * Creat SignalTester and start it
   */
  public static void main(String [] args)
  {
    new SignalTester().run();
  }
}
