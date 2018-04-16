import java.io.*;

import java.util.*;


public class RandomWord
{
  private ArrayList<String> wordArrayList;
  
  private Random random;
  
  public RandomWord(String fileName) throws FileNotFoundException 
  {
    Scanner scanner = null; 
    
    try{
      scanner = new Scanner(new File(fileName)); 
    }
    catch(FileNotFoundException e)
    {
      throw e; 
    }
    this.wordArrayList = new ArrayList<String>();
    
    while (scanner.hasNext())
    {
      this.wordArrayList.add(scanner.next()); 
    }
    scanner.close();
  }
  
  public String next()
  {
   return this.wordArrayList.get(this.random.nextInt(this.wordArrayList.size()));
   
  }
  
}