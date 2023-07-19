package com.Binah830.QueueAssignment;
import java.util.*;
// ID - 10899830

public class TicketCounter {
    private final static int PROCESS = 120;
    private final static int MAX_CASHIERS = 10;
    private final static int NUM_CUSTOMERS = 100;

    public static void main(String[] args){
        Customer customer;
        Queue<Customer> customerQueue = new LinkedList<Customer>();
        int[] cashierTime = new int[MAX_CASHIERS];
        int totalTime, averageTime, departs, start;
        for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++){
            // set each cashiers time to zero initially
            for (int count = 0; count < cashiers; count++)
                cashierTime[count] = 0;
            // load customer queue
            for (int count = 1; count <= NUM_CUSTOMERS; count++)
                customerQueue.add(new Customer(count * 15));
            totalTime = 0;
            // process all customers in the queue
            while (!(customerQueue.isEmpty())){
                for (int count = 0; count <= cashiers; count++){
                    if (!(customerQueue.isEmpty())){
                        customer = customerQueue.remove();
                        if (customer.getArrivalTime() > cashierTime[count])
                            start = customer.getArrivalTime();
                        else
                            start = cashierTime[count];
                        departs = start + PROCESS;
                        customer.setDepartureTime(departs);
                        cashierTime[count] = departs;
                        totalTime += customer.totalTime();
                    }
                }
            }
            // output results for this simulation
            averageTime = totalTime / NUM_CUSTOMERS;
            System.out.println("Number of cashiers: " + (cashiers + 1));
            System.out.println("Average time: " + averageTime + "\n");
        }
    }
}
