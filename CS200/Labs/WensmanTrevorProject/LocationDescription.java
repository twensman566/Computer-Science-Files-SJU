/*
 * File: BookDescription.java
 */

/**
 * Put an appropriate class header here
 */
public class LocationDescription {
  
  // Put in appropriate instance variables.
  private String location,enemy,enemyHealth,enemyDamage,shop,weapon,armor;
  
  private boolean mark;
  //private LocationDescription book;
  /**
   * Creates a new book description with the specified author and title.
   * 
   * @param author the author of the book
   * @param title the title of the book
   * etc ... 
   */
  public LocationDescription(String location, String enemy, String enemyHealth, String enemyDamage, String shop, String weapon, String armor) 
  {
    this.location = location;
    this.enemy = enemy;
    this.enemyHealth = enemyHealth;
    this.enemyDamage = enemyDamage;
    this.shop = shop;
    this.weapon = weapon;
    this.armor = armor;
    this.mark = false;
  }
  
//  public BookDescription(String title, String publisher, String date, String rating, String pages, String description)
//  {
//   this.book = new BookDescription(title,publisher,date,rating,pages,description);
//  }
  
  public String getLocation()
  {
    return this.location; 
  }
  
  public String getEnemy()
  {
    return this.enemy; 
  }
  
  public String getEnemyHealth()
  {
    return this.enemyHealth;
  }
  
  public String getEnemyDamage()
  {
    return this.enemyDamage;
  }
  
  public String getShop()
  {
    return this.shop;
  }
  
  public String getWeapon()
  {
    return this.weapon;
  }
  
  public String getArmor()
  {
    return this.armor;
  }
  
  public void setArmor(String armor)
  {
    this.armor = armor; 
  }
  
  public void setWeapon(String rating)
  {
    this.weapon =  weapon; 
  }
  
  public void setLocation(String location)
  {
   this.location = location; 
  }
  
  public void setEnemyHealth(String enemyHealth)    
  {
    this.enemyHealth = enemyHealth;
  }
  public void setEnemyDamage(String enemyDamage)    
  {
    this.enemyDamage = enemyDamage;
  }
  public boolean isDungeon(String location)
  {
   return true; 
  }
  
  public void unmark()
  {
   this.mark = false;
  }
  
  public void mark()
  {
   this.mark = true; 
  }
  
  public boolean getMark()
  {
   return mark; 
  }
  
  public String toString()
  {
    return this.getLocation() + "\n" + this.getEnemy() + "\n" + this.getEnemyHealth() + "\n" + this.getEnemyDamage() +
      "\n" + this.getShop() + "\n" + this.getWeapon() + "\n" + this. getArmor() + "\n";
  }
  //add another constructor with takes in parameters for ALL class fields
  // Put in necessary get() and set() methods
  
}
