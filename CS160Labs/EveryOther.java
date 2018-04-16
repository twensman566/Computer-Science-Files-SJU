public class EveryOther extends Tester
{
  
  public static int everyOther( int [] array, int i)
  {
    int sum = 0;
    if(i== array.length)
    {
      return sum;
    }
    else
    {
      sum = sum + everyOther(array, i+2);
      
    }
    return sum;
  }
}