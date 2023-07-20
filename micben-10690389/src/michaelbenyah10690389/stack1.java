package michaelbenyah10690389;

package jsjf;
import jsjf.exceptions.*;
import java.util.Arrays;
/**
 * An array implementation of a stack in which the bottom of the
 * stack is fixed at index 0.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayStack<T> implements StackADT<T> {
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the array if necessary.
     *
     * @param element generic element to be pushed onto stack
     */
    public void push(T element) {
        if (size() == stack.length)
            expandCapacity();
        stack[top] = element;
        top++;
    }

    /**
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one.
     */
    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     *
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T pop() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     *
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        return stack[top - 1];
    }
}

