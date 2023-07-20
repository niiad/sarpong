package Hammond320;

import java.util.EmptyStackException;

public class GenericStack<T> {
    private int maxSize;
    private int top;
    private T[] stackArray;

    public GenericStack(int size) {
        maxSize = size;
        stackArray = (T[]) new Object[maxSize];
        top = -1;
    }

    public void push(T value) {
        if (top == maxSize - 1) {
            throw new StackOverflowError("Stack is full. Cannot push element.");
        }
        stackArray[++top] = value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T poppedValue = stackArray[top];
        stackArray[top--] = null;
        return poppedValue;
    }

    public T top(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize - 1);
    }

    public int size(){
        return top + 1;
    }

    public void displayContent(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack(top to bottom): ");
        for (int i = top; i > 0; i--){
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }


}

