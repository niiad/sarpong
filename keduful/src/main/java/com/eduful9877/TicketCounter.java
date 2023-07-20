package com.eduful9877;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TicketCounter demonstrates the use of a queue for simulating a line of
 * customers.
 * @author Kelvin Eduful
 * ID: 10889877
 */
public class TicketCounter {
    private static final int PROCESS = 120;
    private static final int MAX_CASHIERS = 10;
    private static final int NUM_CUSTOMERS = 100;

    public static void main(String[] args) {
        Customer customer;
        Queue<Customer> customerQueue = new LinkedList<>();
        int[] cashierTime = new int[MAX_CASHIERS];
        int totalTime, averageTime, departs, start;

        // run the simulation for various number of cashiers
        for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++) {
            // set each cashiers time to zero initially
            for (int count = 0; count < cashiers; count++) {
                cashierTime[count] = 0;
            }
            // load customer queue
            for (int count = 1; count <= NUM_CUSTOMERS; count++) {
                customerQueue.add(new Customer(count * 15));
            }
            totalTime = 0;

            // process all customers in the queues
            while (!(customerQueue.isEmpty())) {
                for (int count = 0; count <= cashiers; count++) {
                    if (!(customerQueue.isEmpty())) {
                        customer = customerQueue.remove();
                        if (customer.getArrivalTime() > cashierTime[count]) {
                            start = customer.getArrivalTime();
                        } else {
                            start = cashierTime[count];
                        }
                        departs = start + PROCESS;
                        customer.setDepartureTime(departs);
                        cashierTime[count] = departs;
                        totalTime = customer.totalTime();
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
