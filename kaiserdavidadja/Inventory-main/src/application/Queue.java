package application;

public class Queue {
    private static  int front, rear, capacity;
    private static String queue[];

    Queue(int size){
        front = rear = 0;
        capacity = size;
        queue = new String [capacity];
    }

    // insert an element into the queue
    static void queueEnqueue(String item)  {
        // check if the queue is full
        if (capacity == rear) {
            System.out.printf("\nQueue is full\n");
            return;
        }

        // insert element at the rear
        else {
            queue[rear] = item;
            rear++;
        }
        return;
    }

    //remove an element from the queue
    static void queueDequeue()  {
        // check if queue is empty
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
            return;
        }

        // shift elements to the right by one place uptil rear
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }

            // set queue[rear] to 0
            if (rear < capacity)
                queue[rear] = null;

            // decrement rear
            rear--;
        }
        return;
    }

    // print queue elements
    static void  queueDisplay()
    {
        int i;
        if (front == rear) {
            System.out.printf("Queue is Empty\n");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.print(" "+ queue[i]);
        }
        return;
    }

    // print front of queue
    static void queueFront()
    {
        if (front == rear) {
            System.out.print("Queue is Empty\n");
            return;
        }
        System.out.print("\nFront Element of the queue is : "+ queue[front]);
        return;
    }
}
