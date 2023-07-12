import java.util.Stack;

public class MyStack {
    private int maxSize;
    private int[] arrayStack;
    private int top;

    public MyStack(int size) {
        maxSize = size;
        arrayStack = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack is full cannot push element");
            return;
        }
        arrayStack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("the stack is empty cannot remove element");
            return -1;
        }
        return arrayStack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("the stack is empty cannot retrieve element");
            return -1;
        }
        return arrayStack[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arrayStack[i] + " ");
        }
        System.out.println();
    }

    public int size() {
        return top + 1;
    }
}
