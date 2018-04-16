/*
 * File: BookCollection.java
 */

import java.util.*;
import java.io.*;
import TJWstructures.*;

/**
 * Put an appropriate class header here
 */
public class BookCollection2 {
  
  // library is a Map associating authors (the String) with the
  // collection of books they have written (the map of BookDescription2).
  private TJWTreeMap<String, TJWTreeMap<String, BookDescription2>> library;
  
  
  
  
  
  public BookCollection2() 
  {
    
     library = new TJWTreeMap<String, TJWTreeMap<String, BookDescription2>>();
    
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
  public BookCollection2(String fileName)
  {
     library = new TJWTreeMap<String, TJWTreeMap<String, BookDescription2>>();
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
        BookDescription2 book = new BookDescription2(author,title,publisher,date,rating,pages,description);
        add(book);
      }
      
      
      
     // System.out.println(library.values());
    }catch(FileNotFoundException e){
      
    }
  }
  
  
  
  public BookDescription2 getDescription(String author, String title)
  {
    TJWTreeMap<String,BookDescription2> inner = library.get(author);
    return inner.get(title);
  }
  
  public void add(BookDescription2 book)
  {
    
    if(!library.contains(book.getAuthor()))
    {
      TJWTreeMap<String,BookDescription2> newMap = new TJWTreeMap<String,BookDescription2>();    
      newMap.put(book.getTitle(),book);
      library.put(book.getAuthor(),newMap);
    }
    
    else
    {
      TJWTreeMap<String,BookDescription2> newMap = library.get(book.getAuthor());
      newMap.put(book.getTitle(),book);
      library.put(book.getAuthor(),newMap);
    }
    
  }
  
  public boolean remove(BookDescription2 book)
  {
    if(!library.contains(book.getAuthor()))
    {
      return false;
    }
    TJWTreeMap<String,BookDescription2> newMap = library.get(book.getAuthor());
    if(!newMap.contains(book.getTitle()))
    {
      return false;
    }
    else
    {
      newMap.remove(book.getTitle());
      return true;
    }
  }
  
  public boolean isEmpty()
  {
    return this.library.isEmpty(); 
  }
  
  public boolean updateDescription(String author, String title, String description)
  {
    if(!library.contains(author))
    {
      return false;
    }
    TJWTreeMap<String,BookDescription2> newMap = library.get(author);
    if(!newMap.contains(title))
    {
      return false;
    }
    else
    {
      BookDescription2 book = newMap.get(title);
      book.setDescription(description);
      return true;
    }
  }
  
  public void writeToFile(String fileName)
  {
    try{
      PrintWriter printer = new PrintWriter(fileName);
      Iterator<String> authors = authorIterator();
      while(authors.hasNext())
      {
        String author = authors.next();
        TJWTreeMap<String,BookDescription2> inner = library.get(author);
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
  
  public int size()
  {
    int size = 0;
    Iterator<String> authors = authorIterator();
      while(authors.hasNext())
      {
        Iterator<String> titles = titleIterator(authors.next());
        while(titles != null && titles.hasNext())
        {
          titles.next();
          size++;
        }
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
    return this.library.iterator();
  }
  /**
   * gets an iterator for the titles.
   * 
   */
  public Iterator<String> titleIterator(String author)
  {
    TJWTreeMap<String,BookDescription2> inner = library.get(author);
    return inner.iterator();
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
  
  
  public void specificAuthor(String author)
  {
    TJWTreeMap<String,BookDescription2> inner = library.get(author);
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
      TJWTreeMap<String,BookDescription2> inner = library.get(author);
      Iterator<String> iter = inner.iterator();
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
