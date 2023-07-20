package Hammond320;

import java.util.Arrays;



/**
 * The StackArray class represents a stack data structure implemented using an array.
 * It provides methods for performing stack operations such as push, pop, and checking
 * the top element of the stack. The stack has a fixed capacity determined during its
 * initialization.
 */
public class StackArray {
    private int top;
    private final int[] array;
    private final int capacity;

    public StackArray(int capacity){
        this.top = -1;
        this.array = new int[capacity];
        this.capacity = capacity;

    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element the element to be pushed onto the stack
     * @throws RuntimeException if the stack is already full
     */
    public void push(int element){
        if(isFull()){
            throw new RuntimeException("Stack is full.");
        }
        array[++top] = element;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws RuntimeException if the stack is empty
     */
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        int element = array[top];
        top--;
        return element;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws RuntimeException if the stack is empty
     */
    public int top(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull(){
        return top == capacity - 1;
    }

    /**
     * Returns a string representation of the elements in the stack.
     *
     * @return a string representation of the stack's content
     */
    public String displayContent(){
        return Arrays.toString(array);
    }
}

