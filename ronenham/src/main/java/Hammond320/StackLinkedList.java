package Hammond320;

public class StackLinkedList<T> {
    private Node<T> topOfStack;
    private static class Node<T>{
        T value;
        Node<T> next;

        public Node(T value){
            this.value = value;
            this.next = null;
        }

    }

    public void push(T value){
        Node<T> newNode = new Node<>(value);
        if (topOfStack != null) {
            newNode.next = topOfStack;
        }
        topOfStack = newNode;
    }

    public T pop(){
        if (topOfStack == null){
            throw  new IllegalStateException("Stack is empty");
        }

        T value = topOfStack.value;
        topOfStack = topOfStack.next;
        return value;
    }

    public T top(){
        return topOfStack != null ? topOfStack.value : null;
    }

    public  boolean isEmpty(){
        return topOfStack == null;
    }

    public void displayContent(){
        Node<T> temp = topOfStack;
        System.out.print("Stack(top to bottom): ");
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}
