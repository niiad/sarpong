package Malvin;

public interface StackINT<S> {
    public void push (S element);

    public S pop();

    public S peek();

    public int size();

    public boolean isEmpty();

    public void printStack();
}

