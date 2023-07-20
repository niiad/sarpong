package Lumor327;

public class StackArray {
    private int[] array;
    private int top; // Index of the top element in the stack
    private int capacity;

    public StackArray(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        top = -1; // Initialize top to -1 to represent an empty stack
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow. Cannot push element.");
            return;
        }
        top++;
        array[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Cannot pop element.");
            return -1; // Return a special value to indicate underflow
        }
        int poppedElement = array[top];
        top--;
        return poppedElement;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Return a special value to indicate an empty stack
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }
}
