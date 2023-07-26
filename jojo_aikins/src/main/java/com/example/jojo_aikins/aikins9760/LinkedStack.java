package com.example.jojo_aikins.aikins9760;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;
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

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        T removedElement = top.data;
        top = top.next;
        size--;
        return removedElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return top.data;
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
        Node<T> current = top;
        while (current.next != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        sb.append(current.data).append("]");
        return sb.toString();
    }
}
