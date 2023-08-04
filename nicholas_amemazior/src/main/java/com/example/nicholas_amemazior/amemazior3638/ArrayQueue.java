package com.example.nicholas_amemazior.amemazior3638;

import java.util.EmptyStackException;

public class ArrayQueue<T> implements QueueADT<T> {
    private final static int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;

    public ArrayQueue(int initialCapacity) {
        front = rear = count = 0;
        queue = (T[]) (new Object[initialCapacity]);
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public void enqueue(T element) {
        if(size() == queue.length){
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear+1)%queue.length;
        count++;
    }

    private void expandCapacity(){
        T[] larger = (T[]) (new Object[queue.length * 2]);
        for(int scan = 0; scan < count; scan++) {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = count;
        queue = larger;
    }

    public T dequeue() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size() > 0;
    }

    @Override
    public int size() {
        return queue.length;
    }

    @Override
    public T first() {
        return queue[front];
    }
}
