package Maze;
import java.util.Iterator;
/**
 * ListADT defines the interface to a general list collection.
 **/

public interface ListADT<T> extends Iterable<T>
{

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


