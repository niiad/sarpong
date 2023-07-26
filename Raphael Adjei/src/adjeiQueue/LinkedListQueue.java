package adjeiQueue;

public class LinkedListQueue<T> implements QueueDsa<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    public LinkedListQueue(){
        head = tail = null;
        size = 0;
    }


    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<T>(element);
        if (isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty.");
        }
        T element = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return element;
    }

    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty.");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
