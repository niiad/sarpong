package Jerry405;

public interface StackInterface<I> {
    public void push (I element);

    public I pop();

    public I peek();

    public int size();

    public boolean isEmpty();

    public void printStack();
}
