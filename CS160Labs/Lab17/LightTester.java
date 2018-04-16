/**
 * Program to test classes implementing the Light interface
 */
public class LightTester
{
  private Light light;


  /**
   * Constructor method
   */
  public LightTester()
  {
    this.light = new TextLight();
  }


  /**
   * Run the light tester
   */
  public void run()
  {
    System.out.println("Testing initial state");
    System.out.println("The light is: " + this.light + "; should be OFF");
    System.out.println();
    
    System.out.println("Testing isOn()");
    if (!this.light.isOn()) System.out.println("The light is OFF as it should be");
    System.out.println();
    
    System.out.println("Testing turnOn()");
    this.light.turnOn();
    System.out.println("The light is: " + this.light + "; should be ON");
    System.out.println("Testing isOn() again");
    if (this.light.isOn()) System.out.println("The light is ON as it should be");
    System.out.println();
    
    System.out.println("Testing turnOff()");
    this.light.turnOff();
    System.out.println("The light is: " + this.light + "; should be OFF");
    System.out.println();
    
    System.out.println("Testing toggle()");
    this.light.toggle();
    System.out.println("The light is: " + this.light + "; should be ON");
    System.out.println("Toggle again");
    this.light.toggle();
    System.out.println("The light is: " + this.light + "; should be OFF");
    System.out.println();
    
    System.out.println("Testing setState(ON) and getState()");
    this.light.setState(LightState.ON);
    System.out.println("The light is: " + this.light.getState() + "; should be ON");
    System.out.println("Now setState(OFF) and getState()");
    this.light.setState(LightState.OFF);
    System.out.println("The light is: " + this.light.getState() + "; should be OFF");
    System.out.println();
  }


  /**
   * Creat LightTester and start it
   */
  public static void main(String [] args)
  {
    new LightTester().run();
  }
}
