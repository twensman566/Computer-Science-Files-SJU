/*File: Tree.java
 * 
 * 
 * This program
 * 
 */



import java.util.*;
import java.io.*;

public class Tree
{
  
  public static void main(String args[])
  {
    tree ("/net/home/twensman001/CS160Labs","");
  }
  
  private static void tree (String path, String prefix)
  {
    File directory = new File(path+prefix);
    
    boolean hierarchy = false;
    
    if(prefix != "")
    {
      hierarchy = true; 
    }
    File[] fList = directory.listFiles();
    
    for (File file : fList)
    {
      if(file.isFile())
      {
        if(hierarchy == false)
        {
          System.out.println("|--" + file.getName());
        }
        if(hierarchy == true)
        {
          
          System.out.println("    |--" + file.getName());
          
          
        }
      }
      
      if(file.isDirectory())
      {
        System.out.println("'--" + file.getName()); 
        
        tree(path,prefix + "/"+file.getName());
        
      }
      
    }
    
  }
  
}