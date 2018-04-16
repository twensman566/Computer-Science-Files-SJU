// Program
import acm.program.Program;

/*
 * This program accepts a full name, given in the form "First Middle Last", and outputs the middle
 * name only.
 * 
 * Sample algorithm to accomplish this task:
 * 1. Get the full name from the user, call it fullName
 * 2. Compute the location of the first space, call it firstSpaceLocation
 * 3. Compute the location of the second space, call it secondSpaceLocation
 * 4. Compute the middle name as the substring string of fullName starting from
 *    firstSpaceLocation + 1 to secondSpaceLocation, call it middleName
 * 5. Display middleName
 */


/**
 *  This program accepts a full name, given in the form "First Middle Last", and
 *  outputs the middle name only.
 */
public class MiddleName extends Program
{
  /** Entry point for ACM Program -- this is where the program will start */
  public void run()
  {
    // declare and initialize the /local/ variables
    int firstSpaceLocation = 0, secondSpaceLocation = 0, middleNameLength = 0;
    String fullName = "", middleName = "";

    /* step 1 (this steps uses the method /this.readLine()/ to get a full name
     * from the user) */
    fullName = this.readLine("Enter your full name: ");

    /* step 2 & 3 (these steps call the indexOf() /method/ of the String /class/
     * on the /object/ fullName. the indexOf() /method/ takes the String to look
     * for and the location to start looking for it in the String on which it is
     * being called. so to look for the first space, we start at location 0, to
     * look for the second space, we start one character after wherever we found
     * the first space. */
    firstSpaceLocation = fullName.indexOf(" ", 0);
    secondSpaceLocation = fullName.indexOf(" ", firstSpaceLocation + 1);

    /* step 4 (this step calls the substring() /method/ of the String /class/ on
     * the /object/ fullName. the substring() /method/ takes the starting
     * and ending location of the substring. the starting location is the
     * character after the first space, since the first space is not included.
     * */
    middleName = fullName.substring(firstSpaceLocation + 1, secondSpaceLocation);

    // step 5 (this steps uses the method /this.println()/ to output the results)
    this.println("Your middle name is '" + middleName + "'");

  }
}
