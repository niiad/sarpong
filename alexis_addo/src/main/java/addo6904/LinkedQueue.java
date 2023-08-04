package addo6904;
/**
 * LinkedQueue represents a linked implementation of a queue.
 * @author Alexis Adjeley Addo
 * ID: 10896904
 */
public class LinkedQueue<T> implements QueueADT<T> {
    private int count;
    private LinearNode<T> head, tail;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        count = 0;
        head = tail = null;
    }

    /**
     * Adds the specified element to the tail of this queue.
     *
     * @param element the element to be added to the tail of the queue
     */
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<T>(element);
        if (isEmpty())
            head = node;
        else
            tail.setNext(node);
        tail = node;
        count++;
    }

    /**
     * Removes the element at the head of this queue and returns a
     * reference to it.
     *
     * @return the element at the head of this queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("queue");
        T result = head.getElement();
        head = head.getNext();
        count--;
        if (isEmpty())
            tail = null;
        return result;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}