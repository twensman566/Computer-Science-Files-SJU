/**
 * Interface for a traffic signal that can be in any of the specified states
 */
public class TextTrafficSignal implements TrafficSignal
{
  private TrafficSignalState state;
  private Light red,green,yellow;
  
  public TextTrafficSignal()
  {
   this.state = TrafficSignalState.OFF;
   this.red = new TextLight();
   this.green = new TextLight();
   this.yellow = new TextLight();
  }
  /**
   * Get the current state of this TrafficSignal
   *
   * @return the current state of this TrafficSignal
   */
  public TrafficSignalState getState()
  {
    return this.state;
  }

  /**
   * Turn this TrafficSignal ON with an initial state of FLASHING_RED; if it was
   * already ON, the state should be unchanged
   */
  public void turnOn()
  {
    if(this.getState() == TrafficSignalState.OFF)
    {
      this.state = TrafficSignalState.FLASHING_RED;
      this.red.setState(LightState.FLASHING);
    }
  }

  /**
   * Turn this TrafficSignal OFF
   */
  public void turnOff()
  {
    this.state = TrafficSignalState.OFF;
    this.red.turnOff();
    this.green.turnOff();
    this.yellow.turnOff();
  }

  /**
   * Advance this TrafficSignal to its next state:
   *  RED    -> GREEN
   *  GREEN   -> YELLOW
   *  YELLOW   -> RED
   *  FLASHING_RED -> RED
   *  OFF    -> OFF
   */
  public void advance()
  {
    if(this.getState() == TrafficSignalState.RED)
    {
      System.out.println("here");
      this.state = TrafficSignalState.GREEN;
      this.red.turnOff();
      this.green.turnOn();
    }
    else if(this.getState() == TrafficSignalState.GREEN)
    {
      this.state = TrafficSignalState.YELLOW;
     this.green.turnOff();
     this.yellow.turnOn();
    }
    else if(this.getState() == TrafficSignalState.YELLOW)
    {
      this.state = TrafficSignalState.RED; 
     this.yellow.turnOff();
     this.red.turnOn();
    }
    else if(this.state == TrafficSignalState.FLASHING_RED)
    {
     this.state = TrafficSignalState.RED; 
     this.red.turnOn();
    
    
    }
    else
    {
     this.state = TrafficSignalState.OFF; 
     this.red.turnOff();
     this.yellow.turnOff();
     this.green.turnOff();
    }
  
  }

  /**
   * Set the state of this TrafficSignal to FLASHING_RED
   */
  public void setFlashing()
  {
    
    this.state = TrafficSignalState.FLASHING_RED;
    this.red.setState(LightState.FLASHING);
    this.green.turnOff();
    this.yellow.turnOff();
  }

  /**
   * Returns a string representation of this TrafficSignal. For classes
   * implementing this interface, it should return the name of the class,
   * followed by '.' and then by the current state.
   *
   * @return a string representation of this TrafficSignal
   */
  public String toString()
  {
    return "Traffic Signal: " + " state." + this.state + " red." + red.getState() + " yellow." + yellow.getState() + " green." + green.getState();
  }
}
