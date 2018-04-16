// Program
import acm.program.Program;


/**
 *  This program creates a Paladin character from the PC game Diablo II and
 *  outputs some information about said character.
 */
public class DiabloII extends Program
{
  /** Entry point for ACM Program -- this is where the program will start */
  public void run()
  {
    /* Create a new instance of the Paladin class and assign a reference to it
     * to the variable myPaladin */
    Paladin myPaladin = new Paladin("Odal");

    /* Create a new instance of the Paladin class and assign a reference to it
     * to the variable myPaladin */
    Paladin yourPaladin = new Paladin("Alkali");

    // print name of my paladin
    this.println("The Paladin object referenced by the variable myPaladin is named '" + myPaladin.getName() + "'");

    // print name of your paladin
    this.println("The Paladin object referenced by the variable yourPaladin is named '" + yourPaladin.getName() + "'");
  }
}
