package Tetteh647;

//********************************************************************
// LinkedStack.java Java Foundations
//
// Represents a linked implementation of a stack.
//********************************************************************

import java.util.Stack;

public class LinkedStack<T> extends Stack<T> {
    private int count;
    private LinearNode<T> top;
    //-----------------------------------------------------------------
// Creates an empty stack using the default capacity.
//-----------------------------------------------------------------
    public LinkedStack()
    {
        count = 0;
        top = null;
    }
    //-----------------------------------------------------------------
// Removes the element at the top of this stack and returns a
// reference to it. Throws an EmptyCollectionException if the
// stack contains no elements.
//-----------------------------------------------------------------
    public T pop() {
        if (count == 0)
            try {
                throw new EmptyCollectionException ("Pop operation failed. "
                        + "The stack is empty.");
            } catch (EmptyCollectionException e) {
                throw new RuntimeException(e);
            }
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }
    //-----------------------------------------------------------------
// Returns a string representation of this stack.
//-----------------------------------------------------------------
    public String toString()
    {
        String result = "<top of stack>\n";
        LinearNode current = top;
        while (current != null)
        {
            result += current.getElement() + "\n";
            current = current.getNext();
        }
        return result + "<bottom of stack>";
    }
//-----------------------------------------------------------------
// The following methods are left as programming projects.
//-----------------------------------------------------------------
// public void push () { }
// public T peek () throws EmptyCollectionException { }
// public boolean isEmpty() { }
// public int size() { }
}
