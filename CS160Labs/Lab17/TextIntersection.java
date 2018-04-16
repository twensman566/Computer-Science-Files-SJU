/**
 * Interface for an intersection with traffic signals in four directions
 */
public class TextIntersection implements Intersection
{
  /**
   * Get the current state of a directional signal in this intersection
   *
   * @param  direction the direction of the signal to get the state of
   * @return the current state of the specified signal
   */
  private TrafficSignal northBound, southBound, westBound, eastBound;
  
  public TextIntersection()
  {
    this.northBound = new TextTrafficSignal(); 
    this.southBound = new TextTrafficSignal(); 
    this.westBound = new TextTrafficSignal();  
    this.eastBound = new TextTrafficSignal(); 
  }
  public TrafficSignalState getState(Direction direction)
  {
    if (direction == Direction.NORTH)
    {
      return this.northBound.getState();
    }
    else if (direction == Direction.WEST)
    {
      return this.westBound.getState(); 
    }
    else if(direction == Direction.EAST)
    {
      return this.eastBound.getState(); 
    }
    else
    {
      return this.southBound.getState(); 
    }
  }
  
  /**
   * Turn this Intersection ON with an initial state of FLASHING_RED
   * in all directions
   */
  public void turnOn()
  {
    this.northBound.turnOn();
    this.southBound.turnOn();
    this.eastBound.turnOn();
    this.westBound.turnOn();
  }
  
  
  /**
   * Turn OFF all four traffic signals in this Intersection
   */
  public void turnOff()
  {
    this.northBound.turnOff();
    this.southBound.turnOff();
    this.eastBound.turnOff();
    this.westBound.turnOff();
  }
  
  
  /**
   * Advance this Intersection to its next state (N, E, S, W):
   *  R, G, R, G   -> R, Y, R, Y;
   *  R, Y, R, Y   -> G, R, G, R;
   *  G, R, G, R   -> Y, R, Y, R;
   *  Y, R, Y, R   -> R, G, R, G;
   *  FR, FR, FR, FR -> R, G, R, G;
   *  OFF     -> OFF;
   *  any other states -> FR, FR, FR, FR (something went wrong)
   */
  public void advance()
  {
    if(this.northBound.getState() == TrafficSignalState.RED && this.eastBound.getState() == TrafficSignalState.GREEN)
    {
      this.eastBound.advance();
      this.westBound.advance();
    }
    else if(this.northBound.getState() == TrafficSignalState.RED && this.eastBound.getState() == TrafficSignalState.YELLOW)
    {
      this.northBound.advance();
      this.eastBound.advance();
      this.southBound.advance();
      this.westBound.advance();
    }
    else if(this.northBound.getState() == TrafficSignalState.GREEN && this.eastBound.getState() == TrafficSignalState.RED)
    {
      this.northBound.advance();
      this.southBound.advance();
    }
    else if(this.northBound.getState() == TrafficSignalState.YELLOW && this.eastBound.getState() == TrafficSignalState.RED)
    {
      this.eastBound.advance();
      this.northBound.advance();
      this.westBound.advance();
      this.southBound.advance();
    }
    else if(this.northBound.getState() == TrafficSignalState.FLASHING_RED && this.eastBound.getState() == TrafficSignalState.FLASHING_RED)
    {
      this.northBound.advance();
      this.eastBound.advance();
      this.eastBound.advance();
      this.westBound.advance();
      this.westBound.advance();
      this.southBound.advance();
    }
    else
    {
     this.northBound.setFlashing();
     this.southBound.setFlashing();
     this.westBound.setFlashing();
     this.eastBound.setFlashing();
    }
  }
  
  
  /**
   * Set all the signals of this Intersection to FLASHING_RED
   */
  public void setFlashing()
  {
    this.northBound.setFlashing();
    this.southBound.setFlashing();
    this.westBound.setFlashing();
    this.eastBound.setFlashing();
  }
  
  
  /**
   * Returns a string representation of this Intersection. For classes
   * implementing this interface, it should return the name of the class,
   * followed by '.' and then by the current state of each signal.
   *
   * @return a string representation of this Intersection
   */
  public String toString()
  {
    return "\nNorth: " + this.northBound.toString()+"  " + "\n" + " East: " + this.eastBound.toString()+"  " + "\n" + " West: " + this.westBound.toString()+"  " + "\n" + " South: " + this.southBound.toString();
    
    
  }
}
