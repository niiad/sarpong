package michaelbenyah10690389;

package jsjf;
import java.util.Iterator;
/**
 * ListADT defines the interface to a general list collection. Specific
 * types of lists will extend this interface to complete the
 * set of necessary operations.
 ** @author Java Foundations
 * * @version 4.0
 * */


public interface ListADT<T> extends Iterable<T> {
    /**
  * * Removes and returns the first element from this list.
  * *
  * * @return the first element from this list
  * */
    public T removeFirst();
    /**
 * * Removes and returns the last element from this list.
 * *
 * * @return the last element from this list
 * */
        public T removeLast();
        /**
 * * Removes and returns the specified element from this list.
 * *
 * * @param element the element to be removed from the list
 * */
        public T remove(T element);
         /**
 * * Returns a reference to the first element in this list.
 * *
 * * @return a reference to the first element in this list
 * */
        public T first();
         /**
 * * Returns a reference to the last element in this list.
 * *
 * * @return a reference to the last element in this list
 * */
        public T last();
        /**
 * * Returns true if this list contains the specified target element.
 * *
 * * @param target the target that is being sought in the list
 * * @return true if the list contains this element
 */
        public boolean contains(T target);
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty();
    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    public int size();
    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    public Iterator<T> iterator();
    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    public String toString();
}
package jsjf;
/**
 * OrderedListADT defines the interface to an ordered list collection. Only
 * Comparable elements are stored, kept in the order determined by
 * the inherent relationship among the elements.
 *
 * @author Java Foundations
 * @version 4.0
 */
public interface OrderedListADT<T> extends ListADT<T>
{
    /**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     */
    public void add(T element);
}
package jsjf;
/**
 * UnorderedListADT defines the interface to an unordered list collection.
 * Elements are stored in any order the user desires.
 *
 * @author Java Foundations
 * @version 4.0
 */
public interface UnorderedListADT<T> extends ListADT<T>
{
    /**
     * Adds the specified element to the front of this list.
     *
     * @param element the element to be added to the front of this list
     */
    public void addToFront(T element);
    /**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the rear of this list
     */
    public void addToRear(T element);
    /**
     * Adds the specified element after the specified target.
     *
     * @param element the element to be added after the target
     * @param target the target is the item that the element will be added
     * after
     */
    public void addAfter(T element, T target);

    /**
     * ArrayList represents an array implementation of a list. The front of
     * the list is kept at array index 0. This class will be extended
     * to create a specific kind of list.
     *
     * @author Java Foundations
     * @version 4.0
     */
    public abstract class ArrayList<T> implements ListADT<T>, Iterable<T>
    {
        private final static int DEFAULT_CAPACITY = 100;
        private final static int NOT_FOUND = -1;
        protected int rear;
        protected T[] list;
        protected int modCount;
        /**
         * Creates an empty list using the default capacity.
         */
        public ArrayList()
        {
            this(DEFAULT_CAPACITY);
        }
        /**
         * Creates an empty list using the specified capacity.
         *
         * @param initialCapacity the size of the array list
         */
        public ArrayList(int initialCapacity)
        {
            rear = 0;
            list = (T[])(new Object[initialCapacity]);
            modCount = 0;
        }
        /**
         * Removes and returns the specified element.
         *
         * @param element the element to be removed and returned from the list
         * @return the removed elememt
         * @throws ElementNotFoundException if the element is not in the list
         */
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
            modCount++;
            return result;
        }
        /**
         * Returns the array index of the specified element, or the
         * constant NOT_FOUND if it is not found.
         *
         * @param target the target element
         * @return the index of the target element, or the
         * NOT_FOUND constant
         */
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
        /**
         * Returns true if this list contains the specified element.
         *
         * @param target the target element
         * @return true if the target is in the list, false otherwise
         */
        public boolean contains(T target)
        {
            return (find(target) != NOT_FOUND);
        }
        /**
         * Adds the specified Comparable element to this list, keeping
         * the elements in sorted order.
         *
         * @param element the element to be added to the list
         */
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
            modCount++;
        }
        /**
         * Adds the specified element after the specified target element.
         * Throws an ElementNotFoundException if the target is not found.
         *
         * @param element the element to be added after the target element
         * @param target the target that the element is to be added after
         */
        public void addAfter(T element, T target)
        {
            if (size() == list.length)
                expandCapacity();
            int scan = 0;
// find the insertion point
            while (scan < rear && !target.equals(list[scan]))
                scan++;
            if (scan == rear)
                throw new ElementNotFoundException("UnorderedList");
            scan++;
// shift elements up one
            for (int shift=rear; shift > scan; shift--)
                list[shift] = list[shift-1];
// insert element
            list[scan] = element;
            rear++;
            modCount++;
        }

        /**
         * LinkedList represents a linked implementation of a list.
         *
         * @author Java Foundations
         * @version 4.0
         */
        public abstract class LinkedList<T> implements ListADT<T>, Iterable<T>
        {
            protected int count;
            protected LinearNode<T> head, tail;
            protected int modCount;
            /**
             * Creates an empty list.
             */
            public LinkedList()
            {
                count = 0;
                head = tail = null;
                modCount = 0;
            }
            /**
             * Removes the first instance of the specified element from this
             * list and returns it. Throws an EmptyCollectionException
             * if the list is empty. Throws a ElementNotFoundException if the
             * specified element is not found in the list.
             *
             * @param targetElement the element to be removed from the list
             * @return a reference to the removed element
             * @throws EmptyCollectionException if the list is empty
             * @throws ElementNotFoundException if the target element is not found
             */
            public T remove(T targetElement) throws EmptyCollectionException,
                    ElementNotFoundException
            {
                if (isEmpty())
                    throw new EmptyCollectionException("LinkedList");
                boolean found = false;
                LinearNode<T> previous = null;
                LinearNode<T> current = head;
                while (current != null && !found)
                    if (targetElement.equals(current.getElement()))
                        found = true;
                    else
                    {
                        previous = current;
                        current = current.getNext();
                    }
                if (!found)
                    throw new ElementNotFoundException("LinkedList");
                if (size() == 1) // only one element in the list
                    head = tail = null;
                else if (current.equals(head)) // target is at the head
                    head = current.getNext();
                else if (current.equals(tail)) // target is at the tail
                {
                    tail = previous;
                    tail.setNext(null);
                }
                else // target is in the middle
                    previous.setNext(current.getNext());
                count--;
                modCount++;
                return current.getElement();
            }
            
