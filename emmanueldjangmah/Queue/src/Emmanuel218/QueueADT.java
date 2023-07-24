package Emmanuel218;

public interface QueueADT<E> {
    public void enqueue(E element);

    public E dequeue();

    public E first();

    public boolean isEmpty();

    public int size();

    public void ToString();
}
