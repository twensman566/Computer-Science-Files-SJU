// PrintWriter
import java.io.PrintWriter;
import fileChooser.*;
import java.util.*; 
import java.io.*;
import java.lang.*;


public class WordSorter
{
  
  public static void main(String [] args)
  {
    
    String result ="";
    for(String arg: args)
    {
      result +=arg; 
    }
    System.out.println(result);
    if (args.length > 0)
    {
      for(String word : result.split(" "))
      {
        if(word.length()>8)
        {
          
        }
        else if(word.length()>5)
        {
          
        }
        else if(word.length()>2)
        {
          
        }
        else
        {
          
        }
      }
    }
    else
    {
      System.out.println("You must provide at least one file name to process");
    }
  }
  
  
  
  
}