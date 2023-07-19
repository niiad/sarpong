package com.Binah830.StackAssignments;
// ID - 10899830

public class LinearNode<T> {
    private LinearNode<T> next;
    private T element;
    /**
     * Creates an empty node.
     */
    public LinearNode()
    {
        next = null;
        element = null;
    }
    /**
     * Creates a node storing the specified element.
     * @param elem element to be stored
     */
    public LinearNode(T elem)
    {
        next = null;
        element = elem;
    }
    public LinearNode<T> getNext()
    {
        return next;
    }
    /**
     * Sets the node that follows this one.
     * @param node node to follow this one
     */
    public void setNext(LinearNode<T> node)
    {
        next = node; }
    /**
     * Returns the element stored in this node.
     * @return element stored at the node
     */
    public T getElement()
    {
        return element;
    }
    /**
     * Sets the element stored in this node.
     * @param elem element to be stored at this node
     */
    public void setElement(T elem)
    {
        element = elem;
    }


}
