package Emmanuel218;

import java.util.Arrays;

public class StackArray<T> implements StackADT<T> {
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    // Initializes stack with a default capacity of 100
    public StackArray() {
        this(DEFAULT_CAPACITY);
    }

    // Initializes stack with specified capacity
    @SuppressWarnings("unchecked")
    public StackArray(int initialCapacity) {
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }

    // Push elements to stack
    @Override
    public void push(T element) {
        if (size() == stack.length)
            expandCapacity();
        stack[top] = element;
        top++;
    }

    // Double size of stack
    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    // Removes last element from stack and returns value
    @Override
    public T pop() {
        if (top == 0)
            return null;
        top--;
        T result = stack[top];
        stack[top] = null;

        return result;
    }

    // Returns value of last element in stack
    @Override
    public T peek() {
        if (top == 0)
            return null;
        return stack[top - 1];
    }

    // Returns total number of elements in stack
    @Override
    public int size() {
        return top;
    }

    // Verifies if stack is empty
    @Override
    public boolean isEmpty() {
        if (top == 0)
            return true;
        return false;
    }

    // Prints array of elements in stack
    @Override
    public void printStack(){
        System.out.println(Arrays.toString(stack));
    }
}
