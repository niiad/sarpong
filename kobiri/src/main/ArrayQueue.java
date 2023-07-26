package kobiri;

public class ArrayQueue<T> implements Queues<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] items;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        items = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T item) {
        if (size == items.length) {
            resizeArray();
        }
        rear = (rear + 1) % items.length;
        items[rear] = item;
        size++;
    }


    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        size--;
        return item;
    }


    public int size() {
        return size;
    }

    public void clear() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }


    public void display() {
        System.out.print("Queue: ");
        int current = front;
        for (int i = 0; i < size; i++) {
            System.out.print(items[current] + " ");
            current = (current + 1) % items.length;
        }
        System.out.println();
    }

    private void resizeArray() {
        int newCapacity = items.length * 2;
        T[] newItems = (T[]) new Object[newCapacity];
        int current = front;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[current];
            current = (current + 1) % items.length;
        }
        items = newItems;
        front = 0;
        rear = size - 1;
    }
}
