package adjeiQueue;

public interface QueueDsa<T>{
    void enqueue(T element);

    T dequeue();

    int size();

    T peek();

    //T first();

    boolean isEmpty();
}
