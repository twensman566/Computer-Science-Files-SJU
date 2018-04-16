/**
 * Interface for a traffic signal that can be in any of the specified states
 */
public interface TrafficSignal
{
  /**
   * Get the current state of this TrafficSignal
   *
   * @return the current state of this TrafficSignal
   */
  public TrafficSignalState getState();


  /**
   * Turn this TrafficSignal ON with an initial state of FLASHING_RED; if it was
   * already ON, the state should be unchanged
   */
  public void turnOn();


  /**
   * Turn this TrafficSignal OFF
   */
  public void turnOff();


  /**
   * Advance this TrafficSignal to its next state:
   *  RED    -> GREEN
   *  GREEN   -> YELLOW
   *  YELLOW   -> RED
   *  FLASHING_RED -> RED
   *  OFF    -> OFF
   */
  public void advance();


  /**
   * Set the state of this TrafficSignal to FLASHING_RED
   */
  public void setFlashing();


  /**
   * Returns a string representation of this TrafficSignal. For classes
   * implementing this interface, it should return the name of the class,
   * followed by '.' and then by the current state.
   *
   * @return a string representation of this TrafficSignal
   */
  public String toString();
}
