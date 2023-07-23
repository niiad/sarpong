//*******************************************************************
//Code to count tickets of people waiting in a queue using queues 
//*******************************************************************
public class Customer
{
private int arrivalTime, departureTime;

public Customer (int arrives)
{
arrivalTime = arrives;
departureTime = 0;
}

public int getArrivalTime() // Returns the arrival time of this customer.
{
return arrivalTime;
}

public void setDepartureTime (int departs)
{
departureTime = departs;
}

public int getDepartureTime()
{
return departureTime;
}
public int totalTime()
{
return departureTime - arrivalTime;
}
}
