package com.example.nicholas_amemazior.amemazior3638;

public interface QueueADT<T> {
    public void enqueue(T element);

    public T dequeue();
    public T first();
    public boolean isEmpty();
    public int size();

}
