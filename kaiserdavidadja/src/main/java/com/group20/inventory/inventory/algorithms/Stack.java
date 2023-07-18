package jsjf;
import jsjf.exceptions.*;
import java.util.Arrays;

public class Stack {
private final static int DEFAULT_CAPACITY = 100;
private int top;
private T[] stack;

@SuppressWarnings("unchecked")
public ArrayStack(int initialCapacity)
{
top = 0;
stack = (T[])(new Object[initialCapacity]);
}

public void push(T element)
{
if (size() == stack.length)
expandCapacity();
stack[top] = element;
top++;
}

private void expandCapacity()
{
stack = Arrays.copyOf(stack, stack.length * 2);
}
public T pop() throws EmptyCollectionException
{
if (isEmpty())
throw new EmptyCollectionException("stack");
top--;
T result = stack[top];
stack[top] = null;
return result;
}

public T peek() throws EmptyCollectionException
{
if (isEmpty())
throw new EmptyCollectionException("stack");
return stack[top-1];
}

}
