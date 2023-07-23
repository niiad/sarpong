package javafoundations;
import javafoundations.exceptions.*;
public class ArrayStack<T> implements Stack<T>
{
private final int DEFAULT_CAPACITY = 10;
private int count;
private T[] stack;

public ArrayStack()
{
count = 0;
stack = (T[]) (new Object[DEFAULT_CAPACITY]);
}

public void push (T element)
{
if (count == stack.length)
expandCapacity();
stack[count] = element;
count++;
}
