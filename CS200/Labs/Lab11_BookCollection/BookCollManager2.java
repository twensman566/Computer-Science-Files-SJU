import java.util.*;
import java.io.*;
import TJWstructures.*;


/**
 * The driver class for the book collection manager.
 * 
 */
public class BookCollManager2 {
  
  public static void main(String[] args){
   
   // try{
    BookCollection2 col = new BookCollection2("sampleLibrary.BookCollection");
    
    System.out.println("There are " + col.size() + " books in the collection.");
    
    System.out.println();
    
    System.out.print("The authors are ");
    col.theAuthors();
    System.out.println();
    
    System.out.println();
    
    System.out.println("The authors' books (separated by \"-\") are:");
    col.authorsAndBooks();
    System.out.println();
    
    System.out.println("The old book description is:");
    col.specificAuthor("Conrad, Joseph");
    System.out.println("The new description will be \"The book is about a heart of darkness. It is very good.\"");
    col.updateDescription("Conrad, Joseph", "Heart of Darkness", "The book is about a heart of darkness. It is very good.");
    System.out.println("New book description:");
    col.specificAuthor("Conrad, Joseph");
    
    System.out.println("Book to add - Added Book by Conrad, Joseph ");
    BookDescription2 book = new BookDescription2("Conrad, Joseph ", "The Book I Added", "ZJ Inc", "Today", "R", "777", "Read this");
    col.add(book);
    col.authorsAndBooks();
    System.out.println();
    
    System.out.println("Will write to file \"UpdatedFile\".");
    col.writeToFile("Test");
    System.out.println();
    
    System.out.println("Book to remove - Added Book by Conrad, Joseph ");
    col.remove(book);
    col.authorsAndBooks();
    System.out.println();
    }
    //catch(FileNotFoundException e){
  //    System.out.println("ERROR");
 //   }
  }
