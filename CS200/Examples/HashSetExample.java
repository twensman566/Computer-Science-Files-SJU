import java.util.*;

public class HashSetExample {
  
  public static void main(String[] args) {
    
    Set<String> hSet1=new HashSet<String>();
    System.out.println("Inserting elements c, a, b, d & d ...");
    hSet1.add("c");
    hSet1.add("a");
    hSet1.add("b");
    hSet1.add("d");
    // duplicate elements is not permitted
    hSet1.add("d"); 
    System.out.println("Initially size of set 1 is :"+hSet1.size());
    System.out.print("Set 1 contains: ");
    for(String s : hSet1){
      System.out.print(s+ " ");
    }
    System.out.println();
    System.out.println("hSet1="+hSet1);
    System.out.println("******************************************************************");
    hSet1.remove("d");
    System.out.println("After remove(d) size of set 1 is :"+hSet1.size());
    System.out.println("hSet1="+hSet1);
    System.out.println("******************************************************************");
    
    HashSet<String> hSet2=new HashSet<String>();
    hSet2.add("a");
    hSet2.add("x");
    hSet2.add("c");
    System.out.println("Initially size of set 2 is :"+hSet2.size());
    System.out.println("hSet2="+hSet2);
    System.out.println("******************************************************************");
    System.out.println("Is set 1 a subtset of set 2? " + hSet2.containsAll(hSet1));
    System.out.println("******************************************************************");
    
    //(1) union and subset
    hSet2.addAll(hSet1);
    System.out.println("set 2 now contains set 1 union set 2: " + hSet2);
    System.out.println("Is set 1 a subtset of set 2? " + hSet2.containsAll(hSet1));
    System.out.println("******************************************************************");
    
    //(2) intersection
    /*hSet2.retainAll(hSet1);
    System.out.println("set 2 now contains set 1 intersection set 2: " + hSet2);
    System.out.println("******************************************************************");*/
    
    //(3) difference
    /*hSet2.removeAll(hSet1);
    System.out.println("set 2 now contains set 1 difference/minus set 2: " + hSet2);
    System.out.println("******************************************************************");*/
    hSet2.clear();
  }
}
