import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class WordSorter
{
  public static void main(String[] args)
  {
    File file = new File(args[0]);
    
    try
    {
      Scanner wordReader = new Scanner(file);
      PrintWriter smallWriter = new PrintWriter("smallWords.txt");
      PrintWriter mediumWriter = new PrintWriter("mediumWords.txt");
      PrintWriter largeWriter = new PrintWriter("largeWords.txt");
      
      while(wordReader.hasNext())
      {
        String word = wordReader.next();
        word = word.replaceAll("\\p{Punct}","");
        int wordLength = word.length();
        
        if(wordLength >= 3 && wordLength <= 5)
        {
          smallWriter.println(word);
        }
        else if(wordLength >= 6 && wordLength <= 8)
        {
          mediumWriter.println(word);
        }
        else if(wordLength > 8)
        {
          largeWriter.println(word);
        }
      }
      
      smallWriter.close();
      mediumWriter.close();
      largeWriter.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File does not exist");
    }
  }
}