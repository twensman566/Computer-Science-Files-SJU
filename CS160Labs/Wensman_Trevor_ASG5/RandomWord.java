import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RandomWord
{
  private File file;
  private ArrayList<String> wordList;
  
  public RandomWord(String fileName)
  {
    this.file = new File(fileName);
    try
    {
      Scanner reader = new Scanner(this.file);
      
      wordList = new ArrayList<String>();
      while(reader.hasNext())
      {
        String word = reader.next();
        wordList.add(word);
      }
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File does not exist.");
    }
  }
  
  public String next()
  {
    Random whichWord = new Random(System.currentTimeMillis());
    return wordList.get(whichWord.nextInt(wordList.size()));
  }
}