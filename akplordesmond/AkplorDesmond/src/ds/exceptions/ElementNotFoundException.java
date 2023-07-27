package ds.exceptions;

public class ElementNotFoundException extends RuntimeException {
    /**
     * Sets up this exception with an appropriate message.
     * @param collection the name of the collection
     */
    public ElementNotFoundException(String collection)
    {
        super(collection + " Not Found");
    }
}
