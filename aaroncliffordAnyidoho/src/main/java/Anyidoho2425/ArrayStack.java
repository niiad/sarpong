package Anyidoho2425;

public class ArrayStack<T> implements Stack<T> {
    private final int DEFAULT_CAPACITY = 10;
    private int count;
    private T[] stack;

    public ArrayStack() {
        count = 0;
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T element) {
        if (count == stack.length)
            expandCapacity();
        stack[count] = element;
        count++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        T removedElement = stack[count - 1];
        stack[count - 1] = null;
        count--;
        return removedElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stack[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public String toString() {
        if (isEmpty()) {
            return "<top of stack>\n<bottom of stack>";
        }

        StringBuilder sb = new StringBuilder("<top of stack>\n");
        for (int index = count - 1; index >= 0; index--) {
            sb.append(stack[index]).append("\n");
        }
        sb.append("<bottom of stack>");
        return sb.toString();
    }

    private void expandCapacity() {
        T[] larger = (T[]) new Object[stack.length * 2];
        for (int index = 0; index < stack.length; index++) {
            larger[index] = stack[index];
        }
        stack = larger;
    }
}
