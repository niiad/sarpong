package main.structures;//Ordered List implementation using Arrays

import java.util.Arrays;
import java.util.List;

public class OrderedList<T> implements OrderedListADT<T> {
    private final static int DEFAULT_CAPACITY = 100;
    private final static int NOT_FOUND = -1;
    protected int rear;
    protected T[] list;

    // Creates an empty list using the default capacity.
    public OrderedList()
    {
        this(DEFAULT_CAPACITY);
    }

    // Creates an empty list using the specified capacity.
    public OrderedList(int initialCapacity)
    {
        rear = 0;
        list = (T[])(new Object[initialCapacity]);
    }

    // recreates array to with double capacity
    private void expandCapacity()
    {
        list = Arrays.copyOf(list, list.length * 2);
    }

    // Returns true if this list contains no elements.
    public boolean isEmpty(){
        return rear == 0;
    }

    // Returns the number of elements in this list.
    public int size() {
        return rear;
    }


    // Removes and returns the specified element.
    public T remove(T element)
    {
        T result;
        int index = find(element);
        if (index == NOT_FOUND)
            throw new ElementNotFoundException("ArrayList");
        result = list[index];
        rear--;
        // shift the appropriate elements
        for (int scan=index; scan < rear; scan++)
            list[scan] = list[scan+1];
        list[rear] = null;
        return result;
    }

    // Returns the array index of the specified element, or the
    private int find(T target)
    {
        int scan = 0;
        int result = NOT_FOUND;
        if (!isEmpty())
            while (result == NOT_FOUND && scan < rear)
                if (target.equals(list[scan]))
                    result = scan;
                else
                    scan++;
        return result;
    }

    // Returns true if this list contains the specified element.
    public boolean contains(T target)
    {
        return (find(target) != NOT_FOUND);
    }


    // Adds the specified Comparable element to this list, keeping
    public void add(T element)
    {
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("OrderedList");
        Comparable<T> comparableElement = (Comparable<T>)element;
        if (size() == list.length)
            expandCapacity();
        int scan = 0;
        // find the insertion location
        while (scan < rear && comparableElement.compareTo(list[scan]) > 0)
            scan++;
        // shift existing elements up one
        for (int shift=rear; shift > scan; shift--)
            list[shift] = list[shift-1];
        // insert element
        list[scan] = element;
        rear++;
    }

    // Returns a string representation of this stack.
    public String toString(){
        if (isEmpty()){
            return "Empty Stack";
        } else {
            String Output = "";

            for (int i = 0; i < rear; i++) {
                Output += list[i] + "\n";
            }

            return Output;
        }

    }

    // Returns a list of all elements.
    public List<T> getList(){

        T[] slice = Arrays.copyOfRange(list, 0, rear);

        return Arrays.asList(slice);

    }
}
