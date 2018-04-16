import java.io.*;
import mydatastructures.*;

public class BinaryTreeDriver {
  
  public static void main(String args[]) {
    BSTInterface<Integer> bst = new BinarySearchTree<Integer>();
    System.out.println("bst.add(15) : " + bst.add(15));
    System.out.println("bst.add(20) : " + bst.add(20)); 
    System.out.println("bst.add(17) : " + bst.add(17));
    System.out.println("bst.add(20) : " + bst.add(20));
    System.out.println("bst.add(25) : " + bst.add(25));
    System.out.println("bst.add(25) : " + bst.add(25));
    System.out.println("bst.add(5) : " + bst.add(5));
    System.out.println("bst.add(25) : " + bst.add(25));
    System.out.println("bst.add(4) : " + bst.add(4));
    System.out.println("bst.add(9) : " + bst.add(9));
    System.out.println("bst.add(8) : " + bst.add(8));
    System.out.println("bst.add(13) : " + bst.add(13));    
    System.out.println("bst.add(11) : " + bst.add(11));  
    System.out.println("bst.add(10) : " + bst.add(10));
    System.out.println("bst.add(12) : " + bst.add(12));
    System.out.println("bst.add(3) : " + bst.add(3));
    System.out.println(bst);  
    System.out.println("******************************************************************");    
    System.out.println("PREORDER TRAVERSAL:");
    System.out.println(bst.preOrderTraverse());
    System.out.println();    
    System.out.println("INORDER TRAVERSAL:");
    System.out.println(bst.inOrderTraverse());
    System.out.println();
    System.out.println("POSTORDER TRAVERSAL:");
    System.out.println(bst.postOrderTraverse());
    System.out.println();
    System.out.println("******************************************************************");
    System.out.println("bst.contains(5) : " + bst.contains(5));
    System.out.println("bst.contains(15) : " + bst.contains(15));
    System.out.println("bst.contains(17) : " + bst.contains(17));
    System.out.println("bst.contains(20) : " + bst.contains(20));
    System.out.println("bst.contains(25) : " + bst.contains(25));    
    System.out.println("bst.contains(4) : " + bst.contains(4));    
    System.out.println("bst.contains(9) : " + bst.contains(9));    
    System.out.println("bst.contains(10) : " + bst.contains(10)); 
    System.out.println("bst.contains(11) : " + bst.contains(11));  
    System.out.println("bst.contains(12) : " + bst.contains(12));
    System.out.println("bst.contains(13) : " + bst.contains(13));      
    System.out.println("bst.contains(9) : " + bst.contains(9));          

  }
}