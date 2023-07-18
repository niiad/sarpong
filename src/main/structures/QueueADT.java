package main.structures;

public interface QueueADT<T> {
    // Adds one element to the rear of this queue.
    public void enqueue(T element);

    //Removes and returns the element at the front of this queue.
    public T dequeue();


    // Returns true if this queue contains no elements.
    public boolean isEmpty();

    // Returns the number of elements in this queue.
    public int size();

     // Returns a string representation of this queue.
    public String toString();
}
