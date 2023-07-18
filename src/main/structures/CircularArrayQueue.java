package main.structures;// Circular array implementation of queue

// Circular array implementation of queue

import java.util.Arrays;
import java.util.List;

public class CircularArrayQueue<T> implements QueueADT<T>{

    private final static int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;

    // Creates an empty queue using the specified capacity.
    public CircularArrayQueue (int initialCapacity)
    {
        front = rear = count = 0;
        queue = (T[]) (new Object[initialCapacity]);
    }

    // Creates an empty queue using the default capacity.
    public CircularArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }


    // Adds the specified element to the rear of this queue, expanding
    // the capacity of the queue array if necessary.
    public void enqueue(T element) {
        // checks if array is full
        if (size() == queue.length)
            expandCapacity();

        queue[rear] = element;
        rear = (rear+1) % queue.length;
        count++;
    }

    // Creates a new array to store the contents of this queue with
    // twice the capacity of the old one.
    private void expandCapacity()
    {
        T[] larger = (T[]) (new Object[queue.length *2]);
        for (int scan = 0; scan < count; scan++)
        {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = count;
        queue = larger;
    }

    // Removes the element at the front of this queue and returns a
    // reference to it.
    public T dequeue() {
        if (isEmpty())
            throw new EmptyCollectionException("queue");

        T result = queue[front];
        queue[front] = null;
        front = (front+1) % queue.length;
        count--;
        return result;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        // if the front is greater than the rear
        return count;
    }

    // get queue as list
    public List<T> getQueue(){

        T[] larger = (T[]) (new Object[queue.length]);
        int start = front;
        for (int scan = 0; scan < count; scan++)
        {
            larger[scan] = queue[start];
            start = (start + 1) % queue.length;
        }

        T[] slice = Arrays.copyOfRange(larger, 0, count);

        return Arrays.asList(slice);
    }
}