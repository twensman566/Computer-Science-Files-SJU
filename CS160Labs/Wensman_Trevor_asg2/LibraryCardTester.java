import acm.program.Program;

public class LibraryCardTester extends Program
{
  private LibraryCard card1, card2, card3;
  private Student student1, student2;
  
  // Run method for the program
  // also declares the names and emails for the library cards
  
  public void run()
  {
    student1 = new Student();
    this.student1.setName("John Doe");
    this.student1.setEmail("johndoe@csbsju.edu");
    
    
    student2 = new Student();
    this.student2.setName("Dawn Wise");
    this.student2.setEmail("dawnwise@csbsju.edu");
    
    card1 = new LibraryCard();
    this.card1.setOwner(this.student1);
    
    card2 = new LibraryCard();
    this.card2.setOwner(this.student1);
    
    card3 = new LibraryCard();
    this.card3.setOwner(this.student2);
    
    this.card1.setBorrowedBookCount(3);
    this.card2.setBorrowedBookCount(5);
    this.card3.setBorrowedBookCount(2);
    
    System.out.println("Card1 Info: \n\t" + this.card1.toString());
    System.out.println("Card2 Info: \n\t" + this.card2.toString());
    System.out.println("Card3 Info: \n\t" + this.card3.toString());
  }
}
