package Lumor327;


public class Queues {
        private int[] array;
        private int front;  // Index of the front element
        private int rear;   // Index of the rear element
        private int size;   // Current number of elements in the queue

        public Queues(int capacity) {
            array = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == array.length;
        }

        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot enqueue " + item);
                return;
            }
            rear = (rear + 1) % array.length;
            array[rear] = item;
            size++;
            System.out.println("Enqueued: " + item);
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1;
            }
            int item = array[front];
            front = (front + 1) % array.length;
            size--;
            System.out.println("Dequeued: " + item);
            return item;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty. No element to peek.");
                return -1;
            }
            return array[front];
        }

        public int size() {
            return size;
        }}


