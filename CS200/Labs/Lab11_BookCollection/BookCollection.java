/*
 * File: BookCollection.java
 */

import java.util.*;
import java.io.*;

/**
 * Put an appropriate class header here
 */
public class BookCollection {
  
  // library is a Map associating authors (the String) with the
  // collection of books they have written (the map of BookDescription).
  private HashMap<String, HashMap<String, BookDescription>> library;
  
  
  
  
  /**
   * Makes an empty book collection.
   * 
   */
  public BookCollection()
  {
    
    library = new HashMap<String, HashMap<String, BookDescription>>();
    
  }
  /**
   * This constructor will read in all the information for books and
   * insert the author name associated with this book entry into the
   * library. You will need to organize your file in such a way that
   * this is reasonably easy to do. I have included a very short
   * sample library showing one way to organize. (I use a _ to separate
   * one book from the next.)
   * 
   * @param fileName the path to the file containing the book information
   * @throws FILL IN APPROPRIATE EXCEPTION INFORMATION.
   */
  public BookCollection(String fileName)
  {
    library = new HashMap<String, HashMap<String, BookDescription>>();
    File file = new File(fileName);
    try{
      Scanner scanner = new Scanner(file);
      
      while(scanner.hasNextLine())
      {
        
        String author = (scanner.nextLine());
        //  System.out.println(author);
        String title = (scanner.nextLine());
        //  System.out.println(title);
        String publisher = (scanner.nextLine());
        // System.out.println(publisher);
        String date = (scanner.nextLine());
        // System.out.println(date);
        String rating = (scanner.nextLine());
        //System.out.println(rating);
        String pages = (scanner.nextLine());
        //System.out.println(pages);
        String description = "";
        
        while(!scanner.equals("_"))
        {
          
          //System.out.println("asdffasdfa" + scanner.toString().matches("_"));
          //System.out.println(scanner.matches());
          //System.out.println(description);
          String temp = scanner.nextLine();
          if(temp.equals("_"))
          {
            break; 
          }
          description = description + " " + temp;
          
          
        }
        //System.out.println("HERERERERERE");
        BookDescription book = new BookDescription(author,title,publisher,date,rating,pages,description);
        add(book);
      }
      
      
      
      System.out.println(library.values());
    }catch(FileNotFoundException e){
      
    }
  }
  
  
  /**
   * Get a description for a book
   * 
   * @param author the author
   * @param title the title
   * @return the book description
   */
  public String getBookDescription(String author, String title)
  {
    if(!library.containsKey(author))
    {
      return null;
    }
    
    else
    {
      HashMap<String,BookDescription> newMap = library.get(author);
      BookDescription book = newMap.get(title);
      return book.getDescription();
      
    }
    
  }
  /**
   * Add a book to a specific author.
   * 
   */
  public void add(BookDescription book)
  {
    
    if(!library.containsKey(book.getAuthor()))
    {
      HashMap<String,BookDescription> newMap = new HashMap<String,BookDescription>();    
      newMap.put(book.getTitle(),book);
      library.put(book.getAuthor(),newMap);
    }
    
    else
    {
      HashMap<String,BookDescription> newMap = library.get(book.getAuthor());
      newMap.put(book.getTitle(),book);
      library.put(book.getAuthor(),newMap);
    }
    
  }
  /**
   * Removes a book from the collection.
   * 
   * @return boolean true if removed.
   * 
   */
  public boolean remove(BookDescription book)
  {
    if(!library.containsKey(book.getAuthor()))
    {
      return false;
    }
    HashMap<String,BookDescription> newMap = library.get(book.getAuthor());
    if(!newMap.containsKey(book.getTitle()))
    {
      return false;
    }
    else
    {
      newMap.remove(book.getTitle());
      return true;
    }
  }
  /**Checks to see if map is empty.
   * 
   */
  public boolean isEmpty()
  {
    return this.library.isEmpty(); 
  }
  /**
   * Updates the description.
   * 
   * 
   * @param author the author
   * @param title the title
   * @param description the new description
   * 
   * @return boolean true if added
   * 
   */
  public boolean updateDescription(String author, String title, String description)
  {
    if(!library.containsKey(author))
    {
      throw new NoSuchElementException();
    }
    HashMap<String,BookDescription> newMap = library.get(author);
    if(!newMap.containsKey(title))
    {
      return false;
    }
    else
    {
      BookDescription book = newMap.get(title);
      book.setDescription(description);
      return true;
    }
  }
 /**
  * Writes the book info to a file.
  * 
  */ 
  public void writeToFile(String fileName)
  {
    try{
      PrintWriter printer = new PrintWriter(fileName);
      Iterator<String> authors = authorIterator();
      while(authors.hasNext())
      {
        String author = authors.next();
        HashMap<String,BookDescription> inner = library.get(author);
        Iterator<String> titles = titleIterator(author);
        while(titles != null && titles.hasNext())
        {
          printer.println(inner.get(titles.next()));
        }
      }
      printer.close();
    }
    catch(FileNotFoundException e){
      System.out.println("The file was not found."); 
    }
  }
  /**
   * The size of the map.
   * 
   */
  public int size()
  {
    int size = 0;
    Set<String> authors = library.keySet();
    for(String author : authors)
    {
      Set<String> titles = library.get(author).keySet();
      for(String title : titles)
        size++;
    }
    return size;
  }
  
  /**
   * gets an iterator for the authors
   * 
   * @return the iterator
   */
  public Iterator<String> authorIterator()
  {
    return this.library.keySet().iterator();
  }
  /**
   * gets an iterator for the titles.
   * 
   */
  public Iterator<String> titleIterator(String author)
  {
    HashMap<String,BookDescription> inner = library.get(author);
    return inner.keySet().iterator();
  }
  /**
   * Prints the authors out.
   * 
   * 
   */
  public void theAuthors(){
    Iterator<String> authors = authorIterator();
    while(authors.hasNext())
    {
      System.out.print(authors.next());
      if(authors.hasNext())
        System.out.print(" - ");
    }
  }
  
  /**
   * Prints the titles for a specific author.
   * 
   */
  public void specificAuthor(String author)
  {
    HashMap<String,BookDescription> inner = library.get(author);
    Iterator<String> titles = titleIterator(author);
    while(titles != null && titles.hasNext())
    {
      System.out.println(inner.get(titles.next()));
    }
  }
  
  /**
   * Prints the authors and the books
   */
  public void authorsAndBooks()
  {
    Iterator<String> authors = authorIterator();
    while(authors.hasNext())
    {
      String author = authors.next();
      HashMap<String,BookDescription> inner = library.get(author);
      Iterator<String> iter = inner.keySet().iterator();
      System.out.print(author + ": ");
      while(iter.hasNext())
      {
        System.out.print(iter.next());
        if(iter.hasNext())
          System.out.print(" - ");
      }
      System.out.println();
    }
  }
  
  
  
  
  
  
  
  
  
  
  
  
// put in appropriate methods
  
}
