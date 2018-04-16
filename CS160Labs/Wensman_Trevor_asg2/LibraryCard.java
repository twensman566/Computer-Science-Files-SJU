// this class assigns all the information to the library card
public class LibraryCard
{
  //makes a new student object called owner
  // creates the variable for borrowedbooks
  private Student owner;
  private int borrowedBookCount;
  
  public LibraryCard()
  {
    owner = null;
    borrowedBookCount = 0;
  }
  public Student getOwner()
  {
    return owner;
  }
  public void setOwner(Student theOwner)
  {
    this.owner = theOwner; 
  }
  public int getBorrowedBookCount()
  {
    return borrowedBookCount; 
  }
  public void setBorrowedBookCount(int theBorrowedBookCount)
  {
    this.borrowedBookCount = theBorrowedBookCount;
  }
  // returns theLibraryCard
  public String toString()
  {
    return("Owner Name: " +  owner.getName() + "\n\t" + "Email: "+ owner.getEmail() + "\n\t" + "Books Borrowed: " + this.getBorrowedBookCount() + "\n");
  }
}