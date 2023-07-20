package com.eduful9877;

/**
 * QueueADT defines the interface to a queue collection.
 * @author Kelvin Eduful
 * ID: 10889877
 */
public interface QueueADT<T> {

    /**
     * Adds one element to the rear of this queue.
     * @param element  the element to be added to the rear of the queue
     */
    void enqueue(T element);
    /**
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of the queue
     */
    T dequeue();
    /**
     * Returns without removing the element at the front of this queue.
     * @return the first element in the queue
     */
    T first();
    /**
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    boolean isEmpty();
    /**
     * Returns the number of elements in this queue.
     * @return the integer representation of the size of the queue
     */
    int size();
    /**
     * Returns a string representation of this queue.
     * @return the string representation of the queue
     */
    String toString();
}
