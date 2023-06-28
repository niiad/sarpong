package Bawsineku2879;

import java.util.Stack;6

/*
Name: Bawsineku David
ID: 10912879
*/


public interface stacks {

    class Main {
        public static void main(String[] args) {
            // create an object of Stack class
            Stack<String> animals = new Stack<>();
            // push elements to top of stack
            animals.push("Pig");
            animals.push("Panda");
            animals.push("Cattle");
            animals.push("Monkey");
            animals.push("Donkey");
            animals.push("Dog");
            System.out.println("Animals pushed into stack: " + animals);
            // pop element from top of stack
            animals.pop();
            animals.pop();
            animals.pop();
            System.out.println("Animals in stack after pop: " + animals);
        }
    }
}
