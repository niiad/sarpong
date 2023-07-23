package Jerry405;

import java.util.Arrays;

public class ImplementStack<I> implements StackInterface<I> {
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private I[] stack;

    public ImplementStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ImplementStack(int initialCapacity) {
        top = 0;
        stack = (I[]) (new Object[initialCapacity]);
    }

    @Override
    public void push(I element) {
        if (size() == stack.length)
            expandCapacity();
        stack[top] = element;
        top++;
    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    @Override
    public I pop() {
        if (top == 0)
            return null;
        top--;
        I result = stack[top];
        stack[top] = null;

        return result;
    }

    @Override
    public I peek() {
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
