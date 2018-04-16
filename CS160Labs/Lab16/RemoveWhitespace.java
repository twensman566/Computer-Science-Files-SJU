// File, FileNotFoundException
import java.io.*;

// Scanner
import java.util.Scanner;


/**
 * Program that reads a text file and prints the file with all the whitespace
 * (except line breaks) removed.
 */
public class RemoveWhitespace
{
  /**
   * Read the lines of the file, remove whitespace characters and echo the lines
   * to standard output.
   */
  public static void run(String path) throws FileNotFoundException
  {
    Scanner scanner = new Scanner(new File(path));

    /* Modify scanner delimiter so that the hasNext() and next() method return
     * chars instead of strings. */
    scanner.useDelimiter("");

    while (scanner.hasNext())
    {
      char c = scanner.next().charAt(0);

      if (!Character.isWhitespace(c))
      {
        System.out.print(c);
      }
      else if (c == '\n')
      {
        System.out.println();
      }
    }

    scanner.close();
  }


  /**
   * Entry point for program.
   */
  public static void main(String [] args)
  {
    if (args.length > 0)
    {
      for (String arg : args)
      {
        try
        {
          RemoveWhitespace.run(arg);
        }
        catch (FileNotFoundException e)
        {
          System.out.println("Could not fine file '" + arg + "'");
        }
      }
    }
    else
    {
      System.out.println("You must provide at least one file name to process");
    }
  }
}
