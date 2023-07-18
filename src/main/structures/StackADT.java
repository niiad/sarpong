package main.structures;

public interface StackADT<T> {

    // Adds the specified element to the top of this stack.
    public void push(T element);

    // Removes and returns the top element from this stack.
    public T pop();

    // Returns without removing the top element of this stack.
    public T peek();

    // Returns true if this stack contains no elements.
    public boolean isEmpty();

    // Returns the number of elements in this stack.
    public int size();

    // Returns a string representation of this stack.
    public String toString();
}
