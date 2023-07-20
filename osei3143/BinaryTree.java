import java.util.Scanner;

public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    private static class TreeNode<T extends Comparable<T>> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void insert(T data) {
        root = insertNode(root, data);
    }

    private TreeNode<T> insertNode(TreeNode<T> root, T data) {
        if (root == null) {
            root = new TreeNode<>(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertNode(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertNode(root.right, data);
        }

        return root;
    }

    public boolean contains(T data) {
        return containsNode(root, data);
    }

    private boolean containsNode(TreeNode<T> root, T data) {
        if (root == null) {
            return false;
        }

        if (data.equals(root.data)) {
            return true;
        } else if (data.compareTo(root.data) < 0) {
            return containsNode(root.left, data);
        } else {
            return containsNode(root.right, data);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        int number;

        System.out.println("Enter numbers to insert into the binary tree (enter 'done' to stop):");

        while (true) {
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                number = Integer.parseInt(input);
                binaryTree.insert(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done' to stop.");
            }
        }

        System.out.println("Binary Tree contains:");

        while (true) {
            System.out.print("Enter a number to check if it is present in the tree (enter 'done' to exit): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                number = Integer.parseInt(input);
                boolean contains = binaryTree.contains(number);
                System.out.println("Binary Tree contains " + number + ": " + contains);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done' to exit.");
            }
        }
    }
}
