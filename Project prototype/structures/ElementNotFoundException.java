package main.structures;// Exception for when element cannot be found in list

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(String list)
    {
        super("The element cannot be found in the " + list);
    }
}
