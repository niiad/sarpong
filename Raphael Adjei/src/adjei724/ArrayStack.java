package adjei724;

public class ArrayStack<T> implements stackDsa<T>{
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    public ArrayStack(){
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public void push(T element){
        if(top == stack.length - 1){
            expandCapacity();
        }
        stack[++top] = element;
    }

    public T pop(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty.");
        }
        T element = stack[top];
        stack[top--] = null;
        return element;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int size(){
        return top + 1;
    }
    public T peek(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty.");
        }
        return stack[top];
    }
    private void expandCapacity(){
        T[] newStack = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
