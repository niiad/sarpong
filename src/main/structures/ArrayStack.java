package main.structures;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayStack<T> implements StackADT<T>{
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;


    // Construct Empty stack with default capacity
    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }


    // Construct Empty stack with default capacity
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity){
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }

    // Adds the specified element to the top of this stack, expanding
    // the capacity of the array if necessary.
    public void push(T element){
        if (size() == stack.length){
            expandCapacity();
        }

        stack[top] = element;
        top++;
    }

    // recreates array to with double capacity
    private void expandCapacity()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    // Removes the element at the top of the stack and returns it
    // throws error if stack is empty
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    // Returns element at the op of the stack
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        return stack[top-1];
    }

    // Returns true if this stack contains no elements.
    public boolean isEmpty(){
        return top == 0;
    }

    // Returns the number of elements in this stack.
    public int size() {
        return top;
    }

    // Returns a string representation of this stack.
    public String toString(){
        if (isEmpty()){
            return "Empty Stack";
        } else {
            String Output = "";

            for (int i = 0; i < top; i++) {
                Output += stack[i] + "\n";
            }

            return Output;
        }

    }

    // Returns a list representation of this stack.
    public List<T> getStack(){

        T[] slice = Arrays.copyOfRange(stack, 0, top);

        return Arrays.asList(slice);

    }

    // iterator
    public Iterator<T> iterator()
    {
        T[] slice = Arrays.copyOfRange(stack, 0, top);
        Collections.reverse(Arrays.asList(slice));
        return Arrays.asList(slice).iterator();
    }


}
