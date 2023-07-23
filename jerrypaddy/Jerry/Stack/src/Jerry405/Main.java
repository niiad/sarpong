package Jerry405;

/*
Jerry Paddy
10922405
 */

public class Main {
    static ImplementStack<String> stack = new ImplementStack<>(5);

    public static void main(String[] args) {
        stack.push("I");
        stack.push("am");
        stack.push("Jerry");
        stack.push("Goat");

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Top of stack: " + stack.peek());

        System.out.println("Stack size: " + stack.size());

        System.out.println("Stack is empty: " + stack.isEmpty());

        stack.printStack();
    }
}