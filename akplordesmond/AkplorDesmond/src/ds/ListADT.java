package ds;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T> {

    public T removeFirst();


    public T removeLast();


    public T remove(T element);


    public T first();

    public T last();


    public boolean contains(T target);


    public boolean isEmpty();


    public int size();


    public Iterator<T> iterator();


    public String toString();
}