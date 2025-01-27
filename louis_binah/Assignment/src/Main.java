
// ID - 10899830

public class Main {
    public static void main(String[] args) {
        MyQueue myqueue = new MyQueue();
        myqueue.enqueue("element 1");
        myqueue.enqueue("element 2");
        myqueue.enqueue("element 3");

        System.out.println("my queue :" + myqueue);

        String RemoveElement = myqueue.dequeue();

       System.out.println("removing element " + RemoveElement);


        String HeadElement = myqueue.peek();

       System.out.println("Printing the head element: " + HeadElement );


        boolean IsEmpty = myqueue.IsEmpty();
        System.out.println("Checking if the Queue is empty: " + IsEmpty);
        int Size  = myqueue.Size();
        System.out.println("The Size of the Queue: " + Size);

        MyStack stack = new MyStack(5);
        stack.push(3);
        stack.push(5);
        stack.push(8);
        stack.push(20);
        stack.push(30);
        stack.printStack();

        int popElemet = stack.pop();
        System.out.println("Pop Element: " + popElemet);

        int peekElement = stack.peek();
        System.out.println("peek Element: " + peekElement);

        boolean empty = stack.isEmpty();
        System.out.println("Is the Stack empty: " + empty);

        boolean full = stack.isFull();
        System.out.println("Is the Stack full: " + full);

        int size = stack.size();
        System.out.println("the size of the stack is : " + size);

    }
}
