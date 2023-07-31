package Tetteh647;
//********************************************************************
// LinkedQueue.java Java Foundations
//
// Represents a linked implementation of a queue.
//********************************************************************
public class LinkedQ<T> implements Queue<T>
{
    private int count;
    private LinearNode<T> front, rear;
    //-----------------------------------------------------------------
// Creates an empty queue.
//-----------------------------------------------------------------
    public LinkedQ()
    {
        count = 0;
        front = rear = null;
    }
    //-----------------------------------------------------------------
// Adds the specified element to the rear of this queue.
//-----------------------------------------------------------------
    public void enqueue (T element)
    {
        LinearNode<T> node = new LinearNode<T>(element);
        if (count == 0)
            front = node;
        else
            rear.setNext(node);
        rear = node;
        count++;
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
//-----------------------------------------------------------------
// The following methods are left as programming projects.
//-----------------------------------------------------------------
// public T dequeue () throws EmptyCollectionException { }
// public T first () throws EmptyCollectionException { }
// public boolean isEmpty() { }
// public int size() { }
// public String toString() { }
}