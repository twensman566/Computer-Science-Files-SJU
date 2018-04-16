/* A class for recursive methods
   @author Koffman and Wolfgang
 */

public class RecursiveMethodsDriver {
  public static void main(String[] args){
    //String examples
    System.out.println("length of CSCI200 : " + RecursiveMethods.length("CSCI162"));
    System.out.println("characters in CSCI200 : ");
    RecursiveMethods.printChars("CSCI200");    
    System.out.println("reverse of CSCI200 : ");
    RecursiveMethods.printCharsReverse("CSCI200");
    //math examples
    System.out.println("factorial of 5 : " + RecursiveMethods.factorial(5));
    System.out.println("fibonacci of 8 : " + RecursiveMethods.fibonacci(8));  
    
    //searching examples
    int[] arr = {0,10,20,30,40,50,60,70};
    System.out.println("Linear search: 60 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.linearSearch(arr,60,0));
    System.out.println("Linear search: 80 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.linearSearch(arr,80,0));

    System.out.println("Binary search: 60 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.binarySearch(arr,60,0,arr.length-1));
    System.out.println("Binary search: 80 in {0,10,20,30,40,50,60,70} ? : " + RecursiveMethods.binarySearch(arr,80,0,arr.length-1));
    
    

  }
}
