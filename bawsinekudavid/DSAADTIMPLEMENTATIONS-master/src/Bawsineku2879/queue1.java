package Bawsineku2879;


import java.util.LinkedList;
import java.util.Queue;

public interface queue1 {


    public class QueueExample {
        public static void main(String[] args) {
            Queue<String> queue = new LinkedList<>();

            // Adding elements to the queue
            queue.offer("Mango");
            queue.offer("Pear");
            queue.offer("Palm");
            queue.offer("Orange");

            System.out.println("Initial Queue: " + queue);

            // Accessing the elements of the queue
            String firstElement = queue.peek();
            System.out.println("First Element: " + firstElement);

            // Removing elements from the queue
            String removedElement = queue.poll();
            System.out.println("Removed Element: " + removedElement);

            System.out.println("Modified Queue: " + queue);
        }
    }


}


