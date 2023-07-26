package jss2;

public class QueueArrayImplementation {
    public static void main(String[] args) {
        // Create a queue of capacity 4
        Queue q = new Queue(4);

        System.out.println("Initial Queue:");
        // print Queue elements
        q.queueDisplay();

        // inserting elements in the queue
        q.queueEnqueue(10);
        q.queueEnqueue(30);
        q.queueEnqueue(50);
        q.queueEnqueue(70);

        // print Queue elements
        System.out.println("Queue after Enqueue Operation:");
        q.queueDisplay();

        // print front of the queue
        q.queueFront();

        // insert element in the queue
        q.queueEnqueue(90);

        // print Queue elements
        q.queueDisplay();

        q.queueDequeue();
        q.queueDequeue();
        System.out.printf("\nQueue after two dequeue operations:");

        // print Queue elements
        q.queueDisplay();

        // print front of the queue
        q.queueFront();
    }
}
