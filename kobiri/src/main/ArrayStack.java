package kobiri;

import java.util.Arrays;
public class ArrayStack <T> implements StackADT<T>
{

    /**
     * An array implementation of a stack in which the bottom of the
     * stack is fixed at index 0.
     *
     * @author Java Foundations
     * @version 4.0
     */


        private final static int DEFAULT_CAPACITY = 100;
        private int top;
        private T[] stack;
    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
        /**
         * Creates an empty stack using the specified capacity.
         * @param initialCapacity the initial size of the array
         */
@SuppressWarnings("unchecked")
public ArrayStack(int initialCapacity = 0)
        {
            top = 0;
            stack = (T[])(new Object[initialCapacity]);
        }

    }

    public ArrayStack(int defaultCapacity) {

    }

}
