package com.example.jojo_aikins.aikins9760;

public class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T element) {
        if (size == array.length) {
            resizeArray();
        }
        rear = (rear + 1) % array.length;
        array[rear] = element;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        T removedElement = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return removedElement;
    }

    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int current = front;
        for (int i = 0; i < size - 1; i++) {
            sb.append(array[current]).append(", ");
            current = (current + 1) % array.length;
        }
        sb.append(array[current]).append("]");
        return sb.toString();
    }

    private void resizeArray() {
        int newCapacity = array.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        int current = front;
        for (int i = 0; i < size; i++) {
            newArray[i] = array[current];
            current = (current + 1) % array.length;
        }
        array = newArray;
        front = 0;
        rear = size - 1;
    }
}
