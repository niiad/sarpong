package Emmanuel218;

/*
Emmanuel Kodjo Djangmah
10868218
 */

public class Main {

    static QueueArray<Integer> queue = new QueueArray<>(5);

    public static void main(String[] args) {
//        Add elements to queue
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(9);
        queue.enqueue(13);
        queue.enqueue(84);
        queue.enqueue(76);

//        Print first element in queue
        System.out.println("First element in queue is " + queue.first());

//        Print number of elements in queue
        System.out.println("Number of elements in queue is " + queue.size());

//        Show elements in queue
        queue.ToString();

//        Remove elements from queue
        System.out.println("Removed " + queue.dequeue());
        System.out.println("Removed " + queue.dequeue());
        System.out.println("Removed " + queue.dequeue());

//        Print first element in queue
        System.out.println("First element in queue is " + queue.first());

//        Print number of elements in queue
        System.out.println("Number of elements in queue is " + queue.size());

//        Show elements in queue
        queue.ToString();

//        Verify if queue is empty
        System.out.println("The queue is empty: " + queue.isEmpty());
    }
}