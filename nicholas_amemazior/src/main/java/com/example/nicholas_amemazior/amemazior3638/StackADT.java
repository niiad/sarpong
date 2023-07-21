package com.example.nicholas_amemazior.amemazior3638;

public interface StackADT<T>{
    public void push(T element);

    public T pop();

    public T peek();

    public boolean isEmpty();

    public int size();
}