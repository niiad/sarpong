import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue<T> {
    private LinkedList<T> elements;

    public Queue() {
        elements = new LinkedList<>();
    }

    public void enqueue(T item) {
        elements.addLast(item);
    }

    public T dequeue() {
        return elements.removeFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        int number;

        System.out.println("Enter elements to enqueue in the queue (enter 'done' to stop):");

        while (true) {
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                number = Integer.parseInt(input);
                queue.enqueue(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done' to stop.");
            }
        }

        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue elements:");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        System.out.println("\nChoose a method to execute:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. isEmpty");
        System.out.println("4. size");
        System.out.println("5. Exit");

        while (true) {
            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to enqueue: ");
                    try {
                        number = Integer.parseInt(scanner.nextLine());
                        queue.enqueue(number);
                        System.out.println("Number enqueued.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    break;
                case 2:
                    try {
                        if (!queue.isEmpty()) {
                            System.out.println("Dequeued element: " + queue.dequeue());
                        } else {
                            System.out.println("Queue is empty.");
                        }
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 3:
                    System.out.println("Queue is empty: " + queue.isEmpty());
                    break;
                case 4:
                    System.out.println("Queue size: " + queue.size());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }
}
