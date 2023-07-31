package Tetteh647;

//*******************************************************************
// DatabaseConnector.java Java Foundations
//
// Uses a queue to simulate a waiting line.
//*******************************************************************
public class TicketCounter
{
    final static int PROCESS = 120;
    final static int MAX_CASHIERS = 10;
    final static int NUM_CUSTOMERS = 100;
    //-----------------------------------------------------------------
// Loads a queue with customers with various wait times then
// processes the queue.
//-----------------------------------------------------------------
    public static void main ( String[] args)
    {
        Customer customer;
        LinkedQ<Customer> customerQueue = new LinkedQ<Customer>();
        int[] cashierTime = new int[MAX_CASHIERS];
        int totalTime, averageTime, departs;
// process the simulation for various number of cashiers
        for (int cashiers=0; cashiers < MAX_CASHIERS; cashiers++)
        {
// set each cashiers time to zero initially
            for (int count=0; count < cashiers; count++)
                cashierTime[count] = 0;
// load customer queue
            for (int count=1; count <= NUM_CUSTOMERS; count++)
                customerQueue.enqueue(new Customer(count*15));
            totalTime = 0;
// process all customers in the queue
            while (!(customerQueue.isEmpty()))
            {
                for (int count=0; count <= cashiers; count++)
                {
                    if (!(customerQueue.isEmpty()))
                    {customer = customerQueue.dequeue();
                        if (customer.getArrivalTime() > cashierTime[count])
                            departs = customer.getArrivalTime() + PROCESS;
                        else
                            departs = cashierTime[count] + PROCESS;
                        customer.setDepartureTime (departs);
                        cashierTime[count] = departs;
                        totalTime += customer.totalTime();
                    }
                }
            }
// output results for this simulation
            averageTime = totalTime / NUM_CUSTOMERS;
            System.out.println ("Number of cashiers: " + (cashiers+1));
            System.out.println ("Average time: " + averageTime + "\n");
        }
    }
}