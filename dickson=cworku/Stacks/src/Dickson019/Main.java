package Dickson019;

// Dickson Agborgbor Cworku
// 10910019

public class Main {
    static StackArray<Integer> stack = new StackArray<Integer>(5);

    public static void main(String[] args){
        stack.push(10);
        stack.push(8);
        stack.push(18);
        stack.push(11);

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Element on top of stack: " + stack.peek());

        System.out.println("Stack size: " + stack.size());

        System.out.println("Stack is empty: " + stack.isEmpty());

        stack.printStack();
    }
}
