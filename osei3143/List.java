import java.util.ArrayList;
import java.util.Scanner;

public class List<T> {
    private ArrayList<T> elements;

    public List() {
        elements = new ArrayList<>();
    }

    public void add(T item) {
        elements.add(item);
    }

    public void remove(T item) {
        elements.remove(item);
    }

    public boolean contains(T item) {
        return elements.contains(item);
    }

    public T get(int index) {
        return elements.get(index);
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        List<Integer> list = new List<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        int number;

        System.out.println("Enter elements to add to the list (enter 'done' to stop):");

        while (true) {
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                number = Integer.parseInt(input);
                list.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done' to stop.");
            }
        }

        System.out.println("List size: " + list.size());
        System.out.println("List elements:");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("\nChoose a method to execute:");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.println("3. Contains");
        System.out.println("4. Get");
        System.out.println("5. Size");
        System.out.println("6. Exit");

        while (true) {
            System.out.print("Enter your choice: ");
            int choice;
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to add to the list: ");
                    try {
                        number = Integer.parseInt(scanner.nextLine());
                        list.add(number);
                        System.out.println("Number added to the list.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    break;
                case 2:
                    System.out.print("Enter a number to remove from the list: ");
                    try {
                        number = Integer.parseInt(scanner.nextLine());
                        if (list.contains(number)) {
                            list.remove(number);
                            System.out.println("Number removed from the list.");
                        } else {
                            System.out.println("Number not found in the list.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter a number to check if it is present in the list: ");
                    try {
                        number = Integer.parseInt(scanner.nextLine());
                        System.out.println("List contains number: " + list.contains(number));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    break;
                case 4:
                    System.out.print("Enter an index to get the element from the list: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine());
                        if (index >= 0 && index < list.size()) {
                            System.out.println("Element at index " + index + ": " + list.get(index));
                        } else {
                            System.out.println("Invalid index. Please enter a valid index within the range of the list.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    break;
                case 5:
                    System.out.println("List size: " + list.size());
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
