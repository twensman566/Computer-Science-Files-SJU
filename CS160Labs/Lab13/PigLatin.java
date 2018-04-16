/**
 *  This class provides methods that convert words and lines of test into Pig
 *  Latin.
 *
 *  The rules are:
 *    1. if a word has no vowels, it stays the same
 *    2. if a word starts with a vowel, add "way" to the end
 *    3. if a word's first vowel is at position i, move all letters up to, but
 *       not including the letter at position i, to the end of the string and
 *       append "ay".
 *
 *  @author  Jim Schnepf, modified by J. Andrew Whitford Holey
 *  @version October 31, 2013
 */
public class PigLatin
{
  /**
   * Returns true if c is an English vowel.
   *
   * @param c character to determine if it is a vowel
   *
   * @return true if c is a vowel, false otherwise
   */
  private static boolean isVowel(char c)
  {
    // convert to lower-case to make comparisons easier
    c = Character.toLowerCase(c);
    
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
  
  
  /**
   * Returns the index of the first vowel in a word, or -1 if there are no
   * vowels.
   *
   * @param s the string from which to find the index of the first vowel
   *
   * @return the index of the first vowel, -1 if s contains no vowels
   */
  private static int indexOfFirstVowel(String s)
  {
    for (int i = 0; i < s.length(); i++)
    {
      if (PigLatin.isVowel(s.charAt(i)))
      {
        return i;
      }
    }
    
    return -1;
  }
  
  
  /**
   * Converts a word into a Pig Latin word.
   *
   * @param word the String containing the word to be converted
   *
   * @return word converted to Pig Latin
   */
  public static String convertWord(String word)
  {
    //*** Fill in your code here following the rules described at the top of
    //*** this file
    String newWord = "";
    //*** This should be removed after you complete this method
    char firstLetter = word.charAt(0);
    if(isVowel(firstLetter))
    {
      //System.out.println(word.charAt(0));
      return newWord = word + "way";
      //System.out.println(newWord);
    }
    
    if(indexOfFirstVowel(word) == -1)
    {
      return (word); 
    }
    
    else
    {
      String part1 = word.substring(0,indexOfFirstVowel(word));
      String part2 = word.substring(indexOfFirstVowel(word));     
      newWord = part2 + part1 + "ay";
      newWord = newWord.toLowerCase();
      if(Character.isUpperCase(firstLetter))
      {
        char newLetter = newWord.charAt(0);
        newLetter = Character.toUpperCase(newLetter);
        newWord = newLetter + newWord.substring(1);
        return newWord;
      }
      else{
        return newWord;
      }
    }
    
  }
  
  
  /**
   * Converts a sequence of words into Pig Latin.
   *
   * @param line the String containing the words
   *
   * @return a sequence of words in Pig Latin, each converted from the
   *         corresponding word in line
   */
  public static String convertLine(String line)
  {
    String result = "";
    
    for(String word : line.split(" "))
    {
      result += PigLatin.convertWord(word) + " ";
    }
    
    return result;
  }
}
