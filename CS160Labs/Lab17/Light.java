/**
 * Interface for a light that can be OFF or ON
 */
public interface Light
{
  LightState state = LightState.OFF;
  /**
   * Get the current state of this Light
   *
   * @return the current state of this Light
   */
  public LightState getState();


  /**
   * Determine whether this Light is ON
   *
   * @return true if and only if the state of this Light is ON
   */
  public boolean isOn();


  /**
   * Set the state of this light to the specified newState
   *
   * @param newState the state this Light is to be set to
   */
  public void setState(LightState newState);


  /**
   * Turn this Light ON
   */
  public void turnOn();


  /**
   * Turn this Light OFF
   */
  public void turnOff();


  /**
   * Toggle the state of this Light to the other state; i.e., if it is currently
   * ON, turn it OFF; if it is currently OFF, turn it ON
   */
  public void toggle();


  /**
   * Returns a string representation of this Light. For classes implementing
   * this interface, it should return the name of the class, followed by '.' and
   * then by the current state--OFF or ON.
   *
   * @return a string representation of this Light
   */
  public String toString();
}
