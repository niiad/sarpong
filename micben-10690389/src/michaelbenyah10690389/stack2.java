package michaelbenyah10690389;

import java.util.Stack;

public class Stack2{
    public static void main(String a[]){
        // declare stack object
        Stack<Integer> stack = new stack Stack<>();
        //print initial stack
        System.out.println("Initial stack : " + stack);
        //isEmpty ()
        System.out.println("is stack Empty? : " + stack.isEmpty());
        //push () operation
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        //print non-empty stack
        System.out.println("Stack after push : " + stack);
        //pop () operation
        System.out.println("Element popped out: " + stack.pop());
        System.out.println("Stack after pop : " + stack);
        //search () operation
        System.out.println("Element 10 found at position: " + stack.search(10));
        System.out.println("i stack empty : " + stack.isEmpty());


    }
}
