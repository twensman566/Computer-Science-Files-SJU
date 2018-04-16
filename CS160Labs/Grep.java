// File, FileNotFoundException
import java.io.*;

import java.util.*;

  
public class Grep
{
  /**
   * Entry-point for Grep.grep(...) method.
   *
   * @param searchString the string to search for in the file
   * @param filePath     the path of the file/directory for which a tree shall
   *                     be created
   */
  public static void grep(String searchString, String filePath) throws FileNotFoundException
  {
    File file = new File(filePath);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();

      if (line.contains(searchString))
      {
        System.out.println(file.getName() + ": "  + line);
      }
    }

    scanner.close();
  }


  /**
   * The entry point for the program. If this program is called from the
   * command-line with at least two arguments, then this program will look for
   * the first argument in each of the files specified by the remaining
   * arguments. If there is less than two arguments, the program will exit
   * silently.
   */
  public static void main(String [] args)
  {
    if (args.length > 1)
    {
     grep( 
    }
    /* args.length must be greater than 1 for this to work, since we need a
     * string to search for as well as some number of files to search for it in
     * */
  }
}
