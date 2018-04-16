public class Tester
{
  public static void main(String args[])
  {
    int [] intArray = new int [5];
    for(int i = 0; i<=5;i++)
    {
      intArray[i] = i; 
    }
    EveryOther.everyOther(intArray,0);
  }
}