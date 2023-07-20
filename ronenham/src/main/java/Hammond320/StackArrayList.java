package Hammond320;

import java.util.ArrayList;
import java.util.List;

/**
 * The StackArrayList class represents a stack data structure implemented using an ArrayList.
 * It provides operations for pushing elements, popping elements, checking if the stack is empty,
 * retrieving the top element, and displaying the content of the stack.
 */
public class StackArrayList {

    /**
     * The list to store the elements of the stack.
     */
    private final List<Integer> stackList;


    /**
     * Constructs an empty StackArrayList.
     */
    public StackArrayList(){
        this.stackList = new ArrayList<>();
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param value the element to be pushed onto the stack
     */
    public void push(int value){
        stackList.add(value);
    }

    /**
     * Removes and returns the element from the top of the stack.
     *
     * @return the element that was popped from the top of the stack
     * @throws RuntimeException if the stack is empty
     */
    public  int pop(){
        if(!isEmpty()){
            int popValue = stackList.get(stackList.size() - 1);
            stackList.remove(stackList.size() - 1);
            return popValue;
        } else{
            throw new RuntimeException("Stack is empty");
        }
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty(){
        return  stackList.isEmpty();
    }


    /**
     * Retrieves the top element of the stack without removing it.
     *
     * @return the top element of the stack
     * @throws RuntimeException if the stack is empty
     */
    public int top(){
        if (!isEmpty()){
            return stackList.get(stackList.size() - 1);
        } else{
            throw new RuntimeException("Stack is empty");
        }
    }

    /**
     * Returns a string representation of the contents of the stack.
     *
     * @return a string representation of the contents of the stack
     */
    public String displayContent(){
        return stackList.toString();
    }
}
