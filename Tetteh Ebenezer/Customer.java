package Tetteh647;

//*******************************************************************
// Customer.java Java Foundations
//
// Represents a waiting customer.
//*******************************************************************
public class Customer
{
    private int arrivalTime, departureTime;
    //-----------------------------------------------------------------
// Creates a new customer with the specified arrival time.
//-----------------------------------------------------------------
    public Customer (int arrives)
    {
        arrivalTime = arrives;
        departureTime = 0;
    }
    //-----------------------------------------------------------------
// Returns the arrival time of this customer.
//-----------------------------------------------------------------
    public int getArrivalTime()
    {
        return arrivalTime;
    }
    //-----------------------------------------------------------------
// Sets the departure time for this customer.
//-----------------------------------------------------------------
    public void setDepartureTime (int departs)
    {
        departureTime = departs;
    }
    //-----------------------------------------------------------------
// Returns the departure time of this customer.
//-----------------------------------------------------------------
    public int getDepartureTime()
    {
        return departureTime;
    }
    //-----------------------------------------------------------------
// Computes and returns the total time spent by this customer.
//-----------------------------------------------------------------
    public int totalTime()
    {
        return departureTime - arrivalTime;
    }
}