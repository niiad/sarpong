public class Queue<T> {
    // Malvin Seth Osuro; 10909449
    private int front;
    private int rear;
    private int size;
    private T[] items;

    public Queue(int size) {
        this.size = size;
        this.items = new T[size];
        this.front = 0;
        this.rear = 0;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        items[rear] = item;
        rear = (rear + 1) % size;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T item = items[front];
        items[front] = null;
        front = (front + 1) % size;
        return item;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return items[front];
    }

    public int size() {
        return (rear - front + size) % size;
    }
}