import java.util.*;
import javax.swing.*;
import java.io.*;

public class BookCollectionManager extends BookCollection
{
  
  private BookCollection collection;
  
  public BookCollectionManager(String fileName)
  {
    System.out.println("Welcome to the Book Collection Manager");
    collection = new BookCollection(fileName);
  }
  public void runManager() {
    char cmd;
    do
    {
      menu ();
      cmd = acceptCommand ();
      doCommand (cmd);
    }
    while ((cmd != 'q') && (cmd != 'Q'));
  }
  
  private void menu() {
    System.out.println();
    System.out.println("\tA Add a new book");
    System.out.println("\tR Remove a book");
    //System.out.println("\tM Manage an individual worker");
    System.out.println("\tP Report on a Book");
    //System.out.println("\tS Save the current worker set");
    System.out.println("\tL Load a Book File");
    System.out.println("\tQ Quit the program");
    System.out.println();
  }
  private char acceptCommand() {
    char cmd;
    String s = JOptionPane.showInputDialog("Enter command: ");
    cmd = s.charAt(0);
    return cmd;
  }
  
  private void doCommand(char cmd) {
    switch (cmd)
    {
      case 'a': case 'A':
        //add();
        String author = JOptionPane.showInputDialog("Enter author: ");
        String title = JOptionPane.showInputDialog("Enter title: ");
        String publisher = JOptionPane.showInputDialog("Enter publisher: ");
        String date = JOptionPane.showInputDialog("Enter date: ");
        String rating = JOptionPane.showInputDialog("Enter rating: ");
        String pages = JOptionPane.showInputDialog("Enter pages: ");
        String description = JOptionPane.showInputDialog("Enter description: ");
        BookDescription book = new BookDescription(author,title,publisher,date,rating,pages,description);
        add(book);
        break;
      case 'r': case 'R':
       // remove();
        break;
      case 'm': case 'M':
       // manage();
        break;
      case 'p': case 'P':
       // report();
        break;
      case 's': case 'S':
      //  save();
        break;
      case 'l': case 'L':
      //  load();
        
        break;
      case 'q': case 'Q':
      //  quit ();
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  
  public static void main(String args[])
  {
    
    BookCollectionManager manager = new BookCollectionManager("sampleLibrary.BookCollection");
    manager.runManager();
    
  }
  
  
  
}