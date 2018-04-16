/*
 * File: Customer.java
 */

import java.util.*;

/** 
 * A class to represent a customer.
 * 
 * @author Koffman & Wolfgang, edited by J. A. Holey
 * @version October 21, 2008
 */

public class Customer implements Comparable<Customer>{
  
  // Data Fields
  /** The ID number for this customer. */
  private int customerId;
  
  /** The time needed to process this customer. */
  private int processingTime;
  
  /** The time this customer arrives. */
  private int arrivalTime;
  
  /** The sequence number for customers. */
  private static int idNum = 0;
  
  private static double upper, lower;
  
  private int priority;
  
  /**
   * Create a new customer.
   * 
   * @param arrivalTime the time this customer arrives
   */
  public Customer(int arrivalTime, int tempPriority) {
    this.arrivalTime = arrivalTime;
    processingTime = (int) ((new Random()).nextDouble() * (upper-lower) + lower);
    customerId = idNum++;
    priority = tempPriority;
  }
  
  /**
   * Get the arrival time.
   * 
   * @return the arrival time
   */
  public int getArrivalTime() {
    return arrivalTime;
  }
  
   /**
   * Get the customer priority.
   * 
   * @return the customer priority
   */
  public int getPriority()
  {
    return this.priority;
  }
  
  public int compareTo(Customer object)
  {
    if(this.getPriority() > object.getPriority())
      return 1;
    else if(this.getPriority() < object.getPriority())
      return -1;
    
    else if(this.getArrivalTime() < object.getArrivalTime())
      return -1;
    else if(this.getArrivalTime() > object.getArrivalTime())
      return 1;
    else
      return 0;
  }
  
  /**
   * Get the processing time.
   * 
   * @return the processing time
   */
  public int getProcessingTime() {
    return processingTime;
  }
  
  /**
   * Get the customer ID.
   * 
   * @return the customer ID
   */
  public int getId() {
    return customerId;
  }
  
  /**
   * Set the maximum processing time.
   * 
   * @param maxProcessingTime the new value for the maximum processing time
   */
  public static void setProcessingTime(int avgProcessTime) {
    upper = avgProcessTime * 0.4;
    lower = avgProcessTime * 1.6;
  }
}
