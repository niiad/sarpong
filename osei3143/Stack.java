import java.util.LinkedList;
import java.util.Scanner;

public class Stack<T> {
    private LinkedList<T> elements;

    public Stack() {
        elements = new LinkedList<>();
    }

    public void push(T item) {
        elements.addFirst(item);
    }

    public T pop() {
        return elements.removeFirst();
    }

    public T peek() {
        return elements.getFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        int number;

        System.out.println("Enter numbers to push onto the stack (Enter 'done' to halt current session):");

        while (true) {
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                number = Integer.parseInt(input);
                stack.push(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done' to halt session.");
            }
        }

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack elements:");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("\nChoose a method to perform:");
        System.out.println("1. push");
        System.out.println("2. pop");
        System.out.println("3. peek");
        System.out.println("4. isEmpty");
        System.out.println("5. size");
        System.out.println("6. Exit");

        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to push onto the stack: ");
                    number = scanner.nextInt();
                    stack.push(number);
                    System.out.println("Number pushed onto the stack.");
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println("Popped element: " + stack.pop());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println("Peeked element: " + stack.peek());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Stack is empty: " + stack.isEmpty());
                    break;
                case 5:
                    System.out.println("Stack size: " + stack.size());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }
}
