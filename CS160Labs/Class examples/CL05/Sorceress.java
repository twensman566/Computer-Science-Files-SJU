/**
 *  This class encapsulates the functionality of the Paladin character class
 *  from the PC game Diablo II.
 */
public class Sorceress {
  // name of the Paladin
  public String name;


  /**
   *  Constructor method for a Paladin character
   *
   *  @param name The name of the Paladin being created
   */
  public Sorceress(String name)
  {
    /* assign the value of the name parameter to the name field for this Paladin
     * object */
    this.name = name;
  }


  /**
   *  Get the name of the Paladin
   *
   *  @return The name of the Paladin
   */
  public String getName()
  {
    // access the value of the name field for this Paladin object and return it
    return this.name;
  }
}
