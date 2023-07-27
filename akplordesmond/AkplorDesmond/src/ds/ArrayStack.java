package ds;

import ds.exceptions.EmptyCollectionException;

import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T> {

    private final static int Capacity = 100;
    private int top;
    private T[] stack;

    // constructor 1
    public ArrayStack(){
        this(Capacity);
    }

    // constructor 2
    public ArrayStack(int initialCapacity){
        top = 0;

        // creates an array of size, initialCapacity
        stack = (T[]) (new Object[initialCapacity]);
    }


    @Override
    public void push(T element) {
        // inserts element at the top of the stack.
        if (size() == stack.length){
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }



    @Override
    public T pop() throws EmptyCollectionException {
        // removes and returns the element at the top of the stack.
        if (isEmpty()){
            throw new EmptyCollectionException("Stack");
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        return stack[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top <= 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public String toString(){
        if (isEmpty()) {
            return "Stack: {}";
        }

        String text = "Stack: {";
        for (int i = 0; i < top; i++) {
            text = text + stack[i] +", ";
        }
        text = text + "}";
        return text;
    }

    public void expandCapacity(){
        // copies stack with a new length
        stack = Arrays.copyOf(stack, stack.length*2);
    }
}
