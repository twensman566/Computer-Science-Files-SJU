public class Teller {
  
  private int idleTime;
  
  private int customersServed;
  
  private boolean isFree;
  
  private int tellerNumber = 0;
  
  
  public Teller(int value)
  {
    this.idleTime = 0;
    this.customersServed = 0;
    this.isFree = true;
    this.tellerNumber = value;
  }
  
  public int getIdleTime()
  {
    return this.idleTime;
  }
  
  public int getTellerNumber()
  {
    return this.tellerNumber;
  }
  
  public int getCustomersServed()
  {
    return this.customersServed;
  }
  
  public void addOneIdleTime()
  {
    this.idleTime+=1;
  }
  
  public void addOneCustomerServed()
  {
    this.customersServed+=1;
  }
  
  public boolean getIsFree()
  {
    return this.isFree;
  }
  
  public void setIsFree(boolean status)
  {
    this.isFree = status;
  }
}