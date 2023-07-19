package Dankyi749;

public class Stack {
        private int myArrayElements[];
        private int topElement;
        private int capacity;

        // Constructor to initialize the stack
        Stack(int size)
        {
            myArrayElements = new int[size];
            capacity = size;
            topElement = -1;
        }

        //adding an element `x` to the stack
        public void push(int x)
        {
            if (isFull())
            {
                System.out.println("Overflow\nProgram Terminated\n");
                System.exit(-1);
            }

            System.out.println("Inserting " + x);
            myArrayElements[++topElement] = x;
        }

        //removing elements from the stack, using pop()
        public int pop()
        {
            // check for stack underflow
            if (isEmpty())
            {
                System.out.println("Underflow\nProgram Terminated");
                System.exit(-1);
            }

            System.out.println("Removing " + peek());

            // decrease stack size by 1 and (optionally) return the popped element
            return myArrayElements[topElement--];
        }

        //returning the top element of the stack, using peek()
        public int peek()
        {
            if (!isEmpty()) {
                return myArrayElements[topElement];
            }
            else {
                System.exit(-1);
            }

            return -1;
        }

        //Size of the stack
        public int size() {
            return topElement + 1;
        }

        //checking if the stack is empty or not
        public boolean isEmpty() {
            return topElement == -1;
        }

        //checking if the stack is full or not
        public boolean isFull() {
            return topElement == capacity - 1;
        }
    }


    // Running the operations of Stack
    class Main
    {
        public static void main (String[] args)
        {
            Stack stack = new Stack(6);

            stack.push(1);
            stack.push(2);

            stack.pop();
            stack.pop();

            stack.push(3);

            stack.push(4);
            stack.push(5);
            stack.push(6);


            // to check if the isFull method works, uncomment the push functions below
            
            /*
            stack.push(7);
            stack.push(8);
            stack.push(9);
            stack.push(10);
             */


            System.out.println("The top element is " + stack.peek());
            System.out.println("The stack size is " + stack.size());

            stack.pop();

            if (stack.isEmpty()) {
                System.out.println("The stack is empty");
            }
            else {
                System.out.println("The stack is not empty");
            }
            System.out.println("The stack size is " + stack.size());

        }
}
