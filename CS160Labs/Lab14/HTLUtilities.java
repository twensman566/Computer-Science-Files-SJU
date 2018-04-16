// IOModel
import acm.io.IOModel;


/**
 * Utility class for the HeadTailList
 */
public class HTLUtilities
{
  // List traversal utility methods
  public static String displayList(HeadTailList<String> list)
  {
    if(list.isEmpty())
    {
      return "EMPTY LIST";
    }
    else
    {
      if(list.tail().isEmpty())
      {
        return list.head(); 
      }
      else
      {
        return list.head() + " " + displayList(list.tail()); 
      }
    }
  }
  public static <ElementType> boolean find(HeadTailList<ElementType> list, String element)
  {
    if(list.isEmpty())
    {
      return false; 
    }
    else if (list.head().equals(element))
    {
      return true;
    }
    else
    {
     return find(list.tail(), element); 
    }
  }
  
  /**
   * Returns the number of elements in a HeadTailList
   *
   * @param  list the list to count
   * @return the number of elements in list
   */
  public static <ElementType> int count(HeadTailList<ElementType> list)
  {
    if (list.isEmpty())
    {
      return 0;
    }
    else // there's at least one element
    {
      return 1 + count(list.tail());
    }
  }
  
  
  /**
   * Returns the sum of the elements in a list of Integers
   *
   * @param  list the list of integers to sum
   * @return the sum of the elements in list
   */
  public static int sumIntList(HeadTailList<Integer> list)
  {
    if (list.isEmpty())
    {
      return 0;
    }
    else // there's at least one element
    {
      return list.head() + sumIntList(list.tail());
    }
  }
  
  
  /**
   * Returns the sum of the elements in a list of Doubles
   *
   * @param  list the list of doubles to sum
   * @return the sum of the elements in list
   */
  public static double sumDoubleList(HeadTailList<Double> list)
  {
    if (list.isEmpty())
    {
      return 0;
    }
    else // there's at least one element
    {
      return list.head() + sumDoubleList(list.tail());
    }
  }
  
  
  /**
   * Returns the mean of a list of Doubles
   *
   * @param  list the list of doubles to compute the mean of
   * @return the mean of the elements in list; 0 it the list is empty
   */
  public static double meanDoubleList(HeadTailList<Double> list)
  {
    if (list.isEmpty())
    {
      return 0;
    }
    else
    {
      return (sumDoubleList(list) / count(list));
    }
  }
  
  
  /**
   * Reverse a HeadTailList
   *
   * @param  source the list to reverse
   * @return the reverse of source
   */
  public static <ElementType> HeadTailList<ElementType> reverse(HeadTailList<ElementType> source)
  {
    HeadTailList<ElementType> result = new LinkedHeadTailList<ElementType>();
    while  (!source.isEmpty())
    {
      ElementType element = source.head();
      result = new LinkedHeadTailList<ElementType>(element, result);
      source = source.tail();
    }
    return result;
  }
  
  
  /**
   * Removes the specified element from a HeadTailList
   *
   * @param  source the list to cull from
   * @param  element the element to cull
   * @return the list with element culled
   */
  public static <ElementType> HeadTailList<ElementType> cull(HeadTailList<ElementType> source, ElementType element)
  {
    if (source.isEmpty())
    {
      return source;
    }
    else
    {
      HeadTailList<ElementType> tail = cull(source.tail(), element);
      if (source.head().equals(element))
      {
        return tail;
      }
      else
      {
        return new LinkedHeadTailList<ElementType>(source.head(), tail);
      }
    }
  }
  
  
  /**
   * Removes any duplicates from a HeadTailList using cull()
   *
   * @param  source the list to cull duplicates from
   * @return the original list culled of duplicates
   */
  public static <ElementType> HeadTailList<ElementType> cullDuplicates(HeadTailList<ElementType> source)
  {
    if (source.isEmpty())
    {
      return source;
    }
    else
    {
      ElementType element     = source.head();
      HeadTailList<ElementType> tail = cull(source.tail(), element);
      return new LinkedHeadTailList<ElementType>(element, cullDuplicates(tail));
    }
  }
  
  
  // Input utility methods
  
  
  /**
   * Read a list of n ints
   *
   * @param  io the IOModel (Console or Dialog) from which to read
   * @param  n  the number of ints to read
   * @return a HeadTailList<Integer> containing the ints read
   */
  public static HeadTailList<Integer> readIntList(IOModel io, int n)
  {
    if (n <= 0)
    {
      return new LinkedHeadTailList<Integer>();
    }
    else
    {
      int head = io.readInt();
      HeadTailList<Integer> tail = readIntList(io, n - 1);
      return new LinkedHeadTailList<Integer>(head, tail);
    }
  }
  
  
  /**
   * Read a list of n ints with a prompt
   *
   * @param  io     the IOModel (Console or Dialog) from which to read
   * @param  n      the number of ints to read
   * @param  prompt the prompt string to use with each input
   * @return a HeadTailList<Integer> containing the ints read
   */
  public static HeadTailList<Integer> readIntList(IOModel io, int n, String prompt)
  {
    if (n <= 0)
    {
      return new LinkedHeadTailList<Integer>();
    }
    else
    {
      int head = io.readInt(prompt);
      HeadTailList<Integer> tail = readIntList(io, n - 1, prompt);
      return new LinkedHeadTailList<Integer>(head, tail);
    }
  }
  
  
  /**
   * Read a list of ints terminated by the signal value sig
   *
   * @param  io  the IOModel (Console or Dialog) from which to read
   * @param  sig the signal value that terminates the list
   * @return an HeadTailList<Integer> containing the ints read
   */
  public static HeadTailList<Integer> readIntListSig(IOModel io, int sig)
  {
    int head = io.readInt();
    if (head == sig)
    {
      return new LinkedHeadTailList<Integer>();
    }
    else
    {
      HeadTailList<Integer> tail = readIntListSig(io, sig);
      return new LinkedHeadTailList<Integer>(head, tail);
    }
  }
  
  
  /**
   * Read a list of ints terminated by the signal value sig
   *
   * @param  io  the IOModel (Console or Dialog) from which to read
   * @param  sig the signal value that terminates the list
   * @param  prompt the prompt string to use with each input
   * @return an HeadTailList<Integer> containing the ints read
   */
  public static HeadTailList<Integer> readIntListSig(IOModel io, int sig, String prompt)
  {
    int head = io.readInt(prompt);
    if (head == sig)
    {
      return new LinkedHeadTailList<Integer>();
    }
    else
    {
      HeadTailList<Integer> tail = readIntListSig(io, sig, prompt);
      return new LinkedHeadTailList<Integer>(head, tail);
    }
  }
  
  public static HeadTailList<String> readStringListSig( IOModel io, String sig, String prompt)
  {
    String head = io.readLine(prompt);
    if(head.equals(sig))
    {
      return new LinkedHeadTailList<String>(); 
    }
    else
    {
      HeadTailList<String> tail = readStringListSig(io, sig, prompt);
      return new LinkedHeadTailList<String>(head, tail);
    }
  }
}
