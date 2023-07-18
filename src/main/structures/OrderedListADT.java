package main.structures;// Interface for creating ordered list

public interface OrderedListADT<T> {

     // Removes and returns the specified element from this list.
    public T remove(T element);


     // Returns true if this list contains the specified target element.
    public boolean contains(T target);

     // Returns true if this list contains no elements.
    public boolean isEmpty();

     // Returns the number of elements in this list.
    public int size();

     // Returns a string representation of this list.
    public String toString();

     // Adds the specified element to this list at the proper location
    public void add(T element);
}
