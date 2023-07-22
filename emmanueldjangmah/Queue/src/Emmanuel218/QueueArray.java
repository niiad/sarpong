package Emmanuel218;

import java.util.Arrays;

public class QueueArray<E> implements QueueADT<E> {
    private final static int DEFAULT_CAPACITY = 100;
    private int last;
    private E[] queue;

    // Initializes queue with a default capacity of 100
    public QueueArray() {
        this(DEFAULT_CAPACITY);
    }

    // Initializes queue with specified capacity
    @SuppressWarnings("unchecked")
    public QueueArray(int initialCapacity) {
        last = 0;
        queue = (E[]) (new Object[initialCapacity]);
    }
    @Override
    public void enqueue(E element) {
        if (size() == queue.length)
            expandCapacity();
        queue[last] = element;
        last++;
    }

    private void expandCapacity() {
        queue = Arrays.copyOf(queue, queue.length * 2);
    }

    @Override
    public E dequeue() {
        if (last == 0)
            return null;
        E result = queue[0];
        queue[0] = null;
        for (int i = 1; i <= last; i++)
            queue[i-1] = queue[i];
        last--;
        return result;
    }

    @Override
    public E first() {
        if (last == 0)
            return null;
        return queue[0];
    }

    @Override
    public boolean isEmpty() {
        if (last == 0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return last;
    }

    @Override
    public void ToString() {
        System.out.println(Arrays.toString(queue));
    }
}
