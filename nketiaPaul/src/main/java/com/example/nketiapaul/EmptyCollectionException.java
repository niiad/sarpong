package main.project;

public class EmptyCollectionException extends RuntimeException{
    public EmptyCollectionException(String collection)
    {
        super("The " + collection + " is empty.");
    }
}

