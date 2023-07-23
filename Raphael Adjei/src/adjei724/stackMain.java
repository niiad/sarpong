package adjei724;

public class stackMain {
    public static void main(String[] args){
        stackDsa<Integer> stack = new ArrayStack<>();

        stack.push(5);
        stack.push(10);
        stack.push(15);

        System.out.println("Size: " + stack.size()); // Output: Size: 3
        System.out.println("Top element: " + stack.peek()); // Output: Top element: 15
    }
}
