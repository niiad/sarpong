package kobiri;

public interface Queues <T> {
    boolean isEmpty();
    void enqueue(T item);
    T dequeue();
    int size();
    void clear();
    void display();
}
