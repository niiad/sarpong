package Emmanuel218;

/*
Emmanuel Kodjo Djangmah
10868218
 */

public class Main {

    static StackArray<String> stack = new StackArray<>(5);

    public static void main(String[] args) {
        // Push elements to stack
        stack.push("I");
        stack.push("used");
        stack.push("arrays");
        stack.push("in");
        stack.push("implementing");
        stack.push("stack");

        // Pop elements from stack
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        // Inspect element at top of stack
        System.out.println("Element at top of stack: " + stack.peek());

        // Checks the size or total number of elements present
        System.out.println("There are(is) " + stack.size() + " element(s) in stack");

        // Verifies if stack is empty
        System.out.println("Stack is empty: " + stack.isEmpty());

        stack.printStack();
    }
}