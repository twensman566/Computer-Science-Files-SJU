public class RandomWordTester
{
  public static void main(String[] args)
  {
    RandomWord word1 = new RandomWord("smallWords.txt");
    RandomWord word2 = new RandomWord("mediumWords.txt");
    RandomWord word3 = new RandomWord("largeWords.txt");
    
    System.out.println(word1.next());
    System.out.println(word2.next());
    System.out.println(word3.next());
  }
}