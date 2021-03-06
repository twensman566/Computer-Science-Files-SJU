/**
 * Interface for a light that can be OFF or ON
 */
public class TextLight implements Light
{
  private LightState state;
  public TextLight()
  {
   this.state = LightState.OFF; 
  }
  /**
   * Get the current state of this Light
   *
   * @return the current state of this Light
   */
  public LightState getState()
  {
    
    return this.state;
  }
  
  
  /**
   * Determine whether this Light is ON
   *
   * @return true if and only if the state of this Light is ON
   */
  public boolean isOn()
  {
    if (this.getState() == LightState.ON)
    {
      return true; 
    }
    else
    {
      return true;
    }
  }
  
  /**
   * Set the state of this light to the specified newState
   *
   * @param newState the state this Light is to be set to
   */
  public void setState(LightState newState)
  {
    this.state = newState;
  }
  
  /**
   * Turn this Light ON
   */
  public void turnOn()
  {
    
    this.state = LightState.ON;
  }
  
  
  /**
   * Turn this Light OFF
   */
  public void turnOff()
  {
    this.state = LightState.OFF;
  }
  
  /**
   * Toggle the state of this Light to the other state; i.e., if it is currently
   * ON, turn it OFF; if it is currently OFF, turn it ON
   */
  public void toggle()
  {
    if(this.state == LightState.ON)
    {
      this.turnOff();
    }
    else
    {
      this.turnOn();  
    }
    
  }
  
  /**
   * Returns a string representation of this Light. For classes implementing
   * this interface, it should return the name of the class, followed by '.' and
   * then by the current state--OFF or ON.
   *
   * @return a string representation of this Light
   */
  public String toString()
  {
    return "TextLight." + this.state;
  }
}
