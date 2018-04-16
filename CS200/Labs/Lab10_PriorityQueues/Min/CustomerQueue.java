/*
 * File: CustomerQueue.java
 */

import java.util.*;
import zhstructures.*;
import TJWstructures.*;

/** 
 * Class to simulate a queue of customers.
 * 
 * @author Koffman & Wolfgang, modified by J. A. Holey
 * @version October 21, 2008
 */

public class CustomerQueue {
  // Data Fields
  /**  The queue of customers. */
  private TJWHeapPriorityQueue<Customer> queue;
  
  /** The number of customers served. */
  private int numServed = 0;
  
  /** The total units of time customers were waiting in the queue. */
  private int totalWait = 0;
  
  /** The name of this queue. */
  private String queueName;
  
  /** The average arrival rate per unit of time. */
  private double arrivalRate;
  
  private Random rand = new Random();
  
  private int highestPriority;
  
  // Constructor
  /** 
   * Construct a CustomerQueue with the given name.
   * 
   * @param queueName the name of this queue
   */
  public CustomerQueue(String queueName) {
    this.queueName = queueName;
    queue = new TJWHeapPriorityQueue<Customer> ();
  }
  
  public void setHighestPriority(int value)
  {
    highestPriority = value;
  }
  
  /** 
   * Return the number of customers served
   * 
   * @return the number of customers served
   */
  public int getNumServed() {
    return numServed;
  }
  
  /** 
   * Return the total wait time
   * 
   * @return the total wait time
   */
  public int getTotalWait() {
    return totalWait;
  }
  
  /**
   * Return the queue name
   * 
   * @return the queue name
   */
  public String getQueueName() {
    return queueName;
  }
  
  /**
   * Set the arrival rate
   * 
   * @param arrivalRate the value to set
   */
  public void setArrivalRate(double arrivalRate) {
    this.arrivalRate = arrivalRate;
  }
  
  /**
   * Determine if the customer queue is empty
   * 
   * @return true if the customer queue is empty
   */
  public boolean isEmpty() {
    return queue.isEmpty();
  }
  
  /** Determine the size of the customer queue
    @return the size of the customer queue
    */
  public int size() {
    //int size = 0;
    //for(Customer p : queue) size++;
    return queue.size();
  }
  
  public Customer[] getElements()
  {
    //return queue.toArray(new Customer[queue.size()]);
    Customer[] customers = new Customer[queue.size()];
    int i = 0;
    for(Customer cust : this.queue)
      customers[i++] = cust;
    return customers;
  }
  
  /**
   * Check if a new arrival has occurred.
   * 
   * @param clock the current simulated time
   * @param showAll flag to indicate that detailed
   *                data should be output
   */
  public void checkNewArrival(int clock, boolean showAll) {
    if (Math.random() < arrivalRate) {
      Customer tempCustomer = new Customer(clock,rand.nextInt(highestPriority+1));
      queue.enqueue(tempCustomer);
      if (showAll) {
        System.out.println("Time is "
                             + clock + ": "
                             + queueName
                             + " arrival (ID="
                             + tempCustomer.getId()
                             + ", timestamp="
                             + clock
                             + ", priority="
                             + tempCustomer.getPriority()
                             + "), new queue size is "
                             + this.size());
      }
    }
  }
  
  /**
   * Update statistics.
   * 
   * pre: The queue is not empty.
   * 
   * @param clock the current simulated time
   * @param showAll flag to indicate whether to show detail
   * @return the time customer is done being served
   */
  public int update(int clock, boolean showAll, int teller) {
    Customer nextCustomer = queue.dequeue();
    int timeStamp = nextCustomer.getArrivalTime();
    int wait = clock - timeStamp;
    totalWait += wait;
    numServed++;
    if (showAll) {
      System.out.println("Time is " + clock
                           + ": Teller number "
                           + teller
                           + " is now serving customer with timestamp "
                           + timeStamp
                           + " and priority "
                           + nextCustomer.getPriority()
                           + " until "
                           + (nextCustomer.getProcessingTime()+clock+1));
    }
    return clock + nextCustomer.getProcessingTime();
  }
  
}
