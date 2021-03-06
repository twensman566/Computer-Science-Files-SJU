/*
 * File BankSim.java
 */

import java.util.*;
import javax.swing.*;

/**
 * Simulate the check-in process of an airline.
 * 
 * @author Koffman & Wolfgang, edited by J. A. Holey & I. M. Rahal
 * @version October 20, 2010
 */
public class BankSim {
  
  /** Queue of regular customers. */
  private CustomerQueue regularCustomerQueue =
    new CustomerQueue("Customer");
  
  /** Maximum time to service a customer. */
  private int avgProcessingTime;
  
  /** Total simulated time. */
  private int totalTime;
  
  /** If set true, print additional output. */
  private boolean showAll = true;
  
  /** Simulated clock. */
  private int clock = 0;
  
  /** Time that the agent will be done with the current customer.*/
  private ArrayList<Integer> timeDone = new ArrayList<Integer>();
  
  //queue of tellers that are free
  private ArrayList<Integer> freeTellerQueue = new ArrayList<Integer>();
  
  private ArrayList<Integer> busyTellerQueue = new ArrayList<Integer>();
  
  /**
   * Get the data for the simulation.
   */
  private void enterData() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter totalTime (an integer):" +
                       "The total time to run the simulation");
    totalTime = sc.nextInt();
    System.out.println("Enter avgProcessingTime (an integer): " +
                       "The average time to serve a customer");
    avgProcessingTime = sc.nextInt();
    Customer.setProcessingTime(avgProcessingTime);
    System.out.println("Enter arrivalRate for customers (a double): " +
                       "The expected number of customer arrivals per unit of time");
    regularCustomerQueue.setArrivalRate(sc.nextDouble());
    
    System.out.println("Enter the number of tellers for bank (an integer): " +
                       "The  number of tellers working at the bank");
    fillTeller(sc.nextInt());
  }
  
  /**
   * Run the simulation.
   */
  private void runSimulation() {
    for (clock = 0; clock < totalTime; clock++) {
      regularCustomerQueue.checkNewArrival(clock, showAll);
      if (!freeTellerQueue.isEmpty()) { //means that teller is ready to serve (i.e., not busy)
        startServe();
      }
    for(Integer i : freeTellerQueue)
      System.out.println("Time is " + clock + ": Teller number " + i + " is idle");
    
    for(int i = 0; i<timeDone.size(); i++)
    {
      if(timeDone.get(i) == clock){
        freeTellerQueue.add(busyTellerQueue.remove(i));
        timeDone.remove(i);
        i--;
      }
    }
    }
  }
  
  /**
   * Serve the queues in the simulation.
   */
  private void startServe() {
    if (!regularCustomerQueue.isEmpty()) {
      // Serve the next regular customer.
      int teller = freeTellerQueue.remove(0);
      busyTellerQueue.add(teller);
      timeDone.add(regularCustomerQueue.update(clock, showAll, teller));
    }
    else if (showAll) {
      System.out.println("Time is " + clock + ": server is idle");
    }
  }
  
  
  /**
   * Show the statistics after the simulation.
   */
  private void showStats() {
    System.out.println("\nThe number of customers served was " +
                       regularCustomerQueue.getNumServed());
    double averageWaitingTime =
      (double) regularCustomerQueue.getTotalWait() /
      (double) regularCustomerQueue.getNumServed();
    System.out.println(" with an average waiting time of " +
                       averageWaitingTime);
    System.out.println("Customers in customer queue: " +
                       regularCustomerQueue.size());
  }
  
    /**
   * A private method to fill the two queues with the amount of tellers specified
   * 
   * 
   */
  private void fillTeller(int numTellers)
  {
    for(int i = 0; i<numTellers; i++)
    {
      this.freeTellerQueue.add(i);
    }
  }
  
  /**
   * Main method for the simulation program.
   * 
   * @param args the command line arguments (not used)
   */
  public static void main(String args[] ){
    BankSim sim = new BankSim();
    sim.enterData();
    sim.runSimulation();
    sim.showStats();
  }
  
}
