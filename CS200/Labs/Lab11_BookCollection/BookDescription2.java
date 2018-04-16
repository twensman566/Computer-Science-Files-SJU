/*
 * File: BookDescription.java
 */

/**
 * Put an appropriate class header here
 */
public class BookDescription2 {
  
  // Put in appropriate instance variables.
  private String author,title,publisher,date,rating,pages,description;
  private BookDescription book;
  /**
   * Creates a new book description with the specified author and title.
   * 
   * @param author the author of the book
   * @param title the title of the book
   * etc ... 
   */
  public BookDescription2(String author, String title, String publisher, String date, String rating, String pages, String description) 
  {
    this.author = author;
    this.title = title;
    this.publisher = publisher;
    this.date = date;
    this.rating = rating;
    this.pages = pages;
    this.description = description;
  }
  
//  public BookDescription(String title, String publisher, String date, String rating, String pages, String description)
//  {
//   this.book = new BookDescription(title,publisher,date,rating,pages,description);
//  }
  
  public String getAuthor()
  {
    return this.author; 
  }
  
  public String getTitle()
  {
    return this.title; 
  }
  
  public String getPublisher()
  {
    return this.publisher;
  }
  
  public String getDate()
  {
    return this.date;
  }
  
  public String getRating()
  {
    return this.rating;
  }
  
  public String getPages()
  {
    return this.pages;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  /**
   * Sets the description.
   * 
   */
  public void setDescription(String description)
  {
    this.description = description; 
  }
  /**
   * Sets the rating.
   * 
   */
  public void setRating(String rating)
  {
    this.rating = rating; 
  }
  
  public String toString()
  {
    return this.getAuthor() + "\n" + this.getTitle() + "\n" + this.getPublisher() + "\n" + this.getDate() + "\n" + this.getRating() + "\n" + this.getPages() + "\n" + this.getDescription() + "\n" + "_";
  }
  //add another constructor with takes in parameters for ALL class fields
  // Put in necessary get() and set() methods
  
}
