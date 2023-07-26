package Malvin;

import java.util.Arrays;

public class StackArray<S> implements StackINT<S> {
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private S[] stack;

    public StackArray() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public StackArray(int initialCapacity) {
        top = 0;
        stack = (S[]) (new Object[initialCapacity]);
    }

    @Override
    public void push(S element) {
        if (size() == stack.length)
            expandCapacity();
        stack[top] = element;
        top++;
    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    @Override
    public S pop() {
        if (top == 0)
            return null;
        top--;
        S result = stack[top];
        stack[top] = null;

        return result;
    }

    @Override
    public S peek() {
        if (top == 0)
            return null;
        return stack[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void printStack(){
        System.out.println(Arrays.toString(stack));
    }
}
