package com.example.nicholas_amemazior.amemazior3638;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackADT<T>{
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }

    public void push(T element) {
        if(size() == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length*2);
    }

    public T pop() throws EmptyStackException{
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        top--;
        T result = stack[top];
        stack[top] = null;

        return result;
    }

    public T peek() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public boolean isEmpty() {
        if(top == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return stack.length;
    }
}
