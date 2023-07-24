package com.example.benedictabervel.Bervel4316;

import java.util.EmptyStackException;
import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T> {
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity)
    {
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }

    public void push(T element)
    {
        if (size() == stack.length){
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }
    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    public String toString() {
        String result = "";
        if(isEmpty()){
            throw new EmptyStackException();
        } else {
            for(int i = stack.length-1; i >= 0; i--) {
                result += stack[i];
            }
            return result;
        }
    }

    public T pop() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException();
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }
    public T peek() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[top-1];
    }


    public boolean isEmpty() {
        return top == 0;
    }
    public int size(){
        return top;
    }
}
