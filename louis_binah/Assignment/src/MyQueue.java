import java.util.Queue;
import java.util.LinkedList;
// ID: 10899830

public class MyQueue {
    private Queue<String> queue;

    public MyQueue(){
        queue = new LinkedList<>();
    }
    public void enqueue(String element){
        queue.add(element);
    }
    public String dequeue(){
        return queue.poll() ;
    }
    public String peek(){
        return queue.peek();
    }
    public boolean IsEmpty(){
        return queue.isEmpty();
    }
    public int Size(){
        return queue.size();
    }
    @Override
    public  String toString(){
        return queue.toString();
    }
}

