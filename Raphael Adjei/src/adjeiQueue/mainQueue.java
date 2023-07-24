// Name - Raphael Adjei ID - 10897724

package adjeiQueue;

public class mainQueue {

    public int sum(int num){
        int result;
        if (num==1){
            result = 1;
        }
        else{
            result = num + sum(num-1);
        }
        return result;
    }
    public static void main(String[] args) {
//        QueueDsa<String> queue = new LinkedListQueue<>();
//
//        queue.enqueue("Alice");
//        queue.enqueue("Bob");
//        queue.enqueue("Charlie");
//
//        System.out.println("Size: " + queue.size()); // Output: Size: 3
//        System.out.println("Front element: " + queue.peek()); // Output: Front element: Alice


//        for (int i = 10; i >0; i++){
//            System.out.println("mine");
//        }



    }
}
