package com.Binah830.QueueAssignment;
// ID - 10899830
public class Customer {
    private int arrivalTime, departureTime;
    /**
     * Creates a new customer with the specified arrival time.
     * @param arrives the arrival time
     */
    public Customer(int arrives)
    {
        arrivalTime = arrives;
        departureTime = 0;
    }
    /**
     * Returns the arrival time of this customer.
     * @return the arrival time
     */
    public int getArrivalTime()
    {
        return arrivalTime;
    }
    /**
     * Sets the departure time for this customer.
     * @param departs the departure time
     **/
    public void setDepartureTime(int departs)
    {
        departureTime = departs;
    }
    /**
     * Returns the departure time of this customer.
     * @return the departure time
     */
    public int getDepartureTime()
    {
        return departureTime;
    }
    /**
     * Computes and returns the total time spent by this customer.
     * @return the total customer time
     */
    public int totalTime()
    {
        return departureTime - arrivalTime;
    }
}
