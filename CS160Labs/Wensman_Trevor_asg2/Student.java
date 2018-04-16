
//this class sets the student email and name for the library card class
public class Student
{
  private String studentName, studentEmail;
  
  public Student()
  {
    this.studentName = "UNASSIGNED";
    this.studentEmail = "UNASSIGNED";
    
  }
  public String getName()
  {
    return studentName;
  }
  public void setName(String name)
  {
    this.studentName =  name;
  }
  public String getEmail()
  {
    return studentEmail;
  }
  public void setEmail(String email)
  {
    this.studentEmail = email;
  }
}