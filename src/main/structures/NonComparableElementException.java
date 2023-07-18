package main.structures;// Exception for when non-comparable element is added

public class NonComparableElementException extends RuntimeException{
    public NonComparableElementException(String list)
    {
        super("The element cannot be added to the " + list);
    }
}
