
public class RecursiveMethods {
  
  public static int length(String str) {
    if (str == null || str.equals(""))
      return 0;
    else
      return 1 + length(str.substring(1));
  }
  
  
  public static void printChars(String str) {
    if (str == null || str.equals("")) {
      return;
    }
    else {
      System.out.println(str.charAt(0));
      printChars(str.substring(1));
    }
  }
  
  public static void printCharsReverse(String str) {
    if (str == null || str.equals("")) {
      return;
    }
    else {
      printCharsReverse(str.substring(1));
      System.out.println(str.charAt(0));
    }
  }
  
  public static int factorial(int n) {
    if (n == 1)
      return 1;
    else
      return n * factorial(n - 1);
  }
  
  public static int fibonacci(int n) {
    if (n < 2)
      return 1;
    else
      return fibonacci(n - 1) + fibonacci(n - 2);
  }
  
  
  public static int linearSearch(int[] items,int target, int pos) {
    //COMPLETE ME*******************************************************************************
    // for unsuccessful search ==> return -1; 
    // for successful search ==> return array location of match (i.e. position in array) 
    
    if(items[pos] == target)
    {
      return pos;
    }
    else if(items.length < pos)
      return -1;
    return linearSearch(items, target, pos++);
  }
  
  public static int binarySearch(int[] items,int target, int first, int last) {
    //COMPLETE ME*******************************************************************************  
    // Base case for unsuccessful search: (first > last) ==> return -1; 
    // Base case for successful search: target==items[middle] ==> return location of match
    
    return -1;
  }  
}
