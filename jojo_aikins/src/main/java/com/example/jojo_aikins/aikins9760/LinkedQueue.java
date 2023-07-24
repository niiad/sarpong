package com.example.jojo_aikins.aikins9760;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    // Nested Node class
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        T removedElement = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Queue is now empty
        }
        size--;
        return removedElement;
    }

    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return front.data;
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

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front;
        while (current.next != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        sb.append(current.data).append("]");
        return sb.toString();
    }
}
