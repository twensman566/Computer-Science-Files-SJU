// PrintWriter
import java.io.PrintWriter;

// Scanner
import java.util.Scanner;

// FileChooser
import fileChooser.*;


import java.util.*; 


/**
 * Utilities for double arrays
 */
public class DoubleUtilities
{
  /**
   * Selects a file, reads the file and returns a double array of data from the
   * file.
   *
   * @return a double array containing the data read from the file
   */
  public static double [] readFile()
  {
    Scanner scanner = FileChooser.openScanner();
    int i = scanner.nextInt();
    
    
    double [] newArray = new double[i];
    
    for(int j = 0; j<i; j++)
    {
      newArray[j] = scanner.nextDouble();
      
    }
    
    //*** Complete this method
    
    return newArray;
  }
  
  
  /**
   * Writes the specified double array into a selected file.
   *
   * @param array the array of doubles to write
   */
  public static void writeFile(double [] doubleArray)
  {
    PrintWriter printwriter = FileChooser.openPrintWriter();        
    printwriter.println(doubleArray.length);
    //*** Complete this method
    for (int i=0; i< doubleArray.length; i++)
    {
      printwriter.write(doubleArray[i] + "\n");
    }
    printwriter.close();
  }
  
  
  /**
   * Generates size random double values and returns an array containing those
   * values.
   * 
   * @param  numDoubles the number of values to generate
   * @param  low        the lower bound of values to generate
   * @param  high       the upper bound of values to generate
   *
   * @return an array containing size random double values 
   */
  public static double [] generateValues(int numDoubles, double low, double high)
  {
    //*** Complete this method
    double [] doubles = new double[numDoubles];
    Random rand = new Random();
    for (int i=0; i <numDoubles; i++)
    {
      double randomValue = low + (high - low) * rand.nextDouble();
      //System.out.println(randomValue);
      doubles[i] = randomValue;
    }
    
    return doubles;
  }
  
  
  /**
   * Sorts an array of double values using the insertionSort algorithm.
   *
   * @param array the array of doubles to sort
   */
  public static void sort(double [] array)
  {
    //*** Complete this method
    double temp;
    for(int i = 1; i < array.length; i++)
    {
      temp = array[i];
      int j = i-1;
      while(j>=0 && array[j]>temp)
      {
        array[j+1] = array[j];
        j--;
      }
      array[j+1] = temp;
    }
    
  }
}
