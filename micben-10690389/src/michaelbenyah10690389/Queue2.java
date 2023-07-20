package michaelbenyah10690389

import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        Queue<String> languages = new LinkedList<>();

        // add elements
        languages.add("Python");
        languages.add("Java");
        languages.add("C");
        System.out.println("LinkedList: " + languages);

        // access the first element
        String str1 = languages.peek();
        System.out.println("Accessed Element: " + str1);

        // access and remove the first element
        String str2 = languages.poll();
        System.out.println("Removed Element: " + str2);
        System.out.println("LinkedList after poll(): " + languages);

        // add element at the end
        languages.offer("Swift");
        System.out.println("LinkedList after offer(): " + languages);
    }
}